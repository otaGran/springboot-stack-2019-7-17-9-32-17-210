package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.procuarotate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface procuarotateRespository extends JpaRepository<procuarotate, Long> {

}

