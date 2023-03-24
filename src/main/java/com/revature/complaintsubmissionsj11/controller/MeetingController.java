package com.revature.complaintsubmissionsj11.controller;

import com.revature.complaintsubmissionsj11.dto.MeetingContent;
import com.revature.complaintsubmissionsj11.entity.Meeting;
import com.revature.complaintsubmissionsj11.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetings")
@CrossOrigin
public class MeetingController {
    @Autowired
    MeetingService meetingService;

    @PostMapping()
    public Meeting insert(@RequestBody Meeting meeting){
        return meetingService.insert(meeting);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Meeting> getAll(){
        List<Meeting> fullAllReturn = meetingService.getAll();
        fullAllReturn.removeIf(meeting -> meeting.getMeetingId().equals((long) -1));
        return fullAllReturn;
    }

    @GetMapping("/{meetingId}")
    public Meeting getById(@PathVariable("meetingId") Long meetingId){
        return meetingService.getById(meetingId);
    }

    @GetMapping("/on/{date}")
    public List<Meeting> getByDate(@PathVariable("date") Long date){
        List<Meeting> fullAllReturn = meetingService.getByDate(date);
        fullAllReturn.removeIf(meeting -> meeting.getMeetingId().equals((long) -1));
        return fullAllReturn;
    }

    @GetMapping("/before/{date}")
    public List<Meeting> getBeforeDate(@PathVariable("date") Long date){
        List<Meeting> fullAllReturn = meetingService.getBeforeDate(date);
        fullAllReturn.removeIf(meeting -> meeting.getMeetingId().equals((long) -1));
        return fullAllReturn;
    }

    @GetMapping("/after/{date}")
    public List<Meeting> getAfterDate(@PathVariable("date") Long date){
        List<Meeting> fullAllReturn = meetingService.getAfterDate(date);
        fullAllReturn.removeIf(meeting -> meeting.getMeetingId().equals((long) -1));
        return fullAllReturn;
    }

    @PutMapping("/{meetingId}")
    public Meeting update(@PathVariable("meetingId") Long meetingId, @RequestBody MeetingContent meetingContent){
        Meeting updatedMeeting = new Meeting(meetingId,meetingContent);
        return meetingService.update(updatedMeeting);
    }

    @DeleteMapping("/{meetingId}")
    public boolean delete(@PathVariable("meetingId") Long meetingId){
        return meetingService.delete(meetingId);
    }

}
