package oop.inheritance.domain;

public class LectureLog extends LearningActivity{
    //extends 연장, 확장
    //LerningActivity 물려받음
    //LectureLog 자식 LearningActivity 부모

    private String instructorName;
    //강사 이름 (LectureLog만이 고유하게 가지는 필드)

    public LectureLog(String title, int minutes, boolean publicActivity, String instructorName){
        //부모 생성자 부르는 문법
        //상속 관계 하에서 자식 객체가 생성될 때 부모의 객체도 함께 생성(그래야 필드, 메서드를 물려줄 수 있기 때문)
        //그래서 생성자에는 항상 super()가 내장되어 있음
        //부모의 생성자도 호출되어야 자식에게 물려줄 수 있는
        super(title, minutes, publicActivity);
        this.instructorName=normalizeInstructorName(instructorName); //부모가 알 수 없는 영역, 유효성 검증은 자식이 해야
    }

    //메서드 재정의(override)
    //부모가 물려준 메서드가 자식에게 맞지 않거나 부족할 경우 자식이 재 정의해서 사용 가능
    //오버라이딩 규칙: 1. 메서드 이름이 같아야 2. 리턴 타입이 같아야 3. 매개변수의 선언이 일치해야
    @Override
    public void printSummary() {
        System.out.println("[강의] #" + getId() + " " + getTitle() + " - " + getMinutes()
                + "분 - 강사: " + instructorName);
    }

    public boolean needsReview(){
        return getMinutes()<60;
    }

    public void method1(){ //부모는 자식 객체의 메소드 확장을 알 수 없음
        System.out.println("자식의 고유 메서드 호출");
    }

    //이 메서드는 부모가 물려준 게 아닌 자식 고유의 기능(instructorName은 부모가 처리해줄 수 없음)
    //because 부모는 자식의 내용 알 수 없음
    private String normalizeInstructorName(String instructorName){
        if(instructorName==null||instructorName.isBlank()){
            return "강사 미정";
        }
        return instructorName; //null이 아니거나 공백도 아니라면
    }

}
