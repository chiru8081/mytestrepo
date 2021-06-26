package com.product.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductratingserviceImpl {

	public String addProduct(Userbean bean) {
		
		Connection con=null;
		PreparedStatement ps_add=null;
		
		try {
			
			con=JDBCHelper.getConnection();
			if(con==null)
				return null;
			else
			{
				ps_add=con.prepareStatement("insert into product_user(patientname,productname,rating) values(?,?,?)");
				ps_add.setString(1, bean.getPatientname());
				ps_add.setString(2, bean.getProductname());
				ps_add.setInt(3, bean.getRating());
				ps_add.execute();
			    return Constants.SUCCESS;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return "unable to add " +e.getMessage();
		}
		finally
		{
			JDBCHelper.close(ps_add);
			JDBCHelper.close(con);
			
		}
	}
	
	public List<Userbean> getAllProducts(){
		
		List<Userbean> list=new ArrayList<Userbean>();
		
		Connection con=null;
		PreparedStatement ps_sel=null;
		ResultSet rs=null;
		try {
			
			con=JDBCHelper.getConnection();
			if(con==null)
				return null;
			else
			{
				ps_sel=con.prepareStatement("select * from product_user");
				ps_sel.execute();
				
				rs=ps_sel.getResultSet();
				
				while(rs.next())
				{
					Userbean bean=new Userbean();
					bean.setPatientname(rs.getString("patientname"));
					bean.setProductname(rs.getString("productname"));
					bean.setRating(rs.getInt("rating"));
					list.add(bean);
					System.out.println("patientname " + bean.getPatientname() + " productname " + bean.getProductname() + " rating " + bean.getRating());
					
				}
				
			}
			ps_sel.execute();
			return list;
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		finally {
			
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
			JDBCHelper.close(rs);
		}
		
}
	
	public String updateRating(Userbean bean) {
		
		Connection con=null;
		PreparedStatement ps_upd=null;
		
		try {
			con=JDBCHelper.getConnection();
			if(con==null)
				return null;
			else
			{
				ps_upd=con.prepareStatement("update product_user set rating=? where productname=?");
				
				if(bean.getRating()<=5) {
					 ps_upd.setInt(1, bean.getRating());
				}
				else
				{
					System.out.println("Rating should be within 5 "+bean.getPatientname());
				}
			   
				ps_upd.setString(2, bean.getProductname());
			    ps_upd.executeUpdate();
			    return Constants.UPDSUCCESS;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			return "unable to add " +e.getMessage();
		}
		finally
		{
			JDBCHelper.close(con);
			JDBCHelper.close(ps_upd);
		}
	}
	
	public String avgRating() {
		
		Connection con=null;
		PreparedStatement ps_avg=null;
		ResultSet rs=null;
		String rate = null;
		try {
			
			con=JDBCHelper.getConnection();
			if(con==null)
				return null;
			else
			{
				
				ps_avg=con.prepareStatement("select avg(rating) from product_user");
				rs=ps_avg.executeQuery();
				if(rs.next())
				{
					rate=rs.getString("avg(rating)");
					System.out.println(rate);
					
				}
				return rate;
			    
			    
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			return "unable to add " +e.getMessage();
		}
		finally
		{
			JDBCHelper.close(con);
			JDBCHelper.close(ps_avg);
			JDBCHelper.close(rs);
		}
	}
	

    public List<String> getcountofRatings(){
		
		List<String> list=new ArrayList<String>();
		
		Connection con=null;
		PreparedStatement ps_ct=null;
		ResultSet rs=null;
		try {
			
			con=JDBCHelper.getConnection();
			if(con==null)
				return null;
			else
			{
				ps_ct=con.prepareStatement("SELECT rating,count(rating) from product_user group by rating");
				
				
				rs=ps_ct.executeQuery();
				
				while(rs.next())
				{
					
					//String one=rs.getString("rating");
					String two=rs.getString("count(rating)");
					//list.add(one);
					list.add(two);
					
					System.out.println(" count " + list.add(two));
					
				}
				
			}
			return list;
			
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		finally {
			
			JDBCHelper.close(ps_ct);
			JDBCHelper.close(con);
			JDBCHelper.close(rs);
		}
		
  }
	
	
}
