package oop.collection.domain;

import oop.collection.policy.Reviewable;
import oop.collection.policy.Shareable;

public class LectureLog extends LearningActivity implements Reviewable, Shareable {
    //extends 연장, 확장
    //LerningActivity 물려받음
    //LectureLog 자식 LearningActivity 부모
    //LectureLog는 LearningActivity의 한 종류이고, Reviewable에 선언된 역할도 수행할 수 있

    public String instructorName;
    //강사 이름 (LectureLog만이 고유하게 가지는 필드)

    // -> enum 타입으로 변경
    public LectureLog(String title, int minutes, Visibility visibility, String instructorName){
        //부모 생성자 부르는 문법
        //상속 관계 하에서 자식 객체가 생성될 때 부모의 객체도 함께 생성(그래야 필드, 메서드를 물려줄 수 있기 때문)
        //그래서 생성자에는 항상 super()가 내장되어 있음
        //부모의 생성자도 호출되어야 자식에게 물려줄 수 있는
        super(title, minutes, visibility, ActivityCategory.LECTURE);
        this.instructorName=normalizeInstructorName(instructorName); //부모가 알 수 없는 영역, 유효성 검증은 자식이 해야
    }



    @Override
    public boolean needsReview(){
        return getCategory().isShortStudy(getMinutes());
    }

    @Override
    public void printReviewTarget(){
        System.out.println("[복습 권장] " + getTitle() + " (" + getMinutes() + "분)");
    }


    //이 메서드는 부모가 물려준 게 아닌 자식 고유의 기능(instructorName은 부모가 처리해줄 수 없음)
    //because 부모는 자식의 내용 알 수 없음
    private String normalizeInstructorName(String instructorName){
        if(instructorName==null||instructorName.isBlank()){
            return "강사 미정";
        }
        return instructorName; //null이 아니거나 공백도 아니라면
    }

    @Override
    public boolean canShare(){
        return isPublicActivity();
    }

    @Override
    public String getSharTitle(){
        return getTitle();
    }

    @Override
    public String getActivityType(){
        return "강의";
    }

    @Override
    public String getDetailText(){
        return "강사: "+instructorName;
    }
}
