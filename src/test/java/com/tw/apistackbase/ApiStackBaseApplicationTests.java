package com.tw.apistackbase;

import com.tw.apistackbase.model.criminalCase;
import com.tw.apistackbase.model.criminalCaseDetail;
import com.tw.apistackbase.repository.criminalCaseRespository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Java6Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApiStackBaseApplicationTests {
	@Autowired
	private criminalCaseRespository criminalCaseRespository;

	@Test
	public void contextLoads() {
		
	}

}
