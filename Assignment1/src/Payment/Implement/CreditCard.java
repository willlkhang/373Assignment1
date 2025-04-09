package Payment.Implement;

import Payment.Interface.PaymentMethod;

import Exception.*;

public class CreditCard implements PaymentMethod {
    private String cardNumber;
    private String expDate;
    private int ccv;

    public CreditCard(){
        this.cardNumber = "No card number";
        this.expDate = "No expiry date";
        this.ccv = 0;
    }

    public CreditCard(String cardNum, String date, int ccv) throws InvalidInputDataException {
        setCardNumber(cardNum);
        setExpDate(date);
        setCcv(ccv);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) throws InvalidInputDataException {
        if(cardNumber == null || !isValidCreditCardNumber(cardNumber)){
            throw new InvalidInputDataException("Invalid Credit Card Number");
        }
        else
            this.cardNumber = cardNumber;
    }

    public int getCcv()  {
        return ccv;
    }

    public void setCcv(int ccv) throws InvalidInputDataException {
        if(!isValidCCV(ccv)){
            throw new InvalidInputDataException("Invalid Credit Card CCV");
        }
        else
            this.ccv = ccv;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) throws InvalidInputDataException {
        if(expDate == null || !isValidExpiredDate(expDate))
            throw new InvalidInputDataException("Invalid Credit Card expired date");
        else
            this.expDate = expDate;
    }

    private boolean isValidCreditCardNumber(String carNumb){
        if (carNumb == null) return false;
        return carNumb.replaceAll(" ", "").matches("^\\d{20}$");
    }

    private boolean isValidCCV(int ccv){
        return (ccv >=100 && ccv <= 999);
    }

    private boolean isValidExpiredDate(String date){
        String[] tmp = date.split("/");
        int month = Integer.parseInt(tmp[0]);
        int year = Integer.parseInt(tmp[1]); // assume all the card is valid till 2028
        if(year > 28 || year < 26)
            return false;
        if(month > 12 || month < 0)
            return false;
        return true;
    }

    public String paymentDetail(){
        return "Credit Card number ending " + cardNumber.substring(cardNumber.length() - 4);
    }
}
