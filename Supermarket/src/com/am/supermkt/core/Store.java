package com.am.supermkt.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Store {
	public Store() {
		super();
		try {
			readCsv();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	List<Product> productList;
	
	public List<Product> getProductList() {
		return productList;
	}

	public void readCsv() throws IOException{
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src/resource/store.csv"));
		
		String line;
		productList = new ArrayList<Product>();
		while ((line = br.readLine()) != null) {
             String[] row = line.split(",");

             System.out.println("prodName="+ row[0] + " code=" + row[1] + " , cost=" + row[2] + "]");
             Product product = new Product();
             product.setProductName(row[0]);
             product.setProductCode(row[1]);
             float price = Float.parseFloat(row[2].substring(1));
             product.setProductPrice(price);
             productList.add(product);
         }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br.close();
	}
	
	public Product retrieveProduct(String code) throws Exception{
		if(code == null){
			throw new Exception("Invalid code");
		}
		Iterator<Product> ite = productList.iterator();
		while(ite.hasNext()){
			Product p = (Product) ite.next();
			String pCode = p.getProductCode();
			if (pCode.equalsIgnoreCase(code)){
				return p;
			}
		}
		return null;
	}
	
	public float retrieveProductPriceByCode(String code) throws Exception{
		if(code == null){
			throw new Exception("Invalid code");
		}
		Iterator<Product> ite = productList.iterator();
		while(ite.hasNext()){
			Product p = (Product) ite.next();
			String pCode = p.getProductCode();
			if (pCode.equalsIgnoreCase(code)){
				return p.getProductPrice();
			}
		}
		return 0;
	}
	
	public float retrieveProductPriceByName(String name){
		Iterator<Product> ite = productList.iterator();
		while(ite.hasNext()){
			Product p = (Product) ite.next();
			String pName = p.getProductName();
			if (pName.equalsIgnoreCase(name)){
				return p.getProductPrice();
			}
		}
		return 0;
	}
	
	public static void main(String[] arg) {
		Store c = new Store();
		try {
			c.readCsv();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
