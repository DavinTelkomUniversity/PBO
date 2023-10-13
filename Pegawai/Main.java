// nama    : davin wahyu wardana
// nim     : 6706223003
// kelas   : 4603

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Pegawai> pegawaiList = new ArrayList<>();

    public static void main(String[] args) {
        Main aplikasi = new Main();
        aplikasi.tampilkanMenu();
    }

    public void tampilkanMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Menu Aplikasi:");
            System.out.println("1. Input pegawai");
            System.out.println("2. Edit pegawai");
            System.out.println("3. Menampilkan seluruh data pegawai");
            System.out.println("4. Menampilkan data pegawai per-departemen");
            System.out.println("5. Menampilkan data pegawai berdasarkan range gaji");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    inputPegawai();
                    break;
                case 2:
                    editPegawai();
                    break;
                case 3:
                    tampilkanSemuaPegawai();
                    break;
                case 4:
                    tampilkanPegawaiPerDepartemen();
                    break;
                case 5:
                    tampilkanPegawaiBerdasarkanGaji();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 0);
    }

    public void inputPegawai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID pegawai: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Nama pegawai: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Alamat pegawai: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan Departemen (SDM/Keuangan/Produksi): ");
        String departemen = scanner.nextLine();
        System.out.print("Masukkan Gaji pegawai: ");
        double gaji = scanner.nextDouble();

        Pegawai pegawai = new Pegawai(id, nama, alamat, departemen, gaji);
        pegawaiList.add(pegawai);
        System.out.println("Pegawai berhasil ditambahkan.");
    }

    public void editPegawai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID pegawai yang ingin diedit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
    
        for (Pegawai pegawai : pegawaiList) {
            if (pegawai.getId() == id) {
                System.out.print("Masukkan Nama pegawai baru: ");
                String nama = scanner.nextLine();
                pegawai.setNama(nama);
    
                System.out.print("Masukkan Alamat pegawai baru: ");
                String alamat = scanner.nextLine();
                pegawai.setAlamat(alamat);
    
                System.out.print("Masukkan Departemen pegawai baru (SDM/Keuangan/Produksi): ");
                String departemen = scanner.nextLine();
                pegawai.setDepartemen(departemen);
    
                System.out.print("Masukkan Gaji pegawai baru: ");
                double gaji = scanner.nextDouble();
                pegawai.setGaji(gaji);
    
                System.out.println("Data pegawai berhasil diubah.");
                return;
            }
        }
        System.out.println("Pegawai dengan ID tersebut tidak ditemukan.");
    }
    
    
    public void tampilkanSemuaPegawai() {
        for (Pegawai pegawai : pegawaiList) {
            System.out.println("ID: " + pegawai.getId());
            System.out.println("Nama: " + pegawai.getNama());
            System.out.println("Alamat: " + pegawai.getAlamat());
            System.out.println("Departemen: " + pegawai.getDepartemen());
            System.out.println("Gaji: " + pegawai.getGaji());
            System.out.println("----------------------");
        }
    }

    public void tampilkanPegawaiPerDepartemen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Departemen (SDM/Keuangan/Produksi): ");
        String departemen = scanner.nextLine();

        for (Pegawai pegawai : pegawaiList) {
            if (pegawai.getDepartemen().equalsIgnoreCase(departemen)) {
                System.out.println("ID: " + pegawai.getId());
                System.out.println("Nama: " + pegawai.getNama());
                System.out.println("Alamat: " + pegawai.getAlamat());
                System.out.println("Gaji: " + pegawai.getGaji());
                System.out.println("----------------------");
            }
        }
    }

    public void tampilkanPegawaiBerdasarkanGaji() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Range Gaji: ");
        double gajiMin = scanner.nextDouble();

        for (Pegawai pegawai : pegawaiList) {
            if (pegawai.getGaji() > gajiMin) {
                System.out.println("ID: " + pegawai.getId());
                System.out.println("Nama: " + pegawai.getNama());
                System.out.println("Alamat: " + pegawai.getAlamat());
                System.out.println("Departemen: " + pegawai.getDepartemen());
                System.out.println("Gaji: " + pegawai.getGaji());
                System.out.println("----------------------");
            }
        }
    }
}
