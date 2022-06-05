package ir.co.isc.model;

public class SaveCardRequest {

    //    @NotEmpty(message = "national code can not be empty")
    private String nationalCode;
    private CardModel card;

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public CardModel getCard() {
        return card;
    }

    public void setCard(CardModel card) {
        this.card = card;
    }
}
