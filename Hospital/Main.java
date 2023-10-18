package Hospital;
import java.util.ArrayList;
import java.util.Scanner;

// Nama    : Davin Wahyu Wardana
// NIM     : 6706223003
// Kelas   : D3IF-4603

class Nurse {
    private String name;
    private int id;

    public Nurse(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Hospital {
    private String name;
    private int id;
    private ArrayList<Nurse> nurses;

    public Hospital(String name, int id, ArrayList<Nurse> nurses) {
        this.name = name;
        this.id = id;
        this.nurses = nurses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Rumah Sakit: ");
        String hospitalName = scanner.nextLine();
        System.out.print("Masukkan ID Rumah Sakit: ");
        int hospitalId = scanner.nextInt();

        ArrayList<Nurse> nursesList = new ArrayList<>();
        scanner.nextLine(); 
        while (true) {
            System.out.print("Masukkan Nama Perawat: ");
            String nurseName = scanner.nextLine();
            if (nurseName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Masukkan ID Perawat: ");
            int nurseId = scanner.nextInt();
            nursesList.add(new Nurse(nurseName, nurseId));
            scanner.nextLine();
        }

        Hospital hospital = new Hospital(hospitalName, hospitalId, nursesList);

        System.out.println("Hospital Name: " + hospital.getName());
        System.out.println("Hospital ID: " + hospital.getId());
        System.out.println("Nurses:");
        ArrayList<Nurse> nurses = hospital.getNurses();
        for (Nurse nurse : nurses) {
            System.out.println("Nurse ID: " + nurse.getId() + ", Name: " + nurse.getName());
        }
    }
}
