package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 12:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personnel {
    private int id;         // 员工ID
    private String name;    // 姓名
    private String tel;     // 电话号码
    private String sex;     // 性别
    private String job;     // 工作岗位
    private String dept;    // 所属部门
    private int dept_id;    // 部门ID
    private int job_id;     // 工作ID
    private String passName;// 用户名
    private String passWord;// 密码
    private int status;     // 账号状态 ：0-普通用户，1-管理员

    public Personnel(int i, int depId, int jobId) {
    }
}
