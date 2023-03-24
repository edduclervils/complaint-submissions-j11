package com.revature.complaintsubmissionapplication.service;

import com.revature.complaintsubmissionapplication.entity.Meeting;

import java.util.List;

public interface MeetingService {
    Meeting insert(Meeting meeting);
    List<Meeting> getAll();
    Meeting getById(Long meetingId);
    List<Meeting> getByDate(Long beginTimeRange);
    List<Meeting> getBeforeDate(Long currentTime);
    List<Meeting> getAfterDate(Long currentTime);
    Meeting update(Meeting meeting);
    boolean delete(Long meetingId);
}
