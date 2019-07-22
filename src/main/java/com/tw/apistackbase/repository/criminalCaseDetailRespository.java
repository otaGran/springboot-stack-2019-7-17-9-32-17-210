package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.criminalCaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface criminalCaseDetailRespository extends JpaRepository<criminalCaseDetail, Long> {
}
