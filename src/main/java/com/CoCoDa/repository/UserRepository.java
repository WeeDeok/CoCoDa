package com.CoCoDa.repository;

import com.CoCoDa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String>  {
    


}
