// nama    : davin wahyu wardana
// nim     : 6706223003
// kelas   : 4603

package Buku;
public class Main {
    public static void main(String[] args) {
        Buku buku1 = new Buku("Harry Potter", "J.K. Rowling", 300000);
        Buku buku2 = new Buku("UML", "Ivar Jacobson", 400000);

        System.out.println("Judul\t\tPengarang\t\tHarga");
        System.out.println(buku1.getJudul() + "\t" + buku1.getPengarang() + "\t\t" + buku1.getHarga());
        System.out.println(buku2.getJudul() + "\t\t" + buku2.getPengarang() + "\t" + buku2.getHarga());
    }
}
