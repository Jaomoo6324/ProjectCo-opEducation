package com.example.coop.repository;

import com.example.coop.model.StaffModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffModel,Long> {

}
