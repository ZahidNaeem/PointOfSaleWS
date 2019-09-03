package org.zahid.apps.web.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zahid.apps.web.pos.entity.InvoiceMain;

@Repository
public interface InvoiceMainRepo extends JpaRepository<InvoiceMain, Long> {
}
