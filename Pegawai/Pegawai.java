// nama    : davin wahyu wardana
// nim     : 6706223003
// kelas   : 4603

public class Pegawai {
    private int id;
    private String nama;
    private String alamat;
    private String departemen;
    private double gaji;

    public Pegawai(int id, String nama, String alamat, String departemen, double gaji) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.departemen = departemen;
        this.gaji = gaji;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getDepartemen() {
        return departemen;
    }

    public double getGaji() {
        return gaji;
    }
}
