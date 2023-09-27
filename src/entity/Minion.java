package entity;

import java.util.Comparator;

public record Minion(String name, String color, int age, float height, float weight)
        implements Comparable<Minion> {
    public final static String YELLOW = "YELLOW";


    @Override
    public String toString() {
        return "entity.Minion{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Minion o) {
        return this.name.compareTo(o.name);
    }

    public static final Comparator<Minion> AGE_COMPARATOR = Comparator.comparingInt(m -> m.age);
}
