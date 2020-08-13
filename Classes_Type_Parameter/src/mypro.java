/*
F and S in calss Pairs stand for names of some, as yet unknown, types. In the denition of
the class we can use names F and S as names of classes (but not primitive types!)
*/

public class mypro {
    public static void main(String[] args) {
        Pairs<String, Integer> p1 = new Pairs<>("Moh", 34);
        Pairs<String, String> p2 = new Pairs<>("Thu", "Love");

        System.out.println(p1.first +" "+ p1.second+" "+ p1.count);
        System.out.println(p2.first +" "+ p2.second+" "+ p2.count);
    }
}
