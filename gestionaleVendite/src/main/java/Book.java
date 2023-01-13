public class Book extends Product{ //class of "book" product

    private static final ProductCategory productCategory = ProductCategory.BOOK;  //category of the product
    public Book(String description, double price) {  //class's constructor
        super(description, price);
    }

    public static ProductCategory getProductCategory() {  //method that returns the product category
        return productCategory;
    }
}
