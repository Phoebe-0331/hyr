package com.iweb.dao.department;

import com.iweb.pojo.Department;
import com.iweb.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 12:40
 */
public class DepartmentDaoImpl implements DepartmentDao {

    /**
     * 添加部门信息
     *
     * @param department 需要添加的部门信息，其中id为空，因为id是自增长的，不需要提供
     */
    @Override
    public void add(Department department) {
        String sql = "INSERT INTO department(name) VALUES(?)";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            pstmt.setString(1, department.getName());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                department.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据部门名称进行模糊查询部门信息
     *
     * @param name 部门名称，用于进行模糊查询，如果为空，则查询所有部门信息
     * @return 查询到的符合条件的部门信息列表
     */
    @Override
    public List<Department> query(String name) {
        String sql = "SELECT id, name FROM department WHERE 1=1 ";
        if (null != name && !"".equals(name)) {
            sql += " AND name LIKE '%" + name + "%'";
        }
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()
        ) {
            List<Department> list = new ArrayList<>();
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                list.add(department);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据部门id删除部门信息
     *
     * @param id 需要删除的部门信息对应的id
     */
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM department WHERE id=?";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改部门信息，根据部门id进行修改
     *
     * @param department 需要修改的部门信息
     */
    @Override
    public void update(Department department) {
        String sql = "UPDATE department SET name=? WHERE id=?";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, department.getName());
            pstmt.setInt(2, department.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
