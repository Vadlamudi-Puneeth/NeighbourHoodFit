package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is Mandatory")
    private String fullName;

    @NotBlank
    private String mobileNo;

    @NotBlank(message = "Email should be unique")
    private String email;

    private String password;

    private String maritalStatus;

    @Min(value = 1)
    private int noOfFamilyMembers;

    private String profession;

    private Integer twoWheelerCount;

    private Integer fourWheelerCount;

    public User() {
    }

    public User(Long id, String fullName, String mobileNo, String email, String password, String maritalStatus, int noOfFamilyMembers, String profession, Integer twoWheelerCount, Integer fourWheelerCount) {
        this.id = id;
        this.fullName = fullName;
        this.mobileNo = mobileNo;
        this.email = email;
        this.password = password;
        this.maritalStatus = maritalStatus;
        this.noOfFamilyMembers = noOfFamilyMembers;
        this.profession = profession;
        this.twoWheelerCount = twoWheelerCount;
        this.fourWheelerCount = fourWheelerCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getNoOfFamilyMembers() {
        return noOfFamilyMembers;
    }

    public void setNoOfFamilyMembers(int noOfFamilyMembers) {
        this.noOfFamilyMembers = noOfFamilyMembers;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getTwoWheelerCount() {
        return twoWheelerCount;
    }

    public void setTwoWheelerCount(Integer twoWheelerCount) {
        this.twoWheelerCount = twoWheelerCount;
    }

    public Integer getFourWheelerCount() {
        return fourWheelerCount;
    }

    public void setFourWheelerCount(Integer fourWheelerCount) {
        this.fourWheelerCount = fourWheelerCount;
    }
}
