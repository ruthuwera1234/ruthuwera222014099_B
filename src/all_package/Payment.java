package all_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Payment {//payment_id	order_id	total_amount	transaction_date
	private int payment_id;
	private String order_id;
	private String total_amount;
	private String transaction_date;
	
	 
	public Payment(int payment_id,String order_id,String total_amount,String transaction_date) {
		super();
		this.payment_id=payment_id;
		this.order_id=order_id;
		this.total_amount=total_amount;
		this.transaction_date=transaction_date;
		}
	
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}


	public int getPayment_id() {
		return payment_id;
	}


	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}


	public String getOrder_id() {
		return order_id;
	}


	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}


	public String getTotal_amount() {
		return total_amount;
	}


	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}


	public String getTransaction_date() {
		return transaction_date;
	}


	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}


	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO payment_information(order_id,	total_amount, transaction_date)VALUES(?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.order_id);
	       preparedStatement.setString(2, this.total_amount);
	       preparedStatement.setString(3, this.transaction_date);
	       
	       
	      
	  
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	        	System.out.println("Data insert successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }}
			
			
	 
			public static ResultSet viewData() {
		        String host = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
		        String user = "root";
		        String password = "";

		        String sql = "SELECT * FROM payment_information";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
			
			

		    public void update(int inputpayment_id) {
		        String url = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
		        String user = "root";
		        String password = "";

		        String sql = "UPDATE payment_information SET order_id=?, total_amount=?, transaction_date=? WHERE payment_id=?";

		        try (Connection con = DriverManager.getConnection(url, user, password);
		             PreparedStatement stm = con.prepareStatement(sql)) {

		            stm.setString(1, this.getOrder_id());
		            stm.setString(2, this.getTotal_amount());
		            stm.setString(3, this.getTransaction_date());
		            
		            stm.setInt(4, inputpayment_id);

		            int rowsAffected = stm.executeUpdate();

		            if (rowsAffected > 0) {
		                System.out.println("Data updated successfully!");
		                JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                System.out.println("Failed to update data. No matching record found.");
		                JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found!", "After update", JOptionPane.INFORMATION_MESSAGE);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		    public void delete(int inputpayment_id) {
		        String url = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
		        String user = "root";
		        String password = "";

		        String sql = "DELETE FROM  payment_information WHERE payment_id=?";

		        try (Connection con = DriverManager.getConnection(url, user, password);
		             PreparedStatement pl = con.prepareStatement(sql)) {

		            pl.setInt(1, inputpayment_id);

		            int rowsAffected = pl.executeUpdate();

		            if (rowsAffected > 0) {
		                System.out.println("Data deleted successfully!");
		                JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete", JOptionPane.INFORMATION_MESSAGE);
		            } else {
		                System.out.println("Failed to delete data. No matching record found.");
		                JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found!", "After delete", JOptionPane.INFORMATION_MESSAGE);
		            }

		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}


