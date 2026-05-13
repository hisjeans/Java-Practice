package oop.lambda;

//추상 메서드를 반드시 하나만 가질 수 있음
//함수형 인터페이스는 추상메서드가 오직 하나여야 함(그래야 람다식 사용 가능)
@FunctionalInterface
public interface ApplePredicate {

    //조건식을 파라미터화할 것
    //사과를 전달받으면 조건에 맞는 검사를 수행하고, 결과를 리턴하는 메서드
    boolean test(Apple apple);

}
