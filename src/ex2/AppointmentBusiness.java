package ex2;

import java.util.Scanner;

public class AppointmentBusiness {
    public static Appointment[] appointments = new Appointment[100];
    public static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("---------------Appointment Management-----------------");
            System.out.println("1. Add appointment");
            System.out.println("2. Display appointment list");
            System.out.println("3. Search appointment by name patient");
            System.out.println("4. Update appointment by id");
            System.out.println("5. Delete appointment by id");
            System.out.println("6. Statistic");
            System.out.println("7. Exit");
            System.out.println("------------------------------------------------------");
            System.out.print("Your choice is: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addAppointment(sc);
                    break;
                case 2:
                    displayListAppointment();
                    break;
                case 3:
                    searchAppointmentByName(sc);
                    break;
                case 4:
                    updateAppointById(sc);
                    break;
                case 5:

                    break;
                case 6:
                    statisticAppointment();
                    break;
                case 7:
                    break;
                default:
                    System.exit(0);
            }
        } while (true);
    }

    public static void displayListAppointment() {
        if (currentIndex == 0) {
            System.out.println("There are no appointment scheduled");
        } else {
            for (int i = 0; i < currentIndex; i++) {
                System.out.println(appointments[i]);
            }
        }
    }

    public static int getIndexAppointmentById(String id) {
        for (int i = 0; i < currentIndex; i++) {

            if (appointments[i].getAppointmentID().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void addAppointment(Scanner sc) {
        System.out.print("Enter quantity of appointment you want to add: ");
        int quantityAddAppointment = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < quantityAddAppointment; i++) {
            appointments[currentIndex] = new Appointment();
            appointments[currentIndex].inputData(sc);
            currentIndex++;
        }
    }

    public static void searchAppointmentByName(Scanner sc) {
        System.out.print("Enter the name you want to search: ");
        String nameSearch = sc.nextLine();
        for (int i = 0; i < currentIndex; i++) {
            if (appointments[i].getPatientName().toLowerCase().contains(nameSearch.toLowerCase())) {
                appointments[i] = new Appointment();
                System.out.println(appointments[i]);
            }
        }
    }

    public static void updateAppointById(Scanner sc){
        System.out.print("Input the id to update: ");
        String idAppoint = sc.nextLine();
        int idxAppointToUpdate = getIndexAppointmentById(idAppoint);
        if (idxAppointToUpdate == -1){
            System.err.println("Not found this id.");
        }
        System.out.println("-------------CHOOSE UPDATE VALUE--------------");
        System.out.println("1. Name of patient.");
        System.out.println("2. Contact number");
        System.out.println("3. Appointment date");
        System.out.println("4. Name of doctor");
        System.out.println("5. Exit");
        int updateChoose = Integer.parseInt(sc.nextLine());
        switch (updateChoose){
            case 1:
                appointments[idxAppointToUpdate].setPatientName(sc.nextLine());
                break;
            case 2:
                appointments[idxAppointToUpdate].setPhoneNumber(sc.nextLine());
                break;
            case 3:
                appointments[idxAppointToUpdate].setAppointmentDate(sc.nextLine());
                break;
            case 4:
                appointments[idxAppointToUpdate].setDoctor(sc.nextLine());
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Your choice must from 1 to 5");
        }
    }

    public static void statisticAppointment(){
        System.out.println("Quantity of appointment: "+currentIndex);

    }
}
