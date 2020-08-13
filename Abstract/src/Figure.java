import java.util.ArrayList;

public abstract class Figure {

    public abstract double getArea();
    public  abstract double getPerimeter();

    Figure(){}

    static public Figure getFigMaxArea(ArrayList<Figure> figs){
        double maxarea = 0;
        Figure figmax = null;
        for (Figure f: figs) {
            double area = f.getArea();
            if (area > maxarea){
                maxarea = area;
                figmax = f;
            }
        }
        return figmax;
    }

    @Override
    public String toString() {
        return "Area: " + String.format("%6.3f",getArea()) + " ; preimeter: " + String.format("%6.3f",getPerimeter());
    }
}
