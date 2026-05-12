package oop.lambda;

public interface ApplePredicate {

    //조건식을 파라미터화할 것
    //사과를 전달받으면 조건에 맞는 검사를 수행하고, 결과를 리턴하는 메서드
    boolean test(Apple apple);

}
