package oop;

import java.util.Scanner;

public class SprintLogApp {
    public static void main(String[] args) {


        String[] titles = {"Java 시작", "Git 복습", "조건문 학습", "반복문 학습"};
        int[] minutes = {40, 30, 75, 120};
        boolean[] publicFlags = {true, false, true, true};


        //각각의 배열에 0번 인덱스 연관되어 있는 것으로 생각

        Scanner sc=new Scanner(System.in);

        //반복 횟수 알 수 없음
        //for문 범위 명확할 때 주로 사용, while문 범위 불명확할 때 사용

        while(true){
            //(반복문 종료되는 조건) - menu가 0이 입력되었을 때이지만 menu==0 or menu!=0 조건 쓸 수 없음 왜냐하면 menu를 밑에서 입력받기 때문
            //true는 변수가 아닌 논리값 그 자체
            //무한 반복문

            printMenu();

            int menu=sc.nextInt();

            if(menu==1){
                printAllLogs(titles, minutes);
                //메서드 단축키 드래그, command+option+m
                //command+클릭하면 메서드 확인 가능
            } else if(menu==2){
                printPublicLogs(titles, publicFlags, minutes);
            } else if(menu==3){
                int total = calculateTotalMinutes(minutes);
                //menu=3의 total 변경하는데 menu=4의 total도 메서드 호출하는 것으로 변경됨
                System.out.println("전체 학습 시간: "+total+"분");

            } else if(menu==4){
                //기준: 공부시간이 60분이 되지 않는 학습은 복습 필요

                printReviewLogs(titles, minutes);

            } else if(menu==5){
                printLongStudy(titles, minutes);
            }




            else if (menu==0) {

                System.out.println("프로그램을 종료합니다.");
                break;
                //무한 반복에서 반복 종료하려면 조건문에 break 필요
            }

            //여기까지만 입력하면 사용자가 입력한 뒤 바로 끝남
        }
    } //end main

    static void printLongStudy(String[] titles, int[] minutes) {
        printDivider("긴 학습 기록");
        for(int i = 0; i< titles.length; i++){
            if(minutes[i]>=100){ //100분 이상을 긴 학습 기록으로 인정
                System.out.println((i+1)+"."+ titles[i]+" - "+ minutes[i]+"분");
            }
            //option+shift+방향키: 코드 위, 아래 옮길 수 있음
        }
    }

    static void printReviewLogs(String[] titles, int[] minutes) { //매개변수(=parameter)전달받아 내부에서 로직
        //메서드 앞에 return 타입 표시해야
        for(int i = 0; i< titles.length; i++){
            if(minutes[i]<60){
                printLogItemO(i+1, titles[i], minutes[i]);
            }
            //option+shift+방향키: 코드 위, 아래 옮길 수 있음
        }

        int total = calculateTotalMinutes(minutes);
        double avg=(double) total/ minutes.length; //total, minutes.length 모두 int 타입, 소수점 살릴 수 없음
        //소수점까지 표시하기 위해 double 타입으로 변경해줌
        System.out.println("평균 학습 시간: "+avg+"분");
    }

    static int calculateTotalMinutes(int[] minutes) {
        int total=0; //누적해서 합해야 하니

        for(int m: minutes){
            total+=m;
        }
        return total; //계산한 total 값 메서드 호출한 곳으로 돌려줌, int return
    }

    static void printPublicLogs(String[] titles, boolean[] publicFlags, int[] minutes) {
        printDivider("공개된");
        for(int i = 0; i< titles.length; i++){
            if(!publicFlags[i]){ //publicFlags[i]에는 무조건 true or false가 오기 때문에 "==false" 작성하지 않음
                //==publicFlags[i]==false 이지만 '!'으로 작성하는 것 선호
                //예: true->not true==false, false->not false==true
                //if문 true일 때만 동작하기 때문에 '!'
                //break 쓰면 반복문 자체를 나오게 되기 때문에 continue로 건너뛰도록 함
                continue;
            }
            printLogItemO(i+1, titles[i], minutes[i]);
        }
    }

    static void printAllLogs(String[] titles, int[] minutes) {
        printDivider("전체");


        for (int i = 0; i< titles.length; i++){
            printLogItemO(i+1, titles[i], minutes[i]);
        }
    }


    //메서드 이름 앞에는 메서드가 반환하는 값의 타입을 작성하는데 돌려줄 값이 없다면 void
    //main 밖에서 메서드 선언
    static void printMenu(){
        System.out.println();
        System.out.println("===== Spring =====");
        System.out.println("1. 전체 기록 출력");
        System.out.println("2. 공개 기록만 출력");
        System.out.println("3. 전체 학습 시간 출력");
        System.out.println("4. 복습 필요 기록 출력");
        System.out.println("5. 긴 학습 기록 출력");
        System.out.println("0. 종료");
        System.out.println("메뉴를 선택하세요: ");

    }

    //각각의 기능을 main에 넣으면 매우 길어지고 유사한 기능 존재->메서드
    //메서드 선언
    //모든 로직을 main에 넣을 수 있지만 길어질 경우 코드의 중복 빈번, 반복되는 출력 내용 작성 번거로움
    //메서드를 의미있는 이름으로 코드 모듈화해 사용하면 코드 재사용성 높일 수 있음

    static void printDivider(String title){ //메서드 반환 타입을 처음부터 작성할 필요 없음
        System.out.println("=========== "+title+" 기록 ============="); //각 메뉴 이름만 다르고 그 외 표현은 동일

    }

    static void printLogItemO(int index, String title, int minutes){
        System.out.println(index+"."+title+" - "+minutes);
    }
}
