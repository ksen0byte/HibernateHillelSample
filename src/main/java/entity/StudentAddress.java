 package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentAddress {
    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String address;

    public StudentAddress() {
    }

    public StudentAddress(String country, String city, String address) {
        this.country = country;
        this.city = city;
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
