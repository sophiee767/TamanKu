package com.mycompany.tamanku;

import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// MAIN CLASS GUI JavaFX - TamanKu
public class TamanKuFX extends Application {

    private ArrayList<RTH> daftarRTH = new ArrayList<>();
    private ArrayList<Laporan> daftarLaporan = new ArrayList<>();
    private ArrayList<RTH> sedangTampil = new ArrayList<>();

    private ListView<String> listView = new ListView<>();
    private TextField tfCari = new TextField();
    private ComboBox<String> cbJenis = new ComboBox<>();

    @Override
    public void start(Stage stage) {
        isiDataRTH();

        TabPane tabPane = new TabPane(buatTabDaftar(), buatTabStatus(), buatTabEdukasi());
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        stage.setTitle("TamanKu - Informasi dan Pelaporan RTH Kota Bandar Lampung");
        stage.setScene(new Scene(tabPane, 760, 520));
        stage.show();
    }

    // Data RTH Kota Bandar Lampung (instansiasi Object)
    private void isiDataRTH() {
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

    // ===== Tab 1: Daftar RTH, Pencarian, Filter jenis, Detail =====
    private Tab buatTabDaftar() {
        tfCari.setPromptText("Cari nama RTH...");
        cbJenis.getItems().addAll("Semua jenis", "Taman Kota", "Hutan Kota",
                "Lapangan dan Alun-alun", "Jalur Hijau", "Taman Pemakaman");
        cbJenis.setValue("Semua jenis");

        // Event Handling: tombol dihubungkan dengan logika program
        Button btnCari = new Button("Cari / Filter");
        btnCari.setOnAction(e -> perbaruiDaftar());

        Button btnDetail = new Button("Lihat Detail");
        btnDetail.setOnAction(e -> lihatDetail());

        HBox atas = new HBox(10, tfCari, cbJenis, btnCari);
        VBox isi = new VBox(10, atas, listView, btnDetail);
        isi.setPadding(new Insets(15));
        VBox.setVgrow(listView, Priority.ALWAYS);

        perbaruiDaftar();
        return new Tab("Daftar RTH", isi);
    }

    // Menampilkan daftar RTH sesuai kata pencarian dan kategori yang dipilih
    private void perbaruiDaftar() {
        String kata = tfCari.getText().trim().toLowerCase();
        String jenis = cbJenis.getValue();

        sedangTampil.clear();
        listView.getItems().clear();

        for (RTH r : daftarRTH) {
            boolean cocokNama = r.getNama().toLowerCase().contains(kata);
            boolean cocokJenis = jenis.equals("Semua jenis") || r.getKategori().equals(jenis);
            if (cocokNama && cocokJenis) {
                sedangTampil.add(r);
                listView.getItems().add(r.getRingkas());
            }
        }

        if (sedangTampil.isEmpty()) {
            listView.getItems().add("RTH tidak ditemukan.");
        }
    }

    // Detail RTH (pop up Alert) dengan tombol Laporkan Masalah
    private void lihatDetail() {
        int index = listView.getSelectionModel().getSelectedIndex();
        if (index < 0 || index >= sedangTampil.size()) {
            peringatan("Pilih salah satu RTH dari daftar terlebih dahulu.");
            return;
        }

        RTH rth = sedangTampil.get(index);
        ButtonType tombolLapor = new ButtonType("Laporkan Masalah");
        Alert popup = new Alert(Alert.AlertType.INFORMATION, rth.getInfo(),
                tombolLapor, ButtonType.CLOSE);
        popup.setTitle("Detail RTH");
        popup.setHeaderText(rth.getNama());
        popup.getDialogPane().setPrefWidth(620);

        Optional<ButtonType> hasil = popup.showAndWait();
        if (hasil.isPresent() && hasil.get() == tombolLapor) {
            formLaporan(rth);
        }
    }

    // ===== Formulir pelaporan (GridPane) + kode laporan =====
    private void formLaporan(RTH rth) {
        Stage form = new Stage();
        form.setTitle("Formulir Laporan");

        ComboBox<String> cbKategori = new ComboBox<>();
        cbKategori.getItems().addAll("Fasilitas rusak", "Sampah menumpuk",
                "Lampu mati", "Tanaman tidak terawat", "Lainnya");
        cbKategori.setValue("Fasilitas rusak");

        TextArea taKeterangan = new TextArea();
        taKeterangan.setPromptText("Keterangan singkat (wajib)");
        taKeterangan.setPrefRowCount(3);

        TextField tfNama = new TextField();
        tfNama.setPromptText("Opsional");
        TextField tfKontak = new TextField();
        tfKontak.setPromptText("Opsional, nomor HP (angka saja)");
        TextField tfFoto = new TextField();
        tfFoto.setPromptText("Opsional, tautan/nama file foto");

        Button btnKirim = new Button("Kirim Laporan");

        // Layout GridPane
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15));
        grid.add(new Label("RTH yang dilaporkan"), 0, 0);
        grid.add(new Label(rth.getNama() + " (terisi otomatis)"), 1, 0);
        grid.add(new Label("Kategori masalah"), 0, 1);
        grid.add(cbKategori, 1, 1);
        grid.add(new Label("Keterangan *"), 0, 2);
        grid.add(taKeterangan, 1, 2);
        grid.add(new Label("Nama"), 0, 3);
        grid.add(tfNama, 1, 3);
        grid.add(new Label("Kontak"), 0, 4);
        grid.add(tfKontak, 1, 4);
        grid.add(new Label("Foto"), 0, 5);
        grid.add(tfFoto, 1, 5);
        grid.add(btnKirim, 1, 6);

