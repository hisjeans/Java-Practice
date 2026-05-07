package basic.array.loop;

public class WhileExample {
    public static void main(String[] args) {
        //반복문의 필수 3요소 (begin-end-step)

        int i=1; //begin
        while(i<=10) { //end
            //시작, 끝 불명확할 때
            //i=11-> 조건식 false, while문 탈출
            //1<10 true->while문 안으로 들어감
            //while () 안에 조건 삽입
            System.out.println("안녕하세요! "+i+"번 고객님!");
            //문자열+변수

            i++; //step
            //파이썬은 i+=1로 써야 함
            //==i+=1;
            //==i=i+1
            //증감연산자
            //만일, i+1이 없다면 반복 나올 수 없음
            // 1+1->i=2
            //조건식으로 돌아감
        }

        //for(begin; end; step)
        //시작, 끝 범위 명확할 때 사용
        for(int j=1;j<=10;j++){
            System.out.println("안녕하세요! "+j+"번 고객님!");
        }

        System.out.println("==========================================================");

        //1~100까지의 누적합계 구하기
        //1씩 올리고 더하는 행위를 반복해야 함

        int k=1;
        int total=0; //누적합을 담을 변수, 변수만 선언하면 안 됨

        while(k<=100){
            total+=k;
            k++;
        }
        System.out.println("1~100까지의 누적합: "+total);

        int result=0;
        for(int m=1;m<=100;m++){
            result+=m;
        }
        System.out.println("result = " + result);//intelij ideea: soutv 단축키 사용 가능

        System.out.println("=========================================================");

        //특정 값이 소수(prime number: 나누어 떨어지는 수가 1과 자기자신 밖에 없는 수)인지 소수가 아닌지 판별하는 문제
        int num=97;
        int n=1;
        int count=0; //나누어 떨어진 횟수를 세 줄 변수

        while(n<=num){
            if(num%n==0){
                count++;

            }
            n++;

        }

        if(count==2){
            System.out.println(num+"은(는) 소수입니다.");
        } else{
            System.out.println(num+"은(는) 소수가 아닙니다.");
        }

        System.out.println("========================================================");
        //방법 2

        int s=2; //1은 모든 수의 약수이기 때문에 제외하고 2부터 시작
        while(num%s!=0){
            s++;
        }

        if(num==s){
            System.out.println(num+"은 소수입니다.");
        } else{
            System.out.println(num+"은 소수가 아닙니다.");
        }
    }
}
