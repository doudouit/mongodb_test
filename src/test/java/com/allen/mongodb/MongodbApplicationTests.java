package com.allen.mongodb;

import com.alibaba.fastjson2.JSON;
import com.allen.mongodb.dao.StudentDaoTypeOne;
import com.allen.mongodb.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
class MongodbApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private StudentDaoTypeOne studentDaoTypeOne;

    @Test
    void addOneStudent() {
//        插入10行
        for (Integer count = 0; count < 10; count++) {
            Student student = new Student()
                    .setStudentId("student_" + count) //如果自己不去设置id则系统会分配给一个id
                    .setStudentName("Godfery" + count)
                    .setStudentAge(count)
                    .setStudentScore(98.5 - count)
                    .setStudentBirthday(new Date());
            studentDaoTypeOne.save(student);
        }
    }

    @Test
    void deleteOneStudentByStudentId() {
//        删除id为student_0的学生
        studentDaoTypeOne.deleteById("student_0");
    }

    @Test
    void updateOneStudent() {
//        修改姓名为Godfery1的Student年龄为22
        Student student = studentDaoTypeOne.getAllByStudentName("Godfery1");
        student.setStudentAge(22);
        studentDaoTypeOne.save(student);

    }

    @Test
    void getOneStudentByStudentId() {
        System.out.println(studentDaoTypeOne.findById("student_1"));
    }

    @Test
    void getAllStudent() {
        List<Student> studentList = studentDaoTypeOne.findAll();
        studentList.forEach(System.out::println);
    }

    @Test
    void findByStudentNameLike() {
        List<Student> student = studentDaoTypeOne.findByStudentNameLike("God");
        System.out.println(student);
    }

    @Test
    void testPageQuery() {
        Sort sort = Sort.by("studentAge").ascending();
        PageRequest pageRequest = PageRequest.of(0, 5, sort);
        Page<Student> all = studentDaoTypeOne.findAll(pageRequest);
        log.info("【总页数】 = {}", all.getTotalPages());
        log.info("【总条数数】 = {}", all.getTotalElements());
        log.info("【当前页数据】 = {}", JSON.toJSONString(all.getContent()
                .stream()
                .map(student ->
                        "学生id： " + student.getStudentId() +
                        " 学生姓名： " + student.getStudentName() +
                        " 学生年龄： " + student.getStudentAge() +
                        " 分数： " + student.getStudentScore() +
                        " 生日： " + student.getStudentBirthday())
                .collect(Collectors.toList())
        ));
    }

    @Test
    public void deleteAll() {
        studentDaoTypeOne.deleteAll();
    }

}
