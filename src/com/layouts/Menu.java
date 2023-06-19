package com.layouts;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.controllers.dbController;
import com.config.MyConfig;

public class Menu {
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        int choice;

        System.out.println("--------------------------------");
        System.out.println("WELCOME TO ......");
        System.out.println("--------------------------------");
        System.out.println("1. Read Data");
        System.out.println("2. Insert Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("--------------------------------");

        Connection connection = null;
            connection = MyConfig.getConnection();
            dbController dbController = new dbController(connection);

            while (true) {
                System.out.print("Pilih: ");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        ReadData produkReader = new ReadData(dbController);
                        produkReader.readData();
                        break;
                    case 2:
                        InsertData produkWriter = new InsertData(dbController);
                        produkWriter.insertData();
                        break;
                    case 3:
                        EditData produkEditor = new EditData(dbController);
                        produkEditor.editData();
                        break;
                    case 4:
                        DeleteData produkDeleter = new DeleteData(dbController);
                        produkDeleter.deleteData();
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia");
                        break;
                }
            }
        }
    }
