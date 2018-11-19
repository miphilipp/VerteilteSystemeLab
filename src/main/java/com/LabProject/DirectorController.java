package com.LabProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

interface DirectorRepository extends CrudRepository<Director, Integer> { 
    Iterable<Director> findAllByName(String name);
}

/**
 * DirectorController
 */
@RestController
public class DirectorController {

    @Autowired
    DirectorRepository directorRepo;
    
    @RequestMapping("/director")
    public Iterable<Director> getAllDirectors() {
        return directorRepo.findAll();
    }
}