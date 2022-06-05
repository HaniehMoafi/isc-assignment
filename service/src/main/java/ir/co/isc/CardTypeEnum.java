package ir.co.isc;

public enum CardTypeEnum {

    CASH("نقدی"),
    CREDIT("اعتباری");


    private final String name;

    CardTypeEnum(String name) {
        this.name = name;
    }
}
