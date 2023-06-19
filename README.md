# App.java

`App.java` adalah kelas yang berisi metode `App` untuk menjalankan aplikasi.
Terdapat objek
```java
main(String[] args)
```

Metode utama yang menjalankan 

```java
Menu.main(args)
```
untuk memulai aplikasi.

# com
terdapat beberapa package di dalamnya, yaitu:
1. config
2. controllers
3. layouts
4. models


## 1. config
`MyConfig.java` adalah kelas yang bertanggung jawab untuk membuat koneksi ke database menggunakan JDBC.

### Metode dalam `MyConfig.java`
```java
getConnection()
```
-> Membuat koneksi dengan database menggunakan URL, username, dan password yang telah ditentukan.

# 2. controllers
`dbContrroller.java` adalah kelas yang bertanggung jawab untuk mengelola koneksi, pernyataan, dan hasil set data dalam operasi database.

### Metode dalam `dbController`
```java
closeConnection();
executeQuery(String query)
executeUpdate(String query)
```
-> Menutup koneksi, pernyataan, dan hasil set data.
-> Mengeksekusi pernyataan SQL untuk mengambil data dari database.
-> Mengeksekusi pernyataan SQL untuk memperbarui data dalam database.

# 3. Layouts
terdapat 5 class pada file ini yaitu 
- `Menu.java` 
- `ReadData.java` 
- `InsertData.java`
- `EditData.java` 
- `DeleteData.java`

## ReadData.java
`ReadData.java` adalah kelas yang bertanggung jawab untuk membaca dan mencetak data dari tabel `TB_PRODUK` ke konsol.

### Metode dalam `ReadData.java`
```java
readData();
```
-> Mengeksekusi pernyataan SQL untuk mengambil data dari tabel `TB_PRODUK` dan mencetaknya ke konsol.

## EditData.java
`EditData.java` adalah kelas yang bertanggung jawab untuk mengubah data dalam tabel `TB_PRODUK`.

### Metode dalam `EditData.java`
```java
editData();
```
-> Meminta input pengguna untuk ID data yang akan diubah, serta nilai baru untuk NAMA, HARGA, dan JUMLAH. Mengeksekusi pernyataan SQL untuk mengubah data dalam tabel `TB_PRODUK`.

## InserData.java
`InsertData.java` adalah kelas yang bertanggung jawab untuk memasukkan data baru ke dalam tabel `TB_PRODUK`.

### Metode dalam `InsertData.java`
```java
insertData();
```
-> Meminta pengguna untuk memasukkan data baru, kemudian mengeksekusi pernyataan SQL untuk memasukkan data tersebut ke dalam tabel `TB_PRODUK`.

## DeleteData.java
`DeleteData.java` adalah kelas yang bertanggung jawab untuk menghapus data dari tabel `TB_PRODUK`.

### Metode dalam `DeleteData.java`
```java
deleteData();
```
-> Meminta input pengguna untuk ID data yang akan dihapus, kemudian mengeksekusi pernyataan SQL untuk menghapus data dari tabel `TB_PRODUK`.

## Menu.java

`Menu.java` adalah kelas utama yang berfungsi sebagai antarmuka pengguna untuk mengakses fitur-fitur CRUD pada tabel `TB_PRODUK`.

### Metode dalam `Menu.java`
Terdapat objek 
```java
main(String[] args)
```
-> Metode utama yang berfungsi sebagai titik masuk program. Menampilkan menu pilihan dan menerima input pengguna untuk memilih operasi yang diinginkan.

# 4. models
`Produk.java` adalah kelas yang merepresentasikan objek produk dalam aplikasi.

### Properti

- id`: ID produk.
- `name`: Nama produk.
- `price`: Harga produk.
- `stock`: Jumlah stok produk.

### Metode
- Metode setter dan getter untuk setiap properti.


