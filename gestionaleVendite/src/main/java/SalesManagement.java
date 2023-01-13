public class SalesManagement {   //Main class

    public static void main(String[] args){

        SalesOrder[] salesOrder = new SalesOrder[3];  //array instantiation for the SalesOrder objects


        //creating and inserting objects into the array of sale orders
        salesOrder[0] = new SalesOrder(4, "Smartphone1", 500, "Mario", "Bianchi","15/07/2018", OrderStatus.SENT, ProductCategory.SMARTPHONE);
        salesOrder[1] = new SalesOrder(3, "Book1", 24.99,"Antonio", "Bianchi", "01/05/2020", OrderStatus.PROCESSING, ProductCategory.BOOK);
        salesOrder[2] = new SalesOrder(7,"Televisione1", 499.99, "Pippo", "Verdi", "08/12/2021", OrderStatus.DELIVERED, ProductCategory.TELEVISION);


        //print of the sale orders
        salesOrder[0].printSalesOrder();
        salesOrder[1].printSalesOrder();
        salesOrder[2].printSalesOrder();

    }

}
