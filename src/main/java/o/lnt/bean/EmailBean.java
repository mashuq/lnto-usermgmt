package o.lnt.bean;

import o.lnt.enumeration.AddressType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmailBean {
    private Integer emailID;
    @Email
    @NotBlank(message = "Email Address cannot be null")
    private String emailAddress;
    @NotBlank(message = "Email Address Type cannot be null")
    private AddressType addressType;
    private Boolean isDefault;


    public Integer getEmailID() {
        return emailID;
    }

    public void setEmailID(Integer emailID) {
        this.emailID = emailID;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
        return "EmailBean{" +
                "emailID=" + emailID +
                ", emailAddress='" + emailAddress + '\'' +
                ", addressType=" + addressType +
                ", isDefault=" + isDefault +
                '}';
    }
}
