package com.sayo.batch.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shuangyao
 * 21:49 2018/4/15
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
}
