package com.spkarthik.rest.webservices.restfulwebservices.address;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AddressHardcodedService {
	
	private static List<address> addresses = new ArrayList<address>();
	private static long idCounter = 0;
	
	static {
		addresses.add(new address(++idCounter, "spkarthik", "Atma", "Qtr No.40", "Street Krishna Nagar", 943589132, "Ajmer", 88932));
	
	}
	
	public List<address> findAll(){
		return addresses;
	}
	
	public address save(address addres) {
		if(addres.getId()==-1 ||addres.getId()==0  ) {
			addres.setId(++idCounter);
			addresses.add(addres);
		}else {
			deleteById(addres.getId());
			addresses.add(addres);
		}
		return addres;
	}
	
	public address deleteById(long id) {
		address addres = findById(id);
		if(addres == null) return null;
		
		if(addresses.remove(addres)) {
			return addres;
		}
		
		return null;
	}

	public address findById(long id) {
		for(address addres:addresses) {
			if(addres.getId() == id) {
				return addres;
			}
		}
		return null;
	}

}


