package com.iweb.view;

import com.iweb.Main;
import com.iweb.controller.AdminController;
import com.iweb.controller.MainController;
import com.iweb.pojo.Personnel;
import com.iweb.service.MainService;
import com.iweb.service.PersonnelService;
import com.iweb.util.Print;
import com.iweb.util.StringUtil;

import java.util.Scanner;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 15:35
 */
public class MainView {
    private static Scanner sc = new Scanner(System.in);

    public static void mainView() {
        Print.print("欢迎进入人事管理系统！");
        Print.print("请选择您要进行的操作：");
        Print.print("1. 登录");
        Print.print("2. 注册");
        Print.print("3. 退出");
        String choose = sc.nextLine();
        MainController.mainController(choose);
    }

    public static void loginView() {
        Print.print("请输入你登录的用户名:");
        String inputPassName = sc.nextLine();
        Print.print("请输入您的密码:");
        String inputPassWord = sc.nextLine();
        //将获取的输入信息封装成对象
        Personnel inputPersonnel = new Personnel();
        inputPersonnel.setPassName(inputPassName);
        inputPersonnel.setPassWord(inputPassWord);
        //获取验证码:如果发现验证码不对 则直接重新登录
        String confirmCode = StringUtil.getRandomStr();
        Print.print("验证码为:" + confirmCode + "，请输入验证码进行验证，验证码不区分大小写");
        String inputConfirmCode = sc.nextLine();
        if (confirmCode.equalsIgnoreCase(inputConfirmCode)) {
            //如果发现验证码验证通过,则进行验证 在进入到后续流程
            Print.print("验证码通过，正在验证用户名和密码，请稍后...");
            //视图层应该将上面的inputUser传递给业务方法 根据业务方法判断用户是否登录成功
            boolean isLogin = MainService.login(inputPersonnel);
            //如果登录成功,则跳转到下一级页面
            if (isLogin) {
                //跳转到下一级页面
                loginSuccessView();
            } else {
                //否则 重新访问登录页面
                loginView();
            }

        } else {
            //直接要求用户重新输入用户名 密码 新的验证码
            Print.print("验证码输入有误，请重新输入!");
            loginView();
        }
    }

    public static void loginSuccessView() {
            Print.print("欢迎进入管理员界面！");
            Print.print("请选择您要进行的操作：");
            Print.print("1. 管理部门表");
            Print.print("2. 管理职位表");
            Print.print("3. 管理公告表");
            Print.print("4. 管理员工表");
            Print.print("5. 返回上一级");
            //将输入的数据交给下一层Controller处理
            String choose = sc.nextLine();
            AdminController.loginSuccessController(choose);
    }

    public static void registerView() {
        PersonnelService.addPersonnel();
    }

}
