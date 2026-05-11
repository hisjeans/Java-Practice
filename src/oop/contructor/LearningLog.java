package oop.contructor;

//객체 생성을 위한 설계도 클래스에는 main 메서드를 작성하지 않음
public class LearningLog {

    //객체의 속성을 '필드(field), 멤버변수'라고 함
    String title;
    int minutes;
    boolean publicLog;

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

    LearningLog(String title, int minutes, boolean publicLog){ //객체 생성할 때 title, minutes, publiclog 보내주어야
        //title, minutes, publiclog 한번에 전달 가능
        this.title=title;
        //객체가 가진 필드=매개값으로 전달받은 것 세팅
        //but title=title(LearnigLog(String title)로 한다면 구분하지 못함 LearnigLog의 title에 LearningLog의 title을 대입하게 됨
        //해결1: 필드명!=변수명 작성
        //해결2: this 키워드 사용, 지금 생성되고 있는 그 생성자의 타이틀 'this.title'
        //this는 현재 객체 자기 자신을 뜻함
        //생성자에서의 this는 곧 지금 생성자에 의해 생성되고 있는 그 객체를 의미
        //필드와 생성자의 매개변수 이름이 동일할 경우 this를 통해 구분지어 줘야 함

        this.minutes=minutes;
        this.publicLog=publicLog;

    }
    //메서드 선언
    void printSummary(){ //반환해주는 것이 없기 때문에 void
        System.out.println(title+" - "+minutes+"분");
    }//this.title, this.miutes 생략된 것, 이 메서드를 호출한 그 객체의 title, minutes

    boolean needsReview(){

        return minutes<60;
    } //메서드를 호출한 그 객체의 minutes
    //메서드에서 특정 필드 지정하기 위해서도 this

}
