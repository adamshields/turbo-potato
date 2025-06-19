package com.example.adam.service;

import com.example.adam.dto.Meeting;
import java.time.Duration;
import java.util.List;

public interface MeetingService {

    /**
     * INTERVIEW CHALLENGE:
     *
     * Calculate the total meeting time for a day, accounting for overlapping meetings.
     *
     * Example:
     * - Meeting 1: 09:00-10:30 (90 minutes)
     * - Meeting 2: 10:00-11:00 (60 minutes, overlaps 30 minutes with Meeting 1)
     * - Meeting 3: 14:00-15:30 (90 minutes)
     *
     * Total time should be: 90 + 30 + 90 = 210 minutes (not 240)
     *
     * Edge cases to consider:
     * - Empty list
     * - Single meeting
     * - Completely overlapping meetings
     * - Adjacent meetings (10:30-11:00)
     * - Invalid time ranges (end before start)
     *
     * @param meetings List of meetings for the day
     * @return Total duration of all meetings (accounting for overlaps)
     */
    Duration calculateTotalMeetingTime(List<Meeting> meetings);

    /**
     * BONUS CHALLENGE:
     * Find all conflicting meetings (meetings that overlap in time)
     *
     * @param meetings List of meetings
     * @return List of conflict descriptions
     */
    List<String> findConflicts(List<Meeting> meetings);
}
