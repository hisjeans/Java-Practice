package oop.lambda;

@FunctionalInterface
public interface GenericFunction<X, Y> {

    // X 에서 Y를 추출해 줄 것
    Y apply(X x); // X, Y 나중에 결정될 것
    // 매핑 목적으로 구현한 인터페이스
}
