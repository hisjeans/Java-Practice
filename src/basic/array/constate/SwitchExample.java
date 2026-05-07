package basic.array.constate;

public class SwitchExample{
    public static void main(String[] args) {

        String gender="l";

        //경우의 수가 많고, 이 경우가 잘 분리된다면 switch문 편리 != if문
        //if문처럼 논리형 조건식이 들어가는 게 아니라
        //분기를 나눌 기준값이 괄호 안에 들어감 (문자열, 정수만 가능)
        switch (gender){ //(기준)
            case "m":
                //gender="m"일 때 break를 비롯해 아무것도 실행되지 않기 때문에 case "M" 실행될 것=>"남성입니다."
            case "M":
            case "남":
            case "-":
                // == case "m": case "M": case "남":  case "-":

                System.out.println("남성입니다.");
                //여기까지만 작성할 경우 "M" case일 때 아래 조건문까지 출력됨
                break;
            //해당 케이스만 실행하고 switch문을 종료

            case "F", "f", "여", "ㄹ":
                //java 14버전 이후 개선된 case 문
                System.out.println("여성입니다.");
                break;

            default:
                //case를 설정하지 않은 값들은 모두 default로 빠짐
                //default는 break를 적지 않아도 괜찮음 because 아래에 추가되는 case가 없기 때문
                System.out.println("잘못된 성별입니다.");
        }
    }
}
