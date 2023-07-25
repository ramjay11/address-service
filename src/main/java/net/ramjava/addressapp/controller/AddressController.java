package net.ramjava.addressapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.ramjava.addressapp.response.AddressResponse;
import net.ramjava.addressapp.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse>etAddressByEmployeeId(@PathVariable("employeeId") int id) {
		// Make a DB call
		AddressResponse addressResponse = null;
		// Service call
		addressService.findAddressByEmployeeId(id);
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}
}
