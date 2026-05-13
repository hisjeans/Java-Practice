package oop.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static oop.stream.Menu.MENU_LIST;

public class Filtering {
    public static void main(String[] args) {

        // stream API filter 기능
        // 요구사항, 요리 메뉴(메뉴 클래스의 메뉴 리스트) 중 채식주의자가 먹을 수 있는 요리만 필터링

        /*
        Stream<Dish> stream = MENU_LIST.stream();

        //람다식으로 표현 가능
        Stream<Dish> dishStream = stream.filter(new Predicate<Dish>() {
            @Override
            public boolean test(Dish dish) {
                return dish.isVegetarian(); //true->true, false->false
            }
        });
        List<Dish> dishList = dishStream.toList();
        for (Dish dish : dishList) {
            System.out.println(dish);
        }

         */

        // 코드 간결화
        List<Dish> dishList = MENU_LIST.stream()
                .filter(Dish::isVegetarian) // 럄다를 메서드 참조로 바꾸기, filter 메소드 안에서 Dish 객체 안에 있는 isVegeterian 호출, 일괄 참조
                .toList();

        // 향상 for문을 메서드화
        dishList.forEach(System.out::println); // dish 전달될 때마다 sout 전달


        System.out.println("====================================================");

        // 메뉴 목록 중에 육류이면서 600 칼로리 미만인 요리를 필터링해서 출력
        // stream 여는 것으로 시작해야 filter() 가능
        // 변수 호출하는 목적 to 자주 사용 but 한 번만 출력하고 끝내는 것은 굳이 변수 선언할 필요 없음
        // 메소드 체이닝 (method chaining) : 리턴된 결과물을 변수에 할당 없이 바로 호출하는 문법
        MENU_LIST.stream()
                .filter(dish->dish.getType()==Dish.Type.MEAT && dish.getCalories()<600)
                .toList()
                .forEach(System.out::println);

        System.out.println("====================================================");

        // 메뉴 목록에서 요리 이름이 4글자인 것만 필터링해서 출력해줘
        MENU_LIST.stream()
                .filter(dish -> dish.getName().length()==4)
                .toList()
                .forEach(System.out::println);


        System.out.println("=====================================================");

        // 칼로리가 300칼로리보다 큰 요리 중에 앞에 3개만 가져오자
        MENU_LIST.stream()
                .filter(dish->dish.getCalories()>300)
                .limit(3) // 앞에서부터 3개만 추출
                .toList()
                .forEach(System.out::println);

        System.out.println("=====================================================");

        // 칼로리가 300칼로리보다 큰 요리 중에 처음 2개 빼고 가져오자
        MENU_LIST.stream()
                .filter(dish->dish.getCalories()>300)
                .skip(2) // 맨 앞 2개 제외
                .toList()
                .forEach(System.out::println);

        System.out.println("=====================================================");

        // 숫자 리스트
        List<Integer> numbers = List.of(1, 2, 1, 3, 3, 2, 4, 4, 4, 5, 6);

        // 리스트에서 짝수만 필터링 (중복은 제거해서)
        numbers.stream()
                .filter(n->n%2==0)
                .distinct() //중복 제거
                .toList()
                .forEach(System.out::println);
    }
}
