package com.layouts;

import java.sql.SQLException;
import java.util.Scanner;

import com.controllers.dbController;

public class EditData {
    private dbController dbController;

    public EditData(dbController dbController) {
        this.dbController = dbController;
    }

    public void editData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID data yang akan diubah: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan nilai baru untuk NAMA: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan nilai baru untuk HARGA: ");
        double price = scanner.nextDouble();

        System.out.print("Masukkan nilai baru untuk JUMLAH: ");
        int stock = scanner.nextInt();

        try {
            String query = "UPDATE `TB_PRODUK` SET `NAMA` = '" + name + "', `HARGA` = " + price + ", `JUMLAH` = " + stock + " WHERE `TB_PRODUK`.`ID` = " + id;
            dbController.executeUpdate(query);
            System.out.println("Data berhasil diperbarui");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}

