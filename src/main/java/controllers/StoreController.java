package controllers;

import entities.Stores;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.StoreRepository;
import services.StoreService;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController{
        private final StoreRepository storeRepository;
        public StoreController(StoreRepository storeRepository) {
            this.storeRepository = storeRepository;
        }
        @GetMapping
        public List<Stores> getAllStores() {
            return storeRepository.findAll();
        }
        @GetMapping("/{id}")
        public Stores getStoreById(@PathVariable Long id) {
            return storeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Store not found with id :" + id));
        }
        @PostMapping
        public Stores createStore(@RequestBody Stores store) {
            return storeRepository.save(store);
        }
        @PutMapping("/{id}")
        public Stores updateStore(@PathVariable Long id, @RequestBody Stores store) {
            Stores existingStore = storeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Store not found with id :" + id));
            existingStore.setName(store.getName());
            existingStore.setLocation (store.getLocation());
            return storeRepository.save(existingStore);
        }
        @DeleteMapping("/{id}")
        public void deleteStore(@PathVariable Long id) {
            storeRepository.deleteById(id);
        }
}
