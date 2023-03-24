package com.revature.complaintsubmissionsj11.service;

import com.revature.complaintsubmissionsj11.entity.Complaint;

import java.util.List;

public interface ComplaintService {
    Complaint insert(Complaint complaint);
    List<Complaint> getAll();
    Complaint getById(Long complaintId);
    List<Complaint> getByStatus(String status);
    List<Complaint> getByPriority(String priority);
    List<Complaint> getByStatusAndPriority(String status, String priority);
    List<Complaint> getByMeetingId(Long meetingId);
    Complaint update(Complaint complaint);
    boolean delete(Long complaintId);
}
