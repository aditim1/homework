package com.am.supermkt.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Store extends HttpServlet {
	
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Date date = new Date();
		out.println("<html><h2>Hi There!</h2><br/><h3>Date="+date +"</h3></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
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
	
/*	public static void main(String[] arg) {
		Store c = new Store();
		try {
			c.readCsv();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
