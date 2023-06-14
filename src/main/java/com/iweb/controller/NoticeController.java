package com.iweb.controller;

import com.iweb.service.DepartmentService;
import com.iweb.service.NoticeService;
import com.iweb.util.Print;
import com.iweb.view.MainView;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 15:54
 */
public class NoticeController {
    public static void enterNoticeController(String choose) {
        switch (choose) {
            case "1":
                Print.print("查看通知信息");
                NoticeService.queryNotice();
                break;
            case "2":
                Print.print("添加新通知");
                NoticeService.addNotice();
                break;
            case "3":
                Print.print("修改通知信息");
                NoticeService.updateNotice();
                break;
            case "4":
                Print.print("删除通知信息");
                NoticeService.deleteNotice();
                break;
            case "5":
                //返回上一级
                MainView.loginSuccessView();
        }
    }
}
