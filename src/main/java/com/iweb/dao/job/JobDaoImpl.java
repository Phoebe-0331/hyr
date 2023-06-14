package com.iweb.dao.job;

import com.iweb.pojo.Job;
import com.iweb.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 13:19
 */
public class JobDaoImpl implements JobDao {
    @Override
    public void insert(Job job) {
        String sql = "INSERT INTO job(name) VALUES (?)";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            pstmt.setString(1, job.getName());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                job.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Job job) {
        String sql = "UPDATE `job` SET `name` = ? WHERE `id` = ?";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, job.getName());
            pstmt.setInt(2, job.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM `job` WHERE `id` = ?";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Job> listByName(String name) {
        List<Job> list = new ArrayList<>();
        String sql = "SELECT * FROM `job` WHERE `name` LIKE CONCAT('%',?,'%')";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String jobName = rs.getString("name");
                Job job = new Job(id, jobName);
                list.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Job> listAll() {
        List<Job> list = new ArrayList<>();
        String sql = "SELECT * FROM `job`";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String jobName = rs.getString("name");
                Job job = new Job(id, jobName);
                list.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
