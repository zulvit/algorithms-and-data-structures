package module1;

public class Minion {
    public final static String YELLOW = "YELLOW";
    private final String name;
    private final String color;
    private final int age;
    private final float height;
    private final float weight;

    public Minion(String name, String color, int age, float height, float weight) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Minion{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
