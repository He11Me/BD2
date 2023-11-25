import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/training_hw_5", "postgres", "pass");
            if (connection != null) {
                System.out.println("Connected");
                getData(connection);
            } else {
                System.out.println("not connected");
            }
        } catch (Exception var2) {
            System.out.println(var2.getMessage());
        }
    }

    private static void getData(Connection connection) {
        Statement statement = null;
        ResultSet result = null;

        try {
            String query = "SELECT * FROM " + "audit_department";
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            System.out.print("Ревизионный номер изделия| ");
            System.out.print("Тип изделия| ");
            System.out.println("Адрес расположения");

            while(result.next()) {
                System.out.print(result.getString("Ревизионный номер изделия") + "| ");
                System.out.print(result.getString("Тип изделия") + "| ");
                System.out.print(result.getString("Адрес расположения"));
            }
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }

    }
}
