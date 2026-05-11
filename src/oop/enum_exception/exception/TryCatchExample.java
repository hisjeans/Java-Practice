package oop.enum_exception.exception;

public class TryCatchExample {
    public static void main(String[] args) {

        try {
            //try 블록에는 예외 발생 가능성이 있는 코드 배치
            int i=20, j=0; //j가 4라면 에러가 발생하지 않기 때문에 catch문 실행되지 않음

            System.out.println(i+"/"+j+" = "+(i/j));
        } catch (Exception e) {//try 부문에서 예외가 발생했을 때 출력되는 부분
            //catch 블록에는 try에서 실제 예외가 발생했을 경우
            //실행할 내용 작성
            System.out.println("0으로 나누시면 안 됩니다");

        }

        System.out.println("프로그램 정상 종료");
    }
}
