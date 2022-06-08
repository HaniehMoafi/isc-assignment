package ir.co.isc.controller;

import ir.co.isc.business.interfaces.CardService;
import ir.co.isc.exception.CardException;
import ir.co.isc.model.CardModel;
import ir.co.isc.model.DefaultResponse;
import ir.co.isc.model.GetCardsResponse;
import ir.co.isc.model.SaveCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@RestController
@RequestMapping("/card")
@Validated
public class CardRestService {


    private CardService cardService;

    @Autowired
    public CardRestService(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/save")
    public ResponseEntity<DefaultResponse> saveCard(@Valid @RequestBody SaveCardRequest model, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            throw new Exception();
        }
        DefaultResponse response = new DefaultResponse();
        cardService.saveCard(model);
        response.setMessage("the card was successfully saved");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/find")
    public void findCard(@RequestBody CardModel cardModel) {

    }

    @GetMapping("/findByNationalCode/{code}")
    public ResponseEntity<GetCardsResponse> findCardByNationalCode(@PathVariable @NotBlank String code) throws CardException {
        GetCardsResponse response = cardService.findCardByNationalCode(code);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/deleteByCardNumber/{cardNumber}")
    public ResponseEntity<DefaultResponse> deleteCard(@PathVariable @NotBlank String cardNumber) throws CardException {
        DefaultResponse response = new DefaultResponse();
        cardService.deleteCard(cardNumber);
        response.setMessage("the card was successfully removed");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }


}
