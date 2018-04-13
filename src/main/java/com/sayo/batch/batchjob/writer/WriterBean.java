package com.sayo.batch.batchjob.writer;

import com.sayo.batch.entity.Person;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Shuangyao
 * 23:50 2018/4/13
 */
@Component
public class WriterBean {

    /**
     * Writer.
     */
    @Bean
    public JdbcBatchItemWriter<Person> writer(@Qualifier("dataSource") DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Person>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO people (first_name,last_name) VALUE (:firstName, :lastName)")
                .dataSource(dataSource)
                .build();
    }
}
