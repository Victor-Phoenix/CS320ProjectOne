package ProjectOne;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class AppointmentTest {
    @Test
    public void testAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("ID123", futureDate, "Test appointment");

        assertEquals("ID123", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Test appointment", appointment.getDescription());
    }

    @Test
    public void testAppointmentCreationInvalidId() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "Valid description"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("ID12345678901", futureDate, "Valid description"));
    }

    @Test
    public void testAppointmentCreationInvalidDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 1 day in the past
        assertThrows(IllegalArgumentException.class, () -> new Appointment("ID123", pastDate, "Valid description"));
    }

    @Test
    public void testAppointmentCreationInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        assertThrows(IllegalArgumentException.class, () -> new Appointment("ID123", futureDate, null));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("ID123", futureDate, "A".repeat(51)));
    }
}
