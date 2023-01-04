package assignments;

import assignments.CardValidation;

import java.util.Scanner;

public class CardValidationTest {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hello, please enter you card number for verification: ");
            String cardNumber = scanner.next();
            CardValidation CC = new CardValidation();
            CC.checkCC(cardNumber);
        }
}


