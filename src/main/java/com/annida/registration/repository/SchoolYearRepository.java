package com.annida.registration.repository;

import com.annida.registration.model.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SchoolYearRepository extends JpaRepository<SchoolYear, String> {

}
