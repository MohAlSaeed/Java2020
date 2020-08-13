import java.text.ParseException;
import java.util.Scanner;

public class mypro {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name");
        String n = scan.nextLine();
        System.out.println("enter you date of birth like dd/mm/yyyy");
        String dob = scan.nextLine();
        System.out.println("Print what you would like to say");
        String say = scan.nextLine();
        System.out.println("Set the Max age to compare");
        int max = scan.nextInt();
    Person p = new Person(dob, n, say, max);
    System.out.println(p);
    }
}
