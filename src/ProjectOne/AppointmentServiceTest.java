package ProjectOne;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("ID123", futureDate, "Test appointment");

        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("ID123"));
    }

    @Test
    public void testAddAppointmentDuplicateId() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment1 = new Appointment("ID123", futureDate, "Test appointment 1");
        Appointment appointment2 = new Appointment("ID123", futureDate, "Test appointment 2");

        appointmentService.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(appointment2));
    }

    @Test
    public void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("ID123", futureDate, "Test appointment");

        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("ID123");
        assertNull(appointmentService.getAppointment("ID123"));
    }

    @Test
    public void testDeleteAppointmentNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("NonExistentID"));
    }

    @Test
    public void testGetAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("ID123", futureDate, "Test appointment");

        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("ID123"));
    }
}
