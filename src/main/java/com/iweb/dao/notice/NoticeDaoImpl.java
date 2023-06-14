package com.iweb.dao.notice;

import com.iweb.dao.notice.NoticeDao;
import com.iweb.pojo.Notice;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hyr
 * @{Date}: 2023/6/12 13:41
 */
public class NoticeDaoImpl implements NoticeDao {

    @Override
    public void addNotice(Notice notice) {
        String sql = "INSERT INTO notice(title,content,create_date)VALUES (?,?,?)";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, notice.getTitle());
            ps.setString(2, notice.getContent());
            ps.setString(3, notice.getCreateDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteNotice(int id) {
        String sql = "DELETE FROM notice WHERE id = ?";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateNotice(Notice notice) {
        String sql = "UPDATE notice SET title=?, content=?, create_date=? WHERE id=?";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, notice.getTitle());
            ps.setString(2, notice.getContent());
            ps.setString(3, notice.getCreateDate());
            ps.setInt(4, notice.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Notice findNoticeById(int id) {
        String sql = "SELECT * FROM notice WHERE id = ?";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String content = rs.getString("content");
                String createDate = rs.getString("create_date");
                return new Notice(id, title, content, createDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Notice> findNoticesByKeywords(String keywords) {
        String sql = "SELECT * FROM notice WHERE title LIKE ? OR content LIKE ?";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + keywords + "%");
            ps.setString(2, "%" + keywords + "%");
            ResultSet rs = ps.executeQuery();
            List<Notice> noticeList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String createDate = rs.getString("create_date");
                Notice notice = new Notice(id, title, content, createDate);
                noticeList.add(notice);
            }
            return noticeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Notice> findAllNotices() {
        String sql = "SELECT * FROM notice";
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ResultSet rs = ps.executeQuery();
            List<Notice> noticeList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String createDate = rs.getString("create_date");
                Notice notice = new Notice(id, title, content, createDate);
                noticeList.add(notice);
            }
            return noticeList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

