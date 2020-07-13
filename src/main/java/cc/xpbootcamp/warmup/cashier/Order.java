package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<LineItem> lineItems;

    public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public double getTotalSalesTax() {
        return getLineItems().stream().reduce(0d, (acc, item) -> item.getSalesTax() + acc, Double::sum);
    }

    public double getTotal() {
        return getLineItems()
                .stream()
                .reduce(0d, (acc, item) -> item.totalAmount() + item.getSalesTax() + acc, Double::sum);
    }
}
