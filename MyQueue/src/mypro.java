public class mypro {
    public static void main(String[] args) {
        MyQueue<String> names = new MyQueue<>();
        names.addtoqueue("Moh");
        names.addtoqueue("Dan");
        names.addtoqueue("Jone");
        names.addtoqueue("Bone");
        System.out.println("String Queue");
        for (int i = 0; i < names.size; i++) {
            System.out.println(names.getqueue());
        }

        System.out.println("Integer Queue");
        MyQueue<Integer> numbs = new MyQueue<>();
        for (int i = 0; i <= 20; i++) {
            numbs.addtoqueue(i);
        }

        while (!numbs.empty()){
            System.out.print(numbs.getqueue()+" ");
        }
    }
}
