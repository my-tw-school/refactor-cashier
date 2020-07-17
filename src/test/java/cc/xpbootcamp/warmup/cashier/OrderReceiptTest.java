package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {

    @Test
    public void should_print_line_item_and_sales_tax_information() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems));

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk, 10.0 x 2\n"));
        assertThat(output, containsString("biscuits, 5.0 x 5\n"));
        assertThat(output, containsString("chocolate, 20.0 x 1\n"));
        assertThat(output, containsString("Sales Tax: 6.5\n"));
        assertThat(output, containsString("Total Amount: 71.5\n"));
    }

    @Test
    public void should_print_split_line_on_receipt_header_and_footer() {
        OrderReceipt orderReceipt = new OrderReceipt(new Order(new ArrayList<>()));

        String output = orderReceipt.printReceipt();
        assertThat(output, containsString("Lao Wang supermarket, trustworthy"));
        assertThat(output, containsString("--------------------------------\n"));
    }

    @Test
    public void should_print_date_time_information() {
        OrderReceipt orderReceipt = new OrderReceipt(new Order(new ArrayList<>()));
        Instant.now(Clock.fixed(
                Instant.parse("2020-07-17T00:00:00Z"),
                ZoneOffset.UTC));
        String output = orderReceipt.printReceipt();
        assertThat(output, containsString("2020-07-17, Friday\n"));
    }
}