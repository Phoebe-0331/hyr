package com.iweb.controller;

import com.iweb.service.DepartmentService;
import com.iweb.util.Print;
import com.iweb.view.DepartmentView;
import com.iweb.view.MainView;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 15:54
 */
public class DepartmentController {
    public static void enterDepartmentController(String choose) {
        switch (choose) {
            case "1":
                Print.print("查看部门信息");
                DepartmentService.queryDepartment();
                break;
            case "2":
                Print.print("添加新部门");
                DepartmentService.addDepartment();
                break;
            case "3":
                Print.print("修改部门信息");
                DepartmentService.updateDepartment();
                break;
            case "4":
                Print.print("删除部门信息");
                DepartmentService.deleteDepartment();
                break;
            case "5":
                //返回上一级
               MainView.loginSuccessView();
        }
    }
}
