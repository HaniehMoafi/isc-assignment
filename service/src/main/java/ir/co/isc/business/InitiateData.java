package ir.co.isc.business;

import ir.co.isc.CardTypeEnum;
import ir.co.isc.entity.CardEntity;
import ir.co.isc.entity.UserEntity;
import ir.co.isc.repository.CardRepository;
import ir.co.isc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class InitiateData {

    private UserRepository userRepository;
    private CardRepository cardRepository;


    @Autowired
    public InitiateData(UserRepository userRepository, CardRepository cardRepository) {
        this.userRepository = userRepository;
        this.cardRepository = cardRepository;
    }

    @PostConstruct
    private void init() {

        //user : hanieh moafi
        UserEntity u = new UserEntity();
        u.setName("Hanieh");
        u.setFamily("Moafi");
        u.setAddress("Iran/Tehran/Tehran/south Dibaji");
        u.setNationalCode("0050371988");
        u.setPhoneNumber("989129597509");
        CardEntity c = new CardEntity();
        c.setAccountNumber(1234567898L);
        c.setActive(true);
        c.setCardNumber("6221061223829625");
        c.setCardType(CardTypeEnum.CASH);
        c.setExpireDate("05/09");
        c.setIssuerCode(622106);
        c.setIssuerName("پارسیان");
        c.setUser(u);
        userRepository.save(u);
        cardRepository.save(c);



        //user: amin chegini
        UserEntity u1 = new UserEntity();
        u1.setName("Amin");
        u1.setFamily("Chegini");
        u1.setAddress("Iran/Tehran/Tehran/mirdamad");
        u1.setNationalCode("3960371982");
        u1.setPhoneNumber("989123964578");


        CardEntity c1 = new CardEntity();
        c1.setAccountNumber(1234567654L);
        c1.setActive(true);
        c1.setCardNumber("6274121182257998");
        c1.setCardType(CardTypeEnum.CASH);
        c1.setExpireDate("01/10");
        c1.setIssuerCode(627412);
        c1.setIssuerName("اقتصادنوین");


        CardEntity c2 = new CardEntity();
        c2.setAccountNumber(1234577754L);
        c2.setActive(true);
        c2.setCardNumber("6104337325256666");
        c2.setCardType(CardTypeEnum.CREDIT);
        c2.setExpireDate("02/10");
        c2.setIssuerCode(610433);
        c2.setIssuerName("ملت");

        c1.setUser(u1);
        c2.setUser(u1);
        userRepository.save(u1);
        cardRepository.save(c1);
        cardRepository.save(c2);

    }
}
