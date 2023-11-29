package perpustakaanmodernxyz;

/**
 *
 * @author belva
 */
public class Buku {
    private String judul;
    private String penulis;
    private String isbn;
    private boolean tersedia;

    public Buku(String judul, String penulis, String isbn) {
        this.judul = judul;
        this.penulis = penulis;
        this.isbn = isbn;
        this.tersedia = true; // Semua buku awalnya tersedia
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(){
        this.judul = judul;
    }
    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void cekKetersediaan() {
        String status = tersedia ? "tersedia" : "tidak tersedia";
        System.out.println("Buku " + judul + " saat ini " + status);
    }
}
