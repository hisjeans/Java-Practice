package oop.lambda;

import java.util.ArrayList;
import java.util.List;

public class MappingApple {

    // 새 요구사항, 사과의 색상만 추출
    public static List<Color> mapplingAppleByColor(List<Apple> apples){
        List<Color> colorList=new ArrayList<>();
        for (Apple apple : apples) {
            colorList.add(apple.getColor());

        }
        return colorList;
    } //조건을 거는 게 아닌 요구에 맞는 특정 값만 추출해 매핑

    //파라미터화 apple.getColor()가 나중에는 getWeight(), x->y가 요구될 수 있다 가정하면
    // 어떤 타입의 리스트를 받아도 맵핑이 가능한 전역 메서드를 선언해 보자(X->Y)
    // 제너릭 타입 붙여줘야
    public static <X, Y> List<Y> map(List<X> list, GenericFunction<X, Y> mapper){
        List<Y> mappedList=new ArrayList<>(); //Y를 추출해 리턴해야
        for (X x : list) {
            Y y=mapper.apply(x);
            mappedList.add(y);
        }
        return mappedList;
    }




}
