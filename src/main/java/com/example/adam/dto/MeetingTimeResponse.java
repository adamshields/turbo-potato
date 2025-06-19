package com.example.adam.dto;

public class MeetingTimeResponse {
    private long totalMinutes;
    private long totalHours;
    private int meetingCount;

    // Getters and setters
    public long getTotalMinutes() { return totalMinutes; }
    public void setTotalMinutes(long totalMinutes) { this.totalMinutes = totalMinutes; }

    public long getTotalHours() { return totalHours; }
    public void setTotalHours(long totalHours) { this.totalHours = totalHours; }

    public int getMeetingCount() { return meetingCount; }
    public void setMeetingCount(int meetingCount) { this.meetingCount = meetingCount; }
}
