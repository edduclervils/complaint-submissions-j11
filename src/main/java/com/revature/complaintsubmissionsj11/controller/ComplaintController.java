package com.revature.complaintsubmissionsj11.controller;

import com.revature.complaintsubmissionsj11.dto.ComplaintContent;
import com.revature.complaintsubmissionsj11.entity.Complaint;
import com.revature.complaintsubmissionsj11.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
@CrossOrigin
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    @PostMapping()
    public ResponseEntity<Complaint> insert(@RequestBody Complaint complaint){
        return  new ResponseEntity<>(complaintService.insert(complaint), HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Complaint> getAll(@RequestParam(required = false, value = "status") String status, @RequestParam(required = false, value = "priority") String priority){
        if(status == null && priority == null){
            return complaintService.getAll();
        } else if (status != null && priority == null){
            return complaintService.getByStatus(status);
        } else if (status == null && priority != null) {
            return complaintService.getByPriority(priority);
        } else {
            return complaintService.getByStatusAndPriority(status,priority);
        }
    }

    @GetMapping("/{complaintId}")
    public Complaint getById(@PathVariable("complaintId") Long complaintId){
        return complaintService.getById(complaintId);
    }

    @GetMapping("/meeting/{meetingId}")
    public List<Complaint> getByMeetingId(@PathVariable("meetingId") Long meetingId){
        return complaintService.getByMeetingId(meetingId);
    }

    @PutMapping("/{complaintId}")
    public Complaint update(@PathVariable("complaintId") Long complaintId, @RequestBody ComplaintContent complaintContent){
        Complaint updatedComplaint = new Complaint(complaintId, complaintContent);
        return complaintService.update(updatedComplaint);
    }

    @DeleteMapping("/{complaintId}")
    public boolean delete(@PathVariable("complaintId") Long complaintId){
        return complaintService.delete(complaintId);
    }
}
