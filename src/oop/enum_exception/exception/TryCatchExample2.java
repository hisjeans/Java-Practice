package oop.enum_exception.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExample2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); //입력값 잘못 들어가면 예외 발생
        //runtime exception: 실행과정에서 예외 발생
        //compile error: 문법적으로 틀려 실행할 수 없는 상태

        int[] arr=new int[5];

        try {
            System.out.print("정수: ");
            int n=sc.nextInt();

            int result=100/n; //특정 숫자를 0으로 나누는 행위 자체를 자바에서 인정하지 않음

            System.out.println(arr[result]); //100/5=2->arr[20] 없음, 범위(~arr[4])를 벗어남

            String s=null; //null 어느것도 참조하지 않음
            //객체 생성 stack(변수 선언 주소값 저장) -주소값을 보고 찾아감-> heap(객체의 주소값)
            //null 참조해 객체 찾아갈 수 없음
            s.equals("메롱");//빨간줄로 그이지 않은 이유: string 타입 변수에 equals란 메서드 있음-> 코드 작성 당시 문제 없음
        } catch (InputMismatchException|ArithmeticException e) { //비정상 종료되지 않음
            //다중 예외 처리 가능 단, 관련 있는 예외 처리 권장
            System.out.println("입력값이 잘못 되었습니다");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("인덱스 범위를 벗어났어요");
        } //exception의 자식들
        catch (Exception e) {
            System.out.println("예상치 못한 예외 발생"); //예상치 못한 예외 처리, 나머지 모든 예외 처리
            //위에 쓸 수 없음 예외가 발생하면 그 예외는 자신을 받아줄 수 있는 예외문을 위에서부터 아래로 검사하기 때문에 위에서 exception이 나오면 밑의 예외 처리를 할 수 없음
            //항상 exception 예외 처리는 마지막에 두자
            //System.out.println(e.getMessage()); 예외 메시지 확인 가능
            e.printStackTrace();//전체 예외 메시지 내용 확인 가능
            //예외 역추적
            //사용자에게 보여줄 필요는 없지만 개발 과정에서 확인차 사용

        }
        //예외마다 다른 결과 보여주려면->다중 catch문
        //자바에서는 예외 타입에 맞는 객체 생성
        //자바는 예외가 발생하면 해당 예외에 맞는 객체 생성


    }

}
