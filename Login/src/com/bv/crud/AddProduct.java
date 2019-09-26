package com.bv.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bv.products.ProductHandler;
import com.bv.products.Products;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String productname=request.getParameter("productname");
		String manufacturername=request.getParameter("manufacturername");
		Double price=Double.parseDouble(request.getParameter("price"));
	
		String man_date=request.getParameter("manufacturedate");
		
		
		
		Products products = new Products();
		products.setProductname(productname);
		products.setManufacturername(manufacturername);
		products.setPrice(price);
		
		
		 SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy");
         
		java.util.Date udob = null;
		try {
			udob= sdf1.parse(man_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		 java.sql.Date sqdob = new java.sql.Date(udob.getTime());
        products.setManufactureDate(sqdob);
		int status = ProductHandler.addProducts(products);
		if(status>0)
		{
			out.print("<h2>Records inserted successfully!!!</h2>");
			out.print("<a href='View'>ViewProducts</a>");
			
		}
		else
		{
			out.print("Error! in inserting the records");
		}
		out.print("                                         <a href='display.jsp'>Home</a>");
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
