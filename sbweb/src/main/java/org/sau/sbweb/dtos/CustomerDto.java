package org.sau.sbweb.dtos;

import lombok.Data;

@Data
public class CustomerDto {
    private int id;
    private String name;
    private String address;
    private String city;
}
