package com.iweb.service;

import com.iweb.dao.department.DepartmentDaoImpl;
import com.iweb.dao.job.JobDaoImpl;
import com.iweb.pojo.Department;
import com.iweb.pojo.Job;
import com.iweb.util.Print;
import com.iweb.view.JobView;

import java.util.List;
import java.util.Scanner;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 15:51
 */
public class JobService {
    private static Scanner sc = new Scanner(System.in);

    public static void queryJob() {
        // 询问用户要查询的职位名称
        Print.print("请输入要查询的职位名称");
        String name = sc.nextLine();

        // 创建 JobDaoImpl 实例
        JobDaoImpl jobDao = new JobDaoImpl();

        // 调用 query() 方法查询职位信息，返回结果保存在 jobList 中
        List<Job> jobList = jobDao.listByName(name);

        // 判断查询结果是否为空并输出
        if (jobList != null && jobList.size() > 0) {
            for (Job job : jobList) {
                System.out.println(job);
            }
        } else {
            Print.print("没有匹配的结果");
        }
        JobView.jobView();
    }

    public static void addJob() {
        // 读取用户输入的新职位相关信息
        Print.print("请输入新职位id：");
        int id = Integer.parseInt(sc.nextLine());
        Print.print("请输入新职位名称：");
        String name = sc.nextLine();

        // 构造新的 Job 对象
        Job job = new Job(id, name);

        // 创建 JobDaoImpl 实例
        JobDaoImpl jobDao = new JobDaoImpl();

        // 调用 add() 方法查询职位信息，返回结果保存在 jobList 中
        jobDao.insert(job);

        // 打印添加成功消息
        Print.print("职位添加成功！");
        JobView.jobView();
    }

    public static void updateJob() {
        // 询问用户要修改的职位 ID
        Print.print("请输入要修改的职位 ID：");
        int id = Integer.parseInt(sc.nextLine());

        // 读取用户输入的新职位信息
        Print.print("请输入新的职位名称：");
        String name = sc.nextLine();

        // 构造新的 Job 对象
        Job job = new Job(id, name);

        // 创建 JobDaoImpl 实例
        JobDaoImpl jobDao = new JobDaoImpl();

        // 调用 update() 方法更新职位信息
        jobDao.update(job);

        // 打印添加成功消息
        Print.print("职位修改成功！");
        JobView.jobView();
    }

    public static void deleteJob() {
        // 询问用户要删除的职位 ID
        Print.print("请输入要删除的职位 ID：");
        int id = Integer.parseInt(sc.nextLine());

        // 构造新的 Job 对象
        Job job = new Job();

        // 创建 JobDaoImpl 实例
        JobDaoImpl jobDao = new JobDaoImpl();

        // 调用 delete() 方法删除职位信息
        jobDao.deleteById(id);

        // 打印删除成功消息
        Print.print("职位删除成功！");
        JobView.jobView();
    }
}
