package oop.inheritance.app;

import oop.inheritance.domain.LearningActivity;
import oop.inheritance.domain.LectureLog;
import oop.inheritance.domain.PracticeLog;

public class SprintLogApp {
    public static void main(String[] args) {

        //LearningActivity로도 선언 가능(부모자식의 객체에 자식값 가질 수 있음)
        LearningActivity javaLecture = new LectureLog("Java 객체지향", 50, true, "박코치");
        LearningActivity gitPractice = new PracticeLog("Git 브랜치 실습", 70, true, 80);
        PracticeLog oopPractice = new PracticeLog("캡슐화 리팩터링", 40, false, 45);

        //javaLecture.instructorName; 부모 타입으로 자식 객체의 고유한 메서드, 필드 확인 불가능
        //다형성은 분명 많은 장점이 있지만, 부모의 정보로 자식의 고유한 필드와 메서드 호출할 수 없음
        //만일 하고 싶다면 자식 타입의 변수를 선언해 주소값을 넘겨야, 그 과정에서 형 변환 필요

        LectureLog lec=(LectureLog) javaLecture;//타입 변환 필요
        lec.method1();

        //System.out.println("lec = " + lec);
        //System.out.println("javaLecture = " + javaLecture); //lec과 주소 동일

        //메서드의 리턴 타입이 object이면 모든 타입 리턴 가능
        //특정 객체에 어떤 타입이든 전부 넣어야 한다면 object

        //배열은 같은 데이터 타입끼리만 모일 수 있음 LectureLog != PracticeLog
        //LectureLog, PracticeLog는 부모 동일하기 때문에 부모 타입의 배열을 선언할 수 있음
        // = 다형성
        LearningActivity[] logs={javaLecture, gitPractice, oopPractice};
        //javaLecture.printSummary(); 강사 이름까지 나오지 않는 이유: 부모가 물려준 printSummary()에 강사 이름이 나오지 않기 때문
        //=>자식 클래스를 수정하는 오버라이딩으로 해결 가능

        for(LearningActivity log:logs){ //Object 타입으로 호출하면 자식의 정보를 알 수 없음
            //Object가 최상위 부모라 하더라도 부모의 정보로 자식의 고유한 필드, 메서드 호출 불가능
            log.printSummary();//javaLecture, gitPractice, oopPractice
            //반복문 하나만으로 여러 타입 객체 호출 가능

        }

        System.out.println("=== 복습이 필요한 활동 ===");
        for(LearningActivity log:logs){
            if(log.needsReview()){
                log.printSummary();
            }
        }

        System.out.println();
        System.out.println("=== 실습 활동만 보기 ===");
        for (LearningActivity log : logs) {
            //실습 활동만 출력, LectureLog 타입은 건너뛰고 PracticeLog 타입만 출력
            //javaLecture는 LectureLog, gitPractice, oopPractice는 PracticeLog
            //LearningActivity 누구든 들어올 수 있는 상태
            if(log instanceof PracticeLog practiceLog){
                //instanceof 이항 연산자
                //좌항의 객체가 log라는 변수에 들어있는 객체가 우항의 타입을 가질 수 있다면 true, 없다면 false
                //PracitceLog 타입을 가질 수 있는 객체일 때
                //instanceof 특정 개체 출력 가능
                System.out.println(practiceLog.getTitle()+"완료율: "+ practiceLog.getCompletionRate()+"%");
                //자바 17버전 이후부터 사용가능
                //System.out.println(log.getTitle()+"완료율: "+ ((PracticeLog) log).getCompletionRate()+"%");
                //getCompletionRate는 practicelog의 고유한 메서드 log는 부모 타입이기 때문에 받을 수 없음
                //'(PracticeLog)' typecasting 형변환 연산자 '.' 참조 연산자
                //연산자 우선순위 존재, 먼저 하기를 원하는 것에 대해 '()'
                //참조연산 >>우선순위>> 형변환 연산자
                //'(형변환 연산자)' log를 PracticeLog로 변환을 먼저 하도록 함
                //형변환 연산자는 1항 연산자, PracticeLog가 영향을 미치는 연산자 log 1 뿐
                //((PracticeLog) log)1항 연산 .참조 연산 getCompletionRate()

            }
        }


    }

}
