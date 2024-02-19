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
import all_package.Shipping;

public class ShippingForm  implements ActionListener{
	JFrame frame;//customer_id	first_name	last_name	email	phone	address//int shipping_id,String order_id	,String shipping_address,String shipping_date
	JLabel shipping_id_lb=new JLabel("shipping_id ");
	JLabel order_id_lb=new JLabel("order_id");
	JLabel shipping_address_lb=new JLabel("shipping_address");
	JLabel shipping_date_lb=new JLabel("shipping_date");
	
	
	JTextField shipping_id_txf=new JTextField();
	JTextField order_id_txf=new JTextField();
    JTextField shipping_address_txf=new JTextField();
    JTextField shipping_date_txf= new JTextField();
   
    
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  ShippingForm() {
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
        frame.setTitle("Shipping_Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	shipping_id_lb.setBounds(10, 10, 200, 30);
    	order_id_lb.setBounds(10, 50, 200, 30);
    	shipping_address_lb.setBounds(10, 90, 200, 30);
    	shipping_date_lb.setBounds(10, 130, 200, 30);
    
    	
    	
    	shipping_id_txf.setBounds(200, 10, 250, 30);
    	order_id_txf.setBounds(200, 50, 250, 30);
    	shipping_address_txf.setBounds(200, 90, 250, 30);
    	shipping_date_txf.setBounds(200, 130, 250, 30);
    	
    	
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
         read_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(480, 10, 750, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	shipping_id_lb.setFont(fontLabel);
   	order_id_lb.setFont(fontLabel);
   	shipping_address_lb.setFont(fontLabel);
   	shipping_date_lb.setFont(fontLabel);
   
   	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	shipping_id_txf.setFont(fontText);
   	order_id_txf.setFont(fontText);
   	shipping_address_txf.setFont(fontText);
   	shipping_date_txf.setFont(fontText);
    
  
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(shipping_id_lb);
        frame.add(order_id_lb);
        frame.add( shipping_address_lb);
        frame.add(	shipping_date_lb);
      	
   
       
    	
        frame.add(shipping_id_txf);
        frame.add(order_id_txf);
        frame.add( shipping_address_txf);
        frame.add(shipping_date_txf);
       
         
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    public void actionPerformed(ActionEvent e) {
    	Shipping st=new Shipping();
    if (e.getSource() == insert_btn) {
        st.setShipping_address( shipping_id_txf.getText());
        st.setOrder_id(order_id_txf.getText());
        st.setShipping_address(shipping_address_txf.getText());
        st.setShipping_date(shipping_date_txf.getText());
        st.insertData();
    }
    else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("shipping_id");
        model.addColumn(" order_id");
        model.addColumn(" shipping_address");
        model.addColumn("shipping_date");
        
        
        
        ResultSet resultSet =Shipping.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4)});
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    else if (e.getSource() == update_btn) {
        int id = Integer.parseInt(shipping_id_txf.getText());
        st.setOrder_id( order_id_txf.getText());
        st.setShipping_address(shipping_address_txf.getText());
        st.setShipping_date(shipping_date_txf.getText());
        st.update(id);
    } 
    else {
        int id = Integer.parseInt(shipping_id_txf.getText());
        st.delete(id);
    }
}	
	

	public static void main(String[] args) {
		ShippingForm Shipping =new ShippingForm();

	}
	

}




