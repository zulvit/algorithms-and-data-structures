package entity;

public record Minion(String name, String color, int age, float height, float weight) {
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
}
