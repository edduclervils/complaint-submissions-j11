package com.revature.complaintsubmissionapplication.service;

import com.revature.complaintsubmissionapplication.entity.Complaint;
import com.revature.complaintsubmissionapplication.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService{
    @Autowired
    ComplaintRepository complaintRepository;
    @Override
    public Complaint insert(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getAll() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint getById(Long complaintId) {
        return complaintRepository.findById(complaintId).get();
    }

    @Override
    public List<Complaint> getByStatus(String status) {
        return complaintRepository.findByStatus(status);
    }

    @Override
    public List<Complaint> getByPriority(String priority) {
        return complaintRepository.findByPriority(priority);
    }

    @Override
    public List<Complaint> getByStatusAndPriority(String status, String priority) {
        return complaintRepository.findByStatusAndPriority(status,priority);
    }

    @Override
    public List<Complaint> getByMeetingId(Long meetingId) {
        return complaintRepository.findByMeetingId(meetingId);
    }

    @Override
    public Complaint update(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public boolean delete(Long complaintId) {
        boolean found = complaintRepository.existsById(complaintId);
        if (found) complaintRepository.deleteById(complaintId);
        return found;
    }
}
