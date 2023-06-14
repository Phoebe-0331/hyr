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
public class Notice {
    private int id;
    private String title;
    private String content;
    private String createDate;
}
