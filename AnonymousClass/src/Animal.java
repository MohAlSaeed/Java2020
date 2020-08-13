public abstract class Animal {
    String name;
    int weight;

    Animal(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public abstract String speak();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", speak=" + speak() +
                '}';
    }
}
