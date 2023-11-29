package perpustakaanmodernxyz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author belva
 */
//PUSTAKAWAN = ADMIN PERPUSTAKAAN
public class Admin {
    private List<AnggotaPerpustakaan> daftarAnggota;
    private List<Buku> daftarBuku;

    public Admin() {
        daftarAnggota = new ArrayList<>();
        daftarBuku = new ArrayList<>();
    }
    
    public static void Menu(int choice){
        Admin admin = new Admin();
        if (choice == 1) {
            admin.tambahAnggota();
        } else if (choice == 2) {
            admin.tambahBuku(null);
        } else if (choice == 3) {
            admin.lakukanPeminjaman();
        } else if (choice == 4) {
            admin.lakukanPengembalian();
        } else if (choice == 5) {
            admin.cariBuku(null);
        } else if (choice == 6) {
            admin.kirimNotifikasi(null, null);
        } else if (choice == 7) {
            System.out.println("Keluar dari program.");
        } else {
            System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
        }
    }
    
    public void tambahAnggota(){
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama anggota: ");
        String nama = input.nextLine();
        System.out.print("Masukkan nomor anggota: ");
        String id = input.nextLine();
        System.out.print("Masukkan alamat anggota: ");
        String alamat = input.nextLine();

        AnggotaPerpustakaan anggota = new AnggotaPerpustakaan(nama, id, alamat);
        daftarAnggota.add(anggota);
        // Tambahkan anggota ke dalam daftar anggota
        System.out.println("Anggota berhasil ditambahkan");
    }
    
    public AnggotaPerpustakaan cariAnggota(String nomorAnggota) {
        for (AnggotaPerpustakaan anggota : daftarAnggota) {
            if (anggota.getId().equals(nomorAnggota)) {
                return anggota;
            }
        }
        return null; // Anggota tidak ditemukan
    }
    
    public void tambahBuku(Buku buku) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan pengarang buku: ");
        String penulis = scanner.nextLine();
        System.out.print("Masukkan nomor ISBN buku: ");
        String isbn = scanner.nextLine();

        Buku bukuBaru = new Buku (judul, penulis, isbn);
        System.out.println("Buku berhasil ditambahkan ke koleksi.");
    }

    public void hapusBuku(Buku buku) {
        buku.setTersedia(false);
        System.out.println("Menghapus buku: " + buku.getJudul());
    }
    
    public List<Buku> cariBuku(String keyword) {
        List<Buku> hasilPencarian = new ArrayList<>();
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().toLowerCase().contains(keyword.toLowerCase()) ||
                buku.getPenulis().toLowerCase().contains(keyword.toLowerCase()) ||
                buku.getIsbn().toLowerCase().contains(keyword.toLowerCase())) {
                hasilPencarian.add(buku);
            }
        }
        // Menampilkan hasil pencarian
        System.out.println("Hasil Pencarian:");
        for (Buku buku : hasilPencarian) {
            System.out.println("Judul: " + buku.getJudul() + ", Penulis: " + buku.getPenulis());
        }
    
        return hasilPencarian;
    }

    public Buku cariBukuIsbn(String isbn) {
        for (Buku buku : daftarBuku) {
            if (buku.getIsbn().equals(isbn)) {
                return buku;
            }
        }
        return null;
    }
    
    public void lakukanPeminjaman() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nomor anggota perpustakaan: ");
        String nomorAnggota = scanner.nextLine();

        AnggotaPerpustakaan anggota = cariAnggota(nomorAnggota);
        if (anggota != null) {
            System.out.print("Masukkan nomor ISBN buku yang ingin dipinjam: ");
            String isbn = scanner.nextLine();

            Buku buku = cariBukuIsbn(isbn);
            if (buku != null) {
                // Lakukan peminjaman
                Date borrowDate = new Date();
                Date dueDate = new Date(borrowDate.getTime() + (14 * 24 * 60 * 60 * 1000)); // Tenggat waktu 14 hari
                anggota.peminjamanBuku(buku, borrowDate, dueDate);
                System.out.println("Peminjaman berhasil dilakukan.");
            } else {
                System.out.println("Buku tidak ditemukan.");
            }
        } else {
            System.out.println("Anggota perpustakaan tidak ditemukan.");
        }
    }

    public void lakukanPengembalian() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nomor anggota perpustakaan: ");
        String id = scanner.nextLine();

        AnggotaPerpustakaan anggota = cariAnggota(id);
        if (anggota != null) {
            System.out.print("Masukkan nomor ISBN buku yang ingin dikembalikan: ");
            String isbn = scanner.nextLine();

            Buku buku = cariBukuIsbn(isbn);
            if (buku != null) {
                // Lakukan pengembalian
                Date returnDate = new Date();
                anggota.pengembalianBuku(buku, returnDate);
                System.out.println("Pengembalian berhasil dilakukan.");
            } else {
                System.out.println("Buku tidak ditemukan");
            }
        } else {
            System.out.println("Anggota perpustakaan tidak ditemukan");
        }
    }
    
    public void registasiAnggota(AnggotaPerpustakaan anggota) {
        System.out.println("Registrasi anggota baru: " + anggota.getNama());
    }

    public void kirimNotifikasi(AnggotaPerpustakaan anggota, Notifikasi notif) {
        System.out.println("Admin mengirim notifikasi ke " + anggota.getNama());
        anggota.terimaNotifikasi(notif);
    }
    

}
