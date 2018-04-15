package com.sayo.batch.service;

import com.sayo.batch.entity.BatchLog;
import com.sayo.batch.repository.BatchLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by Shuangyao
 * 23:47 2018/4/14
 */
@Service
public class BatchLogService {

    @Autowired
    private BatchLogRepository batchLogRepository;

    public void saveBatchLog(String errMsg, Boolean isSuccess) {
        BatchLog batchLog = new BatchLog();
        batchLog.setJobTime(new Timestamp(System.currentTimeMillis()));
        batchLog.setSuccessFlag(isSuccess);
        if (errMsg != null) {
            batchLog.setErrMag(errMsg);
        }
        this.batchLogRepository.save(batchLog);
    }
}
