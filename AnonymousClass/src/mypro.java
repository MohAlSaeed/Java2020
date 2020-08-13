/*
Important:
        When we dene an anonymous class, local variables visible in the
        current scope will be accessible (and can be used) inside the body of methods of the
        anonymous class being created. The only condition is that these local variables are
        • declared as nal (and, of course, initialized), or
        • effectively nal , i.e., they are dened and initialized
        and then not modied.
*/

public class mypro {
    public static void main(String[] args) {
        Animal an = new Animal("Dog", 22) {
            @Override
            public String speak() {
                return "barks a lot";
            }
        };
        System.out.println(an);
    }
}
