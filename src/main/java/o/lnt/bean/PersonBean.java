package o.lnt.bean;

import o.lnt.enumeration.Gender;

import java.time.LocalDate;
import java.util.List;

public class PersonBean {
    private Integer personID;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthday;
    private Gender gender;
    private String title;
    private String suffix;
    private List<EmailBean> emails;
    private List<PhoneBean> phones;
    private List<AddressBean> addresses;
    private boolean active;

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }


    public List<EmailBean> getEmails() {
        return emails;
    }

    public void setEmails(List<EmailBean> emails) {
        this.emails = emails;
    }

    public List<PhoneBean> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneBean> phones) {
        this.phones = phones;
    }

    public List<AddressBean> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressBean> addresses) {
        this.addresses = addresses;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "personID=" + personID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", title='" + title + '\'' +
                ", suffix='" + suffix + '\'' +
                ", emails=" + emails +
                ", phones=" + phones +
                ", addresses=" + addresses +
                ", active=" + active +
                '}';
    }
}
