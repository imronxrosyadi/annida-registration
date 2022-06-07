package com.annida.registration.repository;

import com.annida.registration.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {

    @Query("SELECT p FROM Profile p WHERE p.email = :email")
    Profile getByEmail(String email);

}
