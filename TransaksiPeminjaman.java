package perpustakaanmodernxyz;

import java.util.Date;

/**
 *
 * @author belva
 */
public class TransaksiPeminjaman {
    private Date tanggalPeminjaman;
    private Date tenggatWaktu;
    private Buku buku;

    public TransaksiPeminjaman(Buku buku, Date tanggalPeminjaman, Date tenggatWaktu) {
        this.buku = buku;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tenggatWaktu = tenggatWaktu;
    }

    public void catatanTransaksi() {
        buku.setTersedia(false);
        System.out.println("Buku \"" + buku.getJudul() + "\" dipinjam pada tanggal: " + tanggalPeminjaman + ". Tenggat waktu pengembalian: " + tenggatWaktu);
    }

}
