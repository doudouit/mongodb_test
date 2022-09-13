package com.allen.mongodb.dao.impl;


import com.allen.mongodb.dao.StudentDaoTypeTwo;
import com.allen.mongodb.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoTypeTwoImp implements StudentDaoTypeTwo {

    /**
     * 使用MongoTemplate模板类实现数据库操作
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 增加一位学生
     *
     * @param student
     */
    public void addOneStudent(Student student) {
        mongoTemplate.save(student);

    }


    /**
     * 根据id删除一位学生
     *
     * @param studentId
     */
    public void deleteOneStudentByStudentId(String studentId) {
        Student student = mongoTemplate.findById(studentId, Student.class);
        if (student != null) {
            mongoTemplate.remove(student);
        }

    }

    /**
     * 修改一位学生的信息
     *
     * @param student
     */
    public void updateOneStudent(Student student) {
        mongoTemplate.save(student);
    }

    /**
     * 根据主键id获取一名学生
     *
     * @param studentId
     * @return
     */
    public Student getOneStudentByStudentId(String studentId) {
        return mongoTemplate.findById(studentId, Student.class);
    }

    /**
     * 获取全部学生
     *
     * @return
     */
    public List<Student> getAllStudent() {
        return mongoTemplate.findAll(Student.class);
    }
}


