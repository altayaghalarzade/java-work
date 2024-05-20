package org.sau.sbweb.dtos;

import lombok.Data;
import org.sau.sbweb.models.Account;
import org.sau.sbweb.models.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DepositorDto {
    private Long id;
    private LocalDate date;
    private BigDecimal amount;
    private Customer customer;
    private Account account;
}