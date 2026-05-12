package oop.lambda;

public class LightApplePredicate implements ApplePredicate{
//메서드 항상 동일하게 동작시키기 위해 인터페이스 구현

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()<=100;
    }


}
