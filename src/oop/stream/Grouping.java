package oop.stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static oop.stream.Menu.*;

public class Grouping {

    public static void main(String[] args) {

        // 채식 요리와 아닌 요리로 메뉴를 나눠보자
        // partitioning 두 분류로 나누어 줌(분류 기준을 논리값으로 전달해 주어야 함)
        Map<Boolean, List<Dish>> veggieMenu = MENU_LIST.stream() // key 타입 boolean<-true, false 만 들어갈 수 있음 따라서 맵 크기 2
                .collect(Collectors.partitioningBy(Dish::isVegetarian));

        System.out.println("--- 채식 메뉴 ---");
        //System.out.println(veggieMenu.get(true)); 맵은 인덱스 없어 전달 시 key 전달해야
        veggieMenu.get(true).forEach(System.out::println); // 깔끔하게 출력하기 위해
        System.out.println("--- 일반 메뉴 ---");
        veggieMenu.get(false).forEach(System.out::println);

        System.out.println("======================================================");

        // 요리를 종류(Type) 별로 그룹화
        Map<Dish.Type, List<Dish>> menuByType = MENU_LIST.stream() // key: MEAT, FISH, OTHER 각각의 키가 List<Dish>로 세팅되어 있음
                .collect(Collectors.groupingBy(Dish::getType));

        System.out.println("--- 기타 메뉴 ---");
        menuByType.get(Dish.Type.OTHER).forEach(System.out::println); // 일괄 출력

        System.out.println("======================================================");


        // 종류별로 나눈 메뉴를 칼로리 기준(500 넘으면 고칼로리, 나머지는 저칼로리) 으로 한 번 더 그룹화
        Map<Dish.Type, Map<String, List<Dish>>> detailedMenu
                = MENU_LIST.stream()
                .collect(Collectors.groupingBy(Dish::getType, // 1차 분류 조건: 타입으로 그룹을 나눌 것
                        Collectors.groupingBy(dish -> {
                            if (dish.getCalories() > 500) return "고칼로리";
                            else return "저칼로리";
                        }) // 2차 분류 기준: 칼로리
                        // 람다식 메서드 내용 한 줄이면 생략 가능, 여러 줄이라면 반드시 {}
                        // dish->dish.getCalories()>500? "고칼로리":"저칼로리" 한 줄로 표현 가능

                )); //MEAT(고칼로리: [], 저칼로리ㅣ []), FISH(고칼로리: [], 저칼로리ㅣ []), OTHER(고칼로리: [], 저칼로리ㅣ [])

        detailedMenu.get(Dish.Type.OTHER).get("저칼로리").forEach(System.out::println);

        System.out.println("======================================================");


        // 종류 별 요리 개수
        Map<Dish.Type, Long> dishCount = MENU_LIST.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting())); // 숫자 세는 건 counting

        System.out.println("dishCount = " + dishCount);

        // 종류별 요리 총 칼로리
        Map<Dish.Type, Integer> totalCalByType = MENU_LIST.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories))); // 각각의 칼로리 합 summingint
        System.out.println("totalCalByType = " + totalCalByType);


        System.out.println("======================================================");

        Map<Dish.Type, IntSummaryStatistics> calorieStas = MENU_LIST.stream() // 모든 칼로리에 대한 계산식 제공
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.summarizingInt(Dish::getCalories)));

        // 요리 종류별 그룹화 후 칼로리에 대한 통계 꾸러미가 리턴(개수, 평균, 합계, 최대/최소)
        System.out.println(calorieStas);
    }
}
