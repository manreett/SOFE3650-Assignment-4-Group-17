package View;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Controller.ProductDB;
import Model.Product;

import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Display {
	private JTextField barCode;
	private JTextField name;
	private JTextField price;

	public Display() throws IOException
	{
		ProductDB controller=new ProductDB();
		
		JFrame frame=new JFrame("Cash App");
		frame.getContentPane().setLayout(null);
		
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(149, 106, 192, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(149, 136, 192, 20);
		
		barCode = new JTextField();
		barCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String upc=barCode.getText();
				controller.setCurrentProductUPC(upc);
				Product p=controller.getCurrentProduct();
				if(p!=null)
				{
					name.setText(p.getName());
					price.setText(Integer.toString(p.getPrice()));
				}
				else
				{
					name.setText("");
					price.setText("");
				}
			}
		});
		barCode.setBounds(149, 50, 192, 28);
		frame.getContentPane().add(barCode);
		barCode.setColumns(10);
		
		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(56, 54, 83, 20);
		frame.getContentPane().add(lblBarcode);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(56, 109, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(56, 139, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		
		frame.getContentPane().add(price);
		frame.setBounds(0, 0, 397, 215);
		frame.setVisible(true);
	}
	
	
}
