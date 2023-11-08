import java.util.Scanner;

class Segitiga {
    private Scanner scanner;

    public Segitiga() {
        scanner = new Scanner(System.in);
    }

    // Method untuk menghitung luas segitiga berdasarkan alas dan tinggi
    public double hitungLuas(double alas, double tinggi) {
        return (alas * tinggi) / 2;
    }

    // Method untuk menghitung keliling segitiga berdasarkan sisi
    public double hitungKeliling(double sisi) {
        return 3 * sisi;
    }

    // Method untuk menampilkan menu dan mengambil input pengguna
    public void tampilkanMenu() {
        int pilihan;
        do {
            System.out.println("Perhitungan Segitiga sama sisi :");
            System.out.println("1. Berdasarkan Alas dan Tinggi");
            System.out.println("2. Berdasarkan Sisi");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan alas: ");
                    double alas = scanner.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    double tinggi = scanner.nextDouble();
                    double luas = hitungLuas(alas, tinggi);
                    double keliling = hitungKeliling(alas);
                    System.out.println("Luas segitiga: " + luas);
                    System.out.println("Keliling segitiga: " + keliling);
                    break;
                case 2:
                    System.out.print("Masukkan panjang sisi: ");
                    double sisi = scanner.nextDouble();
                    luas = hitungLuas(sisi, Math.sqrt(3) / 2 * sisi);
                    keliling = hitungKeliling(sisi);
                    System.out.println("Luas segitiga: " + luas);
                    System.out.println("Keliling segitiga: " + keliling);
                    break;
                case 3:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 3);
    }

    public static void main(String[] args) {
        Segitiga segitiga = new Segitiga();
        segitiga.tampilkanMenu();
    }
}
