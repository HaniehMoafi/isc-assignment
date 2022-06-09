package ir.co.isc.entity;

import ir.co.isc.CardTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "CARD_ENTITY",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"USER_ID", "CARD_TYPE", "ISSUER_CODE"})}
)
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CARD_NUMBER", nullable = false, length = 16, unique = true)
    private String cardNumber;

    @Column(name = "ISSUER_CODE", nullable = false, length = 6)
    private Integer issuerCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "CARD_TYPE")
    private CardTypeEnum cardType;

    @Column(name = "ISSUER_NAME", nullable = false)
    private String issuerName;

    @Column(name = "ACCOUNT_NUMBER", nullable = false, length = 10)
    private Long accountNumber;

    @Column(name = "EXPIRE_DATE", nullable = false, length = 5)
    private String expireDate;


    @Column(name = "ACTIVE")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "id")
    private UserEntity user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getIssuerCode() {
        return issuerCode;
    }

    public void setIssuerCode(Integer issuerCode) {
        this.issuerCode = issuerCode;
    }

    public CardTypeEnum getCardType() {
        return cardType;
    }

    public void setCardType(CardTypeEnum cardType) {
        this.cardType = cardType;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userEntity) {
        this.user = userEntity;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
}
