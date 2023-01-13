public class Television extends ElectronicProduct{ //class of "television" product

    private static final ProductCategory productCategory = ProductCategory.TELEVISION;  //category of the product
    public Television(String description, double price, String televisionBrand, String televisionModel) {  //class's constructor
        super(description, price, televisionBrand, televisionModel);
    }

    public static ProductCategory getProductCategory() {  //method that returns the product category
        return productCategory;
    }
}
