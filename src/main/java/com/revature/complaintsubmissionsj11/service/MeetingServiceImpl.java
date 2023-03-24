package com.revature.complaintsubmissionsj11.service;

import com.revature.complaintsubmissionsj11.entity.Meeting;
import com.revature.complaintsubmissionsj11.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    MeetingRepository meetingRepository;
    @Override
    public Meeting insert(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public List<Meeting> getAll() {
        return meetingRepository.findAll();
    }

    @Override
    public Meeting getById(Long meetingId) {
        return meetingRepository.findById(meetingId).get();
    }

    @Override
    public List<Meeting> getByDate(Long beginTimeRange) {
        return meetingRepository.findMeetingsThisDay(beginTimeRange,beginTimeRange+86400);
    }

    @Override
    public List<Meeting> getBeforeDate(Long currentTime) {
        return meetingRepository.findMeetingsBeforeDate(currentTime);
    }

    @Override
    public List<Meeting> getAfterDate(Long currentTime) {
        return meetingRepository.findMeetingsAfterDate(currentTime);
    }

    @Override
    public Meeting update(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public boolean delete(Long meetingId) {
        boolean found = meetingRepository.existsById(meetingId);
        if (found) meetingRepository.deleteById(meetingId);
        return found;
    }

}
