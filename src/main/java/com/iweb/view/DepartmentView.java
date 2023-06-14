package com.iweb.view;

import com.iweb.controller.DepartmentController;
import com.iweb.controller.MainController;
import com.iweb.util.Print;

import java.util.Scanner;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 16:13
 */
public class DepartmentView {
    private static Scanner sc = new Scanner(System.in);

    public static void departmentView() {
        // 显示操作选项
        Print.print("请选择您要进行的操作：");
        Print.print("1. 查看部门信息");
        Print.print("2. 添加新部门");
        Print.print("3. 修改部门信息");
        Print.print("4. 删除部门信息");
        Print.print("5. 返回上一级菜单");
        String choose = sc.nextLine();
        DepartmentController.enterDepartmentController(choose);
    }

}
