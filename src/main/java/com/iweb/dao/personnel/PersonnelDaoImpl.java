package com.iweb.dao.personnel;

import com.iweb.dao.personnel.PersonnelDao;
import com.iweb.pojo.Personnel;
import com.iweb.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 13:41
 */
public class PersonnelDaoImpl implements PersonnelDao {
    @Override
    public void insert(Personnel personnel) {
        String sql = "insert into personnel("
                + "id, name, tel, sex, job, dept, dept_id, job_id, passName, passWord, status) "
                + "values (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            pstmt.setInt(1, personnel.getId());
            pstmt.setString(2, personnel.getName());
            pstmt.setString(3, personnel.getTel());
            pstmt.setString(4, personnel.getSex());
            pstmt.setString(5, personnel.getJob());
            pstmt.setString(6, personnel.getDept());
            pstmt.setInt(7, personnel.getDept_id());
            pstmt.setInt(8, personnel.getJob_id());
            pstmt.setString(9, personnel.getPassName());
            pstmt.setString(10, personnel.getPassWord());
            pstmt.setInt(11, personnel.getStatus());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                personnel.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDeptAndJobById(Personnel personnel) {
        String sql = "update personnel set dept_id=?, job_id=? where id=?";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, personnel.getDept_id());
            pstmt.setInt(2, personnel.getJob_id());
            pstmt.setInt(3, personnel.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Personnel> getByName(String name) {
        List<Personnel> personnelList = new ArrayList<>();
        String sql = "select * from personnel where name=?";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Personnel personnel = new Personnel();
                personnel.setId(rs.getInt("id"));
                personnel.setName(rs.getString("name"));
                personnel.setTel(rs.getString("tel"));
                personnel.setSex(rs.getString("sex"));
                personnel.setJob(rs.getString("job"));
                personnel.setDept(rs.getString("dept"));
                personnel.setDept_id(rs.getInt("dept_id"));
                personnel.setJob_id(rs.getInt("job_id"));
                personnel.setPassName(rs.getString("passName"));
                personnel.setPassWord(rs.getString("passWord"));
                personnel.setStatus(rs.getInt("status"));

                personnelList.add(personnel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnelList.size() == 0 ? null : personnelList;
    }

    @Override
    public void deleteById(int id) {
        String sql = "delete from personnel where id=?";
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

    @Override
    public List<Personnel> listAll() {
        String sql = "select * from personnel";
        List<Personnel> personnelList = new ArrayList<>();
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Personnel personnel = new Personnel();
                personnel.setId(rs.getInt("id"));
                personnel.setName(rs.getString("name"));
                personnel.setTel(rs.getString("tel"));
                personnel.setSex(rs.getString("sex"));
                personnel.setJob(rs.getString("job"));
                personnel.setDept(rs.getString("dept"));
                personnel.setDept_id(rs.getInt("dept_id"));
                personnel.setJob_id(rs.getInt("job_id"));
                personnel.setPassName(rs.getString("passName"));
                personnel.setPassWord(rs.getString("passWord"));
                personnel.setStatus(rs.getInt("status"));

                personnelList.add(personnel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnelList;
    }

}
