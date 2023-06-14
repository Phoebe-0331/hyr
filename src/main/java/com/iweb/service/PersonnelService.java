package com.iweb.service;

import com.iweb.dao.department.DepartmentDaoImpl;
import com.iweb.dao.personnel.PersonnelDaoImpl;
import com.iweb.pojo.Department;
import com.iweb.pojo.Personnel;
import com.iweb.util.Print;
import com.iweb.view.DepartmentView;
import com.iweb.view.PersonnelView;

import java.util.List;
import java.util.Scanner;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 15:51
 */
public class PersonnelService {
    private static Scanner sc = new Scanner(System.in);

    public static void queryPersonnel() {
        // 询问用户要查询的员工名称
        Print.print("请输入要查询的员工姓名：");
        String name = sc.nextLine();

        // 构造新的 Department 对象
        Department department = new Department();

        // 创建 PersonnelDaoImpl 实例
        PersonnelDaoImpl personnelDao = new PersonnelDaoImpl();

        // 调用 query() 方法查询员工信息，返回结果保存在 personnelList 中
        List<Personnel> personnelList = personnelDao.getByName(name);

        // 判断查询结果是否为空并输出
        if (personnelList != null && personnelList.size() > 0) {
            for (Personnel personnel : personnelList) {
                System.out.println(personnel);
            }
        } else {
            Print.print("没有匹配的结果");
        }
        PersonnelView.personnelView();
    }

    public static void addPersonnel() {
        // 读取用户输入的新员工相关信息
        Print.print("请输入新员工id：");
        int id = Integer.parseInt(sc.nextLine());
        Print.print("请输入新员工姓名：");
        String name = sc.nextLine();
        Print.print("请输入新员工电话：");
        String tel = sc.nextLine();
        Print.print("请输入新员工性别：");
        String sex = sc.nextLine();
        Print.print("请输入新员工职位：");
        String job = sc.nextLine();
        Print.print("请输入新员工部门：");
        String dept = sc.nextLine();
        Print.print("请输入新员工部门id：");
        int depId = Integer.parseInt(sc.nextLine());
        Print.print("请输入新员工的职位id：");
        int jobId = Integer.parseInt(sc.nextLine());
        Print.print("请输入新员工的登录名：");
        String passName = sc.nextLine();
        Print.print("请输入新员工的密码：");
        String passWord = sc.nextLine();
        Print.print("请输入新员工的权限：");
        int status = Integer.parseInt(sc.nextLine());

        // 构造新的 Personnel()对象

        Personnel personnel = new Personnel(id, name, tel, sex, job, dept, depId, jobId, passName, passWord, status);

        // 创建 PersonnelDaoImpl实例
        PersonnelDaoImpl personnelDao = new PersonnelDaoImpl();

        // 调用 add() 方法查询员工信息，返回结果保存在 personnelList 中
        personnelDao.insert(personnel);

        // 打印添加成功消息
        Print.print("员工添加成功！");
        PersonnelView.personnelView();
    }

    public static void updatePersonnel() {
        // 读取用户输入的员工id和新信息
        Print.print("请输入要修改的员工id：");
        int id = Integer.parseInt(sc.nextLine());

        Print.print("请输入要修改的部门id：");
        int depId = Integer.parseInt(sc.nextLine());
        Print.print("请输入要修改的职位id：");
        int jobId = Integer.parseInt(sc.nextLine());


        // 构造新的 Personnel 对象
        Personnel personnel = new Personnel(id, depId, jobId);

        // 创建 PersonnelDaoImpl 实例
        PersonnelDaoImpl personnelDao = new PersonnelDaoImpl();

        // 调用 update() 方法更新员工信息
        personnelDao.updateDeptAndJobById(personnel);

        // 打印修改成功消息
        Print.print("员工信息修改成功！");
        PersonnelView.personnelView();
    }

    public static void deletePersonnel() {
        // 询问用户要删除的人员 ID
        Print.print("请输入要删除的人员 ID：");
        int id = Integer.parseInt(sc.nextLine());

        // 构造新的 Personnel 对象
        Personnel personnel = new Personnel();

        // 创建 PersonnelDaoImpl 实例
        PersonnelDaoImpl personnelDao = new PersonnelDaoImpl();

        // 调用 delete() 方法删除人员信息
        personnelDao.deleteById(id);

        // 打印删除成功消息
        Print.print("人员删除成功！");
        PersonnelView.personnelView();
    }

}
