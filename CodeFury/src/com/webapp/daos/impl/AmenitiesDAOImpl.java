package com.webapp.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webapp.daos.AmenitiesDAO;
import com.webapp.exceptions.ConnectionNotCreatedException;
import com.webapp.models.Amenities;
import com.webapp.utilities.ConnectionUtility;

public class AmenitiesDAOImpl implements AmenitiesDAO {

	private PreparedStatement ps;
	private Connection conn;
	private ConnectionUtility connectionDB;
	
	public AmenitiesDAOImpl() {
		connectionDB=new ConnectionUtility();
	}
	
	@Override
	public int getCost(String amenityId) {
		int cost=-1;
		final String SQL="select cost from amenities where amenityId";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					cost= rs.getInt("cost");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return cost;
			}
			finally {
				connectionDB.closeConnection(conn);
			}
			}
		catch(ConnectionNotCreatedException error) {
			error.printStackTrace();
			return cost;
		}
		return cost;
	}

	@Override
	public boolean addAmenity(Amenities amenity) {
		final String SQL="insert into amenities(amenityName,cost) values (?,?)";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setString(1, amenity.getAmenityName());
				ps.setInt(2, amenity.getCost());
				int cnt=ps.executeUpdate();
				if(cnt!=0) {
					System.out.println("### Record Added to the table ###");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			finally {
				connectionDB.closeConnection(conn);
			}
			}
		catch(ConnectionNotCreatedException error) {
			error.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean changeCost(int newCost, int amenityId) {
		final String SQL="update amenities set cost=? where amenityId=?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, newCost);
				ps.setInt(2, amenityId);
				int cnt=ps.executeUpdate();
				if(cnt!=0) {
					System.out.println("### Record Added to the table ###");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			finally {
				connectionDB.closeConnection(conn);
			}
			}
		catch(ConnectionNotCreatedException error) {
			error.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Amenities> getAmenityList() {
		List<Amenities> amenities=new ArrayList<>();
		final String SQL="select * from amenities";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ResultSet rs =ps.executeQuery();
				while (rs.next()) {
					Amenities ameenityItem =new Amenities();
					ameenityItem.setAmenityId(rs.getInt("amenityId"));
					ameenityItem.setAmenityName(rs.getString("amenityName"));
					ameenityItem.setCost(rs.getInt("cost"));
					amenities.add(ameenityItem);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connectionDB.closeConnection(conn);
			}
			}
		catch(ConnectionNotCreatedException error) {
			error.printStackTrace();
		}
		return amenities;
	}

	public Amenities getAmenityInfo(int amenityId) {
		Amenities amenity =new Amenities();
		final String SQL="select * from amenities where amenityId=?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, amenityId);
				ResultSet rs=ps.executeQuery();
				if (rs.next()) {
					amenity.setAmenityId(rs.getInt("amenityId"));
					amenity.setAmenityName(rs.getString("amenityName"));
					amenity.setCost(rs.getInt("cost"));}
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				connectionDB.closeConnection(conn);
			}
		}
	catch(ConnectionNotCreatedException error) {
		error.printStackTrace();
	}
		
	return amenity;
	}
}
