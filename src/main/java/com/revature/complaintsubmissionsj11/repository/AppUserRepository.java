package com.revature.complaintsubmissionsj11.repository;

import com.revature.complaintsubmissionsj11.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query(value = "SELECT * FROM app_user WHERE username=:theUsername and password=:thePassword", nativeQuery = true)
    AppUser verifyLogin(@Param("theUsername") String theUsername, @Param("thePassword") String thePassword);

    List<AppUser> findByRole(String role);

    AppUser findByUsername(String username);


}
