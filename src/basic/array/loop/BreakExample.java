package basic.array.loop;

public class BreakExample {
    public static void main(String[] args) {

        for(int i=1;i<=10;i++){

            if(i==5) break;
            //반복횟수와 무관하게 강제 종료
            //break는 보통 if문과 함께 사용
            //블록 내의 코드가 한 줄인 경우에는 괄호 생략이 가능(두 줄부터는 불가능)
            //if문 한 줄이라면 {} 생략 가능

            System.out.print(i+" ");
            //print line, println


        }

        System.out.println("\n==========================================");
        //'\n' 줄바꿈 기호

        outer: for(int i=0;i<=2;i++) { //바깥쪽 반복문을 정지시키고 싶다면 outer로 타겟 지정
            for (int j = 0; j <= i; j++) {
                if (i == j) break outer; //break의 target은 for(int j...)
                //break outer(타겟)

                System.out.println(i + "-" + j);
            }
        }
    }
}
