package com.sayo.batch.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Shuangyao
 * 21:29 2018/4/15
 */
@Entity
public class SynUpInfo {

    @Id
    @GeneratedValue
    private Integer number;
    private String status;
    private String reeMsg;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReeMsg() {
        return reeMsg;
    }

    public void setReeMsg(String reeMsg) {
        this.reeMsg = reeMsg;
    }
}
