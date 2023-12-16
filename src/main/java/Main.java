import java.sql.*;

public class Main {
    private static final DatabaseProperties properties = PropertiesFactory.getProperties();

    public void main(String[] args) {
        try {

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(properties.getUrl(), properties.getLogin(), properties.getPassword());

            if (connection != null) {
                getData(connection, "audit_department");
            } else {
                System.out.println("not connected");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getData(Connection connection, String table) {
        Statement statement = null;
        ResultSet result = null;

        try {
            String query = "SELECT * FROM " + table;
            statement = connection.createStatement();
            result = statement.executeQuery(query);

            System.out.print("Ревизионный номер изделия| ");
            System.out.print("Тип изделия| ");
            System.out.println("Адрес расположения");

            while (result.next()) {
                System.out.print(result.getString("Ревизионный номер изделия") + "| ");
                System.out.print(result.getString("Тип изделия") + "| ");
                System.out.print(result.getString("Адрес расположения"));
            }

        } catch (Exception e) {
            System.out.println("error");
        }
    }



}

