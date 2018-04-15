package com.sayo.batch.batchjob.listen;


import com.sayo.batch.entity.Person;
import com.sayo.batch.service.BatchLogService;
import com.sayo.batch.service.PersonService;
import com.sayo.batch.service.TestService;
import com.sayo.batch.util.CollectionUtils;
import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Shuangyao
 * 13:24 2018/4/7
 */
@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger logger = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BatchLogService batchLogService;

    @Autowired
    private PersonService personService;

    @Autowired
    private TestService testService;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        testService.saveData();
    }



    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            logger.info("========== Job complete ! ============");
            jdbcTemplate.query("SELECT first_name,last_name FROM people"
                    , (rs, row) -> new Person(
                            rs.getString(1),
                            rs.getString(2))
            ).forEach(person -> logger.info("Found <" + person + "> in database"));
            batchLogService.saveBatchLog(null, true);
        } else {
            List<Throwable> jobExceptions = jobExecution.getFailureExceptions();
            Throwable lastJobException = jobExceptions.get(jobExceptions.size() - 1);
            String lastJobExceptionMessage = lastJobException.getMessage();
            logger.error("lastJobExceptionMessage"+ lastJobExceptionMessage);
            logger.error("lastJobExceptionSize"+ jobExceptions.size());

            batchLogService.saveBatchLog(null, false);
        }
    }
}
