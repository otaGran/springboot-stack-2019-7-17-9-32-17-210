package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.criminalCase;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface criminalCaseRespository extends JpaRepository<criminalCase, Long> {
    List<criminalCase> findAllByName(String name);
    List<criminalCase> findAllByOrderByTimeStampDesc();

}
