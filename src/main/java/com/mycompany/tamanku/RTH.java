package com.mycompany.tamanku;

public class RTH {
    private int id;
    private String nama;
    private String kategori;   
    private String jenis;      
    private String kecamatan;
    private String alamat;
    private String jamBuka;
    private String fasilitas;
    private String kondisi;
    private String catatan;

    public RTH(int id, String nama, String kategori, String jenis, String kecamatan,
               String alamat, String jamBuka, String fasilitas, String kondisi, String catatan) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.jenis = jenis;
        this.kecamatan = kecamatan;
        this.alamat = alamat;
        this.jamBuka = jamBuka;
        this.fasilitas = fasilitas;
        this.kondisi = kondisi;
        this.catatan = catatan;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getKategori() { return kategori; }
    public String getJenis() { return jenis; }
    public String getKecamatan() { return kecamatan; }
    public String getKondisi() { return kondisi; }

    public void setKondisi(String kondisi) { this.kondisi = kondisi; }

    public String getRingkas() {
        return nama + "  |  " + kategori + "  |  Kec. " + kecamatan;
    }

    public String getInfo() {
        return "Jenis RTH : " + jenis + "\n"
             + "Kecamatan : " + kecamatan + "\n"
             + "Alamat    : " + alamat + "\n"
             + "Jam buka  : " + jamBuka + "\n"
             + "Fasilitas : " + fasilitas + "\n"
             + "Kondisi   : " + kondisi + "\n"
             + "Catatan   : " + catatan;
    }
}

