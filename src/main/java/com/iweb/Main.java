package com.iweb;

import com.iweb.pojo.Personnel;
import com.iweb.view.MainView;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 16:21
 */
public class Main {
    //用来保存当前所登录用户的Personnel对象的引用
    public static Personnel currentPersonnel = null;

    public static void main(String[] args) {
        MainView.mainView();

    }
}
