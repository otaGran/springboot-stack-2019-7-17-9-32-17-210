package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
public class criminalCaseDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long ID;

    @Column(nullable = false, length = 255, unique = true)
    private String objectiveDescription;

    @Column(nullable = false, length = 255)
    private String subjectiveDescription;

    public criminalCaseDetail() {
    }


    public criminalCaseDetail(String objectiveDescription, String subjectiveDescription) {
        this.objectiveDescription = objectiveDescription;
        this.subjectiveDescription = subjectiveDescription;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public void setObjectiveDescription(String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
    }

    public String getSubjectiveDescription() {
        return subjectiveDescription;
    }

    public void setSubjectiveDescription(String subjectiveDescription) {
        this.subjectiveDescription = subjectiveDescription;
    }
}
