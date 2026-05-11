package oop.abstract_interface.domain;

//객체 생성을 위한 설계도 클래스에는 main 메서드를 작성하지 않음
public abstract class LearningActivity {//abstract 추가, 추상 메서드 가진 추상 클래스
//extends Object는 따로 쓰지 않더라도 컴파일 과정에서 자동으로 들어감


    private static int totalCreateCount=0;
    //지금까지 LearningActivity 객체가 몇 개 만들어졌는지 세는 변수

    private final long id;
    //객체가 생성된 수에 맞게 id 개수 올라감
    //final 마지막 변수: 처음 생성될 때 정해진 값이 마지막, 즉 변경되지 않음
    //!=static final 모든 객체가 공유하면서 바뀔 수 있게 하는 값

    //객체의 속성을 '필드(field), 멤버변수'라고 함
    //default 접근제한 상태 String title;...
    //private 접근제한
    //접근 제한자를 활용한 정보 은닉과 캡슐화 (information hiding, encapsulation)
    //1. 필등에 private 접근 제한을 붙여 외부에서의 직접적인 접근을 허용하지 않게 막음
    private String title;
    private int minutes;
    private boolean publicActivity;


    //클래스 이름과 동일한 함수 선언
    //생성자는 클래스의 이름과 대/소문자까지 완전히 일치해야
    //메서드와 달리 리턴 타입이 존재하지 않음
    //일반적인 메서드는 리턴 타입이 반드시 존재해야

    //기본 생성자는 현재 진행되지 않아 삭제

    //생성자 장점: 중복 선언 가능
    //생성자는 메서드처럼 매개값을 전달받을 수 있음
    //전달받은 값을 이용해 필드 초기화할 수 있음
    //생성자는 중복 선언 가능(오버로딩: overloading)
    //이름이 동일하기 때문에 전달하는 값의 개수, 순서, 타입을 다르게 작성해야 중복 선언 인정
    public LearningActivity(String title, int minutes){
        //javaLog, gitLog, loopLog 모두 true이면 LearningLog를 생성할 때 true로 생성하면 되지 않을까

        /*
        this.title=title;
        this.minutes=minutes;
        this.publicActivity=true;
        "Learning:og(String title, int minutes, boolean publicActivity"와 패턴 같음
        */
        this(title, minutes, true);

        //this() 문법으로 자기 자신의 다른 생성자를 호출하는 것 가능
        //title(string), minutes(int), true(boolean) 받을 수 있는 다른 생성자("Learning:og(String title, int minutes, boolean publicActivity") 부를 것
    }

    public LearningActivity(String title, int minutes, boolean publicActivity){
        //객체 3개씩 생성될 때 고유번호 부여하고 싶음
        totalCreateCount++;
        this.id=totalCreateCount; //Java(id=1) Git(id=1) - totalCreateCount 각각 setting된 것 when private int totalCreateCount=0;
        //객체 생성되면 생성자 호출, totalCreate값 하나씩 올라갈 것
        //객체 -> stack(java(0x10) git(0x20) encap(0x30))
        //Heap(0x10(title) 0x20(git) 0x30(encap))
        //Data(LearningActivity: totalCreateCount) - 별도의 공간에 생성된 static 변수의 값을 올려야
        //static 변수로 세팅한 값은 객체마다 따로 생성된 값
        //totalCreateCount는 static으로 선언되어 하나의 값을 공유하는 것(각각 가지지 x)으로 객체와 무관한 상태가 됨
        //id는 객체 생성될 때 정해지는 값, 객체 생성된 후부터 setId...할 수 없게 만드는 final

        this.title=normalizeTitle(title); //객체를 생성할 때 전달하는 title 또한 문제 생길 수 있기 때문에 검사
        this.minutes=minutes;
        this.publicActivity=publicActivity;

    }
    //2. private 접근 제한을 지정하니 제대로 된 값도 수정이 불가능한 것 확인
    //필드 값을 대신 받아 할당하고, 값을 돌려줄 수 있는 메서드를 활용해 값을 보호
    //이 때 사용하는 메서드의 이름을 getter(값을 얻을 때 사용), setter(값을 set할 때 사용)라고 함
    //set+필드이름 으로 짓는 것이 관음
    //가장 민감한 minutes
    //메서드는 private으로 하면 이 안에서 밖에 안 되기 때문에 public 사용
    //setMinutes를 불러야 하는 상황이 됨
    public void extendStudy(int additionalMinutes){
        if(additionalMinutes<=0){
            System.out.println("잘못된 공부 시간입니다.");
            //break; 반복문이 아니기 때문에 넣을 수 없음
            return; //void 메서드에서 return은 메서드를 강제종료
            //void 메서드에서만 사용 가능한 return
        }
        this.minutes+=additionalMinutes;
        //방어로직을 메소드에 작성 가능
    }
    //setTitle, setpublicActivity

    public void changTitle(String newTitle){
        //전달받은 title을 변경받는 것에 집중
        this.title=normalizeTitle(newTitle);
    }

    //메서드 생성 to 역할 분명
    //정보 은닉은 외부에 공개할 필요 없는 내용 숨김
    //to 문자열 return, string 타입으로 변환
    //이 메서드는 외부에서 알 필요 없고, 호출할 일도 없기 때문에 private으로 설정
    //이 클래스 안에서만 사용할 수 있도록 범위를 지정, 객체 내부에서만 쓰는 규칙
    private String normalizeTitle(String newTitle) {
        if(newTitle ==null|| newTitle.isBlank()){
            //||_OR는 좌항이 논리식이면 우항도 논리식이어야
            //null이거나 공백이라면 true
            //and 논리연산자: 둘 중 하나라도 false->false, 모두 true이어야
            //and 대표적인 사례: 로그인(ID, pw 모두 true이어야)
            return "제목 없음";
        }
        return newTitle;//문제가 없다면
    }

    public void openToPublic(){
        this.publicActivity=true;

    }
    public void hideFromPublic(){
        this.publicActivity=false;//publicActivity 필드는 true, false 밖에 들어가지 못함
        //메서드 이름 통해 공개, 숨김 의미 표현

    }
    public abstract void printSummary();

    //주사용은 자식에서 이루어지고 있기 때문에 부모를 추상 클래스로 지정함
    //추상메서드는 메서드 바디가 없는 메서드의 틀 역할
    //특정 메서드는 부모가 대충 정하는 것보다, 자식이 반드시 자기 방식대로 구현하는 것이 명확할 때가 있음
    //추상메서드는 자식에게 물려질 때 오버라이딩 강제, 반드시 구현해야

//needsReview는 reviewable이 그 역할을 대신할

    //get+이름: getter 관례
    //getTitle 단축

    public static int getTotalCreateCount(){

        return totalCreateCount;
    }
    //외부로 필드값을 돌려주는 getter 메서드
    //get+필드이름으로 지어주는 것이 관례
    //boolean 타입의 값을 돌려주는 getter는 is로 시작하도록 이름 지음
    //값을 변경하고 싶지 않을 때, private으로 막고 의도적으로 setter 메서드를 제공하지 않는 경우도 존재
    public long getId(){

        return id;
    }

    public String getTitle() {
        return title;
    }


    public int getMinutes() {
        return minutes;
    }

    //boolean 타입 getter메소드는 is로 시작
    public boolean ispublicActivity() {
        return publicActivity;
    }
}
