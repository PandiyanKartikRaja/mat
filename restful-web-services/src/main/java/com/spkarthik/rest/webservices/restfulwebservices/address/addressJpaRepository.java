package com.spkarthik.rest.webservices.restfulwebservices.address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface addressJpaRepository extends JpaRepository<address, Long> {
		List<address>findByUsername(String username);

}
