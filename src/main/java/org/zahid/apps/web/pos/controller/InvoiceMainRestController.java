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
@RequestMapping("invoice")
public class InvoiceMainRestController {

  private static final Logger LOG = LogManager.getLogger(InvoiceMainRestController.class);

  @Autowired
  private InvoiceMainService invoiceMainService;

  @Autowired
  private InvoiceMainMapper mapper;

  @Autowired
  private PartyService partyService;

  private final int[] poIndx = {-1};
  private final int[] piIndx = {-1};
  private final int[] priIndx = {-1};
  private final int[] soIndx = {-1};
  private final int[] siIndx = {-1};
  private final int[] sriIndx = {-1};

  @GetMapping("all")
  public List<InvoiceMain> findAll() {
    return invoiceMainService.getInvoices();
  }

  @GetMapping("{id}")
  public InvoiceMainDTO findById(@PathVariable("id") final Long id) {
    final InvoiceMain invoiceMain = invoiceMainService.findById(id);
    poIndx[0] = findAll().indexOf(invoiceMain);
    LOG.info("Index in findById(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAll(), poIndx[0]);
  }

  @GetMapping("firstPO")
  public InvoiceMainDTO firstPO() {
    poIndx[0] = 0;
    LOG.info("Index in first(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAll(), poIndx[0]);
  }

  @GetMapping("firstPI")
  public InvoiceMainDTO firstPI() {
    piIndx[0] = 0;
    LOG.info("Index in first(): {}", piIndx[0]);
    return getInvoiceMainDTO(findAll(), piIndx[0]);
  }

  @GetMapping("firstPRI")
  public InvoiceMainDTO firstPRI() {
    priIndx[0] = 0;
    LOG.info("Index in first(): {}", priIndx[0]);
    return getInvoiceMainDTO(findAll(), priIndx[0]);
  }

  @GetMapping("firstSO")
  public InvoiceMainDTO firstSO() {
    soIndx[0] = 0;
    LOG.info("Index in first(): {}", soIndx[0]);
    return getInvoiceMainDTO(findAll(), soIndx[0]);
  }

  @GetMapping("firstSI")
  public InvoiceMainDTO firstSI() {
    siIndx[0] = 0;
    LOG.info("Index in first(): {}", siIndx[0]);
    return getInvoiceMainDTO(findAll(), siIndx[0]);
  }

  @GetMapping("firstSRI")
  public InvoiceMainDTO firstSRI() {
    sriIndx[0] = 0;
    LOG.info("Index in first(): {}", sriIndx[0]);
    return getInvoiceMainDTO(findAll(), sriIndx[0]);
  }

  @GetMapping("previousPO")
  public InvoiceMainDTO previousPO() {
    poIndx[0]--;
    LOG.info("Index in previous(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAll(), poIndx[0]);
  }

  @GetMapping("previousPI")
  public InvoiceMainDTO previousPI() {
    piIndx[0]--;
    LOG.info("Index in previous(): {}", piIndx[0]);
    return getInvoiceMainDTO(findAll(), piIndx[0]);
  }

  @GetMapping("previousPRI")
  public InvoiceMainDTO previousPRI() {
    priIndx[0]--;
    LOG.info("Index in previous(): {}", priIndx[0]);
    return getInvoiceMainDTO(findAll(), priIndx[0]);
  }

  @GetMapping("previousSO")
  public InvoiceMainDTO previousSO() {
    soIndx[0]--;
    LOG.info("Index in previous(): {}", soIndx[0]);
    return getInvoiceMainDTO(findAll(), soIndx[0]);
  }

  @GetMapping("previousSI")
  public InvoiceMainDTO previousSI() {
    siIndx[0]--;
    LOG.info("Index in previous(): {}", siIndx[0]);
    return getInvoiceMainDTO(findAll(), siIndx[0]);
  }

  @GetMapping("previousSRI")
  public InvoiceMainDTO previousSRI() {
    sriIndx[0]--;
    LOG.info("Index in previous(): {}", sriIndx[0]);
    return getInvoiceMainDTO(findAll(), sriIndx[0]);
  }

  @GetMapping("nextPO")
  public InvoiceMainDTO nextPO() {
    poIndx[0]++;
    LOG.info("Index in next(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAll(), poIndx[0]);
  }

  @GetMapping("nextPI")
  public InvoiceMainDTO nextPI() {
    piIndx[0]++;
    LOG.info("Index in next(): {}", piIndx[0]);
    return getInvoiceMainDTO(findAll(), piIndx[0]);
  }

  @GetMapping("nextPRI")
  public InvoiceMainDTO nextPRI() {
    priIndx[0]++;
    LOG.info("Index in next(): {}", priIndx[0]);
    return getInvoiceMainDTO(findAll(), priIndx[0]);
  }

  @GetMapping("nextSO")
  public InvoiceMainDTO nextSO() {
    soIndx[0]++;
    LOG.info("Index in next(): {}", soIndx[0]);
    return getInvoiceMainDTO(findAll(), soIndx[0]);
  }

  @GetMapping("nextSI")
  public InvoiceMainDTO nextSI() {
    siIndx[0]++;
    LOG.info("Index in next(): {}", siIndx[0]);
    return getInvoiceMainDTO(findAll(), siIndx[0]);
  }

  @GetMapping("nextSRI")
  public InvoiceMainDTO nextSRI() {
    sriIndx[0]++;
    LOG.info("Index in next(): {}", sriIndx[0]);
    return getInvoiceMainDTO(findAll(), sriIndx[0]);
  }

  @GetMapping("lastPO")
  public InvoiceMainDTO lastPO() {
    poIndx[0] = findAll().size() - 1;
    LOG.info("Index in last(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAll(), poIndx[0]);
  }

  @GetMapping("lastPI")
  public InvoiceMainDTO lastPI() {
    piIndx[0] = findAll().size() - 1;
    LOG.info("Index in last(): {}", piIndx[0]);
    return getInvoiceMainDTO(findAll(), piIndx[0]);
  }

  @GetMapping("lastPRI")
  public InvoiceMainDTO lastPRI() {
    priIndx[0] = findAll().size() - 1;
    LOG.info("Index in last(): {}", priIndx[0]);
    return getInvoiceMainDTO(findAll(), priIndx[0]);
  }

  @GetMapping("lastSO")
  public InvoiceMainDTO lastSO() {
    soIndx[0] = findAll().size() - 1;
    LOG.info("Index in last(): {}", soIndx[0]);
    return getInvoiceMainDTO(findAll(), soIndx[0]);
  }

  @GetMapping("lastSI")
  public InvoiceMainDTO lastSI() {
    siIndx[0] = findAll().size() - 1;
    LOG.info("Index in last(): {}", siIndx[0]);
    return getInvoiceMainDTO(findAll(), siIndx[0]);
  }

  @GetMapping("lastSRI")
  public InvoiceMainDTO lastSRI() {
    sriIndx[0] = findAll().size() - 1;
    LOG.info("Index in last(): {}", sriIndx[0]);
    return getInvoiceMainDTO(findAll(), sriIndx[0]);
  }

  @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO save(@RequestBody final InvoiceMainDTO dto) {
        /*if (null == dto.getInvoiceMainCode()) {
            dto.setInvoiceMainCode(invoiceMainService.generateID() >= (findAll().size() + 1) ? invoiceMainService.generateID() : (findAll().size() + 1));
        }*/
    final InvoiceMain invoiceMainSaved = invoiceMainService
        .save(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
    poIndx[0] = this.findAll().indexOf(invoiceMainSaved);
    LOG.info("Index in saveInvoiceMain(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAll(), poIndx[0]);
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
        poIndx[0]--;
        LOG.info("Index in deleteInvoiceMainById(): {}", poIndx[0]);
        return getInvoiceMainDTO(findAll(), poIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping(path = "delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO delete(@RequestBody final InvoiceMainDTO dto) {
    LOG.info("Index: {}", poIndx);
    if (null == dto || null == dto.getInvNum() || !invoiceMainService.exists(dto.getInvNum())) {
      throw new IllegalArgumentException("InvoiceMain does not exist");
    } else {
      try {
        invoiceMainService.delete(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
        poIndx[0]--;
        LOG.info("Index in deleteInvoiceMain(): {}", poIndx[0]);
        return getInvoiceMainDTO(findAll(), poIndx[0]);
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
