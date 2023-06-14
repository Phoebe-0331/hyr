package com.iweb.dao.department;

import com.iweb.pojo.Department;

import java.util.List;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 12:36
 */
public interface DepartmentDao {
    /**
     * 添加部门信息
     *
     * @param department 需要添加的部门信息，其中id为空，因为id是自增长的，不需要提供
     */
    void add(Department department);

    /**
     * 根据部门名称进行模糊查询部门信息
     *
     * @param name 部门名称，用于进行模糊查询，如果为空，则查询所有部门信息
     * @return 查询到的符合条件的部门信息列表
     */
    List<Department> query(String name);

    /**
     * 根据部门id删除部门信息
     *
     * @param id 需要删除的部门信息对应的id
     */
    void delete(int id);

    /**
     * 修改部门信息，根据部门id进行修改
     *
     * @param department
     */
    void update(Department department);
}

