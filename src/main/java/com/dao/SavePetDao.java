package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.model.Pet;
import com.model.User;

public class SavePetDao implements DaoInterface {
	
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
	public boolean savePet(Pet pet) {
		PreparedStatement preparedStatement = null;
		String query="";
		Connection connection=getConnection();
		try {
			query="INSERT INTO PETS(PET_NAME,PET_AGE,PET_PLACE) VALUES(?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, pet.getPetName());
			preparedStatement.setInt(2, pet.getPetAge());
			preparedStatement.setString(3, pet.getPetPlace());
			preparedStatement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
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
	public boolean update(User user, int petId) {
		// TODO Auto-generated method stub
		return false;
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
