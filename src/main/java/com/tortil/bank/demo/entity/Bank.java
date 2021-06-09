package com.tortil.bank.demo.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "banks")
public class Bank {

    @Id
    private long id;

    private String name;

    @OneToMany(mappedBy="bank", cascade = CascadeType.ALL)
    private List<Branch> branches;
}
