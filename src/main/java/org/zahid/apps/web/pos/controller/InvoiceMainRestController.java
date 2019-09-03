package org.zahid.apps.web.pos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.zahid.apps.web.pos.dto.InvoiceMainDTO;
import org.zahid.apps.web.pos.entity.InvoiceMain;
import org.zahid.apps.web.pos.entity.NavigationDtl;
import org.zahid.apps.web.pos.mapper.InvoiceMainMapper;
import org.zahid.apps.web.pos.service.InvoiceMainService;
import org.zahid.apps.web.pos.service.PartyService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("invoiceMain")
public class InvoiceMainRestController {

    private static final Logger LOG = LogManager.getLogger(InvoiceMainRestController.class);

    @Autowired
    private InvoiceMainService invoiceMainService;

    @Autowired
    private InvoiceMainMapper mapper;

    @Autowired
    private PartyService partyService;

    private final int[] indx = {-1};

    @GetMapping("all")
    public List<InvoiceMain> findAll() {
        return invoiceMainService.getInvoices();
    }

    @GetMapping("{id}")
    public InvoiceMainDTO findById(@PathVariable("id") final Long id) {
        final InvoiceMain invoiceMain = invoiceMainService.findById(id);
        indx[0] = findAll().indexOf(invoiceMain);
        LOG.info("Index in findById(): {}", indx[0]);
        return getInvoiceMainDTO(findAll(), indx[0]);
    }

    @GetMapping("first")
    public InvoiceMainDTO first() {
        indx[0] = 0;
        LOG.info("Index in first(): {}", indx[0]);
        return getInvoiceMainDTO(findAll(), indx[0]);
    }

    @GetMapping("previous")
    public InvoiceMainDTO previous() {
        indx[0]--;
        LOG.info("Index in previous(): {}", indx[0]);
        return getInvoiceMainDTO(findAll(), indx[0]);
    }

    @GetMapping("next")
    public InvoiceMainDTO next() {
        indx[0]++;
        LOG.info("Index in next(): {}", indx[0]);
        return getInvoiceMainDTO(findAll(), indx[0]);
    }

    @GetMapping("last")
    public InvoiceMainDTO last() {
        indx[0] = findAll().size() - 1;
        LOG.info("Index in last(): {}", indx[0]);
        return getInvoiceMainDTO(findAll(), indx[0]);
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public InvoiceMainDTO save(@RequestBody final InvoiceMainDTO dto) {
        /*if (null == dto.getInvoiceMainCode()) {
            dto.setInvoiceMainCode(invoiceMainService.generateID() >= (findAll().size() + 1) ? invoiceMainService.generateID() : (findAll().size() + 1));
        }*/
        final InvoiceMain invoiceMainSaved = invoiceMainService.save(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
        indx[0] = this.findAll().indexOf(invoiceMainSaved);
        LOG.info("Index in saveInvoiceMain(): {}", indx[0]);
        return getInvoiceMainDTO(findAll(), indx[0]);
    }

    @PostMapping(path = "saveAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InvoiceMain> saveAll(@RequestBody final Set<InvoiceMainDTO> dtos) {
        final Set<InvoiceMain> invoices = new HashSet<>();
        dtos.forEach(dto -> {
            invoices.add(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
        });
        return invoiceMainService.save(invoices);
    }

    @DeleteMapping("/delete/{id}")
    public InvoiceMainDTO deleteById(@PathVariable("id") final Long id) {
        if (!invoiceMainService.exists(id)) {
            throw new IllegalArgumentException("InvoiceMain with id: " + id + " does not exist");
        } else {
            try {
                invoiceMainService.deleteById(id);
                indx[0]--;
                LOG.info("Index in deleteInvoiceMainById(): {}", indx[0]);
                return getInvoiceMainDTO(findAll(), indx[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @DeleteMapping(path = "delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public InvoiceMainDTO delete(@RequestBody final InvoiceMainDTO dto) {
        LOG.info("Index: {}", indx);
        if (null == dto || null == dto.getInvNum() || !invoiceMainService.exists(dto.getInvNum())) {
            throw new IllegalArgumentException("InvoiceMain does not exist");
        } else {
            try {
                invoiceMainService.delete(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
                indx[0]--;
                LOG.info("Index in deleteInvoiceMain(): {}", indx[0]);
                return getInvoiceMainDTO(findAll(), indx[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static final NavigationDtl resetNavigation() {
        NavigationDtl dtl = new NavigationDtl();
        dtl.setFirst(true);
        dtl.setLast(true);
        return dtl;
    }

    private final InvoiceMainDTO getInvoiceMainDTO(List<InvoiceMain> invoices, int indx) {
        if (indx < 0 || indx > invoices.size() - 1) {
            LOG.info("Index in getInvoiceMainDTO(): {}", indx);
            throw new IndexOutOfBoundsException();
        } else {
            final NavigationDtl dtl = resetNavigation();
            final InvoiceMain invoiceMain = invoices.get(indx);
            final InvoiceMainDTO invoiceMainDTO = mapper.fromInvoiceMain(invoiceMain);
            if (indx > 0) {
                dtl.setFirst(false);
            }
            if (indx < invoices.size() - 1) {
                dtl.setLast(false);
            }
            invoiceMainDTO.setNavigationDtl(dtl);
            return invoiceMainDTO;
        }
    }
}
