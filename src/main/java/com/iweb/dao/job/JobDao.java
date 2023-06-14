package com.iweb.dao.job;

import com.iweb.pojo.Job;

import java.util.List;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 12:37
 */
public interface JobDao {
    /**
     * 插入一条职位信息
     *
     * @param job 包含了要添加的职位信息，其中id为空，因为id是自增长的，不需要由开发者提供
     */
    void insert(Job job);

    /**
     * 根据id修改职位名称
     *
     * @param job 提供需要被修改的name字段的值，已经根据哪一个id进行update的主键id
     *            update job set name = ? where id = ?
     */
    void update(Job job);

    /**
     * 根据id删除职位
     *
     * @param id 要删除的职位主键id
     */
    void deleteById(int id);

    /**
     * 根据职位名称模糊查询职位列表
     *
     * @param name 要查询的职位名称
     * @return 模糊查询到的职位列表
     */
    List<Job> listByName(String name);

    /**
     * 查询所有职位列表
     *
     * @return 所有职位列表
     */
    List<Job> listAll();
}
