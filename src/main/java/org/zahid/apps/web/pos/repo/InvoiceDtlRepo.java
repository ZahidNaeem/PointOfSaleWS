package org.zahid.apps.web.pos.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zahid.apps.web.pos.entity.InvoiceDtl;

@Repository
public interface InvoiceDtlRepo extends JpaRepository<InvoiceDtl, Long> {

  List<InvoiceDtl> findByInvoice(Long invNum);
}
