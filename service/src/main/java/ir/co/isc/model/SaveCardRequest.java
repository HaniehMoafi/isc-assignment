package ir.co.isc.model;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class SaveCardRequest {

    @NotEmpty
    private String nationalCode;
    @Valid
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