        // Event Handling + Validasi
        btnKirim.setOnAction(e -> {
            String keterangan = taKeterangan.getText().trim();
            String nama = tfNama.getText().trim();
            String kontak = tfKontak.getText().trim();
            String foto = tfFoto.getText().trim();

            // Validasi 1: kolom wajib tidak boleh kosong
            if (keterangan.isEmpty()) {
                peringatan("Keterangan wajib diisi.");
                return;
            }

            // Validasi 2: kontak (jika diisi) harus berupa angka
            if (!kontak.isEmpty()) {
                try {
                    Long.parseLong(kontak);
                } catch (NumberFormatException ex) {
                    peringatan("Kontak harus berupa angka (nomor HP).");
                    return;
                }
            }

            if (nama.isEmpty()) nama = "Anonim";
            if (kontak.isEmpty()) kontak = "-";
            if (foto.isEmpty()) foto = "Tidak ada foto";

            String kode = "LP" + String.format("%03d", daftarLaporan.size() + 1);
            daftarLaporan.add(new Laporan(kode, rth, cbKategori.getValue(),
                    keterangan, nama, kontak, foto));

            info("Laporan Terkirim", "Laporan Anda sudah diterima.\n\n"
                    + "KODE LAPORAN: " + kode + "\n"
                    + "Status awal: Diterima\n\n"
                    + "Simpan kode ini untuk mengecek status laporan.");
            form.close();
        });

        form.setScene(new Scene(grid, 520, 400));
        form.show();
    }

    // ===== Tab 2: Cek status laporan =====
    private Tab buatTabStatus() {
        TextField tfKode = new TextField();
        tfKode.setPromptText("Masukkan kode laporan, contoh: LP001");

        TextArea hasil = new TextArea();
        hasil.setEditable(false);

        Button btnCek = new Button("Cek Status");
        btnCek.setOnAction(e -> {
            String kode = tfKode.getText().trim();
            if (kode.isEmpty()) {
                peringatan("Kode laporan belum diisi.");
                return;
            }
            Laporan l = cariLaporan(kode);
            if (l == null) {
                hasil.setText("Laporan dengan kode tersebut tidak ditemukan.");
            } else {
                hasil.setText(l.getRingkasan());
            }
        });

        // Tombol demo
        Button btnProses = new Button("Demo: ubah ke Diproses");
        btnProses.setOnAction(e -> ubahStatus(tfKode.getText().trim(), "Diproses", hasil));
        Button btnSelesai = new Button("Demo: ubah ke Selesai");
        btnSelesai.setOnAction(e -> ubahStatus(tfKode.getText().trim(), "Selesai", hasil));

        Label catatan = new Label("Tombol demo hanya meniru pengelola "
                + "(di luar aplikasi warga).");

        HBox tombol = new HBox(10, btnCek, btnProses, btnSelesai);
        VBox isi = new VBox(10, tfKode, tombol, hasil, catatan);
        isi.setPadding(new Insets(15));
        VBox.setVgrow(hasil, Priority.ALWAYS);
        return new Tab("Cek Status Laporan", isi);
    }

    private Laporan cariLaporan(String kode) {
        for (Laporan l : daftarLaporan) {
            if (l.getKode().equalsIgnoreCase(kode)) {
                return l;
            }
        }
        return null;
    }

    private void ubahStatus(String kode, String statusBaru, TextArea hasil) {
        if (kode.isEmpty()) {
            peringatan("Kode laporan belum diisi.");
            return;
        }
        Laporan l = cariLaporan(kode);
        if (l == null) {
            hasil.setText("Laporan dengan kode tersebut tidak ditemukan.");
        } else {
            l.setStatus(statusBaru);
            hasil.setText(l.getRingkasan());
        }
    }

    // ===== Tab 3: Informasi dan edukasi =====
    private Tab buatTabEdukasi() {
        TextArea teks = new TextArea(
                "MANFAAT RTH\n"
              + "- Menjaga kualitas udara dan menurunkan suhu kota\n"
              + "- Menyerap air hujan sehingga mengurangi genangan\n"
              + "- Tempat warga berolahraga dan bersantai\n\n"
              + "JENIS RTH\n"
              + "Taman kota, hutan kota, lapangan dan alun-alun, jalur hijau, taman pemakaman\n\n"
              + "TIPS MENJAGA RTH\n"
              + "- Buang sampah pada tempatnya\n"
              + "- Jangan merusak tanaman dan fasilitas\n"
              + "- Laporkan kerusakan lewat TamanKu");
        teks.setEditable(false);
        teks.setWrapText(true);

        VBox isi = new VBox(teks);
        isi.setPadding(new Insets(15));
        VBox.setVgrow(teks, Priority.ALWAYS);
        return new Tab("Informasi & Edukasi", isi);
    }

    // ===== Pop up Alert =====
    private void info(String judul, String pesan) {
        Alert a = new Alert(Alert.AlertType.INFORMATION, pesan, ButtonType.OK);
        a.setTitle(judul);
        a.setHeaderText(judul);
        a.showAndWait();
    }

    private void peringatan(String pesan) {
        Alert a = new Alert(Alert.AlertType.WARNING, pesan, ButtonType.OK);
        a.setTitle("Peringatan");
        a.setHeaderText("Periksa kembali");
        a.showAndWait();
    }
}