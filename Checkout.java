package assignments;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public record Checkout(String companyName) {

    public double getTotal(Integer quantity, Double price) {
        double total = 0;
        for (double numbers = 0; numbers < quantity; numbers++)
            total = price * quantity;
        return total;
    }

    public String dateAndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return (formatter.format(now));
    }

    public void displayInput(String cashierName, String customerName, ArrayList<String> item,
                             ArrayList<Integer> quantity, ArrayList<Double> price, double discount, double vat) {
        System.out.printf("%s%n%s%n%s%n%s%n%s%s%n%s%s%n%s%s%n", companyName, "MAIN BRANCH",
                "LOCATION 112, HERBERT MACAULAY WAY, SABO YABA, LAGOS.", "TEL: 090777445434",
                "Date: ", dateAndTime(), "CASHIER NAME: ", cashierName, "CUSTOMER NAME: ", customerName);
        System.out.println("=============================================================");
        System.out.println("                ITEM      QTY       PRICE       TOTAL(NGN)");
        System.out.println("-------------------------------------------------------------");
        double subTotal = 0;
        double totals = 0;
        for (int count = 0; count < item.size(); count++) {
            System.out.printf("%20s     ",item.get(count));
            System.out.printf("%-12d", quantity.get(count));
            System.out.printf("%-10.2f", price.get(count));
            System.out.printf("%-11.2f%n", (getTotal(quantity.get(count), price.get(count))));
            subTotal += (getTotal(quantity.get(count), price.get(count)));

        }
            System.out.println("-------------------------------------------------------------");
            System.out.printf("%50s %-10.2f%n", "Sub Total: ",(totals + subTotal));
           double discounts = discount / 100;
            double discountRate = discounts * (totals + subTotal);
            System.out.printf("%50s %-10.2f%n", "Discount : ",discountRate);
            double vatPercent  = vat / 100;
            double VATRate = vatPercent * (totals + subTotal) ;
            System.out.printf("%50s %-10.2f%n", "VAT @ 17.50% : ",VATRate);
            System.out.println("=============================================================");
            double billTotal = ((totals + subTotal) - discountRate) + VATRate;
            System.out.printf("%50s %-10.2f%n", "Bill Total: ",billTotal);
            System.out.println("=============================================================");
            System.out.printf("%s%.2f%n", "       THIS IS NOT A RECEIPT KINDLY PAY ",billTotal);
            System.out.println("=============================================================");
    }

    public void displayReceipt(String cashierName, String customerName, ArrayList<String> item,
                             ArrayList<Integer> quantity, ArrayList<Double> price, double discount, double vat, double payment) {
        System.out.printf("%s%n%s%n%s%n%s%n%s%s%n%s%s%n%s%s%n", companyName, "MAIN BRANCH",
                "LOCATION 112, HERBERT MACAULAY WAY, SABO YABA, LAGOS.", "TEL: 090777445434",
                "Date: ", dateAndTime(), "CASHIER NAME: ", cashierName, "CUSTOMER NAME: ", customerName);
        System.out.println("=============================================================");
        System.out.println("                ITEM      QTY       PRICE       TOTAL(NGN)");
        System.out.println("-------------------------------------------------------------");
        double subTotal = 0;
        double totals = 0;
        for (int count = 0; count < item.size(); count++) {
            System.out.printf("%20s     ", item.get(count));
            System.out.printf("%-12d", quantity.get(count));
            System.out.printf("%-10.2f", price.get(count));
            System.out.printf("%-11.2f%n", (getTotal(quantity.get(count), price.get(count))));
            subTotal += (getTotal(quantity.get(count), price.get(count)));

        }
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%50s %-10.2f%n", "Sub Total: ", (totals + subTotal));
        double discounts = discount / 100;
        double discountRate = discounts * (totals + subTotal);
        System.out.printf("%50s %-10.2f%n", "Discount: ", discountRate);
        double vatPercent = vat / 100;
        double VATRate = vatPercent * (totals + subTotal);
        System.out.printf("%50s %-10.2f%n", "VAT @ 17.50%: ", VATRate);
        System.out.println("=============================================================");
        double billTotal = ((totals + subTotal) - discountRate) + VATRate;
        System.out.printf("%50s %-10.2f%n", "Bill Total: ", billTotal);
        System.out.printf("%50s %-10.2f%n", "Amount Paid:  ", payment);
        if (payment > (totals + subTotal) || payment == (totals + subTotal)) {
            double balance = payment - billTotal;
            System.out.printf("%50s %-10.2f%n", "Balance:  ", balance);
        }else{
            System.err.println("insufficient balance...\n");
        }
        System.out.println("=============================================================");
        System.out.println("            THANK YOU FOR YOUR PATRONAGE");
        System.out.println("=============================================================");
    }
}
