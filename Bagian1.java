import java.util.Scanner;

public class Bagian1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Luas Permukaan dan Volume Balok");
            System.out.println("2. Luas Permukaan dan Volume Bola");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan panjang balok: ");
                    double panjang = scanner.nextDouble();
                    System.out.print("Masukkan lebar balok: ");
                    double lebar = scanner.nextDouble();
                    System.out.print("Masukkan tinggi balok: ");
                    double tinggi = scanner.nextDouble();

                    double luasPermukaanBalok = 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
                    double volumeBalok = panjang * lebar * tinggi;

                    System.out.println("Luas Permukaan Balok: " + luasPermukaanBalok);
                    System.out.println("Volume Balok: " + volumeBalok);
                    break;

                case 2:
                    System.out.print("Masukkan jari-jari bola: ");
                    double jariJari = scanner.nextDouble();

                    double luasPermukaanBola = 4 * Math.PI * Math.pow(jariJari, 2);
                    double volumeBola = (4.0 / 3.0) * Math.PI * Math.pow(jariJari, 3);

                    System.out.println("Luas Permukaan Bola: " + luasPermukaanBola);
                    System.out.println("Volume Bola: " + volumeBola);
                    break;

                case 3:
                    System.out.println("Anda telah keluar program.");
                    break;

                default:
                    System.out.println("Menu tidak valid. Silakan masukkan angka yang tersedia.");
            }
        } while (choice != 3);
    }
}
