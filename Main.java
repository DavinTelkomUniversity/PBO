// Davin Wahyu Wardana
// 6706223003
// D3IF-4603

interface Penjualan {
    int getStock();
    int totalPenjualan(int qty);
    void jualProduk(int qty);
}

abstract class Pakaian implements Penjualan {
    protected char ukuran;
    protected String warna;
    protected int harga;
    protected int jumlah;

    public void setStock(int jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public int getStock() {
        return jumlah;
    }

    @Override
    public int totalPenjualan(int qty) {
        return qty * harga;
    }

    @Override
    public void jualProduk(int qty) {
        if (jumlah >= qty) {
            jumlah -= qty;
        } else {
            System.out.println("Stok tidak mencukupi");
        }
    }
}

class Dress extends Pakaian {
    private String model;

    public Dress() {
        this.harga = 50000;
        setStock(50);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

class Trousers extends Pakaian {
    private String bahan;

    public Trousers() {
        this.harga = 100000;
        setStock(100);
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public String getBahan() {
        return bahan;
    }
}

public class Main {
    public static void main(String[] args) {
        Dress dress = new Dress();
        dress.jualProduk(5);

        Trousers trousers = new Trousers();
        trousers.jualProduk(10);

        System.out.println("-- Trousers --");
        System.out.println("Stok Awal\t\t: " + 100);
        System.out.println("Harga Satuan\t\t: Rp" + trousers.harga);
        System.out.println("Jumlah Penjualan\t: 10");
        System.out.println("Stok Akhir\t\t: " + trousers.getStock());
        System.out.println("Total Penjualan\t\t: Rp" + trousers.totalPenjualan(10));

        System.out.println("\n-- Dress --");
        System.out.println("Stok Awal\t\t: " + 50);
        System.out.println("Harga Satuan\t\t: Rp" + dress.harga);
        System.out.println("Jumlah Penjualan\t: 5");
        System.out.println("Stok Akhir\t\t: " + dress.getStock());
        System.out.println("Total Penjualan\t\t: Rp" + dress.totalPenjualan(5));
    }
}
