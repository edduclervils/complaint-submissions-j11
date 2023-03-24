package com.revature.complaintsubmissionapplication.entity;

import com.revature.complaintsubmissionapplication.dto.MeetingContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data@NoArgsConstructor@AllArgsConstructor@Entity@Table(name = "meetings")
public class Meeting extends MeetingContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;
    private String address;
    private Long time;
    private String summary;

    public Meeting(String address, Long time, String summary){
        this.address = address;
        this.time = time;
        this.summary = summary;

    }

    public Meeting(Long meetingId, MeetingContent meetingContent){
        this.meetingId = meetingId;
        this.address = meetingContent.getAddress();
        this.time = meetingContent.getTime();
        this.summary = meetingContent.getSummary();
    }


}
