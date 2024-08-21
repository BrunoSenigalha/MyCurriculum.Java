package com.bruno.senigalha.curriculum.repositories;

import com.bruno.senigalha.curriculum.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
