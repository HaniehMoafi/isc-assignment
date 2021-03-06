package ir.co.isc.business;

import ir.co.isc.CardTypeEnum;
import ir.co.isc.Translator;
import ir.co.isc.business.interfaces.CardService;
import ir.co.isc.business.interfaces.UserService;
import ir.co.isc.entity.CardEntity;
import ir.co.isc.entity.UserEntity;
import ir.co.isc.exception.CardException;
import ir.co.isc.model.CardModel;
import ir.co.isc.model.GetCardsResponse;
import ir.co.isc.model.SaveCardRequest;
import ir.co.isc.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    private UserService userService;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, UserService userService) {
        this.cardRepository = cardRepository;
        this.userService = userService;
    }

    @Override
    public CardModel findCard(CardModel c) {
        return null;
    }

    @Override
    public GetCardsResponse findCardByNationalCode(String nationalCode) throws CardException {
        GetCardsResponse response = new GetCardsResponse();
        List<CardEntity> cardEntities = cardRepository.findCardByNationalCodeAndIsActive(nationalCode, true);
        if (CollectionUtils.isEmpty(cardEntities))
            throw new CardException(CardException.CARD_NOT_FOUND);
        List<CardModel> cardModels = Translator.cardEntitiesToCardModels(cardEntities);
        CardEntity cardEntity = cardEntities.get(0);
        response.setCards(cardModels);
        response.setFamily(cardEntity.getUser().getFamily());
        response.setName(cardEntity.getUser().getName());
        response.setNationalCode(cardEntity.getUser().getNationalCode());
        return response;
    }

    @Override
    public void saveCard(SaveCardRequest saveCard) {

        UserEntity user = userService.findUserByNationalCode(saveCard.getNationalCode());
        CardEntity card = new CardEntity();
        card.setAccountNumber(saveCard.getCard().getAccountNumber());
        card.setExpireDate(saveCard.getCard().getExpireDate());
        card.setCardNumber(saveCard.getCard().getCardNumber());
        card.setCardType(CardTypeEnum.valueOf(saveCard.getCard().getCardType()));
        card.setActive(true);
        String issuerCode = saveCard.getCard().getCardNumber().substring(0, 6);
        card.setIssuerCode(Integer.parseInt(issuerCode));
        card.setIssuerName(saveCard.getCard().getIssuerName());
        card.setUser(user);
        try {
            cardRepository.save(card);
        } catch (Exception e) {
            throw new CardException(CardException.DUPLICATE_CARD);
        }

    }

    @Override
    public void deleteCard(String cardNumber) throws CardException {
        Optional<CardEntity> c = cardRepository.findByCardNumberAndIsActive(cardNumber, true);
        if (!c.isPresent())
            throw new CardException(CardException.CARD_NOT_FOUND);
        CardEntity cardEntity = c.get();
        cardEntity.setActive(false);
        cardRepository.save(cardEntity);
    }

    @Override
    public CardModel findCardByCardData(String cardData) throws CardException {
        Optional<CardEntity> entity;
        if (cardData.length() == 16) {
            entity = cardRepository.findByCardNumberOrAccountNumber(cardData, 0L);
        } else if (cardData.length() == 10) {
            entity = cardRepository.findByCardNumberOrAccountNumber("", Long.valueOf(cardData));
        } else throw new CardException(CardException.WRONG_CARD_DATA);
        if (entity.isPresent())
            return Translator.cardEntityToCardModel(entity.get());
        else throw new CardException(CardException.CARD_NOT_FOUND);
    }
}
