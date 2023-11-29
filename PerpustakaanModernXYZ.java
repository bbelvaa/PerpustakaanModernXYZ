package perpustakaanmodernxyz;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author belva
 */
public class PerpustakaanModernXYZ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               Scanner input = new Scanner(System.in);

        Admin admin = new Admin();

        int choice;
        do {
            System.out.println("Selamat Datang di Perpustakaan Modern XYZ");
            System.out.println("Silakan Pilih Menu (1-7):");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Tambah Buku");
            System.out.println("3. Peminjaman Buku");
            System.out.println("4. Pengembalian Buku");
            System.out.println("5. Cari Buku");
            System.out.println("6. Mengirimkan Notifikasi Batas Waktu Peminjaman");
            System.out.println("7. Keluar");
            choice = input.nextInt();

            // Proses pilihan
            admin.Menu(choice);

        } while (choice != 7);
        
        input.close();
    }
}
