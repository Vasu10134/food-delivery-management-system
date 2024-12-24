import java.sql.*;

public class DatabaseHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/food_delivery";
    private static final String USER = "root";
    private static final String PASSWORD = "password";  // Replace with your actual MySQL password

    // Establish connection to the database
    public Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Insert a new user into the database
    public void insertUser(String username, String password) {
        String query = "INSERT INTO Users (username, password) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            System.out.println("User registered successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert a new order for a user
    public void insertOrder(int userId, String items) {
        String query = "INSERT INTO Orders (user_id, items, status) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, items);
            stmt.setString(3, "Pending");
            stmt.executeUpdate();
            System.out.println("Order placed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get orders by a specific user
    public void getOrdersByUser(int userId) {
        String query = "SELECT * FROM Orders WHERE user_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                String items = rs.getString("items");
                String status = rs.getString("status");
                System.out.println("Order ID: " + orderId + ", Items: " + items + ", Status: " + status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
