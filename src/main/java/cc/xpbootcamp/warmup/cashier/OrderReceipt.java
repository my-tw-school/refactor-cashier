package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private static final String DATE_PATTERN = "yyyy-MM-dd, EEEE";

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append(printReceiptHeader());

        output.append(printReceiptContent());

        output.append(printReceiptFooter());
        return output.toString();
    }

    private String printReceiptFooter() {
        return "--------------------------------\n" +
                "Sales Tax: "  + order.getTotalSalesTax() + '\n' +
                "Total Amount: " + order.getTotal() + '\n';
    }

    private String printReceiptContent() {
        return order.getLineItems().stream().map(LineItem::toReceiptContent).collect(Collectors.joining());
    }

    private String printReceiptHeader() {
        return "======Lao Wang supermarket, trustworthy======\n" +
                printCurrentDate() + '\n';
    }

    private String printCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return LocalDate.now().format(formatter);
    }

}