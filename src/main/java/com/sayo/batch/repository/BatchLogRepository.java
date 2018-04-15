package com.sayo.batch.repository;

import com.sayo.batch.entity.BatchLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shuangyao
 * 23:46 2018/4/14
 */
@Repository
public interface BatchLogRepository extends JpaRepository<BatchLog,Integer> {
}
