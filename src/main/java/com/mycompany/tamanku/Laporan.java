package com.mycompany.tamanku;

public class Laporan {
    private String kode;
    private RTH rth;
    private String kategori;
    private String keterangan;
    private String namaPelapor;
    private String kontak;
    private String foto;
    private String status;

    public Laporan(String kode, RTH rth, String kategori, String keterangan,
                   String namaPelapor, String kontak, String foto) {
        this.kode = kode;
        this.rth = rth;
        this.kategori = kategori;
        this.keterangan = keterangan;
        this.namaPelapor = namaPelapor;
        this.kontak = kontak;
        this.foto = foto;
        this.status = "Diterima"; 
    }

    public String getKode() { return kode; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getRingkasan() {
        return "Kode laporan : " + kode + "\n"
             + "RTH          : " + rth.getNama() + "\n"
             + "Kategori     : " + kategori + "\n"
             + "Keterangan   : " + keterangan + "\n"
             + "Pelapor      : " + namaPelapor + " (" + kontak + ")\n"
             + "Foto         : " + foto + "\n"
             + "STATUS       : " + status;
    }
}

