package ir.co.isc.business;

import ir.co.isc.Translator;
import ir.co.isc.business.interfaces.CardService;
import ir.co.isc.entity.CardEntity;
import ir.co.isc.exception.CardException;
import ir.co.isc.model.CardModel;
import ir.co.isc.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public CardModel findCard(CardModel c) {
        return null;
    }

    @Override
    public List<CardModel> findCardByNationalCode(String nationalCode) throws CardException {
        List<CardEntity> cardEntities = cardRepository.findCardByNationalCode(nationalCode);
        if (CollectionUtils.isEmpty(cardEntities))
            throw new CardException(CardException.CARD_NOT_FOUND);
        return Translator.cardEntitiesToCardModels(cardEntities);
    }

    @Override
    public void saveCard(CardModel cardModel) {

    }
}
