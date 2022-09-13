package com.allen.mongodb.dao;


import com.allen.mongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * dao层写法一
 * 这里的用法其实和SpringDataJPA相似, 可根据需要来自定义方法
 * <p>
 * 这种写法不需要写实现类
 * <p>
 * MongoRepository<行对应的对象类型, 主键列类型>
 */
public interface StudentDaoTypeOne extends MongoRepository<Student, String> {


    /**
     * 可根据需求自己定义方法, 无需对方法进行实现
     *
     * @param studentName
     * @return
     */
    Student getAllByStudentName(String studentName);

    /**
     * 根据学生名字模糊查询
     *
     * @param studentName
     * @return
     */
    List<Student> findByStudentNameLike(String studentName);

}


