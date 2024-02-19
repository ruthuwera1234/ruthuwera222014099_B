package all_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Order {
    private int order_id;
    private String customer_id;
    private String order_date;

    public Order(int order_id, String customer_id, String order_date) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
    }

    public Order() {
        // Default constructor
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public void makeConnection() {
        // Implement connection logic if needed
    }

    public void insertData() {
        String host = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
        String user = "root";
        String password = "";

        String sql = "INSERT INTO orders (customer_id, order_date) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setString(1, this.customer_id);
            preparedStatement.setString(2, this.order_date);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to insert data.");
                JOptionPane.showMessageDialog(null, "Failed to insert data!", "After insert", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet viewData() {
        String host = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
        String user = "root";
        String password = "";

        String sql = "SELECT * FROM orders";

        try (Connection con = DriverManager.getConnection(host, user, password);
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(int inputOrder_id) {
        String url = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
        String user = "root";
        String password = "";

        String sql = "UPDATE orders SET customer_id=?, order_date=? WHERE order_id=?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, this.getCustomer_id());
            stm.setString(2, this.getOrder_date());
            stm.setInt(3, inputOrder_id);

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data updated successfully!");
                JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to update data. No matching record found.");
                JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found!", "After update", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int inputOrder_id) {
        String url = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
        String user = "root";
        String password = "";

        String sql = "DELETE FROM orders WHERE order_id=?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pl = con.prepareStatement(sql)) {

            pl.setInt(1, inputOrder_id);

            int rowsAffected = pl.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully!");
                JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to delete data. No matching record found.");
                JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found!", "After delete", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
