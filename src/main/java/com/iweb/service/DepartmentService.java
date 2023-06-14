package com.iweb.service;

import com.iweb.dao.department.DepartmentDao;
import com.iweb.dao.department.DepartmentDaoImpl;
import com.iweb.pojo.Department;
import com.iweb.pojo.Personnel;
import com.iweb.util.Print;
import com.iweb.view.DepartmentView;

import java.util.List;
import java.util.Scanner;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 15:51
 */
public class DepartmentService {
    private static Scanner sc = new Scanner(System.in);

    public static void queryDepartment() {
        // 询问用户要查询的部门名称
        Print.print("请输入要查询的部门名称");
        String name = sc.nextLine();

        // 创建 DepartmentDaoImpl 实例
        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();

        // 调用 query() 方法查询部门信息，返回结果保存在 departmentList 中
        List<Department> departmentList = departmentDao.query(name);

        // 判断查询结果是否为空并输出
        if (departmentList != null && departmentList.size() > 0) {
            for (Department department : departmentList) {
                System.out.println(department);
            }
        } else {
            Print.print("没有匹配的结果");
        }
        DepartmentView.departmentView();
    }


    public static void addDepartment() {
        // 读取用户输入的新部门相关信息
        Print.print("请输入新部门id：");
        int id = Integer.parseInt(sc.nextLine());
        Print.print("请输入新部门名称：");
        String name = sc.nextLine();

        // 构造新的 Department 对象
        Department department = new Department(id, name);

        // 创建 DepartmentDaoImpl 实例
        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();

        // 调用 add() 方法查询部门信息，返回结果保存在 departmentList 中
        departmentDao.add(department);

        // 打印添加成功消息
        Print.print("部门添加成功！");
        DepartmentView.departmentView();
    }

    public static void updateDepartment() {
        // 询问用户要修改的部门 ID
        Print.print("请输入要修改的部门 ID：");
        int id = Integer.parseInt(sc.nextLine());

        // 读取用户输入的新部门信息
        Print.print("请输入新的部门名称：");
        String name = sc.nextLine();

        // 构造新的 Department 对象
        Department department = new Department(id, name);

        // 创建 DepartmentDaoImpl 实例
        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();

        // 调用 update() 方法更新部门信息
        departmentDao.update(department);

        // 打印添加成功消息
        Print.print("部门修改成功！");
        DepartmentView.departmentView();
    }

    public static void deleteDepartment() {
        // 询问用户要删除的部门 ID
        Print.print("请输入要删除的部门 ID：");
        int id = Integer.parseInt(sc.nextLine());

        // 构造新的 Department 对象
        Department department = new Department();

        // 创建 DepartmentDaoImpl 实例
        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();

        // 调用 delete() 方法删除部门信息
        departmentDao.delete(id);

        // 打印删除成功消息
        Print.print("部门删除成功！");
        DepartmentView.departmentView();

    }
}

