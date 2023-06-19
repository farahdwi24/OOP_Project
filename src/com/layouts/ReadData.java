package com.layouts;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.controllers.dbController;
import com.models.Produk;

public class ReadData {
    private dbController dbController;

    public ReadData( dbController dbController) {
        this.dbController = dbController;
    }

    public void readData() {
        try {
            ResultSet resultSet = dbController.executeQuery("SELECT ID, NAMA, HARGA, JUMLAH FROM `TB_PRODUK`");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAMA");
                double price = resultSet.getDouble("HARGA");
                int stock = resultSet.getInt("JUMLAH");

                Produk product = new Produk(id, name, price, stock);
                System.out.println(product.getId() +". " + product.getName() + ": Rp." + product.getPrice() + " (" + product.getStock() + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}
