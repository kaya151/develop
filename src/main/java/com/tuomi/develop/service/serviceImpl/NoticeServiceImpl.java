package com.tuomi.develop.service.serviceImpl;

import com.tuomi.develop.dao.NoticeMapper;
import com.tuomi.develop.entity.Notice;
import com.tuomi.develop.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @version: V1.0
 * @description: 消息类
 * @date 2019/6/25 11:15
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public int insertSelective(Notice record) {
        int i = noticeMapper.insertSelective(record);
        return i;
    }

    @Override
    public List<String> selectNoticeTime(Integer userId) {
        List<String> NoticeTime = noticeMapper.selectNoticeTime(userId);
        return NoticeTime;
    }

    @Override
    public List<Notice> selectByReplyTime(String replyTime) {
        List<Notice> notices = noticeMapper.selectByReplyTime(replyTime);
        return notices;
    }

    @Override
    public List<Notice> selectByTimeAndUserId(String replyTime, Integer userId) {
        List<Notice> notices = noticeMapper.selectByTimeAndUserId(replyTime, userId);
        return notices;
    }

    @Override
    public int updateByPrimaryKeySelective(Notice record) {
        int i = noticeMapper.updateByPrimaryKeySelective(record);
        return i;
    }

    @Override
    public Notice selectByPrimaryKey(Integer id) {
        Notice notice = noticeMapper.selectByPrimaryKey(id);
        return notice;
    }

    @Override
    public Integer selectMaxId() {
        Integer id = noticeMapper.selectMaxId();
        return id;
    }

    @Override
    public Notice selectByManualId(Integer manualId) {
        Notice notice = noticeMapper.selectByManualId(manualId);
        return notice;
    }

    @Override
    public int deleteByManualId(Integer manualId) {
        int i = noticeMapper.deleteByManualId(manualId);
        return i;
    }
}
