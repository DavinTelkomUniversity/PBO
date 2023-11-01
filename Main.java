import java.util.Scanner;

class Departemen {
    private String nama;
    private Karyawan[] kar;

    public Departemen(String nama) {
        this.nama = nama;
        this.kar = new Karyawan[100];
    }

    public void addKaryawan(Karyawan k) {
        for (int i = 0; i < kar.length; i++) {
            if (kar[i] == null) {
                kar[i] = k;
                break;
            }
        }
    }

    public void displayAll() {
        System.out.println("Seluruh Karyawan di Departemen " + nama + ":\n");
        for (Karyawan k : kar) {
            if (k != null) {
                k.display();
            }
        }
        System.out.println("-------------------------------------");
    }

    public void displayKontrak() {
        System.out.println("Karyawan Kontrak di Departemen " + nama + ":\n");
        for (Karyawan k : kar) {
            if (k != null && k instanceof Kontrak) {
                k.display();
            }
        }
        System.out.println("-------------------------------------");
    }

    public void displayTetap() {
        System.out.println("Karyawan Tetap di Departemen " + nama + ":\n");
        for (Karyawan k : kar) {
            if (k != null && k instanceof Tetap) {
                k.display();
            }
        }
        System.out.println("-------------------------------------");
    }
}

class Karyawan {
    protected String nama;
    protected double gaDas;

    public Karyawan(String nama, double gaDas) {
        this.nama = nama;
        this.gaDas = gaDas;
    }

    public void display() {
        System.out.println("Nama: " + nama + ", Gaji Dasar: " + gaDas);
    }
}

class Tetap extends Karyawan {
    private double tuDas;

    public Tetap(String nama, double tuDas, double gaDas) {
        super(nama, gaDas);
        this.tuDas = tuDas;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Tunjangan Dasar: " + tuDas);
    }
}

class Kontrak extends Karyawan {
    private int waktu;

    public Kontrak(String nama, int waktu, double gaDas) {
        super(nama, gaDas);
        this.waktu = waktu;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Lama Kontrak: " + waktu + " bulan");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan nama departemen: ");
        String namaDepartemen = scanner.nextLine();
        Departemen departemen = new Departemen(namaDepartemen);

        System.out.print("Masukkan jumlah karyawan tetap: ");
        int jumlahTetap = scanner.nextInt();
        scanner.nextLine(); // Membuang karakter newline

        for (int i = 0; i < jumlahTetap; i++) {
            System.out.print("Masukkan nama karyawan tetap: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan tunjangan dasar: ");
            double tuDas = scanner.nextDouble();
            System.out.print("Masukkan gaji dasar: ");
            double gaDas = scanner.nextDouble();
            scanner.nextLine();

            Tetap tetap = new Tetap(nama, tuDas, gaDas);
            departemen.addKaryawan(tetap);
        }

        System.out.print("Masukkan jumlah karyawan kontrak: ");
        int jumlahKontrak = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < jumlahKontrak; i++) {
            System.out.print("Masukkan nama karyawan kontrak: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan lama kontrak (bulan): ");
            int waktu = scanner.nextInt();
            System.out.print("Masukkan gaji dasar: ");
            double gaDas = scanner.nextDouble();
            scanner.nextLine();

            Kontrak kontrak = new Kontrak(nama, waktu, gaDas);
            departemen.addKaryawan(kontrak);
        }


        System.out.println("-------------------------------------");
        System.out.println("-------- PT. DAVIN INDONESIA --------");
        System.out.println("-------------------------------------\n");

        departemen.displayAll();
        departemen.displayTetap();
        departemen.displayKontrak();

        scanner.close();
    }
}
