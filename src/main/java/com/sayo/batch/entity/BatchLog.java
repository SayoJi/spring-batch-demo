package com.sayo.batch.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by Shuangyao
 * 23:41 2018/4/14
 */
@Entity
public class BatchLog {

    @Id
    @GeneratedValue
    private Integer id;
    private Timestamp jobTime;
    private Boolean successFlag;
    private String errMag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getJobTime() {
        return jobTime;
    }

    public void setJobTime(Timestamp jobTime) {
        this.jobTime = jobTime;
    }

    public Boolean getSuccessFlag() {
        return successFlag;
    }

    public void setSuccessFlag(Boolean successFlag) {
        this.successFlag = successFlag;
    }

    public String getErrMag() {
        return errMag;
    }

    public void setErrMag(String errMag) {
        this.errMag = errMag;
    }
}
