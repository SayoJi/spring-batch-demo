package com.sayo.batch.service;

import com.sayo.batch.entity.Student;
import com.sayo.batch.entity.StudentRepository;
import com.sayo.batch.entity.SynUpInfo;
import com.sayo.batch.repository.SynUpInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuangyao
 * 21:10 2018/4/15
 */
@Service
public class PersonService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SynUpInfoRepository synUpInfoRepository;

    private String number = null;


    @Transactional
    public void savePerSon() {
        savePerson1();
        savePerson2();
    }

    public void saveSynUpInfo(Boolean isFailed, Exception exception) {
        String status = "Success";
        if (isFailed) {
            status = "Failed";
        }
        for (int i = 0; i < 6; i++) {
            SynUpInfo synUpInfo = new SynUpInfo();
            if (number != null && "Failed".equals(status)) {
                synUpInfo.setReeMsg("number '" + number + "' failed in insert " + exception.getStackTrace());
            }
            synUpInfo.setStatus(status);
            this.synUpInfoRepository.save(synUpInfo);
        }
    }


    @Transactional
    public void savePerson1() {
        List<Student> personList1 = getStudentList1();
        for (Student person : personList1) {
            number = person.getName();
            studentRepository.save(person);
        }

    }


    @Transactional
    public void savePerson2() {
        List<Student> personList = getPersonList2();
        for (Student person : personList) {
            number = person.getName();
            studentRepository.save(person);
        }
    }

    private List<Student> getStudentList1() {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();
        student.setName("name1");
        student.setFirstName("save1");
        Student person2 = new Student();
        person2.setName("name2");
        person2.setFirstName("save2");
        Student person3 = new Student();
        person3.setName("name3");
        person3.setFirstName("save3");


        studentList.add(student);
        studentList.add(person2);
        studentList.add(person3);


        return studentList;
    }

    private List<Student> getPersonList2() {
        List<Student> personList = new ArrayList<>();

        Student person4 = new Student();
        person4.setName("name4");
        person4.setFirstName("save4");
        Student person5 = new Student();
        person5.setName("name5");
        person5.setFirstName("save5 before job save6jksdfjdfsdfhbsffsdddddddddddddddddd");
        Student person6 = new Student();
        person6.setName("name6");
        person6.setFirstName("test ");

        personList.add(person4);
        personList.add(person5);
        personList.add(person6);

        return personList;

    }
}
