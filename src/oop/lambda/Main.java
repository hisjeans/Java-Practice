package oop.lambda;


import java.util.List;

import static oop.lambda.Color.*; //import static-> 클래스 이름 생략 가능

public class Main {
    public static void main(String[] args) {

        // 사과 바구니 생성
        // List.of -> 고정형 리스트 생성 (Arrays.asList와 유사)
        // List.of >> 엄격 >> Arrays.asList
        List<Apple> appleBasket = List.of(
                new Apple(80, Color.GREEN) //기존에는 Color.GREEN으로 작성했음, 깔끔하게 상수만 작성하게 위해 import해 클래스 이름 생략
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );

        System.out.println("=========== 녹색 사과만 필터링 ===========");

        List<Apple> greenApples=FilterApple.filterGreenApple(appleBasket);

        for (Apple greenApple : greenApples) {
            System.out.println(greenApple);
        }

        //Apple apple=new Apple(100, Color.RED);

        //System.out.println(apple);
        //System.out.println(apple.toString()); 같은 결과, 자동 생 성
        //toString 메서드 오버라이딩했기 때문에 주소값이 나오지 않고 정보 출력된 것


        System.out.println("============ 원하는 색상의 사과만 필터링 ============");
        List<Apple> redApples=FilterApple.filterAppleByColor(appleBasket, RED);
        for (Apple redApple : redApples) {
            System.out.println(redApple);
        }

        System.out.println("=================================================");

        List<Apple> lightApples
                = FilterApple.filterApple(appleBasket, new LightApplePredicate());
        for (Apple apple : lightApples) {
            System.out.println(apple);
        } //메서드 전달이 안 되기 때문에 객체를 통해 전달하자


        System.out.println("===================================================");

        //빨강 또는 노랑 사과만 필터링
        //클래스를 또 만들기에는 번거로움
        //메서드 호출할 때, 이름 없는 클래스를 즉석에서 만들어 보내면 안 될까? -> 익명 클래스
        //일회용 사용 목적
        List<Apple> apples=FilterApple.filterApple(appleBasket, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor()==RED||apple.getColor()==YELLOW;
            }
        });

        for (Apple apple : apples) {
            System.out.println(apple);
        }

        System.out.println("===================================================");

        // 녹색이면서 100g 이하인 사과만 필터링
        // 우리는 이제 익명클래스를 통해, 새 클래스 파일 생성 없이 즉석에서 보낼 수 있다!
        // 근데... 어짜피 인터페이스에 추상메서드 하나 아니냐?
        // 그럼 이름을 굳이 언급할 필요 있나? -> 람다식 쓰자!
        // 함수형 표현식 람다식
        // 람다식은 구현하고자 하는 인터페이스가 추상메서드를 딱 하나만 가질 때만 사용할 수 있음
        // 람다식을 이용해서 메서드를 오버라이딩 할 때, 메서드의 내용이 단 한 즐이고, 그 한 줄이 return 문이라면
        // 중괄호(메서드 바디)와 return 키워드를 생략할 수 있음
        List<Apple> apples2=FilterApple.filterApple(appleBasket,
                //(
                apple
                        //)
                        -> //{
                        //return
                        apple.getColor()==GREEN&&apple.getWeight()<=100


                //}
        ); //메서드 이름 작성하지 않으면서 오버라이딩

        for (Apple apple : apples2) {
            System.out.println(apple);
        }


        System.out.println("===================================================");


        //색깔이 빨강 혹은 초록이면서, 무게는 150g 초과이어야
        //논리 연산에서 and가 or 보다 우선
        List<Apple> apples3=FilterApple.filterApple(appleBasket,
                apple-> (apple.getColor()==GREEN
                        ||apple.getColor()==RED)
                        &&apple.getWeight()<150);
        //apple.getColor()==RED || apple.getColor()==GREEN && apple.getWeight -> RED는 무게와 상관없이 모두 출력됨, and>>연산자 우선순위>>or

        for (Apple apple : apples3) {
            System.out.println(apple);
        }

        System.out.println("===================================================");

        //FilterApple은 Apple 타입만 거를 수 있지만 apple에 LectureLog, 숫자, 음식들이 올 수 있음
        //여러가지 타입의 객체를 필터링
        List<Integer> numbers=List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> filter1=FilterApple.filter(numbers, n->n%2==0); //짝수만 true로 만들고 홀수는 false로 만들어 리스트에 담기지 않게 함
        System.out.println(filter1);
        /*람다식 사용하지 않으면
        List<Integer> filter1=FilterApple.filter(numbers, new GenericPredicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        }); //짝수만 true로 만들고 홀수는 false로 만들어 리스트에 담기지 않게 함
        */

        List<String> foods=List.of("떡볶이", "아부라소바", "라면", "김치찌개", "삼겹살", "마라탕");
        List<String> filter2=FilterApple.filter(foods, f -> f.length()==3);
        System.out.println(filter2);
    }

}
