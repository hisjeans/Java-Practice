package oop.access_modifier;

public class SpringLogApp {
    public static void main(String[] args) {


        //객체 생성
        LearningLog javaLog=new LearningLog("Java 시작",40/*,true*/);
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

        //문제: 생성자를 이용해 초기화했다 하더라도 변수 안에 있는 객체의 주소값 사용, 접근제한 없기 때문에 즉 같은 패키지에 존재하는 클래스이기 때문에 무작위로 지을 수 있음
        //예) javalog.title="냥"; 외부 로직에 의해 값 변경될 수 있음

        //javalog.title="야호";
        //javalog.minutes=-3899;
        //javalog.publicLog=false; 모든 필드가 private 접근 제한자를 지정했기 때문에 값을 참조하거나 수정이 불가능해짐

        javaLog.extendStudy(200);
        javaLog.changTitle("Java 객체지향과 캡슐화");
        javaLog.hideFromPublic();

        gitLog.extendStudy(45);
        gitLog.openToPublic();


        //외부에서는 public 호출만 가능하기에 private javaLog.normalizeTitle(); 호출 불가능
        //javalog.minutes=100; 와 같이 제대로 된 값 또한 넣지 못하는 문제 발생
        javaLog.printSummary();
        //printSummary 요약
        //printSummary에 public 여부는 보여주지 않고 있음

        gitLog.printSummary();
    }
}
