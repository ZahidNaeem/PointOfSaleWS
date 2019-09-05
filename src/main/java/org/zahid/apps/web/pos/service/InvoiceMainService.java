package org.zahid.apps.web.pos.service;

import org.zahid.apps.web.pos.entity.InvoiceMain;

import java.util.List;
import java.util.Set;

public interface InvoiceMainService {

    boolean exists(Long id);

    InvoiceMain findById(Long id);

    List<InvoiceMain> getInvoices();

    InvoiceMain save(InvoiceMain invoiceMain);

    List<InvoiceMain> save(Set<InvoiceMain> invoices);

    void delete(InvoiceMain invoiceMain);

    void delete(Set<InvoiceMain> invoices);

    void deleteById(Long id);

    void deleteAll();

    void deleteAllInBatch();

    void deleteInBatch(Set<InvoiceMain> invoices);
}