package oop.contructor;

//객체 생성을 위한 설계도 클래스에는 main 메서드를 작성하지 않음
public class LearningLog {

    //객체의 속성을 '필드(field), 멤버변수'라고 함
    String title;
    int minutes;
    boolean publicLog;

    //메서드 선언
    void printSummary(){ //반환해주는 것이 없기 때문에 void
        System.out.println(title+" - "+minutes+"분");
    }

    boolean needsReview(){
        return minutes<60;
    }

}
