package com.revature.complaintsubmissionapplication.repository;

import com.revature.complaintsubmissionapplication.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {

    @Query(value = "SELECT * FROM meetings WHERE time>=:beginTimeRange and time<:endTimeRange", nativeQuery = true)
    List<Meeting> findMeetingsThisDay(@Param("beginTimeRange") Long beginTimeRange, @Param("endTimeRange") Long endTimeRange);

    @Query(value = "SELECT * FROM meetings WHERE time<=:timeRange", nativeQuery = true)
    List<Meeting> findMeetingsBeforeDate(@Param("timeRange") Long timeRange);

    @Query(value = "SELECT * FROM meetings WHERE time>:timeRange", nativeQuery = true)
    List<Meeting> findMeetingsAfterDate(@Param("timeRange") Long timeRange);
}
