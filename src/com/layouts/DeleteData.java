package com.layouts;

import java.sql.SQLException;
import java.util.Scanner;

import com.controllers.dbController;

public class DeleteData {
    private dbController dbController;

    public DeleteData(dbController dbController) {
        this.dbController = dbController;
    }

    public void deleteData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID yang ingin dihapus: ");
        int id = scanner.nextInt();

        try {
            String query = "DELETE FROM `TB_PRODUK` WHERE `ID` = " + id;
            dbController.executeUpdate(query);
            System.out.println("Data berhasil dihapus");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
