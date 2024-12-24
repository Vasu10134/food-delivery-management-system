import java.sql.*;

public class FoodDeliverySystem {

    public static void main(String[] args) {
        DatabaseHelper dbHelper = new DatabaseHelper();
        
        // Register a new user
        dbHelper.insertUser("john_doe", "password123");

        // Place an order for a user (user_id = 1)
        dbHelper.insertOrder(1, "Pizza, Fries");

        // Retrieve and print order details for a user (user_id = 1)
        dbHelper.getOrdersByUser(1);
    }
}
