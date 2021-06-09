package com.tortil.bank.demo.service;

import com.tortil.bank.demo.exception.BadInputRequest;
import com.tortil.bank.demo.exception.RecordNotFoundException;
import com.tortil.bank.demo.model.BranchModel;
import com.tortil.bank.demo.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Bank resource services
 * @Date 6/9/2021
 */
@Service
public class BankService {

    @Autowired
    private BranchRepository branchRepository;

    /**
     * <p>Method to retrieve a bank branch from branch repository for a given IFSC code.</p>
     * @param ifscCode
     * @return BranchModel
     * @throws RecordNotFoundException
     */
    public BranchModel getBranch(String ifscCode) throws RecordNotFoundException {
        if(ifscCode != null && !ifscCode.isBlank()) {
            BranchModel branchModel = branchRepository.getBranch(ifscCode);
            if(branchModel != null) {
                return branchModel;
            } else {
                throw new RecordNotFoundException("No record found for IFSC code: " + ifscCode);
            }
        } else {
            throw new BadInputRequest("Request with an empty IFSC code as input");
        }
    }
}
