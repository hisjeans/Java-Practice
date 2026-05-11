package oop.abstract_interface.domain;

import oop.abstract_interface.policy.Reviewable;
import oop.abstract_interface.policy.Shareable;

public class PracticeLog extends LearningActivity implements Reviewable, Shareable {


    private int completionRate; //PracticLog만 가지는 고유한 필드 1개 사용 위치

    public PracticeLog(String title, int minutes, boolean publicActivity, int completionRate) {
        super(title, minutes, publicActivity);
        //completionRate는 PracticeLog만 받을 수 있는 정보
        this.completionRate=normalizeCompletionRate(completionRate);

    }

    @Override
    public void printSummary() {
        System.out.println("[실습] #" + getId() + " " + getTitle() + " - " + getMinutes()
                + "분 - 완료율: " + completionRate+"%");
    }

    @Override
    public boolean needsReview() {
        return getMinutes()<60||completionRate<70;

    }

    public void printReviewTarget(){
        printSummary();
    }

    public int getCompletionRate() {

        return completionRate;
    }

    private int normalizeCompletionRate(int completionRate){
        if(completionRate<0){
            return 0;
        }

        if(completionRate>100){
            return 100;
        }

        return completionRate;
    }


    @Override
    public boolean canShare() {
        return ispublicActivity();
    }

    @Override
    public String getSharTitle() {
        return getTitle();
    }
    //오버로딩!=오버라이딩
}
