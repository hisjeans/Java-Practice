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

    }

}
