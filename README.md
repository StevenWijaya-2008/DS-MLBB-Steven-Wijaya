# Laporan Praktikum: Struktur Data Tree - MLBB Build Simulator

##  Deskripsi Proyek
Proyek ini menggunakan struktur data General Tree untuk mensimulasikan sistem build item dalam game Mobile Legends: Bang Bang. Program ini menunjukkan bagaimana item jadi (Tier 3) dibentuk dari sub-item (Tier 2) dan item mentahan dasar (Tier 1).



##  Observation Questions (Jawaban)

1. **What is the root node in this program?**
   Root node adalah item final atau Item Jadi yang berada di posisi paling atas dalam struktur, seperti **Immortality**, **Radiant Armor**, atau **Fleeting Time**.

2. **Which nodes are leaf nodes?**
   Leaf nodes adalah item mentahan paling dasar (Tier 1) yang tidak memiliki anak/komponen lagi di bawahnya, seperti **Vitality Crystal**, **Leather Jerkin**, dan **Magic Resist Cloak**.

3. **Why is `children` stored as a `List<ItemNode>` instead of a single variable?**
   Karena dalam MLBB, satu item seringkali membutuhkan lebih dari satu bahan untuk dibuat (misalnya sebuah item butuh 2 atau 3 komponen sekaligus). Menggunakan `List` memungkinkan satu node memiliki banyak anak (General Tree).

4. **What is the difference between a linear structure and a tree structure in this example?**
   Struktur linear (seperti Array) hanya bisa menampilkan daftar item secara berurutan tanpa tahu hubungannya. Struktur tree menampilkan hierarki dan ketergantungan (item mana yang harus dibeli untuk membuat item lainnya).

5. **How does recursion help when working with trees?**
   Rekursi memudahkan penelusuran seluruh cabang pohon tanpa peduli seberapa dalam levelnya. Program cukup memanggil dirinya sendiri untuk setiap anak node hingga mencapai ujung (leaf).

6. **What path is printed when searching for `Corrosion Scythe`?**
   Program saya tidak memuat `corrosionScytheRecipe`, karena saya fokus dalam item defense.

---

##  Take Home Tasks Results

### Task 1: New Branch Addition
Saya telah menambahkan cabang baru untuk item-item pertahanan dan serangan lainnya (seperti *Blade Armor* dan *Queen's Wings*) ke dalam menu utama.

### Task 2: Method `countItemOccurrences()`
Berhasil mengimplementasikan logika untuk menghitung item duplikat.
* Contoh: Mencari berapa banyak `Vitality Crystal` yang dibutuhkan dalam satu resep besar.

### Task 3: Method `printPathsEndingWith()`
Berhasil membuat filter jalur. Jika pengguna mencari jalur yang berakhir di `Immortality`, program hanya akan menampilkan urutan build yang berujung pada item tersebut.

### Task 4: Scanner Input
Program sekarang menerima input dari user melalui terminal untuk memilih item yang ingin dianalisis atau mencari komponen tertentu.

### Task 5: Depth & Height Observation
Menambahkan level baru pada resep (misal: Tier 1 -> Tier 2 -> Tier 3) secara otomatis meningkatkan nilai


## Reflection 
Penggunaan struktur data Tree jauh lebih efektif dibandingkan Array dalam merepresentasikan build item karena kemampuannya menggambarkan hubungan hierarkis dan dependensi antar-komponen. Dalam Array, data tersimpan secara linear sehingga kita kehilangan informasi tentang item mana yang menjadi bahan baku bagi item lainnya. Dengan Tree, kita dapat melihat dengan jelas keterkaitan antara item Tier 1, Tier 2, hingga menjadi item final di Tier 3, yang secara akurat mencerminkan mekanisme crafting dalam game.

Bagian tersulit sekaligus paling mencerahkan dalam praktikum ini adalah saat mengimplementasikan teknik Backtracking pada metode pencarian jalur. Memahami bagaimana program mundur dan menghapus jejak pada list path saat menemui jalan buntu membantu saya memvisualisasikan cara kerja stack dalam rekursi secara nyata. Tantangan terbesar yang saya hadapi adalah melakukan tracing manual pada item dengan banyak komponen duplikat, hal ini menuntut ketelitian tinggi untuk membedakan alur eksekusi pada cabang-cabang yang memiliki nama node yang sama namun berada pada tingkat kedalaman yang berbeda.