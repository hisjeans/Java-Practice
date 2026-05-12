package oop.collection.domain;

import oop.inner_anonymous.policy.Reviewable;
import oop.inner_anonymous.policy.Shareable;


public class PracticeLog extends LearningActivity implements Reviewable, Shareable {

    private static final int MINIMUM_COMPLETION_RATE=70;

    private int completionRate; //PracticLog만 가지는 고유한 필드 1개 사용 위치

    public PracticeLog(String title, int minutes, Visibility visibility, int completionRate) {
        super(title, minutes, visibility, ActivityCategory.PRACTICE);
        //completionRate는 PracticeLog만 받을 수 있는 정보
        this.completionRate=normalizeCompletionRate(completionRate);

    }


    @Override
    public boolean needsReview() {
        return getCategory().isShortStudy(getMinutes())||completionRate<MINIMUM_COMPLETION_RATE;

    }

    @Override
    public void printReviewTarget(){
        System.out.println("[복습 권장] " + getTitle() + " (완료율: " + completionRate + "%)");
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
        return isPublicActivity();
    }

    @Override
    public String getSharTitle() {
        return getTitle();
    }
    //오버로딩!=오버라이딩

    @Override
    public String getActivityType(){
        return "실습";
    }

    @Override
    public String getDetailText(){
        return "완료율"+completionRate+"%";
    }
}
