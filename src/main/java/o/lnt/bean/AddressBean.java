package o.lnt.bean;

import o.lnt.enumeration.AddressType;

import javax.validation.constraints.NotBlank;

public class AddressBean {
    private Integer addressID;
    @NotBlank(message = "Country cannot be null")
    private String Country;
    private String ZipPostCode;
    private String ProvinceStateCounty;
    @NotBlank (message = "City/Town/Village Name cannot be null")
    private String CityTownVillage;
    @NotBlank (message = "Street/Road/Block cannot be null")
    private String StreetRoadBlock;
    @NotBlank (message = "House/Building Number cannot be null")
    private String HouseBuilding;
    private String Other;
    @NotBlank (message = "Address Type cannot be null")
    private AddressType addressType;
    private Boolean isDefault;
    private Double latitude;
    private Double longitude;

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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
