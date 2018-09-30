package com.dao;

import java.util.List;

import com.model.Pet;
import com.model.User;

public interface DaoInterface {
	boolean create(User user);
	boolean read(User user);
	boolean update(User user, int petId);
	boolean delete(String userId);
	String readLogin(User user);
	boolean savePet(Pet pet);
	List<Pet> readPet();
	List<Pet> readPet(User user);
}
