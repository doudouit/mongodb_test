package com.allen.mongodb;

import com.allen.mongodb.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 窦建新
 * @description
 * @date 2022/9/13 15:04
 */
@Slf4j
@SpringBootTest
public class MongodbTemplateTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void is() {
        Query query = new Query();
        query.addCriteria(Criteria.where("studentName").is("Echo1"));
        Student student = mongoTemplate.findOne(query, Student.class);
        System.out.println(student);
        List<Student> students = mongoTemplate.find(query, Student.class);
        students.forEach(System.out::println);
    }

    @Test
    void in() {
        List<Integer> list = Arrays.asList(2,3,4,5);
        Query query = new Query(Criteria.where("studentAge").in(list));
        // 返回指定字段
        query.fields().include("studentId");
        query.fields().include("studentName");
        List<Student> students = mongoTemplate.find(query, Student.class);
        students.forEach(System.out::println);
    }

    @Test
    void like() {
        Query query = new Query(Criteria.where("studentName").regex("cho"));
        // 指定字段不返回
        query.fields().exclude("studentId");
        List<Student> students = mongoTemplate.find(query, Student.class);
        students.forEach(System.out::println);
    }


}
