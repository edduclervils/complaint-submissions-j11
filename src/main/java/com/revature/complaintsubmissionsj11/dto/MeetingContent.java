package com.revature.complaintsubmissionsj11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class MeetingContent {
    private String address;
    private Long time;
    private String summary;
}
