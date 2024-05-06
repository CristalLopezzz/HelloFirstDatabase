import java.sql.*;

public class HelloDB {
    public static void main(String[] args) throws SQLException {
    // This creates a connection to the SQLite database
        String url = "jdbc:sqlite:hello.sqlite";
        Connection connection = DriverManager.getConnection(url);

    // Executes SQL Queries
        Statement statement = connection.createStatement();

    // Creation of table
        String createTableSQL = "CREATE TABLE cats (name TEXT, age INTEGER)";
        statement.execute(createTableSQL);

    // Inserts data to the table
        String insertDataSQL = "INSERT INTO cats VALUES ('Mary', 10)";
        statement.execute(insertDataSQL);

    //Retrieves data from the table
        String getAllDataSQL = "SELECT * FROM cats";
        ResultSet allCats = statement.executeQuery(getAllDataSQL);

    // While loop that goes through list and prints each cat name and age
        while (allCats.next()) {
            String name = allCats.getString("name");
            int age = allCats.getInt("age");
            System.out.println(name + " is " + age + " years old.");
        }
    }
}