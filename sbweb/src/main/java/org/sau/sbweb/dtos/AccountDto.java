package org.sau.sbweb.dtos;

import lombok.Data;

@Data
public class AccountDto {
    private int id;
    private String branch;
    private double balance;
}
