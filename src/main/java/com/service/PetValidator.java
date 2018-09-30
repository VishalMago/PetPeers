package com.service;

import com.dao.SavePetDao;
import com.model.Pet;


public class PetValidator {
	public boolean validate(Pet pet){
		SavePetDao savePetDao=new SavePetDao();
		if(pet.getPetAge()>0&&pet.getPetAge()<=99){
			if(savePetDao.savePet(pet)){
				return true;
			}	
		}
		return false;
	}
}
