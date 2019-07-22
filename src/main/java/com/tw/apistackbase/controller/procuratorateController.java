package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.procuarotate;
import com.tw.apistackbase.repository.procuarotateRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class procuratorateController {


    @Autowired
    private com.tw.apistackbase.repository.procuarotateRespository procuarotateRespository;

    @GetMapping("/procuratorates/{Id}")
    public procuarotate findProcuratorates(@PathVariable long Id) {
        return procuarotateRespository.findById(Id).get();
    }
}
