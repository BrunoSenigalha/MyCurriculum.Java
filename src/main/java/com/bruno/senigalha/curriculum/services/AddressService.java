package com.bruno.senigalha.curriculum.services;

import com.bruno.senigalha.curriculum.entities.Address;
import com.bruno.senigalha.curriculum.entities.Curriculum;
import com.bruno.senigalha.curriculum.repositories.AddressRepository;
import com.bruno.senigalha.curriculum.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> findAll() {
        return repository.findAll();
    }

    public Address findById(Long id) {
        Optional<Address> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Address insert(Address obj) {
        return repository.save(obj);
    }

    public Address update(Long id, Address obj) {
        return repository.findById(id)
                .map(entity ->
                {
                    updateData(entity, obj);
                    return repository.save(entity);
                })
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    private void updateData(Address entity, Address obj) {
        entity.setZipCode(obj.getZipCode());
        entity.setState(obj.getState());
        entity.setCity(obj.getCity());
        entity.setCountry(obj.getCountry());
    }

}
