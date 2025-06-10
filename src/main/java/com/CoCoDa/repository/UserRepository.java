package com.CoCoDa.repository;

import com.CoCoDa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>  {
    
    //@Query("SELECT u FROM UserEntity u WHERE u.userid = :userId AND u.userpw = :userPw")
    @Query(value = "SELECT * FROM USER WHERE userid = :userId AND userpw = :userPw", nativeQuery = true)
    UserEntity findByUserIdAndUserPw(@Param(value = "userId") String userId, @Param(value = "userPw") String userPw);

}
