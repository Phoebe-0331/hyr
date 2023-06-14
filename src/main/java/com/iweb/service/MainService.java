package com.iweb.service;

import com.iweb.pojo.Personnel;
import com.iweb.util.Data;

import java.util.List;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 17:21
 */
public class MainService {
    public static boolean login(Personnel inputPersonnel) {
        boolean isLogin = false;
        List<Personnel> personnelList = Data.getPersonnel();
        for (Personnel personnel : personnelList) {
            if (personnel.getPassName().equals(inputPersonnel.getPassName())
                    && personnel.getPassWord().equals(inputPersonnel.getPassWord())) {
                isLogin = true;
            }
        }
        return isLogin;
    }
}
