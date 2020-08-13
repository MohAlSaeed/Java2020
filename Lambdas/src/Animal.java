public abstract class Animal implements Animaldo{
    String name;
    int weight;

    Animal(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String Animaldo(Animal ani) {
        return ani.name + " I would like a lot";
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name=" + name +
                ", weight=" + weight +
                '}';
    }
}
