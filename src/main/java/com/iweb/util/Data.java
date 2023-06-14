package com.iweb.util;

import com.iweb.pojo.Personnel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 16:37
 */
public class Data {
    private static List<Personnel> personnelList;
    //count用来记录我们当前数组中用户的数量
    private static Integer count;

    //在java代码一次运行的期间内,只有当前Data类第一次被使用(加载)的时候,才会运行
    static {
        init();
    }

    public static List<Personnel> getPersonnel() {
        return personnelList;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Data.count = count;
    }


    public static void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String URL = "jdbc:mysql://localhost:3306/personnel_management?characterEncoding=utf-8";
        String USERNAME = "root";
        final String PASSWORD = "123456";

        personnelList = new ArrayList<>(); //创建集合对象

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            //连接到数据库
            String sql = "SELECT * FROM personnel ";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                //执行查询
                try (ResultSet rs = ps.executeQuery()) {
                    //处理结果集
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String tel = rs.getString("tel");
                        String sex = rs.getString("sex");
                        String job = rs.getString("job");
                        String dept = rs.getString("dept");
                        int dept_id = rs.getInt("dept_id");
                        int job_id = rs.getInt("job_id");
                        String passName = rs.getString("passName");
                        String passWord = rs.getString("passWord");
                        int status = rs.getInt("status");

                        Personnel personnel = new Personnel(id, name, tel, sex, job, dept, dept_id, job_id, passName, passWord, status);
                        personnelList.add(personnel); //添加到集合中
                        count = rs.last() ? rs.getRow() : 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
