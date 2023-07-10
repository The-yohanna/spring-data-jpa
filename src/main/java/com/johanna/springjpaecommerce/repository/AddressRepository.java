package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
