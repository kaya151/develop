package com.tuomi.develop.dao;

import com.tuomi.develop.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
    
    List<String> selectNoticeTime(Integer userId);

    List<Notice> selectByReplyTime(String replyTime);

    List<Notice> selectByTimeAndUserId(@Param("replyTime") String replyTime , @Param("userId") Integer userId);

    Integer selectMaxId();

    Notice selectByManualId(Integer manualId);

    int deleteByManualId(Integer manualId);
}