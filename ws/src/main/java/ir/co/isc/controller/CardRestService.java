package ir.co.isc.controller;

import ir.co.isc.business.interfaces.CardService;
import ir.co.isc.model.CardModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardRestService {


    private CardService cardService;

    @Autowired
    public CardRestService(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/find")
    public void findCard(@RequestBody CardModel cardModel){

    }

    @GetMapping("/findByNationalCode/{code}")
    public ResponseEntity<List<CardModel>> findCardByNationalCode(@PathVariable String code){
        List<CardModel> cards = cardService.findCardByNationalCode(code);
        return new ResponseEntity<>(cards, HttpStatus.OK);

    }
}
