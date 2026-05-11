package oop.abstract_interface.domain;

import oop.abstract_interface.policy.Reviewable;
import oop.abstract_interface.policy.Shareable;

public class ReadingLog extends LearningActivity implements Reviewable, Shareable{    //추상클래스
    //부모가 가진 껍데기 메서드를 자식이 구현하지 않으면 에러->문법적으로 강음

    private String bookTitle;

    public ReadingLog(String title, int minutes, boolean publicActivity, String bookTitle){
        super(title, minutes, publicActivity);
        this.bookTitle=bookTitle;

    }


    @Override
    public boolean needsReview() {
        return getMinutes() < 45;
    }

    @Override
    public void printReviewTarget() {
        System.out.println("[복습 권장] " + getTitle() + " (" + bookTitle + ")");
    }

    @Override
    public boolean canShare() {
        return ispublicActivity();
    }

    @Override
    public String getSharTitle() {
        return getTitle();
    }

    //역할 담당하는 것이 인터페이스
    //인터페이스는 다중상속 가능 클래스는 단일 상속만 가능

    @Override
    public String getActivityType(){
        return "독서";
    }

    @Override
    public String getDetailText(){
        return "책: "+bookTitle;
    }
}
