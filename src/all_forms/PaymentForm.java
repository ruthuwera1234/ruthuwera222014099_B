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

import all_package.Payment;

public class PaymentForm  implements ActionListener{
	JFrame frame;//payment_id	order_id	total_amount	transaction_date
	JLabel payment_id_lb=new JLabel("payment_id");
	JLabel order_id_lb=new JLabel("order_id");
	JLabel total_amount_lb=new JLabel("total_amount");
	JLabel transaction_date_lb=new JLabel("transaction_date");
	
	JTextField payment_id_txf=new JTextField();
	JTextField order_id_txf=new JTextField();
    JTextField total_amount_txf=new JTextField();
    JTextField transaction_date_txf=new JTextField();
    
    
    
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  PaymentForm() {
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
        frame.setTitle("Payment_Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	payment_id_lb.setBounds(10, 10, 200, 30);
    	order_id_lb.setBounds(10, 50, 200, 30);
    	total_amount_lb.setBounds(10, 90, 200, 30);
    	transaction_date_lb.setBounds(10, 130, 200, 30);
    	 
    	
    	payment_id_txf.setBounds(200, 10, 150, 30);
    	order_id_txf.setBounds(200, 50, 150, 30);
    	total_amount_txf.setBounds(200, 90, 150, 30);
    	transaction_date_txf.setBounds(200, 130, 150, 30);
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
         read_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(480, 10, 750, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	payment_id_lb.setFont(fontLabel);
   	order_id_lb.setFont(fontLabel);
   	transaction_date_lb.setFont(fontLabel);
    
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	payment_id_txf.setFont(fontText);
   	order_id_txf.setFont(fontText);
   	total_amount_txf.setFont(fontText);
   	transaction_date_txf.setFont(fontText);
    
      
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(payment_id_lb);
        frame.add(order_id_lb);
        frame.add(total_amount_lb);
        frame.add(transaction_date_lb);
        
       
    	
        frame.add(payment_id_txf);
        frame.add(order_id_txf);
        frame.add(	total_amount_txf);
        frame.add( transaction_date_txf);
        
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    public void actionPerformed(ActionEvent e) {
    	Payment st=new Payment();
    if (e.getSource() == insert_btn) {
        st.setOrder_id( order_id_txf.getText());
        st.setTotal_amount( total_amount_txf.getText());
        st.setTransaction_date(transaction_date_txf.getText());
       
        st.insertData();
    }
    else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("payment_id");
        model.addColumn(" order_id");
        model.addColumn(" total_amount");
        model.addColumn(" transaction_date");
        
        ResultSet resultSet = Payment.viewData();
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
        int id = Integer.parseInt(payment_id_txf.getText());
        st.setOrder_id( order_id_txf.getText());
        st.setTotal_amount( total_amount_txf.getText());
        st.setTransaction_date(transaction_date_txf.getText());
        
        st.update(id);
    } 
    else {
        int id = Integer.parseInt(payment_id_txf.getText());
        st.delete(id);
    }
}	
	

	public static void main(String[] args) {
		PaymentForm payment=new PaymentForm();

	}
	

}



