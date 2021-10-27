package com.directkart.epizza.repository;

import com.directkart.epizza.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAddressRepository extends JpaRepository<Address, String> {
    @Override
    Optional<Address> findById(String addressId);
}
