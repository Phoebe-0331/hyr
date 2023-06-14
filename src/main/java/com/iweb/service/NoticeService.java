package com.iweb.service;

import com.iweb.dao.notice.NoticeDaoImpl;
import com.iweb.pojo.Notice;
import com.iweb.util.Print;
import com.iweb.view.NoticeView;

import java.util.List;
import java.util.Scanner;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 15:51
 */
public class NoticeService {
    private static Scanner sc = new Scanner(System.in);

    public static void queryNotice() {
        // 询问用户要查询的通知标题
        Print.print("请输入要查询的通知标题");
        String title = sc.nextLine();

        // 构造新的 Notice 对象
        Notice notice = new Notice();

        // 创建 NoticeDaoImpl 实例
        NoticeDaoImpl noticeDao = new NoticeDaoImpl();

        // 调用 query() 方法查询通知信息，返回结果保存在 noticeList 中
        List<Notice> noticeList = noticeDao.findAllNotices();

        // 判断查询结果是否为空并输出
        if (noticeList != null && noticeList.size() > 0) {
            for (Notice notice1 : noticeList) {
                System.out.println(notice);
            }
        } else {
            Print.print("没有匹配的结果");
        }
        NoticeView.noticeView();
    }

    public static void addNotice() {
        // 读取用户输入的新通知相关信息
        Print.print("请输入新通知标题：");
        String title = sc.nextLine();
        Print.print("请输入新通知内容：");
        String content = sc.nextLine();

        // 构造新的 Notice 对象
        Notice notice = new Notice();

        // 创建 NoticeDaoImpl 实例
        NoticeDaoImpl noticeDao = new NoticeDaoImpl();

        // 调用 add() 方法查询通知信息，返回结果保存在 noticeList 中
        noticeDao.addNotice(notice);

        // 打印添加成功消息
        Print.print("Notice添加成功！");
        NoticeView.noticeView();
    }

    public static void updateNotice() {
        // 询问用户要修改的通知 ID
        Print.print("请输入要修改的通知 ID：");
        int id = Integer.parseInt(sc.nextLine());

        // 读取用户输入的新通知信息
        Print.print("请输入新的通知标题：");
        String title = sc.nextLine();
        Print.print("请输入新的通知内容：");
        String content = sc.nextLine();

        // 构造新的 Notice 对象
        Notice notice = new Notice();

        // 创建 NoticeDaoImpl 实例
        NoticeDaoImpl noticeDao = new NoticeDaoImpl();

        // 调用 update() 方法更新通知信息
        noticeDao.updateNotice(notice);

        // 打印添加成功消息
        Print.print("Notice修改成功！");
        NoticeView.noticeView();
    }

    public static void deleteNotice(){
        // 询问用户要删除的通知 ID
        Print.print("请输入要删除的通知 ID：");
        int id = Integer.parseInt(sc.nextLine());

        // 构造新的 Notice 对象
        Notice notice = new Notice();

        // 创建 NoticeDaoImpl 实例
        NoticeDaoImpl noticeDao = new NoticeDaoImpl();

        // 调用 delete() 方法删除通知信息
        noticeDao.deleteNotice(id);

        // 打印删除成功消息
        Print.print("Notice删除成功！");
        NoticeView.noticeView();
    }
}
