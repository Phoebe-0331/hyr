package com.iweb.dao.personnel;

import com.iweb.pojo.Personnel;

import java.util.List;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 12:38
 */
public interface PersonnelDao {
    /**
     * 插入一条员工记录，其中id为自增字段，不需要提供
     *
     * @param personnel 待插入的员工信息
     */
    void insert(Personnel personnel);

    /**
     * 根据id修改员工记录中的dept_id和job_id字段的值
     *
     * @param personnel 提供需要被修改的dept_id和job_id字段的值, 以及根据哪一个id进行update的主键id
     */
    void updateDeptAndJobById(Personnel personnel);

    /**
     * 根据用户名查询员工信息
     *
     * @param name 用户名
     * @return 查询到的员工信息，如果没有则返回为空
     */
    List<Personnel> getByName(String name);

    /**
     * 根据员工id删除指定员工记录
     *
     * @param id 员工id
     */
    void deleteById(int id);

    /**
     * 查询所有员工的信息
     *
     * @return 所有员工的信息
     */
    List<Personnel> listAll();

}
