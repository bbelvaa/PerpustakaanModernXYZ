package perpustakaanmodernxyz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author belva
 */
//PEMUSTAKA = ANGGOTA PERPUSTAKAAN
public class AnggotaPerpustakaan {
    private String nama;
    private String id;
    private String alamat;
    private List<TransaksiPeminjaman> daftarPeminjaman;
    private List<TransaksiPengembalian> daftarPengembalian;
    private List<Notifikasi> notifikasiTerima;

    public AnggotaPerpustakaan(String nama, String id, String alamat) {
        this.nama = nama;
        this.id = id;
        this.alamat = alamat;
        this.daftarPeminjaman = new ArrayList<>();
        this.daftarPengembalian = new ArrayList<>();
        this.notifikasiTerima = new ArrayList<>();
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public List<Notifikasi> getNotifikasiTerima() {
        return notifikasiTerima;
    }

    public void setNotifikasiTerima(List<Notifikasi> notifikasiTerima) {
        this.notifikasiTerima = notifikasiTerima;
    }

    public void peminjamanBuku(Buku buku, Date tanggalPeminjaman, Date tenggatWaktu) {
        System.out.println(nama + " meminjam buku: " + buku.getJudul());
        daftarPeminjaman.add(new TransaksiPeminjaman(buku, tanggalPeminjaman, tenggatWaktu));
    }

    public void pengembalianBuku(Buku buku, Date tanggalPengembalian) {
        System.out.println(nama + " mengembalikan buku: " + buku.getJudul());
        daftarPengembalian.add(new TransaksiPengembalian(buku, tanggalPengembalian));
    }

    public void terimaNotifikasi(Notifikasi notif) {
        notifikasiTerima.add(notif);
        System.out.println(nama + " menerima notifikasi: " + notif.getPesan());
    }

    // Getter untuk daftar peminjaman dan pengembalian
    public List<TransaksiPeminjaman> getDaftarPeminjaman() {
        return daftarPeminjaman;
    }

    public List<TransaksiPengembalian> getDaftarPengembalian() {
        return daftarPengembalian;
    }

}
