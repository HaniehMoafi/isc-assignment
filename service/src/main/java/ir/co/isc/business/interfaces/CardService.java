package ir.co.isc.business.interfaces;


import ir.co.isc.model.CardModel;

import java.util.List;

public interface CardService {

    CardModel findCard(CardModel c);

    List<CardModel> findCardByNationalCode(String nationalCode);
}
