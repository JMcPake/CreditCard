import java.util.Calendar;

public class CreditCard {

    private int CardExpiryMonth;
    private int CardExpiryYear;
    private String CardfirstName;
    private String CardlastName;
    private String CardccNumber;

    public CreditCard(int expiryMonth, int expiryYear, String firstName, String lastName, String ccNumber) {
        CardExpiryMonth = expiryMonth;
        CardExpiryYear = expiryYear;
        CardfirstName = firstName;
        CardlastName = lastName;
        CardccNumber = ccNumber;
    }

    public String formatExpiryDate(){
        return CardExpiryMonth + "/" + (CardExpiryYear %100);
    }

    public String formatFullName() {
        return CardfirstName + " " + CardlastName;
    }

    public String formatCCNumber() {
        String formattedNo = "";
        char [] ccNoArray = CardccNumber.toCharArray();

        for(int i = 0; i < ccNoArray.length; i++){

            if (i % 4 == 0 && i > 0){
                formattedNo += " " + ccNoArray[i];
            } else {
                formattedNo += ccNoArray[i];
            }
        }

        return formattedNo;
    }

    public boolean isValid() {

        Calendar now = Calendar.getInstance();

        if (now.get(Calendar.YEAR) <= CardExpiryYear){
            return now.get(Calendar.MONTH) <= CardExpiryMonth - 1;
        }

        return false;


    }

    public String cardToString() {
        return ("Number : " + formatCCNumber() + "\nExpiration Date : " + formatExpiryDate() + "\nAccount Holder : " + formatFullName() + "\nIs Valid? : " + isValid());
    }

}
