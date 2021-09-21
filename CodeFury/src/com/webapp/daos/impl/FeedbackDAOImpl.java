package com.webapp.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webapp.daos.FeedbackDAO;
import com.webapp.exceptions.ConnectionNotCreatedException;
import com.webapp.exceptions.InvalidRatingException;
import com.webapp.models.Feedback;
import com.webapp.utilities.ConnectionUtility;

public class FeedbackDAOImpl implements FeedbackDAO {
	
	private PreparedStatement ps;
	private Connection conn;
	private ConnectionUtility connectionDB;
	public FeedbackDAOImpl() {
		connectionDB=new ConnectionUtility();
	}
	
	@Override
	public boolean addRoomFeedback(Feedback obj) {
		final String SQL="insert into feedback(userId,meetingRoomName,rating) values (?,?,?)";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, obj.getSubmitter().getUserId());
				ps.setString(2, obj.getRoomInfo().getMeetingRoomName());
				int rating=obj.getRating();
				if (rating<0 || rating>6) {
					throw new InvalidRatingException();
				}
				ps.setInt(3,rating);
				System.out.println(ps.toString());
				int cnt=ps.executeUpdate();
				if(cnt!=0) {
					System.out.println("### Record Added to the table ###");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			catch(InvalidRatingException err) {
				err.printStackTrace();
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
	public double getAvgFeedback(String meetingRoomName) {
		double result = 0.0;
		final String SQL="select sum(rating) as totalRating,count(userId) as count from feedback where meetingRoomName=?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setString(1, meetingRoomName);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					int totalRating = rs.getInt("totalRating");
					int count= rs.getInt("count");
					result= (double) totalRating/count;
					System.out.println("### Record Added to the table ###");
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
		return result;
	}

	@Override
	public List<Feedback> getFeedbackByUser(int userId) {
		
		List<Feedback> feedbacks=new ArrayList<>();
		final String SQL="select name,rating,meetingRoomName,users.userId,feedbackId from feedback inner join users on users.userId = feedback.userId where feedback.userId= ?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, userId);
				ResultSet rs =ps.executeQuery();
				while (rs.next()) {
					Feedback feedback =new Feedback();
					feedback.setFeedbackId(rs.getInt("feedbackId"));
					feedback.getRoomInfo().setMeetingRoomName(rs.getString("meetingRoomName"));
					feedback.setRating(rs.getInt("rating"));
					feedback.getSubmitter().setUserId(rs.getInt("users.userId"));
					feedback.getSubmitter().setName(rs.getString("name"));
					feedbacks.add(feedback);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			} catch (InvalidRatingException e) {
				e.printStackTrace();
			}
			finally {
				connectionDB.closeConnection(conn);
			}
			}
		catch(ConnectionNotCreatedException error) {
			error.printStackTrace();
		}
		return feedbacks;

	}

	@Override
	public List<Feedback> getFeedbackByRoom(String meetingRoomName) {
		
		List<Feedback> feedbacks=new ArrayList<>();
		final String SQL="select name,rating,meetingRoomName,users.userId,feedbackId from feedback inner join users on users.userId = feedback.userId where meetingRoomName= ?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setString(1, meetingRoomName);
				System.out.println(ps.toString());
				ResultSet rs =ps.executeQuery();
				while (rs.next()) {
					Feedback feedback =new Feedback();
					feedback.setFeedbackId(rs.getInt("feedbackId"));
					feedback.getRoomInfo().setMeetingRoomName(rs.getString("meetingRoomName"));
					feedback.setRating(rs.getInt("rating"));
					feedback.getSubmitter().setUserId(rs.getInt("users.userId"));
					feedback.getSubmitter().setName(rs.getString("name"));
					feedbacks.add(feedback);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			} catch (InvalidRatingException e) {
				e.printStackTrace();
			}
			finally {
				connectionDB.closeConnection(conn);
			}
			}
		catch(ConnectionNotCreatedException error) {
			error.printStackTrace();
		}
		return feedbacks;

	}

	@Override
	public boolean editFeedback(Feedback obj) {
		final String SQL="update feedback set userId=?, meetingRoomName = ?,rating =? where feedbackId = ?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, obj.getFeedbackId());
				ps.setString(2, obj.getRoomInfo().getMeetingRoomName());
				int rating=obj.getRating();
				if (rating<0 || rating>6) {
					throw new InvalidRatingException();
				}
				ps.setInt(3,rating);
				ps.setInt(4, obj.getFeedbackId());
				int cnt=ps.executeUpdate();
				if(cnt!=0) {
					System.out.println("### Updated the record ###");
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			catch(InvalidRatingException err) {
				err.printStackTrace();
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
	public boolean deleteFeedback(int feedbackId) {
		final String SQL="delete from feedback where feedbackId = ?";
		try{
			System.out.println("Trying Connection");
			conn=connectionDB.createConnection();
			try {
				ps=conn.prepareStatement(SQL);
				ps.setInt(1, feedbackId);
				int cnt=ps.executeUpdate();
				if(cnt!=0) {
					System.out.println("### Deleted the record ###");
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

	
}
