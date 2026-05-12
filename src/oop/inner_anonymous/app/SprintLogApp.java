package oop.inner_anonymous.app;

import oop.inner_anonymous.domain.*;
import oop.inner_anonymous.exception.InvalidActivityException;
import oop.inner_anonymous.printer.ActivityPrinter;
import oop.inner_anonymous.printer.ConsoleActivityPrinter;
import oop.inner_anonymous.service.ActivityDashboard;


public class SprintLogApp {
    public static void main(String[] args) {

        // ── 1. 기본 활동 목록 ──────────────────────────────────────────
        // boolean 대신 Visibility enum으로 공개 상태를 표현한다.
        LearningActivity[] activities = {
                new LectureLog("Java enum 기초", 50, Visibility.PUBLIC, "박코치"),
                new LectureLog("Java 내부 클래스", 70, Visibility.PUBLIC, "김선생"),
                new PracticeLog("예외 처리 실습", 80, Visibility.PUBLIC, 90),
                new PracticeLog("인터페이스 실습", 100, Visibility.PUBLIC, 85),
                new ReadingLog("객체지향의 사실과 오해", 35, Visibility.PRIVATE, "조영호")
                //임의로 객체 수 늘림
                //summarize안 count가 계산
        };

        //----2. 정적 중첩 클래스 시연: Summary -----------------------
        //static 클래스로 선언된 상태
        //summary 객체 자체가 lecturelog의 수, practicelog의 수... 정보를 담는데 직접 객체를 {20,30,..} 이렇게 생성하면 안 됨
        //Summary는 ActivityDashboard 객체 없이도 생성이 가능하지만, Summary가 의미있는 활성 객체 수를 가지게 하기 위해
        //dashboard.summarize()를 호출해서 리턴받음
        ActivityDashboard dashboard=new ActivityDashboard(activities);
        ActivityDashboard.Summary summary=dashboard.summarize();

        System.out.println("=== 학습 요약 (정적 중첩 클래스: Summary) ==="); //Summary 안에 의미있는 값을 담게끔
        System.out.println("총 활동 수  : " + summary.getTotalCount()); //총 객체 수
        System.out.println("강의        : " + summary.getLectureCount());
        System.out.println("실습        : " + summary.getPracticeCount());
        System.out.println("독서        : " + summary.getReadingCount());

        // ── 3. 멤버 내부 클래스 시연: ReportBuilder ──────────────────────
        // dashboard.new ReportBuilder(...) — 외부 인스턴스에 묶여서 생성된다.
        System.out.println();
        System.out.println("=== 기본 보고서 (멤버 내부 클래스: ReportBuilder) ===");
        ActivityPrinter consolePrinter = new ConsoleActivityPrinter();
        dashboard.new ReportBuilder(consolePrinter).print(); //전달받은 pirnter 통해 출력
        //report가 일종의 중개 역할을 하는 것, summary 가져와 전달, dashboard 전달받은 것을 출력
        //static 객체는 외부 객체(dashboard) 없이 아예 생성 자체가 불가능

        // --- 4. 익명 클래스 시연: ActivityPrinter 구현체 즉석 구현 ---
        //클래스 이름 없이 인터페이스를 바로 구현
        //딱 한 번만 쓸 간단한 출력 방식을 별도 클래스 파일 없이 표현
        System.out.println();
        System.out.println("=== 간단 보고서 (익명 클래스:  ActivityPrinter 구현체 즉석 구현) ===");
        //한 번만 사용하고 버릴 프린터
        //프린터를 제작할 때 항상 인터페이스 구현
        //new ActivityPrinter() ActivityPrinter는 인터페이스, 인터페이스는 생성자 없음, 객체 생성할 수 없는 개념, 클래스는 가능



        ActivityPrinter compactPrinter=new ActivityPrinter(){
            @Override
            public void print(LearningActivity activity){
                //익명 클래스 안에서 activity public API를 자유롭게 사용
                //printf: 서식 지정 표준 출력 함수
                //%s: String, %d: 정수, %f:실수
                System.out.printf(" [%s] %s - %d분%n",
                        activity.getActivityType(),
                        activity.getTitle(),
                        activity.getMinutes());
            }
        };

        dashboard.new ReportBuilder(compactPrinter).print();




        System.out.println();
        System.out.println("=== 잘못된 입력 처리 ===");





    }


}