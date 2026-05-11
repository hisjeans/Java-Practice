package oop.enum_exception.exception.custom;

// 로그인 검증을 수행하는 클래스
public class LoginUser {

    private String account;
    private String password;

    public LoginUser(String account, String password) {
        this.account = account;
        this.password = password;
    }

    // 로그인 검증 기능
    public String authenticate(String inputAccount, String inputPassword)
            throws LoginInvalidException {
        //메서드를 호출한 객체가 입력된 account와 같지 않다면 즉, 틀리다면
        //this.account!=inputAccount (x) 자바에서는 문자열 비교할 때 연산자 사용 불가
        //자바에서 문자열 타입은 string, 이는 기본 데이터 타입 아님

        if (!this.account.equals(inputAccount)) {
            throw new LoginInvalidException("회원 가입이 되지 않은 계정입니다.", inputAccount);
        } //false이면 this.acoount!=inputAccount -> 예외 발생

        if (!this.password.equals(inputPassword)) {
            throw new LoginInvalidException("비밀번호가 틀렸습니다.", inputPassword); //연습용, 실제로는 비밀번호 노출 위험
        }


        System.out.println("로그인에 성공하셨습니다.");

        return "로그인 성공!";
    }
}