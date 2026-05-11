package oop.abstract_interface.app;

import oop.abstract_interface.domain.LearningActivity;
import oop.abstract_interface.domain.LectureLog;
import oop.abstract_interface.domain.PracticeLog;
import oop.abstract_interface.domain.ReadingLog;
import oop.abstract_interface.policy.Reviewable;
import oop.abstract_interface.policy.Shareable;

import oop.abstract_interface.printer.ActivityPrinter;
import oop.abstract_interface.printer.CompactActivityPrinter;


public class SprintLogApp {
    public static void main(String[] args) {

        LectureLog javaLecture = new LectureLog("Java 객체지향", 50, true, "박코치");
        PracticeLog gitPractice = new PracticeLog("Git 브랜치 실습", 70, true, 80);
        PracticeLog oopPractice = new PracticeLog("캡슐화 리팩터링", 40, false, 45);
        ReadingLog oopBook = new ReadingLog("객체지향의 사실과 오해", 35, true, "객체지향의 사실과 오해");

        //LeraningActivity act=new LearningActivity("test", 10);
        //추상클래스는 스스로의 객체를 생성할 수 없고, 자식에 의해 생성될 뿐

        LearningActivity[] activities = {javaLecture, gitPractice, oopPractice, oopBook};
        //javaLecture...자식 객체들이 printer 메소드 호출되었을 때 자식은 부모의 역할을 완벽히 대신할 수 있음 => LSP

        //인터페이스 activity printer의 역할을 잡았기 때문에 기존 객체->새로운 객체로만 변경하면 됨
        //기능확장에는 열려 있고 변경에는 닫혀 있음 => OCP
        ActivityPrinter printer=new CompactActivityPrinter();

        System.out.println("=== 간단 학습 활동 목록 ===");
        for (int i = 0; i < activities.length; i++) {
            printer.print(activities[i]);
        }

        //인터페이스 특징: 다형성이란 부모 타입의 변수에 자식 타입의 객체가 들어올 수 있다는 것
        //다형성은 인터페이스 구현 관계에서도 발생 가능

        Reviewable[] reviewables={javaLecture, gitPractice, oopPractice, oopBook};
        //인터페이스 타입으로 배열 선언해 객체를 하나로 모아줄 수 있음
        //sharable 인터페이스 또한 가능
        //추상 메서드를 구현한 객체만 들어갈 수 있도록 문법적으로 강제할 수 있음
        //reviewable 역할 수행할 수 있는지에 대해서만 집중_인터페이스
        System.out.println();
        System.out.println("=== 복습 필요 활동 ===");

        for (Reviewable reviewable : reviewables) {
            if(reviewable.needsReview()) {
                reviewable.printReviewTarget();
            } //복습 필요한 객체만 출력하도록 함
            //다형성이 상속 관계에서 뿐만 아니라 인터페이스 구현 속에서도 발생
        }


        Shareable[] shareables={javaLecture, gitPractice, oopPractice, oopBook};
        //인터페이스 타입으로 배열 선언해 객체를 하나로 모아줄 수 있음
        //sharable 인터페이스 또한 가능
        //추상 메서드를 구현한 객체만 들어갈 수 있도록 문법적으로 강제할 수 있음
        //공유 가능한 객체 수용한 것만 가능, 인터페이스 구현한 객체에 대해서만
        //인터페이스에도 다형성 구현 가능
        //역할 강조하기 위한 인터페이스 선언, 그 인터페이스 선언한 객체 구현 가능

        System.out.println();
        System.out.println("=== 복습 필요 활동 ===");

        for (Shareable shareable : shareables) {
            if(shareable.canShare()) {
                System.out.println(shareable.getSharTitle());
            } //공유 가능한 객체만 출력하도록 함

        }
    }

}
