package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "procuarotate")
public class procuarotate {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;

    @Column(nullable = false,length = 50)
    private String name;

    @OneToMany
    @JoinColumn(name = "procuratorate_id")
    private List<procurator> procurators;

    public procuarotate() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<procurator> getProcurators() {
        return procurators;
    }

    public void setProcurators(List<procurator> procurators) {
        this.procurators = procurators;
    }
}
