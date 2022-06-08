package ir.co.isc.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CardModel {

    @NotEmpty
    @Size(min = 16 , max = 16)
    private String cardNumber;
    private Integer issuerCode;
    @NotEmpty
    private String cardType;
    @NotEmpty
    private String issuerName;
    @NotNull
    private Long accountNumber;
    @NotEmpty
    @Size(min = 5 , max = 5)
    private String expireDate;
    private boolean isActive;



    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(Integer issuerCode) {
        this.issuerCode = issuerCode;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
