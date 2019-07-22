package com.tw.apistackbase;

import com.tw.apistackbase.model.criminalCase;
import com.tw.apistackbase.model.criminalCaseDetail;
import com.tw.apistackbase.repository.criminalCaseDetailRespository;
import com.tw.apistackbase.repository.criminalCaseRespository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class criminalCaseDetailTest {


    @Autowired
    private com.tw.apistackbase.repository.criminalCaseRespository criminalCaseRespository;

    @Autowired
    private com.tw.apistackbase.repository.criminalCaseDetailRespository criminalCaseDetailRespository;

    @Before
    public void setUp() throws Exception {
        List<criminalCase> criminalCases = new ArrayList<>();
        criminalCases.add(new criminalCase("Jason", 1563370121L, new criminalCaseDetail("ss", "ss")));
        criminalCases.add(new criminalCase("berry", 1563370122L, new criminalCaseDetail("ss1", "ss")));
        criminalCases.add(new criminalCase("berry", 1563370123L, new criminalCaseDetail("ss2", "ss")));
        criminalCases.add(new criminalCase("berry", 1563370124L, new criminalCaseDetail("ss3", "ss")));
        criminalCases.add(new criminalCase("berry", 1563370125L, new criminalCaseDetail("ss4", "ss")));
        criminalCases.add(new criminalCase("berry", 1563370126L, new criminalCaseDetail("ss5", "ss")));
        criminalCaseRespository.saveAll(criminalCases);
    }

    @Test
    public void find_case_detail_by_ID() {
        criminalCaseDetail caseDetail = criminalCaseRespository.findAll().get(0).getCriminalCaseDetail1();
        criminalCaseDetail criminalCaseDetail = criminalCaseDetailRespository.findById(caseDetail
                .getID())
                .get();
        assertThat(criminalCaseDetail).isEqualTo(caseDetail);
    }
}
