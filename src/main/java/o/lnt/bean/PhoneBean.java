package o.lnt.bean;

import o.lnt.enumeration.AddressType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PhoneBean {
    private Integer phoneID;
    @Pattern(regexp = "\\d+", message = "For phone number only digits allowed")
    @NotBlank (message = "Phone number cannot be null")
    private String phoneNumber;
    @NotBlank(message = "Address Type cannot be null")
    private AddressType addressType;
    private Boolean isDefault;

    public Integer getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(Integer phoneID) {
        this.phoneID = phoneID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "PhoneBean{" +
                "phoneID=" + phoneID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addressType=" + addressType +
                ", isDefault=" + isDefault +
                '}';
    }
}
