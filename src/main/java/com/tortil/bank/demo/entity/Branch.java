package com.tortil.bank.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "branches")
public class Branch {

    @Id
    private long id;

    private String ifsc;

    private String branch;

    private String address;

    private String city;

    private String district;

    private String state;

    @OneToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private Bank bank;
}
