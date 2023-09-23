package com.example.coop.controller;

import com.example.coop.model.StaffModel;
import com.example.coop.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/Staff")
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping
    public List<StaffModel>getData() {
        return staffRepository.findAll();
    }

    @PostMapping
    public StaffModel addStaff(@RequestBody StaffModel staffModel){
        return staffRepository.save(staffModel);
    }
}
