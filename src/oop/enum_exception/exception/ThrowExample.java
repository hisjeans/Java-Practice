package oop.enum_exception.exception;

public class ThrowExample {

    static int calcTotal(int end) throws RuntimeException{
        if(end<=0){//프로그램상으로는 에러가 나지 않지만 나의 기준에서는 에러
            throw new RuntimeException("매개값은 양수로 주세요"); //메시지 담아 전달
            //예외가 발생하는 그 즉시 프로그램 종료
            //calcTotal안에서 try-catch문을 할 필요가 없음
            //자바에서 잡지 못하는 예외 직접 생성
        }
        int total=0;
        for(int i=1;i<=end;i++){ //if) end=-120_1<=-120_false 반복문 탈출
            total+=i;
        }
        return total;
    }

    public static void main(String[] args){ //try-catch

        try{
            int result=calcTotal(100);
            System.out.println("result = "+result);

            int result2=calcTotal(-120); //예외 객체가 전달됨
            System.out.println("result2 = "+result2);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.println("프로그램 정상 종료");

    }     //종료 코드 1 비정상 종료, 0 정상 종료
}
