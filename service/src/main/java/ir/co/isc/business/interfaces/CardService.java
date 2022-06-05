package ir.co.isc.business.interfaces;


import ir.co.isc.exception.CardException;
import ir.co.isc.model.CardModel;
import ir.co.isc.model.GetCardsResponse;
import ir.co.isc.model.SaveCardRequest;

public interface CardService {

    CardModel findCard(CardModel c);

    GetCardsResponse findCardByNationalCode(String nationalCode) throws CardException;

    void saveCard(SaveCardRequest cardModel);
}
