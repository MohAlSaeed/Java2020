public class Rect extends Figure{
    double x,y;
    Rect(double x, double y){
        this.x = x;
        this.y = y;
    }
    @Override
    public double getArea() {
        double area = x * y;
        return area;
    }

    @Override
    public double getPerimeter() {
        return 2*(x+y);
    }

    @Override
    public String toString() {
        return "Rect x=" + x + " y=" + y + " " + super.toString();
    }
}
