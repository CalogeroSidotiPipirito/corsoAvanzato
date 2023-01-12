package comparableInterface;

import javax.xml.namespace.QName;

public class Triangle extends Shape{

    private final Name name;
    private int base;
    private int height;

    private double area;

    public Triangle(Name name, int base, int height){
        this.name = name;
        this.base = base;
        this.height = height;
        this.area = calculateArea();
    }

    public Name getName(){
        return name;
    }

    public double getArea(){
        return area;
    }

    public double calculateArea(){
        return (base * height)/2;
    }

}
