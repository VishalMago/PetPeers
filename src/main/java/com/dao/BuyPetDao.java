package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.model.Pet;
import com.model.User;

public class BuyPetDao implements DaoInterface{
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	private static final String DB_URL = "jdbc:mysql://localhost/PETSDB";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	private Connection getConnection(){
		Connection connection=null;
		try {
			Class.forName(JDBC_DRIVER);
			connection= DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}


	@Override
	public boolean create(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean read(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User user,int petId) {
		PreparedStatement preparedStatement = null;
		String query="";
		Connection connection=getConnection();
		try {
			query="UPDATE PETS SET PET_OWNERID=(SELECT ID FROM PET_USER WHERE USER_NAME=?) WHERE ID=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setInt(2,petId);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String readLogin(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean savePet(Pet pet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pet> readPet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> readPet(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
