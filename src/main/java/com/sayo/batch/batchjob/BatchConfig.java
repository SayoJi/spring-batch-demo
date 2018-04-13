package com.sayo.batch.batchjob;

import com.sayo.batch.batchjob.listen.JobCompletionNotificationListener;
import com.sayo.batch.batchjob.processor.ProcessorBean;
import com.sayo.batch.batchjob.reader.BatchReaderBean;
import com.sayo.batch.batchjob.writer.WriterBean;
import com.sayo.batch.entity.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Shuangyao
 * 17:00 2018/4/5
 * Spring batch demo,refer to spring official website {https://spring.io/guides/gs/batch-processing/}
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private WriterBean writerBean;


    /**
     * Job.
     */
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step) {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step)
                .end()
                .build();
    }

    /**
     * Step.
     */
    @Bean
    public Step step1(JdbcBatchItemWriter writer) {
        return stepBuilderFactory.get("step1")
                .<Person, Person>chunk(10)
                .reader(BatchReaderBean.reader())
                .processor(ProcessorBean.processor())
                .writer(writer)
                .build();
    }

}
