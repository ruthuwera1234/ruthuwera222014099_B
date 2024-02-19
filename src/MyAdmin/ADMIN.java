package MyAdmin;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class ADMIN {
    private String fname;
    private String lname;
    private String idNumber;
    private String phone;
    private String gender;
    private String martialStatus;
    private String DoB; // Assuming DoB stands for Date of Birth
    private String email;
    private String password;

    // Constructors

    public ADMIN() {
        // Default constructor
    }

    public ADMIN(String fname, String lname, String idNumber, String phone, String gender, String martialStatus, String DoB,
            String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.idNumber = idNumber;
        this.phone = phone;
        this.gender = gender;
        this.martialStatus = martialStatus;
        this.DoB = DoB;
        this.email = email;
        this.password = password;
    }

    public void makeConnection() {
        // JDBC URL, username, and password of MySQL server
        String host = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
        String user = "root";
        String password = "";

        try {
            // Establish the database connection
            Connection con = (Connection) DriverManager.getConnection(host, user, password);
            con.close(); // Close the connection immediately (just to test the connection)

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getDoB() {
		return DoB;
	}

	public void setDoB(String doB) {
		DoB = doB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void insertData() {
        String host = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
        String user = "root";
        String password = "";
        String sql = "INSERT INTO admin (fname, lname, id_number, phone, gender, martial_status, DoB, email, password) VALUES (?, ?, ?, ?,?,?,?,?,?)";

        try (
            // Establish the database connection
            Connection con = (Connection) DriverManager.getConnection(host, user, password);

            // Create a prepared statement
            PreparedStatement stm = con.prepareStatement(sql);
        ) {
            // Set the values for the prepared statement
            stm.setString(1, this.fname);
            stm.setString(2, this.lname);
            stm.setString(3, this.idNumber);
            stm.setString(4, this.phone);
            stm.setString(5, this.gender);
            stm.setString(6, this.martialStatus);
            stm.setString(7, this.DoB);
            stm.setString(8, this.email);
            stm.setString(9, this.password);

            // Execute the query
            int rowsAffected = stm.executeUpdate();

            // Check the result
            if (rowsAffected > 0) {
                //JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to insert data.");
                JOptionPane.showMessageDialog(null, "Failed to insert data!", "After insert", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void login() {
        makeConnection();
        String host = "jdbc:mysql://localhost/online_coat_and_paint_selling_system";
        String user = "root";
        String password = "";
        String sql = "SELECT * FROM admin WHERE email = ? AND password = ?";

        try (
            // Establish the database connection
            Connection con = (Connection) DriverManager.getConnection(host, user, password);

            PreparedStatement stm = con.prepareStatement(sql);
        ) {

            stm.setString(1, this.email);
            stm.setString(2, this.password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Logged in successfully!", "After login", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Email and password!", "After login", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
