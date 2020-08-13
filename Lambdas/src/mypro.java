/*
Instead of passing an object of a concrete or anonymous class implementing an interface,
one can often provide just a simple expression describing a functionality of a method
which is supposed to be implemented (we call such an expression a
lambda ).
there must be only one abstract method in the interface involved
 */
public class mypro {
    public static void main(String[] args) {
        // anonymous class
    Animal ani1 = new Animal("dog", 11) {
        @Override
        public String  Animaldo(Animal ani) {
            return ani.toString();
        }
    };
        System.out.println(ani1.Animaldo(ani1));

        // anonymous class
    Animal ani2 = new Animal("Cat", 13) {
        @Override
        public String Animaldo(Animal ani) {
            return "the "+ ani.name + " is the animal type I would like";
        }
    };

        System.out.println(ani2.Animaldo(ani2));

        //  lambda expr4ssion
        Animaldo ani3 = new Animaldo() {
            @Override
            public String Animaldo(Animal ani) {
                return "I want to have a "+ ani.name;
            }
        };

        System.out.println(ani3.Animaldo(ani2));

        //  applying the lambda expression
        Animaldo ani4 = (ani) -> {
                return "I want to have a new "+ ani.name+" which weights around "+ ani.weight+" kg";
        };

        System.out.println(ani4.Animaldo(ani2));
    }
}
