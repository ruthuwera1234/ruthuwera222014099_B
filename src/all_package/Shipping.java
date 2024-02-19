package all_package;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Shipping {//	customer_id	first_name	last_name	email	phone	address
	private  int  shipping_id;
	private String  order_id;
	private String shipping_address;
	private String shipping_date;

	
	 
	public Shipping(int shipping_id,String order_id	,String shipping_address,String shipping_date) {
		super();
		this.shipping_id=shipping_id;
		this.order_id=order_id;
		this.shipping_address=shipping_address;
		this.shipping_date=shipping_date;
		
		
		}
	
	
	public Shipping() {
		// TODO Auto-generated constructor stub
	}


	
	public int getShipping_id() {
		return shipping_id;
	}


	public void setShipping_id(int shipping_id) {
		this.shipping_id = shipping_id;
	}


	public String getOrder_id() {
		return order_id;
	}


	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}


	public String getShipping_address() {
		return shipping_address;
	}


	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}


	public String getShipping_date() {
		return shipping_date;
	}


	public void setShipping_date(String shipping_date) {
		this.shipping_date = shipping_date;
	}



	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO shipping_information(order_id,shipping_address,shipping_date)VALUES(?,?,?)";
		
	    try (
	        // Establish the connection
	        java.sql.Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.order_id);
	       preparedStatement.setString(2, this.shipping_address);
	       preparedStatement.setString(3, this.shipping_date);
	      
	       
	      
	  
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

		        String sql = "SELECT * FROM shipping_information";

		        try {
		            java.sql.Connection con = DriverManager.getConnection(host, user, password);
		            java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
			
			

		    public void update(int inputshipping_id) {
		        String url = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
		        String user = "root";
		        String password = "";

		        String sql = "UPDATE shipping_information SET order_id=?, shipping_address=?, shipping_date=?  WHERE shipping_id=?";

		        try (java.sql.Connection con = DriverManager.getConnection(url, user, password);
		             java.sql.PreparedStatement stm = con.prepareStatement(sql)) {

		            stm.setString(1, this.getOrder_id());
		            stm.setString(2, this.getShipping_address());
		            stm.setString(3, this.getShipping_date());
		           
		        
		            stm.setInt(4, inputshipping_id);

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

		    public void delete(int inputshipping_id) {
		        String url = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
		        String user = "root";
		        String password = "";

		        String sql = "DELETE FROM shipping_information WHERE shipping_id=?";

		        try (java.sql.Connection con = DriverManager.getConnection(url, user, password);
		             java.sql.PreparedStatement pl = con.prepareStatement(sql)) {

		            pl.setInt(1, inputshipping_id);

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

