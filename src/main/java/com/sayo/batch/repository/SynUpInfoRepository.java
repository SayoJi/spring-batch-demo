package com.sayo.batch.repository;

import com.sayo.batch.entity.SynUpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shuangyao
 * 22:29 2018/4/15
 */
@Repository
public interface SynUpInfoRepository extends JpaRepository<SynUpInfo,Integer> {
}
