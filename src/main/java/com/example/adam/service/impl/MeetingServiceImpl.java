package com.example.adam.service.impl;

import com.example.adam.dto.Meeting;
import com.example.adam.service.MeetingService;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.List;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Override
    public Duration calculateTotalMeetingTime(List<Meeting> meetings) {
        // TODO: Implement this method
        // Current implementation just sums all meetings (WRONG - doesn't handle overlaps)

        return meetings.stream()
                .mapToLong(meeting -> Duration.between(meeting.getStartTime(), meeting.getEndTime()).toMinutes())
                .mapToObj(Duration::ofMinutes)
                .reduce(Duration.ZERO, Duration::plus);
    }

    @Override
    public List<String> findConflicts(List<Meeting> meetings) {
        // TODO: Implement this method
        return List.of("Not implemented yet");
    }
}
