package com.example.adam.controller;


import com.example.adam.dto.Meeting;
import com.example.adam.dto.MeetingTimeResponse;
import com.example.adam.service.MeetingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/api/meetings")
@Tag(name = "Meeting Scheduler", description = "Meeting room scheduling and analytics")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @PostMapping("/total-time")
    @Operation(summary = "Calculate total meeting time",
            description = "Calculates total meeting duration accounting for overlapping meetings")
    public ResponseEntity<MeetingTimeResponse> calculateTotalMeetingTime(
            @Valid @RequestBody List<Meeting> meetings) {

        Duration totalTime = meetingService.calculateTotalMeetingTime(meetings);

        MeetingTimeResponse response = new MeetingTimeResponse();
        response.setTotalMinutes(totalTime.toMinutes());
        response.setTotalHours(totalTime.toHours());
        response.setMeetingCount(meetings.size());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/conflicts")
    @Operation(summary = "Find conflicting meetings",
            description = "Identifies meetings that overlap in time")
    public ResponseEntity<List<String>> findConflicts(@Valid @RequestBody List<Meeting> meetings) {
        List<String> conflicts = meetingService.findConflicts(meetings);
        return ResponseEntity.ok(conflicts);
    }
}
