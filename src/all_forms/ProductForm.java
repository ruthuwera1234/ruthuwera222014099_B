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

import all_package.Product;


public class ProductForm implements ActionListener{
	JFrame frame;//Product{//product_id	product_name	price	stock_quantity
	JLabel product_id_lb=new JLabel("product_id");
	JLabel product_name_lb=new JLabel("product_name");
	JLabel price_lb=new JLabel("price");
	JLabel stock_quantity_lb=new JLabel("stock_quantity");
	
	JTextField product_id_txf=new JTextField();
	JTextField product_name_txf=new JTextField();
    JTextField price_txf=new JTextField();
    JTextField stock_quantity_txf= new JTextField();
  
    JButton insert_btn = new JButton("INSERT");
    JButton read_btn = new JButton("VIEW");
    JButton update_btn = new JButton("UPDATE");
    JButton delete_btn = new JButton("DELETE");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int w = (int) screensize.getWidth();
    int h = (int) screensize.getWidth();

    public  ProductForm() {
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
        frame.setTitle("CP_Form");
        frame.setBounds(0, 0, w / 2, h / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    private void setLocationAndSize() {
    	product_id_lb.setBounds(10, 10, 200, 30);
    	product_name_lb.setBounds(10, 50, 200, 30);
    	price_lb.setBounds(10, 90, 200, 30);
    	stock_quantity_lb.setBounds(10, 130, 200, 30);
    	
    	 product_id_txf.setBounds(200, 10, 250, 30);
    	 product_name_txf.setBounds(200, 50, 250, 30);
    	 price_txf.setBounds(200, 90, 250, 30);
    	 stock_quantity_txf.setBounds(200, 130, 250, 30);
    	 
    	 
    	 insert_btn.setBounds(10, 250, 85, 30);
         read_btn.setBounds(100,  250, 85, 30);
         update_btn.setBounds(190,  250, 85, 30);
         delete_btn.setBounds(280,  250, 85, 30);
         table.setBounds(480, 10, 750, 200);
     	}
    private void setFontForAll() {
   	Font fontLabel = new Font("Georgia", Font.BOLD, 18);
   	product_id_lb.setFont(fontLabel);
   	product_name_lb.setFont(fontLabel);
   	price_lb.setFont(fontLabel);
   	stock_quantity_lb.setFont(fontLabel);
     	 
   	
   	Font fontText = new Font("Georgia", Font.BOLD, 18);
   	product_id_txf.setFont(fontText);
   	product_name_txf.setFont(fontText);
   	price_txf.setFont(fontText);
   	stock_quantity_txf.setFont(fontText);
   
       Font fontButtonItalic = new Font("Courier New", Font.ITALIC, 12);
       insert_btn.setFont(fontButtonItalic);
       read_btn.setFont(fontButtonItalic);
       update_btn.setFont(fontButtonItalic);
       delete_btn.setFont(fontButtonItalic);
   }
    private void addComponentToFrame() {
    	frame.add(product_id_lb);
        frame.add(product_name_lb);
        frame.add( price_lb);
        frame.add(stock_quantity_lb);
        
    	
        frame.add(product_id_txf);
        frame.add(product_name_txf);
        frame.add( price_txf);
        frame.add(stock_quantity_txf);
        
       
        //Buttons CRUD
        frame.add(insert_btn);
        frame.add(read_btn);
        frame.add(update_btn);
        frame.add(delete_btn);
        frame.add(table);
    }
    public void actionPerformed(ActionEvent e) {
    	Product st=new Product();
    if (e.getSource() == insert_btn) {
        st.setProduct_name( product_name_txf.getText());
        st.setPrice(price_txf.getText());
        st.setStock_quantity(stock_quantity_txf.getText());
        st.insertData();
    }
    else if (e.getSource() == read_btn) {
        model.setColumnCount(0);
        model.setRowCount(1);
        model.addColumn("product_id");
        model.addColumn(" product_name");
        model.addColumn(" price");
        model.addColumn("stock_quantity");
      
        
        ResultSet resultSet =Product.viewData();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                            resultSet.getString(3), resultSet.getString(4) });
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    else if (e.getSource() == update_btn) {
        int id = Integer.parseInt(product_id_txf.getText());
        st.setProduct_name( product_name_txf.getText());
        st.setPrice(price_txf.getText());
        st.setStock_quantity(stock_quantity_txf.getText());
        
        st.update(id);
    } 
    else {
        int id = Integer.parseInt(product_id_txf.getText());
        st.delete(id);
    }
}	
	

	public static void main(String[] args) {
		ProductForm prodf=new ProductForm();

	}
	

}

