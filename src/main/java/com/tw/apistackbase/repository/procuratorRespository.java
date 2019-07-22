package com.tw.apistackbase.repository;


import com.tw.apistackbase.model.procurator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface procuratorRespository  extends JpaRepository<procurator, Long> {


}
