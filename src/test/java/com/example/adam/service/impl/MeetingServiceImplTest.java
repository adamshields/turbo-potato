import com.example.adam.dto.Meeting;
import com.example.adam.service.impl.MeetingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class MeetingServiceImplTest {

    private MeetingServiceImpl meetingService;

    @BeforeEach
    void setUp() {
        meetingService = new MeetingServiceImpl();
    }

    @Test
    void testNoOverlap() {
        List<Meeting> meetings = Arrays.asList(
                new Meeting("Morning Standup", LocalTime.of(9, 0), LocalTime.of(9, 30)),
                new Meeting("Team Review", LocalTime.of(14, 0), LocalTime.of(15, 0))
        );

        Duration result = meetingService.calculateTotalMeetingTime(meetings);
        assertEquals(90, result.toMinutes()); // 30 + 60 minutes
    }

    @Test
    void testPartialOverlap() {
        List<Meeting> meetings = Arrays.asList(
                new Meeting("Project Planning", LocalTime.of(9, 0), LocalTime.of(10, 30)), // 90 min
                new Meeting("Design Review", LocalTime.of(10, 0), LocalTime.of(11, 0))     // 60 min, 30 min overlap
        );

        Duration result = meetingService.calculateTotalMeetingTime(meetings);
        // Should be 120 minutes total (90 + 30 non-overlapping), not 150
        assertEquals(120, result.toMinutes());
    }

    @Test
    void testCompleteOverlap() {
        List<Meeting> meetings = Arrays.asList(
                new Meeting("All Hands", LocalTime.of(10, 0), LocalTime.of(11, 0)),
                new Meeting("Department Sync", LocalTime.of(10, 15), LocalTime.of(10, 45)) // Completely inside
        );

        Duration result = meetingService.calculateTotalMeetingTime(meetings);
        assertEquals(60, result.toMinutes()); // Should be 60, not 90
    }

    @Test
    void testAdjacentMeetings() {
        List<Meeting> meetings = Arrays.asList(
                new Meeting("Sprint Planning", LocalTime.of(9, 0), LocalTime.of(10, 0)),
                new Meeting("Retrospective", LocalTime.of(10, 0), LocalTime.of(11, 0)) // Exactly adjacent
        );

        Duration result = meetingService.calculateTotalMeetingTime(meetings);
        assertEquals(120, result.toMinutes()); // 60 + 60 = 120
    }

    @Test
    void testEmptyList() {
        Duration result = meetingService.calculateTotalMeetingTime(List.of());
        assertEquals(0, result.toMinutes());
    }

    // This test will FAIL with current implementation - that's the point!
    @Test
    void testCurrentImplementationFails() {
        List<Meeting> meetings = Arrays.asList(
                new Meeting("Meeting A", LocalTime.of(9, 0), LocalTime.of(10, 30)),  // 90 min
                new Meeting("Meeting B", LocalTime.of(10, 0), LocalTime.of(11, 0))   // 60 min, 30 overlap
        );

        Duration result = meetingService.calculateTotalMeetingTime(meetings);

        // Current implementation will return 150 minutes (wrong)
        // Correct answer should be 120 minutes
        assertNotEquals(150, result.toMinutes(), "Current implementation incorrectly sums all meetings");
    }
}