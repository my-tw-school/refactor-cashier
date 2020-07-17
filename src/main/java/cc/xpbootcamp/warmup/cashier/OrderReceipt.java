package cc.xpbootcamp.warmup.cashier;

import java.time.Clock;
import java.time.DayOfWeek;
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
    private final Clock clock;

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
        clock = Clock.systemDefaultZone();
    }

    public OrderReceipt(Order order, Clock clock) {
        this.order = order;
        this.clock = clock;
    }

    public String printReceipt() {
        return printReceiptHeader() +
                printReceiptContent() +
                printReceiptFooter();
    }

    private String printReceiptFooter() {
        return "--------------------------------\n" +
                "Sales Tax: "  + order.getTotalSalesTax() + '\n' +
                printDiscount() +
                "Total Amount: " + (order.getTotal() - calculateDiscount()) + '\n';
    }

    private String printDiscount() {
        if (isWednesday()) {
            return "Discount: " + calculateDiscount() + '\n';
        }
        return "";
    }

    private double calculateDiscount() {
        return isWednesday() ? order.getTotal() * 0.02 : 0.0;
    }

    private boolean isWednesday() {
        return LocalDate.now(clock).getDayOfWeek() == DayOfWeek.WEDNESDAY;
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
        return LocalDate.now(clock).format(formatter);
    }

}