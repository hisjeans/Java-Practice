package oop.lambda;

//추상 메서드 하나만 선언할 것
@FunctionalInterface
public interface GenericPredicate<T> {

    boolean test(T t); //이제 다양한 타입이 올 수 있다 가정
    //현재는 무슨 타입인지 알 수 없는 T 타입으로 받을 것
    //객체가 생성될 때 T가사용한 타입을 따라갈 것
    //List<String>->T에 전달되면서 T의 타입이 String이 됨
    //List jeneric 쓰지 않으면 object로 작성됨 but object타입은 자식의 고유한 메서드 사용 불가능
    //=>객체가 생성되었을 때 사용한 그 타입으로 사용, return 타입에도 사용 가능

}
