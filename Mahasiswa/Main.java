package Mahasiswa;
import java.util.ArrayList;
import java.util.Scanner;

// Nama    : Davin Wahyu Wardana
// NIM     : 6706223003
// Kelas   : D3IF-4603

class Mahasiswa {
    private String nim;
    private String nama;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }
}

class Jurusan {
    private String kode;
    private String nama;
    private ArrayList<Mahasiswa> mhs;

    public Jurusan(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
        this.mhs = new ArrayList<>();
    }

    public void addMhs(Mahasiswa m) {
        mhs.add(m);
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public ArrayList<Mahasiswa> getMhs() {
        return mhs;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jurusan> jurusanList = new ArrayList<>();

        while (true) {
            System.out.print("Kode Jurusan: ");
            String kode = scanner.nextLine();
            if (kode.equals("done")) {
                break;
            }

            System.out.print("Nama Jurusan: ");
            String nama = scanner.nextLine();

            Jurusan jurusan = new Jurusan(kode, nama);
            while (true) {
                System.out.print("NIM Mahasiswa: ");
                String nim = scanner.nextLine();
                if (nim.equals("done")) {
                    break;
                }

                System.out.print("Nama Mahasiswa: ");
                String namaMhs = scanner.nextLine();
                Mahasiswa mahasiswa = new Mahasiswa(nim, namaMhs);
                jurusan.addMhs(mahasiswa);
            }

            jurusanList.add(jurusan);
        }

        for (Jurusan jurusan : jurusanList) {
            System.out.println("Kode: " + jurusan.getKode());
            System.out.println("Nama: " + jurusan.getNama());
            System.out.println("Daftar mahasiswa:");
            ArrayList<Mahasiswa> mahasiswaList = jurusan.getMhs();
            for (int i = 0; i < mahasiswaList.size(); i++) {
                Mahasiswa mahasiswa = mahasiswaList.get(i);
                System.out.println((i + 1) + ". " + mahasiswa.getNim() + " - " + mahasiswa.getNama());
            }
        }
    }
}
