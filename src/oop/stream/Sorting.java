package oop.stream;

import java.util.Comparator;
import java.util.List;

import static oop.stream.Menu.*;

public class Sorting {

    public static void main(String[] args) {

        // 육류 요리 중 칼로리가 낮은 순으로 정렬
        List<Dish> meatAsc = MENU_LIST.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .sorted(Comparator.comparing(Dish::getCalories)) // 칼로리로 비교하는 것은 compare 에 전달하면 오름차순으로 전달해줌
                .toList();

        meatAsc.forEach(System.out::println);


        System.out.println("======================================================");

        // 전체 메뉴 이름 기준 내림차순으로 정렬(zxy..순)
        MENU_LIST.stream()
                .sorted(Comparator.comparing(Dish::getName).reversed()) // 기본 오름차순 정렬 -> 반대로 바꿔 역으로(내림차순) 출력하도록 함
                .forEach(System.out::println);

        System.out.println("======================================================");


        // 300 칼로리 이상인 요리 중 칼로리가 낮은 탑 3 요리를 필터링
        MENU_LIST.stream()
                .filter(dish->dish.getCalories()>=300)
                // 첫 번째 정렬 기준: 칼로리 오름차순, 만일 칼로리가 같다면 이름 내림차순
                .sorted(Comparator.comparing(Dish::getCalories).thenComparing(Dish::getName, Comparator.reverseOrder())) // 그 다음으로 comparing할 때는 reverse로
                .limit(3)
                .forEach(System.out::println);
    }
}
