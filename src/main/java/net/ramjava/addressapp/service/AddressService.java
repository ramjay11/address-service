package net.ramjava.addressapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ramjava.addressapp.entity.Address;
import net.ramjava.addressapp.repo.AddressRepo;
import net.ramjava.addressapp.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AddressResponse findAddressByEmployeeId(int employeeId) {
	
		Address address = addressRepo.findAddressByEmployeeId(employeeId);
		
		// Convert entity object to response object
		AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
		return addressResponse;
	}
}
