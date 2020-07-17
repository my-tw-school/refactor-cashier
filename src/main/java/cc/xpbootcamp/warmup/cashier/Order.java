package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private List<LineItem> lineItems;

    public Order(List<LineItem> lineItems) {
        this.lineItems = lineItems;
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
