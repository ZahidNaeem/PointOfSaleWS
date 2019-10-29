package org.zahid.apps.web.pos.service;

import java.util.List;
import java.util.Set;
import org.zahid.apps.web.pos.entity.InvoiceDtl;

public interface InvoiceDtlService {

    boolean exists(Long id);

    List<InvoiceDtl> findAll();

    InvoiceDtl findById(Long id);

    List<InvoiceDtl> findByInvoice(Long invNum);

    InvoiceDtl save(InvoiceDtl invoiceDtl);

    List<InvoiceDtl> save(Set<InvoiceDtl> invoiceDtls);

    void delete(InvoiceDtl invoiceDtl);

    void delete(Set<InvoiceDtl> invoiceDtls);

    void deleteById(Long id);

    void deleteAll();

    void deleteAllInBatch();

    void deleteInBatch(Set<InvoiceDtl> invoiceDtls);
}
