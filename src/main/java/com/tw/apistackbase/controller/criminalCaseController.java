package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.criminalCase;
import com.tw.apistackbase.model.criminalCaseDetail;
import com.tw.apistackbase.model.procuarotate;
import com.tw.apistackbase.repository.criminalCaseDetailRespository;
import com.tw.apistackbase.repository.criminalCaseRespository;
import com.tw.apistackbase.repository.procuarotateRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class criminalCaseController {
    @Autowired
    private criminalCaseRespository criminalCaseRespository;

    @Autowired
    private criminalCaseDetailRespository criminalCaseDetailRespository;


    @GetMapping("/cases")
    public ResponseEntity getCases(){
        return ResponseEntity.ok(criminalCaseRespository.findAll());
    }

    @PostMapping("/cases")
    public ResponseEntity createCriminalCase(@RequestBody criminalCase criminalCase){
        return ResponseEntity.ok(criminalCaseRespository.save(criminalCase));
    }

    @GetMapping("/criminalCases/{ID}")
    public criminalCase findCaseById(@PathVariable long ID) {
        return criminalCaseRespository.findById(ID).get();
    }

    @GetMapping("/criminalCases")
    public List<criminalCase> findAllCases() {
        return criminalCaseRespository.findAll();
    }

    @GetMapping("/sortedCases")
    public List<criminalCase> findAllCasesAndSortedByTime() {

        return criminalCaseRespository.findAllByOrderByTimeStampDesc();
    }

    @DeleteMapping("/criminalCases/{ID}")
    public void deleteCaseById(@PathVariable long ID) {
        criminalCaseRespository.deleteById(ID);
    }

    @GetMapping("/criminalCaseDetails/{ID}")
    public criminalCaseDetail findCriminalDetailById(@PathVariable long ID) {
        return criminalCaseDetailRespository.findById(ID).get();
    }

    @PostMapping("/criminalCases/{ID}")
    public void addElementToCertainCase(@PathVariable long ID, @RequestBody criminalCaseDetail criminalCaseDetail) {
        criminalCase criminalCase = criminalCaseRespository.findById(ID).get();
        criminalCase.setCriminalCaseDetail1(criminalCaseDetail);
    }



}
