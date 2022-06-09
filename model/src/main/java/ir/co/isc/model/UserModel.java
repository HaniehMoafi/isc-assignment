package ir.co.isc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserModel {

    @NotBlank
    private String name;
    @NotBlank
    private String family;
    @NotBlank
    @Size(min = 10, max = 10)
    private String nationalCode;
    private String address;
    @NotBlank
    private String phoneNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
