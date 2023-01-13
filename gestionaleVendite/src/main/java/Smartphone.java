public class Smartphone extends ElectronicProduct{   //class of "smartphone" product

    private static final ProductCategory productCategory = ProductCategory.SMARTPHONE;   //category of the product
    public Smartphone(String description, double price, String smartphoneBrand, String smartphoneModel) {   //class's constructor
        super(description, price, smartphoneBrand, smartphoneModel);
    }

    public static ProductCategory getProductCategory() {   //method that returns the product category
        return productCategory;
    }
}
