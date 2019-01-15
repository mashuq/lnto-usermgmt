package o.lnt.bean;

import o.lnt.enumeration.AddressType;

public class AddressBean {
    private Integer addressID;
    private String Country;
    private String ZipPostCode;
    private String ProvinceStateCounty;
    private String CityTownVillage;
    private String StreetRoadBlock;
    private String HouseBuilding;
    private String Other;
    private AddressType addressType;
    private Boolean isDefault;

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getZipPostCode() {
        return ZipPostCode;
    }

    public void setZipPostCode(String zipPostCode) {
        ZipPostCode = zipPostCode;
    }

    public String getProvinceStateCounty() {
        return ProvinceStateCounty;
    }

    public void setProvinceStateCounty(String provinceStateCounty) {
        ProvinceStateCounty = provinceStateCounty;
    }

    public String getCityTownVillage() {
        return CityTownVillage;
    }

    public void setCityTownVillage(String cityTownVillage) {
        CityTownVillage = cityTownVillage;
    }

    public String getStreetRoadBlock() {
        return StreetRoadBlock;
    }

    public void setStreetRoadBlock(String streetRoadBlock) {
        StreetRoadBlock = streetRoadBlock;
    }

    public String getHouseBuilding() {
        return HouseBuilding;
    }

    public void setHouseBuilding(String houseBuilding) {
        HouseBuilding = houseBuilding;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String other) {
        Other = other;
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
        return "AddressBean{" +
                "addressID=" + addressID +
                ", Country='" + Country + '\'' +
                ", ZipPostCode='" + ZipPostCode + '\'' +
                ", ProvinceStateCounty='" + ProvinceStateCounty + '\'' +
                ", CityTownVillage='" + CityTownVillage + '\'' +
                ", StreetRoadBlock='" + StreetRoadBlock + '\'' +
                ", HouseBuilding='" + HouseBuilding + '\'' +
                ", Other='" + Other + '\'' +
                ", addressType=" + addressType +
                ", isDefault=" + isDefault +
                '}';
    }
}
