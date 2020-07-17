package cc.xpbootcamp.warmup.cashier;

import java.util.stream.Collectors;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(getReceiptHeader());

        output.append(getReceiptContent());

        output.append(getReceiptFooter());
        return output.toString();
    }

    private String getReceiptFooter() {
        return "Sales Tax" + '\t' + order.getTotalSalesTax() +
                "Total Amount" + '\t' + order.getTotal();
    }

    private String getReceiptContent() {
        return order.getLineItems().stream().map(LineItem::toReceiptContent).collect(Collectors.joining());
    }

    private String getReceiptHeader() {
        return "======Printing Orders======\n" +
                order.getCustomerName() +
                order.getCustomerAddress();
    }

}