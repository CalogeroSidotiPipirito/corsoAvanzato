import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class SalesOrder {

    private final int productQuantity;

    private final Product product; //Product object

    private final Customer customer;  //Customer object

    private final LocalDate orderDate;

    private OrderStatus orderStatus;  //enum type

    private ProductCategory productCategory;  //enum type


    //class's constructor
    public SalesOrder(int productQuantity, String productDescription, double productPrice, String customerName, String customerSurname, String orderDate, OrderStatus orderStatus, ProductCategory productCategory){
        this.product = new Product(productDescription, productPrice);
        this.productQuantity = productQuantity;
        this.customer = new Customer(customerName, customerSurname);
        this.orderDate = stringToLocalDate(orderDate);
        this.orderStatus = orderStatus;
        this.productCategory = productCategory;
    }

    public int getProductQuantity(){  //returns the quantity of product purchased
        return productQuantity;
    }


    public Product getProduct(){  //returns the instantiated Product object
        return product;
    }

    public Customer getCustomer(){   //returns the instantiated Customer object
        return customer;
    }

    public LocalDate getOrderDate(){  //returns LocalDate object that indicates the purchase date
        return orderDate;
    }

    public OrderStatus getOrderStatus() {  //return enum type PROCESSING or SENT or DELIVERED;
        return orderStatus;
    }

    public ProductCategory getProductCategory() {   //return enum type SMARTPHONE or TELEVISION or BOOK;
        return productCategory;
    }

    public void printSalesOrder(){
        System.out.println("Il cliente " + getCustomer().getName() + " " + getCustomer().getSurname() + " ha acquistato il prodotto " + getProduct().getDescription());
        System.out.print("Quantita' acquistata: " + getProductQuantity() + "\nPrezzo unitario prodotto: " + getProduct().getPrice() + "\nTotale costo: " + (getProductQuantity() * getProduct().getPrice()) + "\n");
        System.out.println("Data d'acquisto: " + getOrderDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));

        System.out.print("Stato dell'ordine: ");
        if (getOrderStatus() == OrderStatus.PROCESSING)
            System.out.print("Processing...\n");
        else if (getOrderStatus() == OrderStatus.SENT)
            System.out.print("Sent\n");
        else if (getOrderStatus() == OrderStatus.DELIVERED)
            System.out.print("Delivered\n");


        System.out.print("Categoria del prodotto: " + getProductCategory() + "\n");

    }


    //method that converts String object to LocalDate object
    public LocalDate stringToLocalDate(String orderDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataParsed = LocalDate.parse(orderDate, formatter);

        return dataParsed;
    }


}
