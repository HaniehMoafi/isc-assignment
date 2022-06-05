package ir.co.isc;

import ir.co.isc.entity.CardEntity;
import ir.co.isc.model.CardModel;

import java.util.ArrayList;
import java.util.List;

public class  Translator {


    public static CardModel cardEntityToCardModel(CardEntity cardEntity){
        CardModel model = new CardModel();
        model.setAccountNumber(cardEntity.getAccountNumber());
        model.setCardNumber(cardEntity.getCardNumber());
        model.setCardType(cardEntity.getCardType().name());
        model.setExpireDate(cardEntity.getExpireDate());
        model.setIssuerCode(cardEntity.getIssuerCode());
        model.setIssuerName(cardEntity.getIssuerName());
        return model;
    }

    public static List<CardModel> cardEntitiesToCardModels(List<CardEntity> cardEntities){
        List<CardModel> models = new ArrayList<>();
        for (CardEntity c :cardEntities) {
            CardModel model = cardEntityToCardModel(c);
            models.add(model);
        }
        return models;
    }
}
