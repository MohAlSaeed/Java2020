public class Circle extends Figure{
    double r;
    Circle(double r){
        this.r = r;
    }
    @Override
    public double getArea() {
        double area = r*r*Math.PI;
        return area;
    }

    @Override
    public double getPerimeter() {
        return 2*r*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle r=" + r + " " + super.toString();
    }
}
