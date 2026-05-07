package basic.array.array;

import java.util.Arrays;

public class ArrayBasic {
    public static void main(String[] args) {
        //1. 배열 변수 선언: int 값, 정수 여러 개 들어갈 수 있는 변수
        //int numbers[] 가능하지만 C언어 타입에 가까움
        int[] numbers;

        //2. 배열 객체 생성: 5 크기
        numbers=new int[5];

        //3. 배열 내부 초기화
        //인덱스를 지목해 데이터 할당
        //인덱스는 0부터 시작해 1씩 증가
        numbers[0]=50;
        numbers[1]=77;
        numbers[2]=(int)3.14; //배열 int로 선언했기 때문에 실수, 문자 들어갈 수 없음
        //double을 int로 변환해 값을 할당할 수 있음, 소수점이 탈락
        //numbers[4]="메롱"; (x)
        numbers[3]=numbers[0]+20; //numbers[3] 영역에 20이란 값 대입
        numbers[4]=100;
        //numbers[5]=10; (x) 인덱스 크기 < 배열, 배열 길이 벗어난 인덱스, 빨간 줄 뜨지 않으니 조심

        //4. 배열의 길이
        System.out.println("배열의 길이: "+numbers.length);

        //5. 배열의 순회
        for(int i=0;i< numbers.length;i++){
            System.out.println((i+1)+"번째 값: "+numbers[i]);
        }

        //배열의 순회 forEach (향상된 for문), 배열에서 유용
        for(int n : numbers){
            //iter
            // for( 배열 안의 값 받을 변수 선언 : 반복 돌릴 배열)
            //for-each문 동작: numbers[0]의 값->n 전달되어 반복문 한 바퀴 실행, numbers[1]의 값->n 전달되어 반복문 한 바퀴 실행....
            System.out.println(n);
            //for 장점: 직접 범위 지정 가능 vs for-each 장점: 범위 지정 필요 없음(전체 범위)
            //무조건 범위는 배열의 처음부터 끝까지 설정(물론, 중간에 break, continue 가능)

        }

        //배열 내부 문자열 형태로 한 번에 출력
        System.out.println(Arrays.toString(numbers));


        //배열 쉽게 초기화 하기
        int[] pointList={10, 20, 30, 40};
        String[] pets={"멍멍", "미야오", "짹짹", "그르릉"};
        //크기 고정됨
        //pets={"멍멍", "미야오", "짹짹"}; (x)
        pets=new String[]{"멍멍", "야옹", "짹짹"};
        //선언 당시에 크기가 고정되고, 이 크기는 변할 수 없음
        //만약 혹시라도 크기를 늘리거나 줄이고 싶다면 배열을 새로 만들어 값을 옮겨야 함
    }
}
