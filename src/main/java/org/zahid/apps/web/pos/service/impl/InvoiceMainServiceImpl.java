package org.zahid.apps.web.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zahid.apps.web.pos.entity.InvoiceMain;
import org.zahid.apps.web.pos.exception.InvoiceMainNotFoundException;
import org.zahid.apps.web.pos.repo.InvoiceMainRepo;
import org.zahid.apps.web.pos.service.InvoiceMainService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class InvoiceMainServiceImpl implements InvoiceMainService {

    @Autowired
    private InvoiceMainRepo invoiceMainRepo;

    @Override
    public boolean exists(Long id) {
        return invoiceMainRepo.existsById(id);
    }

    @Override
    public InvoiceMain findById(Long id) {
        final Optional<InvoiceMain> invoice = invoiceMainRepo.findById(id);
        if (invoice.isPresent()) {
            return invoice.get();
        }
        throw new InvoiceMainNotFoundException("Invoice with id " + id + " not found");
    }

    @Override
    public List<InvoiceMain> getInvoices() {
        return invoiceMainRepo.findAll();
    }

    @Override
    public InvoiceMain save(InvoiceMain invoiceMain) {
        return invoiceMainRepo.save(invoiceMain);
    }

    @Override
    public List<InvoiceMain> save(Set<InvoiceMain> invoices) {
        return invoiceMainRepo.saveAll(invoices);
    }

    @Override
    public void delete(InvoiceMain invoiceMain) {
        invoiceMainRepo.delete(invoiceMain);
    }

    @Override
    public void delete(Set<InvoiceMain> invoices) {
        invoiceMainRepo.deleteAll(invoices);
    }

    @Override
    public void deleteById(Long id) {
        invoiceMainRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        invoiceMainRepo.deleteAll();
    }

    @Override
    public void deleteAllInBatch() {
        invoiceMainRepo.deleteAllInBatch();
    }

    @Override
    public void deleteInBatch(Set<InvoiceMain> invoices) {
        invoiceMainRepo.deleteInBatch(invoices);
    }
}