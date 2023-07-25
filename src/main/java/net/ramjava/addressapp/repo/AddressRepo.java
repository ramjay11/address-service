package net.ramjava.addressapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.ramjava.addressapp.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	// Query address based on ID using Native SQL query
	@Query(nativeQuery = true, value="SELECT ea.id, ea.lane1, ea.lane2, ea.state, ea.Zip FROM employee_address_microservices.address ea join employee_address_microservices.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
	Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
