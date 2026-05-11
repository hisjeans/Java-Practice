package oop.enum_exception.exception.custom;


public class main {
    public static void main(String[] args) {
        LoginUser user=new LoginUser("abc1234", "aaa11111!");
        String result=null; //해결: try문 밖에 선언
        try{
            /*String*/ result=user.authenticate("abc1234", "abc11111!");
            //데이터타입 붙은 것으로 result 선언 위치 알 수 있음
            //try 블록 안에서 result 변수가 선언된 것
            //try 블록을 벗어나면 result는 유효하지 않음

        } catch (LoginInvalidException e) {
            System.out.println(e.getMessage());
            System.out.println("입력한 값: "+e.getInputAccount()); //아이디가 틀렸다면 아이디, 비밀번호가 틀렸다면 비밀번호 나옴
        }

        System.out.println("result = "+result); //try 블록 바깥에 result 출력하려고 함
        //변수의 생명주기: 변수는 선언된 블록 내에서만 유효
        //예) if문 내에 선언된 변수는 if문 내에서만 유효
    }
}
