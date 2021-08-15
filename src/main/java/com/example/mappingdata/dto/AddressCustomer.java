package com.example.mappingdata.dto;

import lombok.Data;

@Data
public class AddressCustomer {
    private String streetName;
    private String city;
    private String zipCode;
    private String name;
    private String age;
}
