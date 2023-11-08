public class Lingkaran {

    // Method untuk menghitung luas lingkaran berdasarkan jarijari
    public static double hitungLuas(double jarijari) {
        return Math.PI * jarijari * jarijari;
    }

    // Method untuk menghitung keliling lingkaran berdasarkan jarijari
    public static double hitungKeliling(double jarijari) {
        return 2 * Math.PI * jarijari;
    }

    // Method untuk menghitung luas lingkaran berdasarkan diameter
    public static double hitungLuasDiameter(double diameter) {
        double jarijari = diameter / 2;
        return Math.PI * jarijari * jarijari;
    }

    // Method untuk menghitung keliling lingkaran berdasarkan diameter
    public static double hitungKelilingDiameter(double diameter) {
        double jarijari = diameter / 2;
        return 2 * Math.PI * jarijari;
    }

    public static void main(String[] args) {
        // Kasus 1: Lingkaran dengan jarijari 7
        double jarijari1 = 7;
        double luas1 = hitungLuas(jarijari1);
        double keliling1 = hitungKeliling(jarijari1);
        System.out.println("Luas Lingkaran dengan jari-jari 7: " + luas1);
        System.out.println("Keliling Lingkaran dengan jari-jari 7: " + keliling1);

        // Kasus 2: Lingkaran dengan jarijari 5.5
        double jarijari2 = 5.5;
        double luas2 = hitungLuas(jarijari2);
        double keliling2 = hitungKeliling(jarijari2);
        System.out.println("Luas Lingkaran dengan jari-jari 5.5: " + luas2);
        System.out.println("Keliling Lingkaran dengan jari-jari 5.5: " + keliling2);

        // Kasus 3: Lingkaran dengan diameter 20.4
        double diameter3 = 20.4;
        double luas3 = hitungLuasDiameter(diameter3);
        double keliling3 = hitungKelilingDiameter(diameter3);
        System.out.println("Luas Lingkaran dengan diameter 20.4: " + luas3);
        System.out.println("Keliling Lingkaran dengan diameter 20.4: " + keliling3);
    }
}
