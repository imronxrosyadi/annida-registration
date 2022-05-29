package com.annida.registration.repository;

import com.annida.registration.model.Approval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ApprovalRepository extends JpaRepository<Approval, String> {
}
