package br.com.test.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

public class PersonVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String lastName;
    private String address;
    private String gender;

    public PersonVO() {}

    public PersonVO(Integer id, String name, String lastName, String address, String gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVO PersonVO = (PersonVO) o;
        return Objects.equals(id, PersonVO.id) && Objects.equals(name, PersonVO.name) && Objects.equals(lastName, PersonVO.lastName) && Objects.equals(address, PersonVO.address) && Objects.equals(gender, PersonVO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, address, gender);
    }
}
