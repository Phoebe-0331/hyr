package com.iweb.controller;

import com.iweb.dao.personnel.PersonnelDaoImpl;
import com.iweb.pojo.Personnel;
import com.iweb.service.DepartmentService;
import com.iweb.service.PersonnelService;
import com.iweb.util.Print;
import com.iweb.view.DepartmentView;
import com.iweb.view.MainView;
import com.iweb.view.PersonnelView;

import java.util.List;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 15:55
 */
public class PersonnelController {
    public static void enterPersonnelController(String choose) {
        switch (choose) {
            case "1":
                Print.print("查看员工信息");
                PersonnelService.queryPersonnel();
                break;
            case "2":
                Print.print("添加新员工");
                PersonnelService.addPersonnel();
                break;
            case "3":
                Print.print("修改部门信息");
                PersonnelService.updatePersonnel();
                break;
            case "4":
                Print.print("删除部门信息");
                PersonnelService.deletePersonnel();
                break;
            case "5":
                //返回上一级
                MainView.loginSuccessView();
        }
    }

}
