/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 * Nama : Davin Wahyu Wardana
 * NIM : 6706223003
 * Kelas : D3IF-4603
 */
import java.util.ArrayList;

interface Pembayaran {
    void invoice();
    int totalBayar(int jumlah, int harga);
}

class Pegawai {
    protected String nama;
    private String alamat;
    private String telepon;
    private ArrayList<String> idOrder;

    public Pegawai(String nama, String alamat, String telepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.idOrder = new ArrayList<>();
    }

    public void addOrder(String idOrder) {
        this.idOrder.add(idOrder);
    }

    public void displayOrder() {
        for (String id : idOrder) {
            System.out.println("ID order: " + id);
        }
    }
}

// Kelas Penjaga
class Penjaga extends Pegawai {
    private String sesiMasuk;

    public Penjaga(String nama, String alamat, String telepon, String sesiMasuk) {
        super(nama, alamat, telepon);
        this.sesiMasuk = sesiMasuk;
    }

    public String getNamaPenjaga() {
        return super.nama;
    }

    public String getSesiMasuk() {
        return sesiMasuk;
    }
}

class Kurir extends Pegawai {
    private String wilayahAntar;

    public Kurir(String nama, String alamat, String telepon, String wilayahAntar) {
        super(nama, alamat, telepon);
        this.wilayahAntar = wilayahAntar;
    }

    public String getWilayahAntar() {
        return wilayahAntar;
    }

    public String getNamaKurir() {
        return super.nama;
    }
}

class Order implements Pembayaran {
    protected String id;
    protected String namaPembeli;
    protected String item;
    protected int jumlah;
    protected int harga;
    private String alamatKirim;

    public Order(String id, String namaPembeli, String item, int jumlah, int harga, String alamatKirim) {
        this.id = id;
        this.namaPembeli = namaPembeli;
        this.item = item;
        this.jumlah = jumlah;
        this.harga = harga;
        this.alamatKirim = alamatKirim;
    }

    @Override
    public void invoice() {
        System.out.println("INVOICE");
        System.out.println("PT Davin");
        System.out.println("Pembelian barang " + item);
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Total harga: " + totalBayar(jumlah, harga));
        System.out.println();
    }

    @Override
    public int totalBayar(int jumlah, int harga) {
        return jumlah * harga;
    }

    public String getIdOrder() {
        return id;
    }
}

class PreOrder extends Order {
    private String tanggalKirim;
    private int dp;

    public PreOrder(String id, String namaPembeli, String item, int jumlah, int harga, String alamatKirim,
                    String tanggalKirim, int dp) {
        super(id, namaPembeli, item, jumlah, harga, alamatKirim);
        this.tanggalKirim = tanggalKirim;
        this.dp = dp;
    }

    @Override
    public void invoice() {
        System.out.println("INVOICE");
        System.out.println("PT Davin");
        System.out.println("Pre-order item: " + super.item);
        System.out.println("Jumlah: " + super.jumlah);
        System.out.println("DP yang sudah dibayar: " + dp);
        System.out.println("Sisa Bayar: " + (totalBayar(super.jumlah, super.harga) - dp));
        System.out.println("Tanggal kirim: " + tanggalKirim);
        System.out.println();
    }

    @Override
    public int totalBayar(int jumlah, int harga) {
        return super.totalBayar(jumlah, harga);
    }

    public String getIdOrderPO() {
        return super.getIdOrder();
    }
}
/**
 *
 * @author user
 */
public class Main {
    public static void main(String[] args) {
        Penjaga penjaga = new Penjaga("Rita", "Cikawalo", "085723456", "Pagi");
        Kurir kurir1 = new Kurir("Dudi", "Bojongsoang", "0812123222", "Cikoneng-Ciwastra");
        Kurir kurir2 = new Kurir("Riki", "Cikoneng", "0811123212", "Setiabudi");

        Order item1 = new Order("A001", "Asep", "Hand sanitizer", 10, 20000, "Sukajadi");
        Order item2 = new Order("A002", "Ita", "Masker wangi", 100, 1500, "Sukajadi 2");
        PreOrder po1 = new PreOrder("B001", "Dinda", "Hair mask", 2, 50000, "Cikoneng",
                "25 November 2023", 25000);

        System.out.println("Invoice untuk setiap pemesanan");

        item1.invoice();
        item2.invoice();
        po1.invoice();

        penjaga.addOrder(item1.getIdOrder());
        penjaga.addOrder(item2.getIdOrder());
        penjaga.addOrder(po1.getIdOrderPO());

        System.out.println("Karyawan toko: " + penjaga.getNamaPenjaga());
        penjaga.displayOrder();

        System.out.println("Kurir: " + kurir1.getNamaKurir());
        System.out.println("Wilayah antar: " + kurir1.getWilayahAntar());
        kurir1.addOrder(item1.getIdOrder());
        kurir1.addOrder(item2.getIdOrder());
        kurir1.displayOrder();

        System.out.println("Kurir: " + kurir2.getNamaKurir());
        System.out.println("Wilayah antar: " + kurir2.getWilayahAntar());
        kurir2.addOrder(po1.getIdOrderPO());
        kurir2.displayOrder();
    }
}
