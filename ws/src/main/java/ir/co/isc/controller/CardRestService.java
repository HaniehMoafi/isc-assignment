package ir.co.isc.controller;

import ir.co.isc.business.interfaces.CardService;
import ir.co.isc.exception.CardException;
import ir.co.isc.model.CardModel;
import ir.co.isc.response.CardDefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardRestService  {


    private CardService cardService;

    @Autowired
    public CardRestService(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/save")
    public ResponseEntity<CardDefaultResponse> saveCard(@RequestBody CardModel cardModel) {
        CardDefaultResponse response = new CardDefaultResponse();
        cardService.saveCard(cardModel);
        response.setMessage("the card was successfully added");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/find")
    public void findCard(@RequestBody CardModel cardModel) {

    }

    @GetMapping("/findByNationalCode/{code}")
    public ResponseEntity<List<CardModel>> findCardByNationalCode(@PathVariable String code) throws CardException {
            List<CardModel> cards = cardService.findCardByNationalCode(code);
            return new ResponseEntity<>(cards, HttpStatus.OK);

    }
}
