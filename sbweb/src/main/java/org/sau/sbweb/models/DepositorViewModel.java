package org.sau.sbweb.models;

import lombok.Data;

import java.util.Date;

@Data
public class DepositorViewModel {
    private Long id;
    private String customerName;
    private String accountBranch;
    private double accountBalance;
    private String depositDate;
    private double depositAmount;

    public DepositorViewModel(int id, String s, String s1, double v, Date date, Double amount) {
    }
}
