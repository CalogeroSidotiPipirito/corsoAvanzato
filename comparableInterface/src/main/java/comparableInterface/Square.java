package comparableInterface;

public class Square extends Shape{

    private final Name name;
    private int side;
    private double area;

    public Square(Name name, int side){
        this.name = name;
        this.side = side;
        this.area = calculateArea();
    }

    public Name getName(){
        return name;
    }

    public double getArea(){
        return area;
    }

    public double calculateArea(){
        return side * side;
    }

}
