package com.tortil.bank.demo;

import com.tortil.bank.demo.exception.BadInputRequest;
import com.tortil.bank.demo.exception.RecordNotFoundException;
import com.tortil.bank.demo.model.BranchModel;
import com.tortil.bank.demo.repository.BranchRepository;
import com.tortil.bank.demo.service.BankService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class DemoApplicationTests {

	@InjectMocks
	private BankService bankService;

	@Mock
	private BranchRepository branchRepository;

	private static final String ifscTestCode = "ABHY0065001";

	@BeforeEach
	void initiateExecutionServiceTests() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getBranchServiceTest() {
		BranchModel branchModel = new BranchModel("ABHY0065001", "RTGS-HO",
				"ABHYUDAYA COOPERATIVE BANK LIMITED",
				"ABHYUDAYA BANK BLDG., B.NO.71, NEHRU NAGAR, KURLA (E), MUMBAI-400024",
				"MUMBAI", "GREATER MUMBAI", "MAHARASHTRA");
		when(branchRepository.getBranch(ifscTestCode)).thenReturn(branchModel);
		Assertions.assertEquals(branchModel, bankService.getBranch(ifscTestCode));
	}

	@Test
	void getBranchServiceValidations() {
		Assertions.assertThrows(BadInputRequest.class, () -> bankService.getBranch(null));
		Assertions.assertThrows(BadInputRequest.class, () -> bankService.getBranch(""));
		when(branchRepository.getBranch(ifscTestCode)).thenReturn(null);
		Assertions.assertThrows(RecordNotFoundException.class, () -> bankService.getBranch(ifscTestCode));
	}

}
