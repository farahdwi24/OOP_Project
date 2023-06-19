package com.controllers;

import com.models.Produk;
import com.config.MyConfig;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dbController extends MyConfig {
    
    public static List<Produk> readData() {
       connection();
        List<Produk> dataList = new ArrayList<>();
        
        try {
            statement = connect.prepareStatement("SELECT * FROM `TB_PRODUK` ");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAMA");
                int price = resultSet.getInt("HARGA");
                int stock = resultSet.getInt("JUMLAH");

                Produk product = new Produk(id, name, price, stock);
                dataList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }
    
    public static void deleteData(int id) {
        connection();

        try {
            String query = "DELETE FROM `TB_PRODUK` WHERE `TB_PRODUK`.`ID` = ?";
            statement = connect.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            updateId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    public static void insertData(String nama, long harga, int stock) {
        connection();
        try {
            resetId();
            statement = connect.prepareStatement("INSERT INTO TB_PRODUK (NAMA, HARGA, STOCK) VALUES (?, ?, ?)");
            statement.setString(1, nama);
            statement.setLong(2, harga);
            statement.setInt(3, stock);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateJumlah(int id, int stock) {
        connection();
        try {
            statement = connect.prepareStatement("UPDATE TB_PRODUK SET STOCK=? WHERE ID=?");
            statement.setInt(1, stock);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateHarga(int id, long harga) {
        connection();
        try {
            statement = connect.prepareStatement("UPDATE TB_PRODUK SET HARGA=? WHERE ID=?");
            statement.setLong(1, harga);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateNama(int id, String nama) {
        connection();
        try {
            statement = connect.prepareStatement("UPDATE TB_PRODUK SET NAMA=? WHERE ID=?");
            statement.setString(1, nama);
            statement.setInt(2, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void resetId(){
        connection();
        try{
            statement = connect.prepareStatement("ALTER TABLE `TB_PRODUK` AUTO_INCREMENT = 1");
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateId(){
        connection();
        try{
            List<Produk> dataList = readData();
            for (int i = 0; i < dataList.size(); i++){
                Produk data = dataList.get(i);
                int newId = i + 1;
                statement = connect.prepareStatement("UPDATE TB_PRODUK SET ID = ? WHERE ID = ?");
                statement.setInt(1, newId);
                statement.setInt(2, data.getId());
                statement.executeUpdate();
                statement.close();
            } 
        } catch (SQLException e){
                e.printStackTrace();
        }
    }
}

