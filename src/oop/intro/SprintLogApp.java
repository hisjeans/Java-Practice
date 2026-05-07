package oop.intro;

public class SprintLogApp {
    public static void main(String[] args) {

        //객체 생성
        //객체를 가리키고 있는 주소값 담은 변수로 구분 가능

        LearningLog javaLog=new LearningLog();
        //javaLog 정보 생성
        javaLog.title="Java 시작";//'.' 참조
        javaLog.minutes=40;
        javaLog.publicLog=true;

        //클래스는 =, 생성된 객체 !=
        LearningLog gitLog=new LearningLog();
        //객체 생성했다면 주소 저장해야

        javaLog.title="Git 복습";//'.' 참조
        javaLog.minutes=30;
        javaLog.publicLog=false;

        LearningLog conditionLog = new LearningLog();
        conditionLog.title = "조건문 학습";
        conditionLog.minutes = 75;
        conditionLog.publicLog = true;

        LearningLog loopLog = new LearningLog();
        loopLog.title = "반복문 학습";
        loopLog.minutes = 120;
        loopLog.publicLog = true;

        //모두 LearningLog 타입
        LearningLog[] logs={javaLog, gitLog, conditionLog, loopLog};

        System.out.println("=== 객체로 관리하는 학습 기록 ===");
        for (int i=0;i<logs.length;i++){ //인덱스는 배열의 크기 보다 항상 1 작음
            logs[i].printSummary();
        }

        System.out.println();
        System.out.println("=== 복습 필요 기록 ===");
        for(LearningLog log:logs){
            if(!log.needsReview()) {
                log.printSummary();
                //boolean 타입이기 때문에 minutes<60 true/false 리턴


            }
        }
        System.out.println();
        System.out.println("=== 공개 기록 ===");
        for(LearningLog log:logs){
            if(!log.publicLog){
                continue;
            }
            log.printSummary();
        }
    }
}
