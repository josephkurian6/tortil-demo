package com.tortil.bank.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO for branch resource
 */
@Data
@AllArgsConstructor
public class BranchModel {

    private String ifscCode;

    private String branchName;

    private String bankName;

    private String address;

    private String city;

    private String district;

    private String state;
}
