package ProjectOne;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private final List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
        for (Appointment existing : appointments) {
            if (existing.getAppointmentId().equals(appointment.getAppointmentId())) {
                throw new IllegalArgumentException("Appointment with this ID already exists");
            }
        }
        appointments.add(appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        Appointment toRemove = null;
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                toRemove = appointment;
                break;
            }
        }
        if (toRemove != null) {
            appointments.remove(toRemove);
        } else {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }
    }

    public Appointment getAppointment(String appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                return appointment;
            }
        }
        return null;
    }
}
