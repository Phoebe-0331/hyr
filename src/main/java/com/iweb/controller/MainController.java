package com.iweb.controller;

import com.iweb.util.Print;
import com.iweb.view.MainView;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 16:12
 */
public class MainController {
    public static void mainController(String choose) {
        //根据choose的值 决定后续的跳转页面
        switch (choose) {
            case "1":
                MainView.loginView();
                break;
            case "2":
                MainView.registerView();
                break;
            case "3":
                System.out.println("即将退出");
                break;
            default:
                Print.print("输入有误，请重新输入！");
                break;
        }
    }
}

