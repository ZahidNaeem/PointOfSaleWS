package org.zahid.apps.web.pos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.zahid.apps.web.pos.dto.InvoiceDtlDTO;
import org.zahid.apps.web.pos.entity.InvoiceDtl;
import org.zahid.apps.web.pos.mapper.InvoiceDtlMapper;
import org.zahid.apps.web.pos.service.InvoiceDtlService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("invoiceDtl")
public class InvoiceDtlRestController {

    private static final Logger LOG = LogManager.getLogger(InvoiceDtlRestController.class);

    @Autowired
    private InvoiceDtlService invoiceDtlService;

    @Autowired
    private InvoiceDtlMapper invoiceDtlMapper;

    @GetMapping("all")
    public List<InvoiceDtl> findAll() {
        return invoiceDtlService.findAll();
    }

    @GetMapping("{id}")
    public InvoiceDtl findById(@PathVariable("id") final Long id) {
        return invoiceDtlService.findById(id);
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public InvoiceDtl save(@RequestBody final InvoiceDtl invoiceDtl) {
        /*if (null == invoiceDtl.getInvoiceDtlId()) {
            invoiceDtl.setInvoiceDtlId(invoiceDtlService.generateID() >= (findAll().size() + 1) ? invoiceDtlService.generateID() : (findAll().size() + 1));
        }*/
        return invoiceDtlService.save(invoiceDtl);
    }

    @PostMapping(path = "saveAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InvoiceDtl> saveAll(@RequestBody final Set<InvoiceDtlDTO> invoiceDtlDTO) {
        final Set<InvoiceDtl> invoiceDtls = new HashSet<>();
        invoiceDtlDTO.forEach(dto -> {
            final InvoiceDtl invoiceDtl = invoiceDtlMapper.toInvoiceDtl(dto);
            invoiceDtls.add(invoiceDtl);
        });
        return invoiceDtlService.save(invoiceDtls);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteById(@PathVariable("id") final Long id) {
        if (!invoiceDtlService.exists(id)) {
            throw new IllegalArgumentException("InvoiceDtl with id: " + id + " does not exist");
        } else {
            try {
                invoiceDtlService.deleteById(id);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @DeleteMapping(path = "delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean delete(@RequestBody final InvoiceDtl invoiceDtl) {
        if (null == invoiceDtl || null == invoiceDtl.getInvDtlNum() || !invoiceDtlService.exists(invoiceDtl.getInvDtlNum())) {
            throw new IllegalArgumentException("InvoiceDtl does not exist");
        } else {
            try {
                invoiceDtlService.delete(invoiceDtl);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
