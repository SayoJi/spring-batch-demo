package com.sayo.batch.repository;

import com.sayo.batch.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shuangyao
 * 21:12 2018/4/15
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
