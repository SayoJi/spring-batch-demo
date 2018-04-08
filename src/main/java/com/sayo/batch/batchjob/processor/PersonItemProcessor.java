package com.sayo.batch.batchjob.processor;


import com.sayo.batch.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Shuangyao
 * 20:45 2018/4/5
 */
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger logger = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(final Person person) throws Exception {
        final String lastName = person.getLastName().toUpperCase();
        final String firstName = person.getFirstName().toUpperCase();

        Person resultPerson = new Person(firstName, lastName);

        logger.info("Convert " + person + "to" + resultPerson);

        return resultPerson;
    }
}
