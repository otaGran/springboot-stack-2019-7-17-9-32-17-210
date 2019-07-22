package com.tw.apistackbase.model;



import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "criminalCase")
public class criminalCase {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long ID;

    @Column(nullable = false,length = 255)
    private String name;

    @Column(nullable = false)
    private long timeStamp;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private criminalCaseDetail criminalCaseDetail1;


    public criminalCase(){

    }

    public criminalCase(String name,long timeStamp) {
        this.name = name;
        this.timeStamp = timeStamp;
    }

    public criminalCase(String name,long timeStamp, @NotNull criminalCaseDetail criminalCaseDetail1) {
        this.name = name;
        this.timeStamp = timeStamp;
        this.criminalCaseDetail1 = criminalCaseDetail1;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public criminalCaseDetail getCriminalCaseDetail1() {
        return criminalCaseDetail1;
    }

    public void setCriminalCaseDetail1(criminalCaseDetail criminalCaseDetail1) {
        this.criminalCaseDetail1 = criminalCaseDetail1;
    }
}
