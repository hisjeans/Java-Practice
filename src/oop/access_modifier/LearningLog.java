package oop.access_modifier;

//객체 생성을 위한 설계도 클래스에는 main 메서드를 작성하지 않음
public class LearningLog {

    //객체의 속성을 '필드(field), 멤버변수'라고 함
    //default 접근제한 상태 String title;...
    //private 접근제한
    //접근 제한자를 활용한 정보 은닉과 캡슐화 (information hiding, encapsulation)
    //1. 필등에 private 접근 제한을 붙여 외부에서의 직접적인 접근을 허용하지 않게 막음
    private String title;
    private int minutes;
    private boolean publicLog;

    //클래스 이름과 동일한 함수 선언
    //생성자는 클래스의 이름과 대/소문자까지 완전히 일치해야
    //메서드와 달리 리턴 타입이 존재하지 않음
    //일반적인 메서드는 리턴 타입이 반드시 존재해야

    //기본 생성자
    LearningLog(){ //전달받은 값이 없기 때문에 그냥 생성 가능
        System.out.println("기본 생성자 호출");

    }
    //생성자 장점: 중복 선언 가능
    //생성자는 메서드처럼 매개값을 전달받을 수 있음
    //전달받은 값을 이용해 필드 초기화할 수 있음
    //생성자는 중복 선언 가능(오버로딩: overloading)
    //이름이 동일하기 때문에 전달하는 값의 개수, 순서, 타입을 다르게 작성해야 중복 선언 인정
    LearningLog(String title, int minutes){
        //javaLog, gitLog, loopLog 모두 true이면 LearningLog를 생성할 때 true로 생성하면 되지 않을까

        /*
        this.title=title;
        this.minutes=minutes;
        this.publicLog=true;
        "Learning:og(String title, int minutes, boolean publicLog"와 패턴 같음
        */
        this(title, minutes, true);

        //this() 문법으로 자기 자신의 다른 생성자를 호출하는 것 가능
        //title(string), minutes(int), true(boolean) 받을 수 있는 다른 생성자("Learning:og(String title, int minutes, boolean publicLog") 부를 것
    }

    LearningLog(String title, int minutes, boolean publicLog){
        this.title=title;
        this.minutes=minutes;
        this.publicLog=publicLog;

    }
    //private 접근 제한을 지정하니 제대로 된 값도 수정이 불가능한 것 확인
    //필드 값을 대신 받아 할당하고, 값을 돌려줄 수 있는 메서드를 활용해 값을 보호
    //이 때 사용하는 메서드의 이름을 getter(값을 얻을 때 사용), setter(값을 set할 때 사용)라고 함
    //가장 민감한 minutes
    //메서드는 private으로 하면 이 안에서 밖에 안 되기 때문에 public 사용
    //setMinutes를 불러야 하는 상황이 됨
    public void setMinutes(int minutes){
        if(minutes<=0){
            System.out.println("잘못된 공부 시간입니다.");
            //break; 반복문이 아니기 때문에 넣을 수 없음
            return; //void 메서드에서 return은 메서드를 강제종료
            //void 메서드에서만 사용 가능한 return
        }
        this.minutes+=minutes;
        //방어로직을 메소드에 작성 가능
    }
    //setTitle, setPublicLog

    void printSummary(){
        System.out.println(title+" - "+minutes+"분");
    }

    boolean needsReview(){
        return minutes<60;
    }

}
