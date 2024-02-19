package all_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Customer {//	customer_id	first_name	last_name	email	phone	address
	private int customer_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone;	
	private String address;
	
	 
	public Customer(int customer_id,String first_name,String last_name,String email,String phone,String address) {
		super();
		this.customer_id=customer_id;
		this.first_name=first_name;
		this.last_name=last_name;
		this.email=email;
		this.phone=phone;	
		this.address=address;
		}
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void makeconnection() {
	}
			public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO customers(first_name,last_name,email,phone,address)VALUES(?,?,?,?,?)";
		
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.first_name);
	       preparedStatement.setString(2, this.last_name);
	       preparedStatement.setString(3, this.email);
	       preparedStatement.setString(4, this.phone);
	       preparedStatement.setString(5, this.address);
	       
	      
	  
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

		        String sql = "SELECT * FROM customers";

		        try {
		            Connection con = DriverManager.getConnection(host, user, password);
		            PreparedStatement preparedStatement = con.prepareStatement(sql);
		            return preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return null;
		        }
		    }
			
			

		    public void update(int inputcustomer_id) {
		        String url = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
		        String user = "root";
		        String password = "";

		        String sql = "UPDATE customers SET first_name=?, last_name=?, email=?, phone=?, address=? WHERE customer_id=?";

		        try (Connection con = DriverManager.getConnection(url, user, password);
		             PreparedStatement stm = con.prepareStatement(sql)) {

		            stm.setString(1, this.getFirst_name());
		            stm.setString(2, this.getLast_name());
		            stm.setString(3, this.getEmail());
		            stm.setString(4, this.getPhone());
		            stm.setString(5, this.getAddress());
		            stm.setInt(6, inputcustomer_id);

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

		    public void delete(int inputcustomer_id) {
		        String url = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
		        String user = "root";
		        String password = "";

		        String sql = "DELETE FROM customers WHERE customer_id=?";

		        try (Connection con = DriverManager.getConnection(url, user, password);
		             PreparedStatement pl = con.prepareStatement(sql)) {

		            pl.setInt(1, inputcustomer_id);

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

