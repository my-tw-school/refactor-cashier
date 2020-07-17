package cc.xpbootcamp.warmup.cashier;

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

        for (LineItem lineItem : order.getLineItems()) {
            output.append(getLineItemContent(lineItem));
        }

        output.append("Sales Tax").append('\t').append(order.getTotalSalesTax());

        output.append("Total Amount").append('\t').append(order.getTotal());
        return output.toString();
    }

    private String getLineItemContent(LineItem lineItem) {
        return lineItem.getDescription() +
                '\t' +
                lineItem.getPrice() +
                '\t' +
                lineItem.getQuantity() +
                '\t' +
                lineItem.totalAmount() +
                '\n';
    }

    private String getReceiptHeader() {
        return "======Printing Orders======\n" +
                order.getCustomerName() +
                order.getCustomerAddress();
    }

}