package dbdz;

import dbdz.config.DatabaseProperties;
import dbdz.config.PropertiesFactory;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class Main {

    private static final DatabaseProperties properties = PropertiesFactory.getProperties();
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(properties.getUrl(), properties.getLogin(), properties.getPassword());
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM audit_department");
                System.out.printf("'%-20s'", "ревизионный номер");
                System.out.printf("'%-20s'", "Тип изделия");
                System.out.printf("'%-20s' %n", "адрес");
                while (rs.next()) {
                    System.out.printf("'%-20s'", rs.getString(1));
                    System.out.printf("'%-20s'", rs.getString(2));
                    System.out.printf("'%-20s' %n", rs.getString(3));
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}