package com.sayo.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shuangyao
 * 23:56 2018/4/15
 */
@Service
public class TestService {

    @Autowired
    private PersonService personService;

    public void saveData() {
        try {
            personService.savePerSon();
            personService.saveSynUpInfo(false, null);
        } catch (Exception exception) {
            personService.saveSynUpInfo(true, exception);
            throw exception;
        }
    }
}
