package oop.lambda;

public class Apple {

    private int weight;
    private Color color;

    //기본 생성자 권장
    public Apple() {
    }

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() { //부모가 상속해준 메서드를 자식에 맞게 메서드 재정의
        //Apple extends Object, Object의 자식
        //모든 클래스 toString 오버라이딩할 수 있음
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}
