package all_forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import all_package.Customer;

public class CustomerForm implements ActionListener{
	JFrame frame;//customer_id	first_name	last_name	email	phone	address
	JLabel customer_id_lb=new JLabel("customer_id ");
	JLabel first_name_lb=new JLabel("first_name");
	JLabel last_name_lb=new JLabel("last_name");
	JLabel email_lb=new JLabel("email");
	JLabel phone_lb=new JLabel(" phone");
	JLabel address_lb=new JLabel(" address");
	
	JTextField customer_id_txf=new JTextField();
	JTextField first_name_txf=new JTextField();
    JTextField last_name_txf=new JTextField();
    JTextField email_txf= new JTextField();
    JTextField phone_txF=new JTextField();
    JTextField address_txF=new JTextField();
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  CustomerForm() {
    	setFontForAll();
        createForm();
        setLocationAndSize();
        addComponentToFrame();
        actionEvent();
    }
    private void actionEvent() {
        insert_btn.addActionListener((ActionListener) this);
        read_btn.addActionListener((ActionListener) this);
        update_btn.addActionListener((ActionListener) this);
        delete_btn.addActionListener((ActionListener) this);
        }
    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Customer_Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	customer_id_lb.setBounds(10, 10, 200, 30);
    	first_name_lb.setBounds(10, 50, 200, 30);
    	last_name_lb.setBounds(10, 90, 200, 30);
    	 email_lb.setBounds(10, 130, 200, 30);
    	 phone_lb.setBounds(10, 170, 200, 30);
    	 address_lb.setBounds(10, 210, 200, 30);
    	
    	 customer_id_txf.setBounds(200, 10, 250, 30);
    	 first_name_txf.setBounds(200, 50, 250, 30);
    	 last_name_txf.setBounds(200, 90, 250, 30);
    	 email_txf.setBounds(200, 130, 250, 30);
    	 phone_txF.setBounds(200, 170, 250, 30);
    	 address_txF.setBounds(200, 210, 250, 30);
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
         read_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(480, 10, 750, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	customer_id_lb.setFont(fontLabel);
    first_name_lb.setFont(fontLabel);
    last_name_lb.setFont(fontLabel);
    email_lb.setFont(fontLabel);
    phone_lb.setFont(fontLabel);
    address_lb.setFont(fontLabel);  	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	customer_id_txf.setFont(fontText);
    first_name_txf.setFont(fontText);
    last_name_txf.setFont(fontText);
    email_txf.setFont(fontText);
    phone_txF.setFont(fontText);
    address_txF.setFont(fontText);
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(customer_id_lb);
        frame.add(first_name_lb);
        frame.add( last_name_lb);
        frame.add(email_lb);
        frame.add(phone_lb);	
        frame.add(address_lb);
       
    	
        frame.add(customer_id_txf);
        frame.add(first_name_txf);
        frame.add( last_name_txf);
        frame.add(email_txf);
        frame.add(phone_txF);
        frame.add(address_txF); 
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    public void actionPerformed(ActionEvent e) {
    	Customer st=new Customer();
    if (e.getSource() == insert_btn) {
        st.setFirst_name( first_name_txf.getText());
        st.setLast_name(last_name_txf.getText());
        st.setEmail(email_txf.getText());
        st.setPhone(phone_txF.getText());
        st.setAddress(address_txF.getText());
        st.insertData();
    }
    else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("customer_id");
        model.addColumn(" first_name");
        model.addColumn(" last_name");
        model.addColumn("email");
        model.addColumn("phone");
        model.addColumn("address");
        
        ResultSet resultSet =Customer.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)
                            , resultSet.getString(6)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    else if (e.getSource() == update_btn) {
        int id = Integer.parseInt(customer_id_txf.getText());
        st.setFirst_name( first_name_txf.getText());
        st.setLast_name(last_name_txf.getText());
        st.setEmail(email_txf.getText());
        st.setPhone(phone_txF.getText());
        st.setAddress(address_txF.getText());
        st.update(id);
    } 
    else {
        int id = Integer.parseInt(customer_id_txf.getText());
        st.delete(id);
    }
}	
	

	public static void main(String[] args) {
		CustomerForm customf=new CustomerForm();

	}
	

}

