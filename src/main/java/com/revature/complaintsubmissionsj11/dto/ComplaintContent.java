package com.revature.complaintsubmissionsj11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class ComplaintContent {
    private  String description;
    private String status;
    private String priority;
    private Long meetingId;
}
