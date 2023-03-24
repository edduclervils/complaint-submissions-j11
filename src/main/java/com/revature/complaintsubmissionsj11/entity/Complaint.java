package com.revature.complaintsubmissionsj11.entity;

import com.revature.complaintsubmissionsj11.dto.ComplaintContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data@NoArgsConstructor@AllArgsConstructor@Entity@Table(name = "complaints")
public class Complaint extends ComplaintContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaintId;
    private  String description;
    private String status;
    private String priority;
    private Long meetingId;

    public Complaint(String description, String status, String priority, Long meetingId ){
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.meetingId = meetingId;
    }

    public Complaint(Long complaintId, ComplaintContent complaintContent){
        this.complaintId = complaintId;
        this.description = complaintContent.getDescription();
        this.status = complaintContent.getStatus();
        this.priority = complaintContent.getPriority();
        this.meetingId = complaintContent.getMeetingId();
    }
}
