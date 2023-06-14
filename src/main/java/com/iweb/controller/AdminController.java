package com.iweb.controller;

import com.iweb.util.Print;
import com.iweb.view.*;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 23:34
 */
public class AdminController {
    public static void loginSuccessController(String choose) {
        switch (choose) {
            case "1":
                Print.print("即将跳转到部门表...");
                DepartmentView.departmentView();
                break;
            case "2":
                Print.print("即将跳转到职位表...");
                JobView.jobView();
                break;
            case "3":
                Print.print("即将跳转到公告表...");
                NoticeView.noticeView();
                break;
            case "4":
                Print.print("即将跳转到员工表...");
                PersonnelView.personnelView();
                break;
            case "5":
                //返回上一级
                MainView.loginView();
        }
    }
}
