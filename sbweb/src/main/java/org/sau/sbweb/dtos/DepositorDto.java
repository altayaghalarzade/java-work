package org.sau.sbweb.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class DepositorDto {
    private int id;
    private Date date;
    private double ammount;
    private int customerId;
    private int accountId;
}
