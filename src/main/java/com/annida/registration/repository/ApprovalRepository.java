package com.annida.registration.repository;

import com.annida.registration.model.Approval;
import com.annida.registration.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApprovalRepository extends JpaRepository<Approval, String> {

//    @Query("SELECT a FROM Approval a WHERE a.ticketNumber = :ticketNumber")
//    Approval getByTicketNumber(String ticketNumber);

    Optional<Approval> findByTicketNumber(String ticketNumber);
}
