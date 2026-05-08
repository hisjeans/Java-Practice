package oop.static_final;

public class SprintLogApp {
    public static void main(String[] args) {



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

        LearningLog encapLog = new LearningLog("캡슐화 연습", 90);
        //option+enter 객체 생성 단축어
        //javaLog, gitLog, encapLog는 같은 클래스 기반으로 생성된 객체는 맞지만, 주소값, 제목, 학습시간 모두 다름
        //title, minutes, publicLog는 객체마다 달라야 하는 값=>static 붙이지 않는 것
        //객체마다 달라야 하는 값에는 static 붙이지 않음

        LearningLog[] logs={javaLog, gitLog, encapLog};

        for(LearningLog log:logs){
            log.printSummary();
        }


        System.out.println("==============================================================================");

        System.out.println("지금까지 생성된 학습 기록 수: "+LearningLog.getTotalCreateCount());
        //javaLog.totalCreateCount 문제: totalCreatCount 는 static 변수인데 객체 javalog에서 찾으려고 하는 것
        //totalCreateCount는 객체마다 생성된 것이 아니라 별도의 공간(LearningLog.totalCreateCount)에 있는 것
        //static 변수나 메서드는 객체마다 가지고 있는 값이 아니기 때문에
        //값을 참조할 때 선언된 클래스의 이름으로 참조할 수 있음
        //static 붙지 않으면 javaLog.getTotalCreateCount() 객체로 접근해야
        //!: static 변수를 얻어오는 메소드를 일반 메소드로 선언할 이유 없음
        //static 메서드로 선언하자
        //LearningLog.getTotalCreateCount() 공유된 하나의 메서드 값을 얻기 위해서도 LearningLog 클래스로 선언

    }

}
