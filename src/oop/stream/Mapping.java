package oop.stream;

import java.util.Arrays;
import java.util.List;

import static oop.stream.Menu.*;

// map : 리스트, 컬렉션에서 원하는 데이터만 추출
// original : [ {}, {}, {}, {}, {} ]
// filter   : [ {}, {}, {} ] 객체의 원형은 그대로 유지하되, 조건에 맞지 않는 것만 거름
// map      : [ "", "", "", "", "" ] 수는 변경되지 않지만 객체의 원형은 아님
public class Mapping {
    public static void main(String[] args) {

        // 요리 이름만 출력
        List<String> nameList = MENU_LIST.stream()
                .map(dish -> dish.getName()) //메서드 참조식 Dish::getName 가능
                .toList();
                // .collect(Collectors.toList());
        // toList(): 자바 16부터 쓸 수 있음. 불변 리스트 -> 수정 안됨!, 수정이 필요하지 않은 상황
        // collect(Collectors.toList()): 자바 8부터 존재하던 방식 -> 수정 자유로움, 나중에 수정이 필요한 경우 사용
        // 예) nameList.add, remove 수정 불가능한 리스트


        System.out.println("nameList = " + nameList);

        System.out.println("=====================================================");

        List<String> browsers = List.of("safari", "chrome", "ms edge", "firefox", "opera");

        // 문자열의 길이만 추출 조건
        List<Integer> list = browsers.stream()
                .map(b -> b.length()) // x-> y
                .toList();
        System.out.println("list = " + list);


        List<Character> list2 = browsers.stream()
                // char 기본 타입으로 메서드 제공하지 않기 때문에 대문자 변경 후 첫 번째 글자 추출하도록 함
                .map(b -> b.toUpperCase().charAt(0)) //첫 번째 글자만 추출해 대문자로 표현
                .toList();
        System.out.println("list2 = " + list2);

        System.out.println("=====================================================");


        // 메뉴 목록에서 메뉴 이름과 칼로리만 추출해 새로운 객체로 포장해서 받고자 함
        List<SimpleDish> simpleDishes = MENU_LIST.stream()
                .map(SimpleDish::new) // dish-> SimpleDish 압축 느낌, dish -> new SimpleDish(dish) 일괄적으로 받음
                // new 생성자 SimpleDish 생성자로 new 전달
                .toList();

        simpleDishes.forEach(System.out::println);

        System.out.println("=======================================================");

        /*
            메뉴 목록에서 칼로리가 500칼로리보다 큰
            음식들을 필터링한 다음에 음식의 이름과 타입만
            추출해서 출력해주세요. -> DishDetail이라는 객체로 맵핑
            단, 타입은 MEAT의 경우 육류라고 저장
            FISH는 어류라고 저장, OTHER는 기타라고 저장
         */

       MENU_LIST.stream()
               .filter(dish->dish.getCalories()>500)
               .map(DishDetail::new)
               .toList()
               .forEach(System.out::println);

        System.out.println("=======================================================");

        // 메뉴 목록에 있는 요리들의 총 칼로리 구하기
        int sum = MENU_LIST.stream()
                .mapToInt(Dish::getCalories)
                .sum();//총합
        System.out.println("sum = " + sum);


        // 육류 메뉴의 평균 칼로리 구하기
        double meatAvgCal = MENU_LIST.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .mapToInt(Dish::getCalories)
                .average()
                .getAsDouble();
        System.out.printf("meatAvgCal = %.2f\n", meatAvgCal);

        System.out.println("=======================================================");


        // 모든 요리 이름에 포함된 알파벳을 중복 없이 추출.
        // flatMap: map처럼 변환을 하긴 하는데, 그 결과는 반드시 stream 이어야 한다.
        // 여러개의 스트림을 단일 스트림으로 합쳐줍니다.
/*        String pets="강아지, 고양이, 새, 코끼리";
        String[] split=pets.split(", "); //", " 기준 분할 메서드 split()
        System.out.println("split = " + split);
        String s="programming";
        String[] split1=s.split("");
        System.out.println(Arrays.toString(split1));
*/
        List<String> stringList = MENU_LIST.stream()
                .map(dish -> dish.getName().split("")) // 여기까지 하면 공백이 출력됨
                .flatMap(arr -> Arrays.stream(arr))// 각각의 배열 스트림을 하나의 스트림으로 통합, 모든 문자에 적용시키기 위해
                .filter(name -> name.isBlank()) // 비어 있지 않은 것만 취하도록, 각가의 단일 문자 중 공백을 제거하는 행위
                .distinct()
                .toList();// 단일 문자 담긴 리스트
        System.out.println("stringList = " + stringList);


    }
}
