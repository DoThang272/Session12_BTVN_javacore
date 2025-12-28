package ex2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Appointment {
    private String appointmentID;
    private String patientName;
    private String phoneNumber;
    private String appointmentDate;
    private String doctor;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Appointment() {
    }

    public Appointment(String appointmentID, String patientName, String phoneNumber, String appointmentDate, String doctor) {
        this.appointmentID = appointmentID;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void inputData(Scanner sc) {
        this.appointmentID = inputAppointmentId(sc);
        this.patientName = inputPatientName(sc);
        this.phoneNumber = inputPhoneNumber(sc);
        this.appointmentDate = inputDate(sc);
        this.doctor = inputDoctor(sc);
    }

    @Override
    public String toString() {
        return "Appointment ID: " + this.appointmentID + " | Patient Name: " + this.patientName + " | Phone number: " + this.phoneNumber
                + "\n | appointment date: " + this.appointmentDate + " | Name of doctor: " + this.doctor;
    }

    public String inputAppointmentId(Scanner sc) {
        System.out.print("Enter the appointment id: ");
        do {
            String reg = ".{6}";
            String appointmentID = sc.nextLine();
            if (Pattern.matches(reg, appointmentID)) {
                boolean isExit = false;
                for (int i = 0; i < AppointmentBusiness.currentIndex; i++) {
                    if (AppointmentBusiness.appointments[i].appointmentID.equals(appointmentID)) {
                        isExit = true;
                        break;
                    }
                }
                if (!isExit) {
                    return appointmentID;
                }
                System.err.println("This id is already exist!");
            } else {
                System.err.println("The id of appointment have 6 character!");
            }
        } while (true);
    }

    public String inputPatientName(Scanner sc) {
        System.out.print("Input the patient name: ");
        do {
            String patientName = sc.nextLine();
            String regexName = ".{10,50}";

            if (Pattern.matches(regexName, patientName)) {
                return patientName;
            } else {
                System.err.println("Name must have from 10-50 character!");
            }
        } while (true);
    }

    public String inputPhoneNumber(Scanner sc) {
        System.out.println("Enter the phone patient: ");
        do {
            String regexPhone = "(032|033|034|035|036|037|038|039|086|096|097|098)\\d{7}";
            String phoneNum = sc.nextLine();

            if (Pattern.matches(regexPhone, phoneNum)) {
                return phoneNum;
            } else {
                System.err.println("The phone number must start with a Vietnam network prefix and consist of 11 digits!");
            }
        } while (true);
    }

    public String inputDate(Scanner sc) {
        System.out.print("Input the appointment date(dd/MM/yyyy): ");
        do {
            String appointDate = sc.nextLine();
            try {
                LocalDate date = LocalDate.parse(appointDate, formatter);
                return appointDate;
            } catch (DateTimeParseException e) {
                System.out.println("Error exception, please re-enter date. Example: 31/12/1999");
            }
        } while (true);

    }

    public String inputDoctor(Scanner sc) {
        System.out.print("Input the name of Doctor: ");
        do {
            String regexDoc = ".{0,200}";
            String nameDoctor = sc.nextLine();
            if (Pattern.matches(regexDoc, nameDoctor)) {
                return nameDoctor;
            } else {
                System.out.println("Name of doctor must have maximum 200 character.");
            }
        } while (true);
    }



}
