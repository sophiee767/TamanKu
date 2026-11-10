package com.mycompany.tamanku;

import java.util.ArrayList;
import java.util.Scanner;

// MAIN CLASS - TamanKu 
public class TamanKu {

    static ArrayList<RTH> daftarRTH = new ArrayList<>();
    static ArrayList<Laporan> daftarLaporan = new ArrayList<>();
    static Scanner input = new Scanner(System.in);   
    
    public static void main(String[] args) {

        isiDataRTH();

        boolean jalan = true;
        while (jalan) {
            System.out.println("\n========== TAMANKU - Info & Pelaporan RTH ==========");
            System.out.println("1. Daftar RTH");
            System.out.println("2. Cari RTH (berdasarkan nama)");
            System.out.println("3. Filter jenis RTH");
            System.out.println("4. Detail RTH & Laporkan Masalah");
            System.out.println("5. Cek Status Laporan");
            System.out.println("6. Informasi & Edukasi");
            System.out.println("7. Simulasi Pengelola (demo)");
            System.out.println("0. Keluar");
            int pilihan = bacaAngka("Pilih menu: ");

            switch (pilihan) {
                case 1: tampilDaftar(daftarRTH); break;
                case 2: cariRTH(); break;
                case 3: filterJenis(); break;
                case 4: detailRTH(); break;
                case 5: cekStatus(); break;
                case 6: edukasi(); break;
                case 7: simulasiPengelola(); break;
                case 0: jalan = false; break;
                default: System.out.println("Menu tidak tersedia.");
            }
        }
        System.out.println("Terima kasih telah menggunakan TamanKu!");
    }

