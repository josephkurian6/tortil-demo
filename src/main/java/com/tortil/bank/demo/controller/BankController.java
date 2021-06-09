package com.tortil.bank.demo.controller;

import com.tortil.bank.demo.model.BranchModel;
import com.tortil.bank.demo.model.ResourceResponse;
import com.tortil.bank.demo.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * <p>Controller for bank/branch resources</p>
 * @Date 6/9/2021
 */
@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    /**
     * <p>Get branch for a given IFSC Code. Branch resource with self reference link</p>
     * @version V1
     * @param ifscCode
     * @return RepresentationModel of branch resource.
     */
    @GetMapping("/v1/{ifscCode}")
    public ResourceResponse getBankBranch(@PathVariable("ifscCode") String ifscCode) {
        return new ResourceResponse(bankService.getBranch(ifscCode))
                .add(linkTo(methodOn(BankController.class).getBankBranch(ifscCode)).withSelfRel());
    }

    /**
     * <p>Get branch for a given IFSC Code.</p>
     * @version: V0
     * @param ifscCode
     * @return BranchModel
     */
    @GetMapping("/{ifscCode}")
    public BranchModel getBranch(@PathVariable("ifscCode") String ifscCode) {
        return bankService.getBranch(ifscCode);
    }
}
