package com.layouts;

import java.sql.SQLException;
import java.util.Scanner;
import com.controllers.dbController;

public class InsertData {
    private dbController dbController;

    public InsertData( dbController dbController) {
        this.dbController = dbController;
    }

    public void insertData() {
        Scanner input = new Scanner(System.in);

        System.out.print("ID : ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("NAMA : ");
        String name = input.nextLine();

        System.out.print("HARGA : ");
        double price = input.nextDouble();

        System.out.print("JUMLAH : ");
        int stock = input.nextInt();

        try {
            String query = "INSERT INTO `TB_PRODUK` (`ID`, `NAMA`, `HARGA`, `JUMLAH`) VALUES ('" + id + "', '" + name + "', '" + price + "', '" + stock + "') ";
            dbController.executeUpdate(query);
            System.out.println("Data successfully inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