    // Data RTH Kota Bandar Lampung 
    static void isiDataRTH() {
        
        // ===== Taman Kota =====
        daftarRTH.add(new TamanKota(1, "Lungsir", "Taman Kota", "Teluk Betung Utara",
                "Jl. Dokter Susilo (depan Kantor Walikota)",
                "24 Jam (Paling ramai 16.00 - 23.00)",
                "Kuliner kaki lima, area pedestrian, JPO Siger Milenial, monumen jangkar kapal",
                "Sangat baik dan ramai",
                "Pusat interaksi warga dan titik kumpul kuliner malam terbesar di pusat kota."));
        daftarRTH.add(new TamanKota(2, "Taman Dipangga", "Taman Kota", "Teluk Betung Selatan",
                "Jl. Wolter Monginsidi (depan Polda Lampung lama)",
                "06.00 - 18.00",
                "Pepohonan peneduh tua, bangku taman, Zona Bocah (area bermain anak)",
                "Cukup baik dan rindang",
                "Taman bersejarah yang dibangun untuk mengenang letusan Gunung Krakatau 1883."));
        daftarRTH.add(new TamanKota(3, "Taman Kota Pasar Korpri", "Taman Kota", "Sukarame",
                "Kawasan Harapan Jaya",
                "06.00 - 18.00",
                "Danau buatan kecil (embung), wahana bermain anak, bangku semen",
                "Cukup baik",
                "RTH gratis yang ramah keluarga, sering dipakai warga lokal untuk memancing santai."));
        daftarRTH.add(new TamanKota(4, "Taman Asilo Hermelink", "Taman Kota (Semi-Publik)", "Kedaton",
                "Jl. Zainal Abidin Pagar Alam (dekat Pascasarjana UBL)",
                "06.00 - 18.00",
                "Hutan pinus, jogging track, jalur sepeda, area camping mandiri",
                "Sangat baik dan asri",
                "RTH privat berkonsep terbuka hijau dengan suasana sejuk khas pegunungan pinus."));
        daftarRTH.add(new TamanKota(5, "Taman Gajah (Elephant Park) / Lapangan Enggal",
                "Taman Kota / Ruang Terbuka Publik", "Enggal",
                "Jl. Sriwijaya, Enggal (Samping Lapangan Saburai)",
                "06.00 - 22.00",
                "Lapangan basket, skate park, tahapan pertunjukan teater, air mancur mini, taman bermain",
                "Cukup baik",
                "Kawasan ruang publik kreatif terpadu yang ramah anak dan anak muda di tengah kota."));

        // ===== Hutan Kota =====
        daftarRTH.add(new HutanKota(6, "Taman Wisata Hutan Kera", "Hutan Kota / Konservasi", "Teluk Betung Utara",
                "Kawasan perbukitan Sumur Batu",
                "07.00 - 17.00",
                "Jalur tracking, pos pengamatan satwa, tempat penjualan pakan kera",
                "Cukup baik (alami)",
                "Habitat alami ratusan kera liar di tengah kota yang hidup berdampingan dengan pengunjung."));
        daftarRTH.add(new HutanKota(7, "Hutan Konservasi & Taman Kupu-Kupu Gita Persada",
                "Hutan Kota / Edukasi", "Kemiling",
                "Jl. Wan Abdurrahman, kaki Gunung Betung",
                "08.00 - 17.00",
                "Kandang penangkaran penutup, museum spesimen, rumah pohon, jalur edukasi alam",
                "Sangat baik dan lebat",
                "Pusat pelestarian dan penelitian ratusan spesies kupu-kupu asli pulau Sumatra."));
        daftarRTH.add(new HutanKota(8, "Kawasan Agrowisata & RTH Sukadanaham",
                "Hutan Kota / Sabuk Hijau (Green Belt)", "Tanjung Karang Barat",
                "Jl. Ridwan Rais, Kelurahan Sukadanaham",
                "07.00 - 18.00 (Tergantung lokasi wisata)",
                "Perkebunan durian, gardu pandang, area hijau perbukitan",
                "Sangat baik dan alami",
                "Kawasan perbukitan rawan erosi yang dipertahankan fungsinya sebagai sabuk hijau pelindung resapan air kota."));

        // ===== Lapangan dan Alun-alun =====
        daftarRTH.add(new RTH(9, "Tugu Adipura / Bundaran Gajah", "Lapangan dan Alun-alun",
                "Alun-Alun / Ruang Terbuka Publik", "Tanjung Karang Pusat",
                "Persimpangan Jl. Raden Intan dan Jl. Jenderal Ahmad Yani",
                "24 Jam (Khusus CFD: Minggu 06.00 - 10.00)",
                "Landmark patung gajah, air mancur, area pejalan kaki luas saat CFD",
                "Sangat baik",
                "Jantung kota sekaligus lokasi utama pelaksanaan Car Free Day mingguan."));
        daftarRTH.add(new RTH(10, "Lapangan Saburai Enggal", "Lapangan dan Alun-alun",
                "Lapangan Terbuka", "Enggal",
                "Kawasan Enggal (dekat pusat perbelanjaan)",
                "24 Jam (Tergantung acara)",
                "Panggung acara, area lapangan tanah/rumput luas, kantong parkir",
                "Cukup baik",
                "Ruang publik multifungsi yang sering disewa untuk konser, pameran, dan pasar malam."));
        daftarRTH.add(new RTH(11, "Kawasan PKOR Way Halim & Stadion Sumpah Pemuda", "Lapangan dan Alun-alun",
                "Kompleks Olahraga dan Alun-Alun Publik", "Way Halim",
                "Jl. Sumpah Pemuda",
                "05.00 - 22.00",
                "Jogging track, stadion sepak bola, arena sepatu roda/skateboard, sentra UMKM kuliner",
                "Sangat baik dan sangat ramai",
                "Episentrum olahraga sore hari dan pusat jajanan rakyat terbesar di Bandar Lampung."));
        daftarRTH.add(new RTH(12, "Lapangan Kalpataru Kemiling", "Lapangan dan Alun-alun",
                "Lapangan Publik / Taman Lingkungan", "Kemiling",
                "Jl. Kalpataru",
                "06.00 - 21.00",
                "Jogging track semen, lapangan olahraga terbuka, area duduk warga",
                "Baik",
                "Ruang terbuka andalan warga wilayah barat untuk berolahraga pagi dan sore."));
        daftarRTH.add(new RTH(13, "Lapangan Krida Wisata", "Lapangan dan Alun-alun",
                "Lapangan Terbuka / Taman Lingkungan", "Sukarame",
                "Kompleks Perumahan Korpri, Blok B",
                "06.00 - 18.00",
                "Lapangan sepak bola, jogging track, area bermain anak sederhana",
                "Cukup baik",
                "Menjadi pusat aktivitas olahraga pagi, sore, dan tempat pasar kaget mingguan bagi warga Sukarame."));

        // ===== Jalur Hijau =====
        daftarRTH.add(new RTH(14, "Taman UMKM Bung Karno", "Jalur Hijau",
                "Taman Kota / Jalur Hijau Edukasi", "Teluk Betung Utara",
                "Jl. Gatot Subroto",
                "24 Jam (Kuliner hanya Sabtu & Minggu pagi)",
                "Patung Bung Karno, pedestrian lebar, bangku taman, lampu hias kota",
                "Sangat baik dan tertata rapi",
                "Jalur hijau yang disulap menjadi taman tematik dan pusat wisata kuliner UMKM setiap akhir pekan."));

        // ===== Taman Pemakaman =====
        daftarRTH.add(new RTH(15, "Taman Makam Pahlawan (TMP) Tanjung Karang", "Taman Pemakaman",
                "Taman Pemakaman (Khusus)", "Kedaton",
                "Jl. Teuku Umar",
                "07.00 - 16.00 (Untuk peziarah umum)",
                "Gerbang monumen, plaza upacara, taman simetris rapi, jalur pejalan kaki paving block",
                "Sangat baik, bersih, dan terawat ketat",
                "Kompleks pemakaman pahlawan kemerdekaan yang berfungsi sebagai RTH pasif kota."));
        daftarRTH.add(new RTH(16, "TPU Beringin Raya", "Taman Pemakaman",
                "Tempat Pemakaman Umum", "Kemiling",
                "Kawasan Kelurahan Beringin Raya",
                "24 Jam",
                "Lahan pemakaman blok, akses jalan masuk, area parkir kendaraan",
                "Cukup baik (sangat luas)",
                "Salah satu pemakaman umum terluas kelolaan pemkot untuk kebutuhan zona barat."));
        daftarRTH.add(new RTH(17, "TPU Kamboja", "Taman Pemakaman",
                "Tempat Pemakaman Umum", "Tanjung Senang",
                "Kelurahan Labuhan Dalam",
                "24 Jam",
                "Area pemakaman muslim/non-muslim teratur, vegetasi pohon pelindung",
                "Cukup baik",
                "Menopang kebutuhan lahan pemakaman bagi warga di wilayah timur laut kota."));
        daftarRTH.add(new RTH(18, "TPU Kebon Jahe", "Taman Pemakaman",
                "Tempat Pemakaman Umum", "Tanjung Karang Pusat",
                "Kelurahan Kebon Jahe",
                "24 Jam",
                "Area pemakaman umum, akses jalan setapak, gerbang masuk",
                "Cukup padat namun teratur",
                "Salah satu makam umum tertua dan bersejarah yang terletak di area pusat kota Bandar Lampung."));
    }

