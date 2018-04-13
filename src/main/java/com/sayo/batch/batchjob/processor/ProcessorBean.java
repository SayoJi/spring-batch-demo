package com.sayo.batch.batchjob.processor;

import org.springframework.context.annotation.Bean;

/**
 * Created by Shuangyao
 * 23:47 2018/4/13
 */
public class ProcessorBean {

    /**
     * Processor.
     */
    @Bean
    public static PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }
}
