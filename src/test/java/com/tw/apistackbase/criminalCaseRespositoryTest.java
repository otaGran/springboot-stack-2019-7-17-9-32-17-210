package com.tw.apistackbase;


import com.tw.apistackbase.model.criminalCase;
import com.tw.apistackbase.model.criminalCaseDetail;
import com.tw.apistackbase.repository.criminalCaseRespository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@RunWith(SpringRunner.class)
@DataJpaTest
public class criminalCaseRespositoryTest {

    @Autowired
    private criminalCaseRespository criminalCaseRespository;

    @Test
    public void should_not_save_criminal_case_if_any_field_is_null_except_id() {

//        assertThrows(Exception.class, () -> {
//            criminalCase x = new criminalCase(null, 1563370123L,new criminalCaseDetailRespository());
//            criminalCaseRespository.save(x);
//        });
////        criminalCaseRespository.findAllByOrderByTimeStampAsc();

    }

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
    public void should_return_correspond_criminal_case_when_given_name() {
        List<criminalCase> findEmployees = criminalCaseRespository.findAllByName("berry");
        Assertions.assertThat(findEmployees.stream()
                .filter(v -> v.getName().equals("berry"))
                .collect(Collectors.toList()))
                .size()
                .isEqualTo(5);
    }


    @Test
    public void should_find_case_by_ID() {
        criminalCaseDetail criminalElement = new criminalCaseDetail();
        criminalElement.setObjectiveDescription("objective");
        criminalElement.setSubjectiveDescription("subjective");
        criminalCase criminalCase = new criminalCase();
        criminalCase.setName("case1");
        criminalCase.setTimeStamp(20190701);
        criminalCase.setCriminalCaseDetail1(criminalElement);
        criminalCaseRespository.save(criminalCase);

        criminalCase fetchedCriminalCase = criminalCaseRespository.findById(criminalCase.getID()).get();

        assertThat(fetchedCriminalCase.getName()).isEqualTo("case1");
        assertThat(fetchedCriminalCase.getTimeStamp()).isEqualTo(20190701);
        assertThat(fetchedCriminalCase.getCriminalCaseDetail1()).isEqualTo(criminalElement);
    }

    @Test
    public void should_find_all_cases() {
        List<criminalCase> findEmployees = criminalCaseRespository.findAll();

        assertThat(findEmployees.get(0).getName()).isEqualTo("Jason");
        assertThat(findEmployees.get(1).getName()).isEqualTo("berry");
    }

    @Test
    public void should_find_all_cases_and_sorted_byTime() {
        List<criminalCase> findEmployees = criminalCaseRespository.findAllByOrderByTimeStampDesc();

        assertThat(findEmployees.get(0).getTimeStamp()).isEqualTo(1563370126L);
        assertThat(findEmployees.get(1).getTimeStamp()).isEqualTo(1563370125L);
    }

    @Test
    public void delete_case_by_ID() {
        List<criminalCase> findEmployees = criminalCaseRespository.findAll();
        criminalCase criminalCase1 = findEmployees.get(0);
        criminalCaseRespository.deleteById(findEmployees.get(0).getID());

        assertThat(criminalCaseRespository.findAll()).doesNotContain(criminalCase1);
    }
}
