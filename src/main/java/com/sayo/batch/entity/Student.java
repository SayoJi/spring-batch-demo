package com.sayo.batch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Shuangyao
 * 21:46 2018/4/15
 */
@Entity
public class Student {

    @Id
    private String name;
    @Column(length = 20)
    private String firstName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
