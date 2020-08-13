import java.util.Objects;
import java.util.Scanner;

public class mypro {

    public static void main(String[] args) {
        MyQueue2 testqueue = new MyQueue2();
//        testqueue.addtoMyQueue2("Dan");
//        testqueue.addtoMyQueue2("Moh");
//        testqueue.addtoMyQueue2("Bas");
//        testqueue.addtoMyQueue2("Thu");
//        testqueue.addtoMyQueue2("bmw");
//
//        for (int i = 0; i < testqueue.size; i++) {
//            System.out.println(testqueue.getQueue());
//        }

        String data;

        for (data = null; !Objects.equals(data, "end");) {
            Scanner scn = new Scanner(System.in);
            data = scn.next();
            testqueue.addtoMyQueue2(data);
        }
        for (int i = 0; i < testqueue.size; i++) {
            System.out.println(testqueue.getQueue());
        }

    }
}
