package com.tuomi.develop.service;

import com.tuomi.develop.entity.Notice;

import java.util.List;

public interface NoticeService {

    int insertSelective(Notice record);

    List<String> selectNoticeTime(Integer userId);

    List<Notice> selectByReplyTime(String replyTime);

    List<Notice> selectByTimeAndUserId(String replyTime , Integer userId);

    int updateByPrimaryKeySelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    Integer selectMaxId();

    Notice selectByManualId(Integer manualId);

    int deleteByManualId(Integer manualId);

}
