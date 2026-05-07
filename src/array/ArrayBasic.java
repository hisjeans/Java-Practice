package array;

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
        //numbers[5]=10; (x) 인덱스 크기 < 배열

        //4. 배열의 길이
        System.out.println("배열의 길이: "+numbers.length);
    }
}
