package basic.array;

public class JavaStarter {
    public static void main(String[] args) {
        //control 마우스 휠 글자 크기 변경 가능
        //main 자동완성
        //java는 최소 1의 main 함수 필요
        //주석(comments)은 프로그램의 실행에 영향을 주지 않음
        /*
        문장 주석
         */

        String title="Java 변수와 자료형";
        int studyMinutes=90;
        int targetMinutes=120;
        int extraMinutes=60;

        studyMinutes=100; //값은 1당 1밖에 들어가지 못하기 때문에 기존의 값이 밀려나 새로운 값이 들어가게 됨

        //변수명 중복 불가능
        boolean isPublic=true;
        //논리형 타입 true/false
        //자바는 데이터 타입 엄격
        char level='A';

        //자바에서 int와 int의 연산 결과는 항상 int
        //소수점을 표현하고 싶다면 연산하고자 하는 값의 타입을 실수형(double)로 변경해야
        double progressRate=(double)studyMinutes/targetMinutes;
        //int->double 타입 변환
        //자바에서 int/int=int
        //int와 double의 연산=double_더 큰 타입으로 보는 실수에 맞춤
        boolean isEnoughStudy=studyMinutes>=60;

        //문자열의 덧셈 연산은 뒤에 어떤 타입이 들어와도 가능
        //연산의 결과는 항상 문자열
        System.out.println("제목: "+title);
        //문자+문자, 문자+정수, 문자+실수, 문자+논리 타입 ... 모두 가능
        System.out.println("학습 시간: "+studyMinutes+"분");
        System.out.println("목표 시간: "+targetMinutes+"분");
        System.out.println("추가 시간: "+extraMinutes);
        System.out.println("중요도: "+level);
        System.out.println("진도율: "+progressRate+"%");
        System.out.println("충분히 학습했나요?: "+isEnoughStudy);

        //sout : 인텔리제이 출력 함수 생성
        //실행 단축키 control+shift+R



    }
}

//이곳에서도 주석 가능
