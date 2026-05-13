package oop.stream;

import java.util.Comparator;

import static oop.stream.Menu.MENU_LIST;

public class Finding {
    public static void main(String[] args) {

        // 탐색 결과 도출 메서드
        // 메뉴 목록에서 500칼로리 이상 요리 중 채식주의자가 먹을 수 있는 요리가 하나라도 존재 하는가?
        boolean flag1 = MENU_LIST.stream()
                .filter(dish -> dish.getCalories() >= 500) // filter 에 조건을 추가해도 괜찮지만 작성 내용이 많아지기 때문에 anyMatch
                .anyMatch(dish -> dish.isVegetarian());// 뭐라도 매칭되는 게 있는지

        System.out.println("flag1 = " + flag1);

        // 메뉴 목록 중 칼로리가 100 이하인 요리가 하나라도 존재 하는가?
        boolean flag2 = MENU_LIST.stream()
                .anyMatch(dish -> dish.getCalories() <= 100);
        System.out.println("flag2 = " + flag2);


        // 음식 메뉴 중에 모든 요리가 1000칼로리 미만 인가요?

        boolean flag3 = MENU_LIST.stream()
                .allMatch(d -> d.getCalories() < 1000);// 모두 일치해야 함 => allMatch
        System.out.println("flag3 = " + flag3);


        // 음식 메뉴 중에 모든 요리가 1000칼로리 미만이 아닌가요?
        boolean flag4 = MENU_LIST.stream()
                .noneMatch(d -> d.getCalories() > 1000);// 전부 불일치 하는가? nonMatch <-> allMatch
        System.out.println("flag4 = " + flag4);

        // 음식 중에 칼로리가 제일 낮은 애가 누구에요?
        Dish d = MENU_LIST.stream()
                .min(Comparator.comparing(dish -> dish.getCalories())) //가장 작은 값 판별하기 위해 값 비교
                .get();
        System.out.println("d = " + d);

    }
}
