package services;

import entities.Stores;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.StoreRepository;

import java.util.List;
@Service
public class StoreService {
    @Autowired
    private final StoreRepository storeRepository;
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
    public List<Stores> findAll() {
        return storeRepository.findAll();
    }
    public Stores findById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Store not found with id :" + id));
    }
    public Stores save(Stores store) {
        return storeRepository.save(store);
    }
    public void delete(Long id) {
        storeRepository.deleteById(id);
    }
}
