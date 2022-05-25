package com.terabulk.seller.controllers;

import com.terabulk.seller.models.Logo;
import com.terabulk.seller.models.Store;
import com.terabulk.seller.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/seller/store")
public class StoreController {

    @Autowired
    private StoreRepository storeRepo;

    @GetMapping("/one")
    public Store getStoreByStoreUrl(@RequestParam String storeId){ return storeRepo.findByStoreUrl(storeId); }

    @PutMapping("/changeLogo")
    public String changeLogo(@RequestParam String storeId, @RequestBody Logo logo){
        try{
            Store store = storeRepo.findByStoreUrl(storeId);
            store.setLogoImg(logo.getLogo());
            storeRepo.save(store);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }
}
