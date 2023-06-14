package com.iweb.dao.notice;

import com.iweb.pojo.Notice;

import java.util.List;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 12:37
 */
public interface NoticeDao {
    /**
     * 添加公告
     *
     * @param notice 公告对象
     */
    void addNotice(Notice notice);

    /**
     * 删除公告
     *
     * @param id 公告id
     */
    void deleteNotice(int id);

    /**
     * 更新公告
     *
     * @param notice 公告对象
     */
    void updateNotice(Notice notice);

    /**
     * 根据id查找公告
     *
     * @param id 公告id
     * @return 查询到的公告对象
     */
    Notice findNoticeById(int id);

    /**
     * 根据标题或者内容模糊查询公告
     *
     * @param keywords 查询关键字
     * @return 查询到的公告对象集合
     */
    List<Notice> findNoticesByKeywords(String keywords);

    /**
     * 获取所有公告
     *
     * @return 所有公告对象的集合
     */
    List<Notice> findAllNotices();
}

