
	package all_package;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import javax.swing.JOptionPane;

	public class Product{//product_id	product_name	price	stock_quantity
		private int product_id;
		private String product_name;
		private String price;
		private String stock_quantity;
	
		
		 
		public Product(int product_id,String product_name,String price,String stock_quantity) {
			super();
			this.product_id=product_id;
			this.product_name=product_name;
			this.price=price;
			this.stock_quantity=stock_quantity;
			
			}
		

		public Product() {
			// TODO Auto-generated constructor stub
		}


		public int getProduct_id() {
			return product_id;
		}


		public void setProduct_id(int product_id) {
			this.product_id = product_id;
		}


		public String getProduct_name() {
			return product_name;
		}


		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}


		public String getPrice() {
			return price;
		}


		public void setPrice(String price) {
			this.price = price;
		}


		public String getStock_quantity() {
			return stock_quantity;
		}


		public void setStock_quantity(String stock_quantity) {
			this.stock_quantity = stock_quantity;
		}


		public void makeconnection() {
		}
				public void insertData() {
			// JDBC URL, username, and password of MySQL server
		    String host = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
		    String user = "root";
		    String password = "";

		    // SQL query to insert data
		    String sql = "INSERT INTO products (product_name , price, stock_quantity)VALUES(?,?,?)";
			
		    try (
		        // Establish the connection
		        Connection con = DriverManager.getConnection(host, user, password);

		        // Create a prepared statement
		    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
		    	    ) {
		        // Set the values for the prepared statement
		       preparedStatement.setString(1, this.product_name);
		       preparedStatement.setString(2, this.price);
		       preparedStatement.setString(3, this.stock_quantity);
		       
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

			        String sql = "SELECT * FROM products";

			        try {
			            Connection con = DriverManager.getConnection(host, user, password);
			            PreparedStatement preparedStatement = con.prepareStatement(sql);
			            return preparedStatement.executeQuery();
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return null;
			        }
			    }
				
				

			    public void update(int inputproduct_id) {
			        String url = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
			        String user = "root";
			        String password = "";

			        String sql = "UPDATE products SET  product_name=?,  price=?, stock_quantity=?  WHERE product_id = ?";

			        try (Connection con = DriverManager.getConnection(url, user, password);
			             PreparedStatement stm = con.prepareStatement(sql)) {

			            stm.setString(1, this.getProduct_name());
			            stm.setString(2, this.getPrice());
			            stm.setString(3, this.getStock_quantity());
			            stm.setInt(4, inputproduct_id);

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

			    public void delete(int inputproduct_id) {
			        String url = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
			        String user = "root";
			        String password = "";

			        String sql = "DELETE FROM products WHERE product_id=?";

			        try (Connection con = DriverManager.getConnection(url, user, password);
			             PreparedStatement pl = con.prepareStatement(sql)) {

			            pl.setInt(1, inputproduct_id);

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

