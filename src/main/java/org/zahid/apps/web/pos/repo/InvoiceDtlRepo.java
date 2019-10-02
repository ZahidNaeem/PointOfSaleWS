package org.zahid.apps.web.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zahid.apps.web.pos.entity.InvoiceDtl;

@Repository
public interface InvoiceDtlRepo extends JpaRepository<InvoiceDtl, Long> {
}
