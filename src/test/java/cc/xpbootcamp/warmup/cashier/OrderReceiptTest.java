package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
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
}