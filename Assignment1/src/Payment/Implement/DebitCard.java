package Payment.Implement;

import Payment.Interface.PaymentMethod;

public class DebitCard implements PaymentMethod {
    private String cardNumber;
    private String expDate;
    private int ccv;

    public DebitCard(){
        this.cardNumber = "No card number";
        this.expDate = "No expiry date";
        this.ccv = 0;
    }

    public DebitCard(String cardNum, String date, int ccv){
        this.cardNumber = cardNum;
        this.expDate = date;
        this.ccv = ccv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String paymentDetail(){
        return "Debit Card number ending " + cardNumber.substring(cardNumber.length() - 4);
    }
}
