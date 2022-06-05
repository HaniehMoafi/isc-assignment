package ir.co.isc;

import ir.co.isc.entity.CardEntity;
import ir.co.isc.entity.UserEntity;
import ir.co.isc.model.CardModel;
import ir.co.isc.model.UserModel;

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

    public static UserModel userEntityToUserModel(UserEntity userEntity){
        UserModel model = new UserModel();
        model.setAddress(userEntity.getAddress());
        model.setFamily(userEntity.getFamily());
        model.setName(userEntity.getName());
        model.setNationalCode(userEntity.getNationalCode());
        model.setPhoneNumber(userEntity.getPhoneNumber());
        return model;
    }
}
