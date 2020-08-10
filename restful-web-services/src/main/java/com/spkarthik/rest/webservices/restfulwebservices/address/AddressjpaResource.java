package com.spkarthik.rest.webservices.restfulwebservices.address;

import java.util.List;
import java.net.URI;

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
public class AddressjpaResource {
	
	@Autowired
	private AddressHardcodedService addressService;
	
	@Autowired
	private addressJpaRepository addresJpaRepository;
	
	@GetMapping("/jpa/users/{username}/address")
	public List<address> getAllAddress(@PathVariable String username){
		return addresJpaRepository.findByUsername(username);
		//return addressService.findAll();
		
	}
	@GetMapping("/jpa/users/{username}/address/{id}")
	public address getAddress(@PathVariable String username, @PathVariable long id){
		return addresJpaRepository.findById(id).get();
		//return addressService.findById(id);
		
	}
	
	@DeleteMapping("/jpa/users/{username}/address/{id}")
	public ResponseEntity<Void> deleteAddress(
			@PathVariable String username, @PathVariable long id){
		
		addresJpaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		
		

	
	@PutMapping("/jpa/users/{username}/address/{id}")
	public ResponseEntity<address> updateAddress(
			@PathVariable String username, 
			@PathVariable long id, @RequestBody address addres){
		
		addres.setUsername(username);
		
		address addresUpdated = addresJpaRepository.save(addres);
		return new ResponseEntity<address>(addres, HttpStatus.OK);
	
   }
	
	@PostMapping("/jpa/users/{username}/address")
	public ResponseEntity<Void> createAddress(
			@PathVariable String username, 
			@RequestBody address addres){
		
		addres.setUsername(username);
		
		address createdaddress = addresJpaRepository.save(addres);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(createdaddress.getId()).toUri();
		
		
		return ResponseEntity.created(uri).build();
	
   }
}
