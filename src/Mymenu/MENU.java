package Mymenu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import all_forms.CustomerForm;
import all_forms.OrderForm;
import all_forms.PaymentForm;
import all_forms.ProductForm;
import all_forms.ShippingForm;

public class MENU extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu Customermenu;
    private JMenu Ordermenu;
    private JMenu Paymentmenu;
    private JMenu Productmenu;
    private JMenu Shippingmenu;
    private JMenu Logoutmenu;
    


	public MENU() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem CustomerItem;
    private JMenuItem OrderItem;
    private JMenuItem PaymentItem;
    private JMenuItem ProductItem;
    private JMenuItem ShippingItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public MENU(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        Customermenu = new JMenu("Customer");
        Ordermenu = new JMenu("Order");
        Paymentmenu= new JMenu("Payment");
        Productmenu = new JMenu("Product ");
        Shippingmenu = new JMenu("Shipping");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(Customermenu);
        CustomerItem = new JMenuItem("CustomerForm");
        CustomerItem.addActionListener(this);
        
        menuBar.add(Ordermenu);
        OrderItem = new JMenuItem("OrderForm");
        OrderItem.addActionListener(this);
        
        menuBar.add(Paymentmenu);
        PaymentItem = new JMenuItem("PaymentForm");
        PaymentItem.addActionListener(this);
        
        menuBar.add(Productmenu);
        ProductItem = new JMenuItem("ProductForm");
        ProductItem.addActionListener(this);
        
        menuBar.add(Shippingmenu);
        ShippingItem = new JMenuItem("ShippingForm");
        ShippingItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        Customermenu.add(CustomerItem);
        Ordermenu.add(OrderItem);
        Paymentmenu.add(PaymentItem);
        Productmenu.add(ProductItem);
        Shippingmenu.add(ShippingItem);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\mahoro chany\\Desktop\\New folder\\Bluesky.jpg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
      
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CustomerItem) {
            new CustomerForm();
        
        } else if (e.getSource() == OrderItem) {
            new OrderForm();
        
        } else if (e.getSource() == PaymentItem) {
            new PaymentForm();
       
        } else if (e.getSource() == ProductItem) {
           new ProductForm();
        
        } else if (e.getSource() == ShippingItem) {
           new ShippingForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MENU("TO ONLINE COAT AND PAINT SELLING"));
    }
}





