# Meeting Scheduler Challenge

## Background
You're working on a meeting analytics feature for a corporate scheduling system. The business team wants to know the **total actual meeting time** for employees each day to understand workload and optimize schedules.

## The Problem
The current implementation in `MeetingServiceImpl.calculateTotalMeetingTime()` is **fundamentally broken**. It simply sums all meeting durations, but this **double-counts time** when meetings overlap.

### Real-world scenario:
- **9:00-10:30**: Project Planning (90 minutes)
- **10:00-11:00**: Design Review (60 minutes)
- **14:00-15:30**: Team Retrospective (90 minutes)

**Current broken result**: 240 minutes (4 hours)  
**Correct result**: 210 minutes (3.5 hours)

The 30-minute overlap between Project Planning and Design Review should only be counted once.

## Your Task
Fix the `calculateTotalMeetingTime` method to correctly calculate total meeting time, accounting for overlapping meetings.

## Requirements

### Functional Requirements
1. **Handle overlapping meetings correctly** - don't double-count time
2. **Handle adjacent meetings** (10:30-11:00 followed by 11:00-12:00) - should count as 90 minutes total
3. **Handle completely nested meetings** - if one meeting is entirely within another, only count the outer meeting time
4. **Handle empty input** - return Duration.ZERO for empty meeting lists

### Edge Cases to Consider
- Empty meeting list
- Single meeting
- Multiple meetings with no overlaps
- Meetings with partial overlaps
- Meetings completely contained within other meetings
- Adjacent meetings (touching but not overlapping)
- Meetings in random order (not sorted by time)
- Invalid meetings (end time before start time) - assume input is always valid

### Performance Requirements
- Must handle up to 1000 meetings efficiently
- Time complexity should be O(n log n) or better
- Space complexity should be reasonable

## Validation
1. **Run the tests**: `./mvnw test` - all tests in `MeetingServiceImplTest` must pass
2. **Test via API**: Use Swagger UI at `/swagger` to test the `/api/meetings/total-time` endpoint
3. **Verify edge cases**: Make sure your solution handles all the edge cases listed above

## Test Data for Manual Verification

### Case 1: Partial Overlap
```json
[
  {"title": "Project Planning", "startTime": "09:00", "endTime": "10:30"},
  {"title": "Design Review", "startTime": "10:00", "endTime": "11:00"}
]
```
**Expected**: 120 minutes (not 150)

### Case 2: Complete Overlap
```json
[
  {"title": "All Hands", "startTime": "10:00", "endTime": "11:00"},
  {"title": "Department Sync", "startTime": "10:15", "endTime": "10:45"}
]
```
**Expected**: 60 minutes (not 90)

### Case 3: Multiple Overlaps
```json
[
  {"title": "Meeting A", "startTime": "09:00", "endTime": "10:00"},
  {"title": "Meeting B", "startTime": "09:30", "endTime": "10:30"},
  {"title": "Meeting C", "startTime": "10:15", "endTime": "11:15"},
  {"title": "Meeting D", "startTime": "14:00", "endTime": "15:00"}
]
```
**Expected**: 135 minutes

## Success Criteria
- [ ] All unit tests pass
- [ ] API returns correct results for test cases above
- [ ] Solution handles all edge cases
- [ ] Code is clean and readable
- [ ] Time complexity is O(n log n) or better

## Time Limit
**30 minutes maximum**

## Hints (only if completely stuck)
<details>
<summary>Click only if you need a hint</summary>

Think about this as a classic "merge intervals" problem:
1. Convert meetings to time intervals
2. Sort intervals by start time
3. Merge overlapping intervals
4. Sum the merged intervals

</details>

---

**Good luck! This is a real-world problem that tests algorithmic thinking, attention to detail, and ability to handle edge cases.**