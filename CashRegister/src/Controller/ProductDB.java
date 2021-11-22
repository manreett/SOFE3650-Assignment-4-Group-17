package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Model.Product;
import View.Display;

public class ProductDB {
	
	ArrayList<Product> products;
	String upc;
	public ProductDB() throws IOException
	{
		products=new ArrayList<Product>();
		 File file = new File("products.txt");
		       
		        BufferedReader br= new BufferedReader(new FileReader(file));
		        String st;
		        while ((st = br.readLine()) != null)
		        {
		            String arr[]=st.split(" ");
		            products.add(new Product(arr[0],arr[1],Integer.parseInt(arr[2])));
		        }
	}
	
	public void setCurrentProductUPC(String upc)
	{
		this.upc=upc;
	}
	
	public Product getCurrentProduct()
	{
		for(int i=0;i<products.size();i++)
		{
			if(upc.equals(products.get(i).getBarcode()))
			{
				return products.get(i);
			}
		}
		return null;
	}
		
	
	
}
