public class Address {
    String district;
    String place;
    Long pinCode;
    public void setDistrict(String district){
        this.district=district;
    }
    public void setPlace(String place){
        this.place=place;
    }
    public void setPinCode(Long pinCode){
        this.pinCode=pinCode;
    }
    public String getDistrict(){
        return district;
    }
    public String getPlace(){
        return place;
    }
    public Long getPinCode(){
        return pinCode;
    }
}
