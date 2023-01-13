public class ElectronicProduct extends Product{  //class indicating an electronic product

    private final String brand;
    private final String model;

    public ElectronicProduct(String description, double price, String brand, String model) {   //class's conctructor
        super(description, price);
        this.brand = brand;
        this.model = model;
    }

    public String getBrand(){   //method that returns the "brand" of instance
        return brand;
    }

    public String getModel(){  //method that returns the "model" of instance
        return model;
    }

}