    // FITUR a: Daftar RTH
    static void tampilDaftar(ArrayList<RTH> list) {
        if (list.isEmpty()) {
            System.out.println("RTH tidak ditemukan.");
            return;
        }
        System.out.println("\n--- Daftar RTH ---");
        for (int i = 0; i < list.size(); i++) {
            RTH r = list.get(i);
            System.out.println(r.getId() + ". " + r.getNama() + " | " + r.getKategori()
                    + " | Kec. " + r.getKecamatan());
        }
    }

    // FITUR b: Pencarian RTH berdasarkan nama
    static void cariRTH() {
        System.out.print("Ketik nama RTH: ");
        String kata = input.nextLine().trim().toLowerCase();
        ArrayList<RTH> hasil = new ArrayList<>();
        for (RTH r : daftarRTH) {
            if (r.getNama().toLowerCase().contains(kata)) {
                hasil.add(r);
            }
        }
        tampilDaftar(hasil);
    }

    // FITUR c: Filter jenis RTH
    static void filterJenis() {
        System.out.println("1. Taman Kota");
        System.out.println("2. Hutan Kota");
        System.out.println("3. Lapangan dan Alun-alun");
        System.out.println("4. Jalur Hijau");
        System.out.println("5. Taman Pemakaman");
        int pilihan = bacaAngka("Pilih jenis: ");

        String jenis = "";
        switch (pilihan) {
            case 1: jenis = "Taman Kota"; break;
            case 2: jenis = "Hutan Kota"; break;
            case 3: jenis = "Lapangan dan Alun-alun"; break;
            case 4: jenis = "Jalur Hijau"; break;
            case 5: jenis = "Taman Pemakaman"; break;
            default: System.out.println("Pilihan tidak valid."); return;
        }

        ArrayList<RTH> hasil = new ArrayList<>();
        for (RTH r : daftarRTH) {
            if (r.getKategori().equals(jenis)) {
                hasil.add(r);
            }
        }
        tampilDaftar(hasil);
    }

    // FITUR d: Detail RTH, lalu pilihan Laporkan Masalah
    static void detailRTH() {
        tampilDaftar(daftarRTH);
        int id = bacaAngka("Masukkan nomor RTH: ");

        RTH terpilih = null;
        for (RTH r : daftarRTH) {
            if (r.getId() == id) {
                terpilih = r;
            }
        }
        if (terpilih == null) {
            System.out.println("RTH tidak ditemukan.");
            return;
        }

        System.out.println("\n=== DETAIL RTH: " + terpilih.getNama() + " ===");
        System.out.println(terpilih.getInfo());

        System.out.print("\nLaporkan masalah di RTH ini? (y/n): ");
        if (input.nextLine().trim().equalsIgnoreCase("y")) {
            buatLaporan(terpilih);
        }
    }

