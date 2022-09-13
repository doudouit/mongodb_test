package com.allen.mongodb.dao;


import com.allen.mongodb.entity.Student;

import java.util.List;

/**
 * dao层写法二
 * <p>
 * 写法二需要进行实现
 */
public interface StudentDaoTypeTwo {
    /**
     * 增加一位学生
     *
     * @param student
     */
    void addOneStudent(Student student);

    /**
     * 根据id删除一位学生
     *
     * @param studentId
     */
    void deleteOneStudentByStudentId(String studentId);


    /**
     * 修改一位学生的信息
     *
     * @param student
     */
    void updateOneStudent(Student student);


    /**
     * 根据主键id获取一名学生
     *
     * @param studentId
     * @return
     */
    Student getOneStudentByStudentId(String studentId);


    /**
     * 获取全部学生
     *
     * @return
     */
    List<Student> getAllStudent();
}


