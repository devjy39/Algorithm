package modern;

import java.util.ArrayList;
import java.util.List;

public class Apple {
    int weight;
    String country;

    public Apple(int weight, String country) {
        this.weight = weight;
        this.country = country;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", country='" + country + '\'' +
                '}';
    }

    public static List<Apple> getList() {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(10,"한국"));
        list.add(new Apple(20,"중국"));
        list.add(new Apple(30,"미국"));
        list.add(new Apple(40,"캐나다"));
        list.add(new Apple(50, "일본"));
        return list;
    }
}