    // FITUR e dan f: Formulir pelaporan + Kode laporan
    static void buatLaporan(RTH rth) {
        System.out.println("\n--- Formulir Laporan ---");
        System.out.println("RTH yang dilaporkan: " + rth.getNama() + " (terisi otomatis)");
        System.out.println("1. Fasilitas rusak  2. Sampah menumpuk  3. Lampu mati");
        System.out.println("4. Tanaman tidak terawat  5. Lainnya");
        int k = bacaAngka("Pilih kategori masalah: ");

        String kategori;
        switch (k) {
            case 1: kategori = "Fasilitas rusak"; break;
            case 2: kategori = "Sampah menumpuk"; break;
            case 3: kategori = "Lampu mati"; break;
            case 4: kategori = "Tanaman tidak terawat"; break;
            default: kategori = "Lainnya";
        }

        System.out.print("Keterangan singkat: ");
        String keterangan = input.nextLine().trim();
        while (keterangan.isEmpty()) {
            System.out.print("Keterangan wajib diisi: ");
            keterangan = input.nextLine().trim();
        }

        System.out.print("Nama (opsional, Enter untuk lewati): ");
        String nama = input.nextLine().trim();
        System.out.print("Kontak (opsional, Enter untuk lewati): ");
        String kontak = input.nextLine().trim();
        System.out.print("Tautan/nama file foto (opsional, Enter untuk lewati): ");
        String foto = input.nextLine().trim();

        if (nama.isEmpty()) nama = "Anonim";
        if (kontak.isEmpty()) kontak = "-";
        if (foto.isEmpty()) foto = "Tidak ada foto";

        String kode = "LP" + String.format("%03d", daftarLaporan.size() + 1);
        daftarLaporan.add(new Laporan(kode, rth, kategori, keterangan, nama, kontak, foto));

        System.out.println("\n>>> Laporan Anda sudah diterima.");
        System.out.println(">>> KODE LAPORAN : " + kode);
        System.out.println(">>> Status awal   : Diterima");
        System.out.println(">>> Simpan kode ini untuk mengecek status laporan.");
    }

    // FITUR g: Cek status laporan
    static void cekStatus() {
        System.out.print("Masukkan kode laporan: ");
        Laporan l = cariLaporan(input.nextLine().trim());
        if (l == null) {
            System.out.println("Laporan dengan kode tersebut tidak ditemukan.");
        } else {
            System.out.println("\n=== STATUS LAPORAN ===");
            System.out.println(l.getRingkasan());
        }
    }

    static Laporan cariLaporan(String kode) {
        for (Laporan l : daftarLaporan) {
            if (l.getKode().equalsIgnoreCase(kode)) {
                return l;
            }
        }
        return null;
    }

    // FITUR h: Informasi dan edukasi
    static void edukasi() {
        System.out.println("\n=== INFORMASI & EDUKASI RTH ===");
        System.out.println("MANFAAT RTH");
        System.out.println("- Menjaga kualitas udara dan menurunkan suhu kota");
        System.out.println("- Menyerap air hujan sehingga mengurangi genangan");
        System.out.println("- Tempat warga berolahraga dan bersantai");
        System.out.println("\nJENIS RTH");
        System.out.println("Taman kota, hutan kota, lapangan dan alun-alun, jalur hijau, taman pemakaman");
        System.out.println("\nTIPS MENJAGA RTH");
        System.out.println("- Buang sampah pada tempatnya");
        System.out.println("- Jangan merusak tanaman dan fasilitas");
        System.out.println("- Laporkan kerusakan lewat TamanKu");
    }

    // Demo: pengelola mengubah status (peran di luar aplikasi warga)
    static void simulasiPengelola() {
        System.out.print("[Demo] Masukkan kode laporan: ");
        Laporan l = cariLaporan(input.nextLine().trim());
        if (l == null) {
            System.out.println("Laporan dengan kode tersebut tidak ditemukan.");
            return;
        }
        System.out.println("1. Diproses  2. Selesai");
        int p = bacaAngka("Ubah status ke: ");
        if (p == 1) {
            l.setStatus("Diproses");
        } else if (p == 2) {
            l.setStatus("Selesai");
        }
        System.out.println("Status sekarang: " + l.getStatus());
    }

    // Membaca angka; mengulang jika input bukan angka
    static int bacaAngka(String pesan) {
        while (true) {
            System.out.print(pesan);
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
    }
}

