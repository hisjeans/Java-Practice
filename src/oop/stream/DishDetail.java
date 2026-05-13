package oop.stream;

public class DishDetail {

    private final String dishName;
    private final String type;
    //문자열 받기 위해 String type


    public DishDetail(Dish dish) {
        this.dishName = dish.getName();
        this.type = dish.getType().getDesc();
    }


    @Override
    public String toString() {
        return "DishDetail{" +
                "dishName='" + dishName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


}
