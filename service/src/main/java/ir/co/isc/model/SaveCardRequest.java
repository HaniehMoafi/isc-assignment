package ir.co.isc.model;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SaveCardRequest {

    @NotEmpty
    @Size(min = 10 , max = 10)
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
