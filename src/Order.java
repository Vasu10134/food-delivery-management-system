public class Order {
    private int orderId;
    private int userId;
    private String items;
    private String status;

    public Order(int orderId, int userId, String items, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.items = items;
        this.status = status;
    }

    // Getters and setters for order details
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
