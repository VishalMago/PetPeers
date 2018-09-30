package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Pet;
import com.model.User;

public class MyPetsDao implements DaoInterface{
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
	public boolean savePet(Pet pet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pet> readPet(User user) {
		PreparedStatement preparedStatement = null;
		String query="";
		ResultSet resultSet=null;
		List<Pet> petList=new ArrayList<Pet>();
		Connection connection=getConnection();
		try {
			query="SELECT * FROM PETS where PET_OWNERID=(SELECT ID FROM PET_USER WHERE USER_NAME=?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUserName());
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				Pet pet=new Pet();
				pet.setPetId(resultSet.getInt("ID"));
				pet.setPetName(resultSet.getString("PET_NAME"));
				pet.setPetAge(resultSet.getInt("PET_AGE"));
				pet.setPetPlace(resultSet.getString("PET_PLACE"));
				pet.setOwnerId(resultSet.getInt("PET_OWNERID"));
				petList.add(pet);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return petList;
	}

	@Override
	public List<Pet> readPet() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
