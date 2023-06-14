package com.iweb.controller;

import com.iweb.service.DepartmentService;
import com.iweb.service.JobService;
import com.iweb.util.Print;
import com.iweb.view.DepartmentView;
import com.iweb.view.JobView;
import com.iweb.view.MainView;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 15:54
 */
public class JobController {
   public static void enterJobController(String choose) {
        switch (choose) {
            case "1":
                Print.print("查看员工信息");
                JobService.queryJob();
                break;
            case "2":
                Print.print("添加新员工");
               JobService.addJob();
                break;
            case "3":
                Print.print("修改员工信息");
               JobService.updateJob();
                break;
            case "4":
                Print.print("删除员工信息");
               JobService.deleteJob();
                break;
            case "5":
                //返回上一级
               MainView.loginSuccessView();
        }
    }

}
