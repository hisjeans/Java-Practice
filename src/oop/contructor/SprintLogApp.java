package oop.contructor;

public class SprintLogApp {
    public static void main(String[] args) {


        //객체 생성
        LearningLog javalog=new LearningLog("Java 시작",40/*,true*/);
        //'LearnigLog()' 생성자
        //"LearnigLog(String title, int minutes, boolean publicLog가 받음
        //객체 생성하자마자 printsummary 호출하면 생성자가 호출되고 title, minutes 값을 넣지 않아 null이 나옴
        //컴파일러가 코드를 바이트 코드로 번역하고 컴퓨터에게 전달
        //JVM(Java Virtual Machine)이 자바 실행될 수 있는 가상 환경(JRE) 만듦
        //JVM만 존재한다면 맥, 윈도우 무관하게 동작 가능
        //JVM이 main 메서드 호출해 main 메서드 안의 내용 실행되는 것

        LearningLog gitLog=new LearningLog("Git 복습",30,false);
        //생성자가 실수 방지해줄 수 있음 하나라도 빠지면 알려줌
        //public log가 false가 될 때만 전달해줌
        LearningLog conditionLog=new LearningLog("조건문 학습",75/*,true*/);

        LearningLog loopLog=new LearningLog("반복문 학습",120/*,true*/);
        //javaLog, gitLog, loopLog 모두 true이면 LearningLog를 생성할 때 true로 생성하면 되지 않을까

        LearningLog[] logs={javalog, gitLog, conditionLog, loopLog};
        System.out.println("=== 생성자로 만든 학습 기록 ===");
        for(LearningLog log:logs){
            log.printSummary();
        }
    }
}
