package Nine;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.util.Objects;

@Embeddable
public class Address {
    private String city;

    private String address;

    private String zipCode;

    @OneToOne
    private Box box;

    public Address() {}

    public Address(String city, String address, String zipCode) {
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Address setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(getCity(), address1.getCity()) &&
                Objects.equals(getAddress(), address1.getAddress()) &&
                Objects.equals(getZipCode(), address1.getZipCode()) &&
                Objects.equals(box, address1.box);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getAddress(), getZipCode(), box);
    }
}
