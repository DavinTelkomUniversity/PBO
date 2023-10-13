import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bagian2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> nilaiKelasA = new ArrayList<>();
        ArrayList<Double> nilaiKelasB = new ArrayList<>();
        ArrayList<Double> nilaiKelasC = new ArrayList<>();

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Input Nilai PBO Kelas A");
            System.out.println("2. Input Nilai PBO Kelas B");
            System.out.println("3. Input Nilai PBO Kelas C");
            System.out.println("4. Tampilkan Statistik Kelas A");
            System.out.println("5. Tampilkan Statistik Kelas B");
            System.out.println("6. Tampilkan Statistik Kelas C");
            System.out.println("7. Tampilkan Statistik Keseluruhan");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nilai PBO kelas A: ");
                    double nilaiA = scanner.nextDouble();
                    nilaiKelasA.add(nilaiA);
                    break;
                case 2:
                    System.out.print("Masukkan nilai PBO kelas B: ");
                    double nilaiB = scanner.nextDouble();
                    nilaiKelasB.add(nilaiB);
                    break;
                case 3:
                    System.out.print("Masukkan nilai PBO kelas C: ");
                    double nilaiC = scanner.nextDouble();
                    nilaiKelasC.add(nilaiC);
                    break;
                case 4:
                    tampilkanStatistik(nilaiKelasA, "Kelas A");
                    break;
                case 5:
                    tampilkanStatistik(nilaiKelasB, "Kelas B");
                    break;
                case 6:
                    tampilkanStatistik(nilaiKelasC, "Kelas C");
                    break;
                case 7:
                    ArrayList<Double> semuaNilai = new ArrayList<>();
                    semuaNilai.addAll(nilaiKelasA);
                    semuaNilai.addAll(nilaiKelasB);
                    semuaNilai.addAll(nilaiKelasC);
                    tampilkanStatistik(semuaNilai, "Keseluruhan");
                    break;
                case 8:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu yang benar.");
            }
        } while (choice != 8);
    }

    private static void tampilkanStatistik(ArrayList<Double> nilai, String kelas) {
        if (nilai.isEmpty()) {
            System.out.println("Belum ada nilai untuk " + kelas);
            return;
        }

        double rataRata = hitungRataRata(nilai);
        double nilaiTertinggi = Collections.max(nilai);
        double nilaiTerendah = Collections.min(nilai);

        System.out.println("Statistik untuk " + kelas);
        System.out.println("Nilai Tertinggi: " + nilaiTertinggi);
        System.out.println("Nilai Terendah: " + nilaiTerendah);
        System.out.println("Rata-rata Nilai: " + rataRata);
    }

    private static double hitungRataRata(ArrayList<Double> nilai) {
        double total = 0;
        for (double nilaiPBO : nilai) {
            total += nilaiPBO;
        }
        return total / nilai.size();
    }
}
