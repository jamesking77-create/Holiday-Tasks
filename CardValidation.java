package assignments;

public class CardValidation {
    public void checkCC(String cardNumber)  {
        String cardDigit = cardNumber.replaceAll(" ", "");

        int sum = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            int cardNumberDigits = Integer.parseInt(Character.toString(cardDigit.charAt(i)));

            if ((cardDigit.length() - i) % 2 == 0) {
                cardNumberDigits = cardNumberDigits * 2;

                if (cardNumberDigits > 9) {
                    cardNumberDigits = cardNumberDigits - 9;
                }
            }
            sum += cardNumberDigits;
        }
            if (cardNumber.charAt(0) == '4'){
               String cardNumberType = "Visa card";
                System.out.println("Credit Card Type: "+ cardNumberType);
                System.out.println("Credit Card Number: "+ cardNumber);
                System.out.println("Card Digit Length: "+ cardNumber.length());
            }
            if (cardNumber.charAt(0) == '5') {
               String cardNumberType = "Master card";
                System.out.println("Credit Card Type: "+ cardNumberType);
                System.out.println("Credit Card Number: "+ cardNumber);
                System.out.println("Card Digit Length: "+ cardNumber.length());
            }
            if (cardNumber.charAt(0) != '5' && cardNumber.charAt(0) != '4' ){
                System.out.println("Credit Card Type: Invalid Card");
                System.out.println("Credit Card Number: "+ cardNumber);
                System.out.println("Card Digit Length: "+ cardNumber.length());
            }

            if (sum % 10 == 0){
                cardNumber = "Valid";
            }else{
                cardNumber = "Invalid";
            }
            System.out.println("Card Status: "+ cardNumber);
    }
}
