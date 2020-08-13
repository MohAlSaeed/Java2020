import java.util.ArrayList;
import java.util.Scanner;

public class mypro {
    public static void main(String[] args) {
    Circle cr;
    Rect rec;
    Scanner scan = new Scanner(System.in);
    System.out.println("Input number of trys to find the maxfigure");
    Double tr = scan.nextDouble();
    ArrayList<Figure> figs = new ArrayList<>();
        for (int i = 0; i < tr; i += 2) {
            double r = Math.random()*100;
            double x = Math.random()*100;
            double y = Math.random()*100;
            cr = new Circle(r);
            rec = new Rect(x,y);
            figs.add(cr);
            figs.add(rec);
        }
        Figure f = Figure.getFigMaxArea(figs);
        System.out.println(f);

    }
}
