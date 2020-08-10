package com.spkarthik.rest.webservices.restfulwebservices.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AddressResource {
	
	@Autowired
	private AddressHardcodedService addressService;
	
	@GetMapping("/users/{username}/address")
	public List<address> getAllAddress(@PathVariable String username){
		return addressService.findAll();
		
	}
	@GetMapping("/users/{username}/address/{id}")
	public address getAddress(@PathVariable String username, @PathVariable long id){
		return addressService.findById(id);
		
	}
	
	@DeleteMapping("/users/{username}/address/{id}")
	public ResponseEntity<Void> deleteAddress(
			@PathVariable String username, @PathVariable long id){
		address addres = addressService.deleteById(id);
		if(addres != null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/users/{username}/address/{id}")
	public ResponseEntity<address> updateAddress(
			@PathVariable String username, @PathVariable long id, @RequestBody address addres){
		address addresUpdated = addressService.save(addres);
		return new ResponseEntity<address>(addres, HttpStatus.OK);
	
   }
	
	@PostMapping("/users/{username}/address")
	public ResponseEntity<Void> updateAddress(
			@PathVariable String username, @RequestBody address addres){
		address createdaddress = addressService.save(addres);
		
		
		
		
		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(createdaddress.getId()).toUri();
		
		
		return ResponseEntity.created(uri).build();
	
   }
}
