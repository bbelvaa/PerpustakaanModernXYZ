package perpustakaanmodernxyz;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author belva
 */
public class TransaksiPengembalian {
    private Date tanggalPengembalian;
    private Buku buku;
    private static final double denda = 5000;

    public Date getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(Date tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public TransaksiPengembalian(Buku buku, Date tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
        this.buku = buku;
    }
    
    public double menghitungDenda(Date tenggatWaktu) {
        long selisihHari = getSelisihHari(tenggatWaktu, tanggalPengembalian);
        return selisihHari > 0 ? selisihHari * denda : 0;
    }

    private long getSelisihHari(Date startDate, Date endDate) {
        long selisihWaktu = endDate.getTime() - startDate.getTime();
        return TimeUnit.DAYS.convert(selisihWaktu, TimeUnit.MILLISECONDS);
    }

    public void catatanTransaksi() {
        buku.setTersedia(true);
        System.out.println("Transaksi pengembalian pada tanggal: " + tanggalPengembalian);
    }

}
