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

  @GetMapping("all/po")
  public List<InvoiceMain> findAllPOs() {
    return invoiceMainService.findAllPOs();
  }

  @GetMapping("all/pi")
  public List<InvoiceMain> findAllPurchaseInvoices() {
    return invoiceMainService.findAllPurchaseInvoices();
  }

  @GetMapping("all/pri")
  public List<InvoiceMain> findAllPurchaseReturnInvoices() {
    return invoiceMainService.findAllPurchaseReturnInvoices();
  }

  @GetMapping("all/so")
  public List<InvoiceMain> findAllSOs() {
    return invoiceMainService.findAllSOs();
  }

  @GetMapping("all/si")
  public List<InvoiceMain> findAllSaleInvoices() {
    return invoiceMainService.findAllSaleInvoices();
  }

  @GetMapping("all/sri")
  public List<InvoiceMain> findAllSaleReturnInvoices() {
    return invoiceMainService.findAllSaleReturnInvoices();
  }

  @GetMapping("{po/id}")
  public InvoiceMainDTO findPOById(@PathVariable("id") final Long id) {
    final InvoiceMain invoiceMain = invoiceMainService.findById(id);
    poIndx[0] = findAllPOs().indexOf(invoiceMain);
    LOG.info("Index in findById(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAllPOs(), poIndx[0]);
  }

  @GetMapping("{pi/id}")
  public InvoiceMainDTO findPIById(@PathVariable("id") final Long id) {
    final InvoiceMain invoiceMain = invoiceMainService.findById(id);
    piIndx[0] = findAllPurchaseInvoices().indexOf(invoiceMain);
    LOG.info("Index in findById(): {}", piIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseInvoices(), piIndx[0]);
  }

  @GetMapping("{pri/id}")
  public InvoiceMainDTO findPRIById(@PathVariable("id") final Long id) {
    final InvoiceMain invoiceMain = invoiceMainService.findById(id);
    priIndx[0] = findAllPurchaseReturnInvoices().indexOf(invoiceMain);
    LOG.info("Index in findById(): {}", priIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseReturnInvoices(), priIndx[0]);
  }

  @GetMapping("{so/id}")
  public InvoiceMainDTO findSOById(@PathVariable("id") final Long id) {
    final InvoiceMain invoiceMain = invoiceMainService.findById(id);
    soIndx[0] = findAllSOs().indexOf(invoiceMain);
    LOG.info("Index in findById(): {}", soIndx[0]);
    return getInvoiceMainDTO(findAllSOs(), soIndx[0]);
  }

  @GetMapping("{si/id}")
  public InvoiceMainDTO findSIById(@PathVariable("id") final Long id) {
    final InvoiceMain invoiceMain = invoiceMainService.findById(id);
    siIndx[0] = findAllSaleInvoices().indexOf(invoiceMain);
    LOG.info("Index in findById(): {}", siIndx[0]);
    return getInvoiceMainDTO(findAllSaleInvoices(), siIndx[0]);
  }

  @GetMapping("{sri/id}")
  public InvoiceMainDTO findSRIById(@PathVariable("id") final Long id) {
    final InvoiceMain invoiceMain = invoiceMainService.findById(id);
    sriIndx[0] = findAllSaleReturnInvoices().indexOf(invoiceMain);
    LOG.info("Index in findById(): {}", sriIndx[0]);
    return getInvoiceMainDTO(findAllSaleReturnInvoices(), sriIndx[0]);
  }

  @GetMapping("{id}")
  public InvoiceMainDTO findById(@PathVariable("id") final Long id) {
    final InvoiceMain invoiceMain = invoiceMainService.findById(id);
    poIndx[0] = findAll().indexOf(invoiceMain);
    LOG.info("Index in findById(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAll(), poIndx[0]);
  }

  @GetMapping("po/first")
  public InvoiceMainDTO firstPO() {
    poIndx[0] = 0;
    LOG.info("Index in first(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAllPOs(), poIndx[0]);
  }

  @GetMapping("pi/first")
  public InvoiceMainDTO firstPI() {
    piIndx[0] = 0;
    LOG.info("Index in first(): {}", piIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseInvoices(), piIndx[0]);
  }

  @GetMapping("pri/first")
  public InvoiceMainDTO firstPRI() {
    priIndx[0] = 0;
    LOG.info("Index in first(): {}", priIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseReturnInvoices(), priIndx[0]);
  }

  @GetMapping("so/first")
  public InvoiceMainDTO firstSO() {
    soIndx[0] = 0;
    LOG.info("Index in first(): {}", soIndx[0]);
    return getInvoiceMainDTO(findAllSOs(), soIndx[0]);
  }

  @GetMapping("si/first")
  public InvoiceMainDTO firstSI() {
    siIndx[0] = 0;
    LOG.info("Index in first(): {}", siIndx[0]);
    return getInvoiceMainDTO(findAllSaleInvoices(), siIndx[0]);
  }

  @GetMapping("sri/first")
  public InvoiceMainDTO firstSRI() {
    sriIndx[0] = 0;
    LOG.info("Index in first(): {}", sriIndx[0]);
    return getInvoiceMainDTO(findAllSaleReturnInvoices(), sriIndx[0]);
  }

  @GetMapping("po/previous")
  public InvoiceMainDTO previousPO() {
    poIndx[0]--;
    LOG.info("Index in previous(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAllPOs(), poIndx[0]);
  }

  @GetMapping("pi/previous")
  public InvoiceMainDTO previousPI() {
    piIndx[0]--;
    LOG.info("Index in previous(): {}", piIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseInvoices(), piIndx[0]);
  }

  @GetMapping("pri/previous")
  public InvoiceMainDTO previousPRI() {
    priIndx[0]--;
    LOG.info("Index in previous(): {}", priIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseReturnInvoices(), priIndx[0]);
  }

  @GetMapping("so/previous")
  public InvoiceMainDTO previousSO() {
    soIndx[0]--;
    LOG.info("Index in previous(): {}", soIndx[0]);
    return getInvoiceMainDTO(findAllSOs(), soIndx[0]);
  }

  @GetMapping("si/previous")
  public InvoiceMainDTO previousSI() {
    siIndx[0]--;
    LOG.info("Index in previous(): {}", siIndx[0]);
    return getInvoiceMainDTO(findAllSaleInvoices(), siIndx[0]);
  }

  @GetMapping("sri/previous")
  public InvoiceMainDTO previousSRI() {
    sriIndx[0]--;
    LOG.info("Index in previous(): {}", sriIndx[0]);
    return getInvoiceMainDTO(findAllSaleReturnInvoices(), sriIndx[0]);
  }

  @GetMapping("po/next")
  public InvoiceMainDTO nextPO() {
    poIndx[0]++;
    LOG.info("Index in next(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAllPOs(), poIndx[0]);
  }

  @GetMapping("pi/next")
  public InvoiceMainDTO nextPI() {
    piIndx[0]++;
    LOG.info("Index in next(): {}", piIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseInvoices(), piIndx[0]);
  }

  @GetMapping("pri/next")
  public InvoiceMainDTO nextPRI() {
    priIndx[0]++;
    LOG.info("Index in next(): {}", priIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseReturnInvoices(), priIndx[0]);
  }

  @GetMapping("so/next")
  public InvoiceMainDTO nextSO() {
    soIndx[0]++;
    LOG.info("Index in next(): {}", soIndx[0]);
    return getInvoiceMainDTO(findAllSOs(), soIndx[0]);
  }

  @GetMapping("si/next")
  public InvoiceMainDTO nextSI() {
    siIndx[0]++;
    LOG.info("Index in next(): {}", siIndx[0]);
    return getInvoiceMainDTO(findAllSaleInvoices(), siIndx[0]);
  }

  @GetMapping("sri/next")
  public InvoiceMainDTO nextSRI() {
    sriIndx[0]++;
    LOG.info("Index in next(): {}", sriIndx[0]);
    return getInvoiceMainDTO(findAllSaleReturnInvoices(), sriIndx[0]);
  }

  @GetMapping("po/last")
  public InvoiceMainDTO lastPO() {
    poIndx[0] = findAllPOs().size() - 1;
    LOG.info("Index in last(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAllPOs(), poIndx[0]);
  }

  @GetMapping("pi/last")
  public InvoiceMainDTO lastPI() {
    piIndx[0] = findAllPurchaseInvoices().size() - 1;
    LOG.info("Index in last(): {}", piIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseInvoices(), piIndx[0]);
  }

  @GetMapping("pri/last")
  public InvoiceMainDTO lastPRI() {
    priIndx[0] = findAllPurchaseReturnInvoices().size() - 1;
    LOG.info("Index in last(): {}", priIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseReturnInvoices(), priIndx[0]);
  }

  @GetMapping("so/last")
  public InvoiceMainDTO lastSO() {
    soIndx[0] = findAllSOs().size() - 1;
    LOG.info("Index in last(): {}", soIndx[0]);
    return getInvoiceMainDTO(findAllSOs(), soIndx[0]);
  }

  @GetMapping("si/last")
  public InvoiceMainDTO lastSI() {
    siIndx[0] = findAllSaleInvoices().size() - 1;
    LOG.info("Index in last(): {}", siIndx[0]);
    return getInvoiceMainDTO(findAllSaleInvoices(), siIndx[0]);
  }

  @GetMapping("sri/last")
  public InvoiceMainDTO lastSRI() {
    sriIndx[0] = findAllSaleReturnInvoices().size() - 1;
    LOG.info("Index in last(): {}", sriIndx[0]);
    return getInvoiceMainDTO(findAllSaleReturnInvoices(), sriIndx[0]);
  }

  @PostMapping(path = "po/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO savePO(@RequestBody final InvoiceMainDTO dto) {
        /*if (null == dto.getInvoiceMainCode()) {
            dto.setInvoiceMainCode(invoiceMainService.generateID() >= (findAll().size() + 1) ? invoiceMainService.generateID() : (findAll().size() + 1));
        }*/
    final InvoiceMain invoiceMainSaved = invoiceMainService
        .save(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
    poIndx[0] = this.findAllPOs().indexOf(invoiceMainSaved);
    LOG.info("Index in saveInvoiceMain(): {}", poIndx[0]);
    return getInvoiceMainDTO(findAllPOs(), poIndx[0]);
  }

  @PostMapping(path = "pi/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO savePI(@RequestBody final InvoiceMainDTO dto) {
        /*if (null == dto.getInvoiceMainCode()) {
            dto.setInvoiceMainCode(invoiceMainService.generateID() >= (findAll().size() + 1) ? invoiceMainService.generateID() : (findAll().size() + 1));
        }*/
    final InvoiceMain invoiceMainSaved = invoiceMainService
        .save(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
    piIndx[0] = this.findAllPurchaseInvoices().indexOf(invoiceMainSaved);
    LOG.info("Index in saveInvoiceMain(): {}", piIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseInvoices(), piIndx[0]);
  }

  @PostMapping(path = "pri/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO savePRI(@RequestBody final InvoiceMainDTO dto) {
        /*if (null == dto.getInvoiceMainCode()) {
            dto.setInvoiceMainCode(invoiceMainService.generateID() >= (findAll().size() + 1) ? invoiceMainService.generateID() : (findAll().size() + 1));
        }*/
    final InvoiceMain invoiceMainSaved = invoiceMainService
        .save(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
    priIndx[0] = this.findAllPurchaseReturnInvoices().indexOf(invoiceMainSaved);
    LOG.info("Index in saveInvoiceMain(): {}", priIndx[0]);
    return getInvoiceMainDTO(findAllPurchaseReturnInvoices(), priIndx[0]);
  }

  @PostMapping(path = "so/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO saveSO(@RequestBody final InvoiceMainDTO dto) {
        /*if (null == dto.getInvoiceMainCode()) {
            dto.setInvoiceMainCode(invoiceMainService.generateID() >= (findAll().size() + 1) ? invoiceMainService.generateID() : (findAll().size() + 1));
        }*/
    final InvoiceMain invoiceMainSaved = invoiceMainService
        .save(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
    soIndx[0] = this.findAllSOs().indexOf(invoiceMainSaved);
    LOG.info("Index in saveInvoiceMain(): {}", soIndx[0]);
    return getInvoiceMainDTO(findAllSOs(), soIndx[0]);
  }

  @PostMapping(path = "si/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO saveSI(@RequestBody final InvoiceMainDTO dto) {
        /*if (null == dto.getInvoiceMainCode()) {
            dto.setInvoiceMainCode(invoiceMainService.generateID() >= (findAll().size() + 1) ? invoiceMainService.generateID() : (findAll().size() + 1));
        }*/
    final InvoiceMain invoiceMainSaved = invoiceMainService
        .save(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
    siIndx[0] = this.findAllSaleInvoices().indexOf(invoiceMainSaved);
    LOG.info("Index in saveInvoiceMain(): {}", siIndx[0]);
    return getInvoiceMainDTO(findAllSaleInvoices(), siIndx[0]);
  }

  @PostMapping(path = "sri/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO saveSRI(@RequestBody final InvoiceMainDTO dto) {
        /*if (null == dto.getInvoiceMainCode()) {
            dto.setInvoiceMainCode(invoiceMainService.generateID() >= (findAll().srize() + 1) ? invoiceMainService.generateID() : (findAll().srize() + 1));
        }*/
    final InvoiceMain invoiceMainSaved = invoiceMainService
        .save(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
    sriIndx[0] = this.findAllSaleReturnInvoices().indexOf(invoiceMainSaved);
    LOG.info("Index in saveInvoiceMain(): {}", sriIndx[0]);
    return getInvoiceMainDTO(findAllSaleReturnInvoices(), sriIndx[0]);
  }

  @PostMapping(path = "saveAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<InvoiceMain> saveAll(@RequestBody final Set<InvoiceMainDTO> dtos) {
    final Set<InvoiceMain> invoices = new HashSet<>();
    dtos.forEach(dto -> {
      invoices.add(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
    });
    return invoiceMainService.save(invoices);
  }

  @DeleteMapping("/delete/po/{id}")
  public InvoiceMainDTO deletePOById(@PathVariable("id") final Long id) {
    if (!invoiceMainService.exists(id)) {
      throw new IllegalArgumentException("Invoice with id: " + id + " does not exist");
    } else {
      try {
        invoiceMainService.deleteById(id);
        poIndx[0]--;
        LOG.info("Index in deleteInvoiceMainById(): {}", poIndx[0]);
        return getInvoiceMainDTO(findAllPOs(), poIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping(path = "delete/po", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO deletePO(@RequestBody final InvoiceMainDTO dto) {
    LOG.info("Index: {}", poIndx[0]);
    if (null == dto || null == dto.getInvNum() || !invoiceMainService.exists(dto.getInvNum())) {
      throw new IllegalArgumentException("Invoice with id: " + dto.getInvNum() + " does not exist");
    } else {
      try {
        invoiceMainService.delete(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
        poIndx[0]--;
        LOG.info("Index in deleteInvoiceMain(): {}", poIndx[0]);
        return getInvoiceMainDTO(findAllPOs(), poIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping("/delete/pi/{id}")
  public InvoiceMainDTO deletePIById(@PathVariable("id") final Long id) {
    if (!invoiceMainService.exists(id)) {
      throw new IllegalArgumentException("Invoice with id: " + id + " does not exist");
    } else {
      try {
        invoiceMainService.deleteById(id);
        piIndx[0]--;
        LOG.info("Index in deleteInvoiceMainById(): {}", piIndx[0]);
        return getInvoiceMainDTO(findAllPurchaseInvoices(), piIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping(path = "delete/pi", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO deletePI(@RequestBody final InvoiceMainDTO dto) {
    LOG.info("Index: {}", piIndx[0]);
    if (null == dto || null == dto.getInvNum() || !invoiceMainService.exists(dto.getInvNum())) {
      throw new IllegalArgumentException("Invoice with id: " + dto.getInvNum() + " does not exist");
    } else {
      try {
        invoiceMainService.delete(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
        piIndx[0]--;
        LOG.info("Index in deleteInvoiceMain(): {}", piIndx[0]);
        return getInvoiceMainDTO(findAllPurchaseInvoices(), piIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping("/delete/pri/{id}")
  public InvoiceMainDTO deletePRIById(@PathVariable("id") final Long id) {
    if (!invoiceMainService.exists(id)) {
      throw new IllegalArgumentException("Invoice with id: " + id + " does not exist");
    } else {
      try {
        invoiceMainService.deleteById(id);
        priIndx[0]--;
        LOG.info("Index in deleteInvoiceMainById(): {}", priIndx[0]);
        return getInvoiceMainDTO(findAllPurchaseReturnInvoices(), priIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping(path = "delete/pri", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO deletePRI(@RequestBody final InvoiceMainDTO dto) {
    LOG.info("Index: {}", priIndx[0]);
    if (null == dto || null == dto.getInvNum() || !invoiceMainService.exists(dto.getInvNum())) {
      throw new IllegalArgumentException("Invoice with id: " + dto.getInvNum() + " does not exist");
    } else {
      try {
        invoiceMainService.delete(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
        priIndx[0]--;
        LOG.info("Index in deleteInvoiceMain(): {}", priIndx[0]);
        return getInvoiceMainDTO(findAllPurchaseReturnInvoices(), priIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping("/delete/so/{id}")
  public InvoiceMainDTO deleteSOById(@PathVariable("id") final Long id) {
    if (!invoiceMainService.exists(id)) {
      throw new IllegalArgumentException("Invoice with id: " + id + " does not exist");
    } else {
      try {
        invoiceMainService.deleteById(id);
        soIndx[0]--;
        LOG.info("Index in deleteInvoiceMainById(): {}", soIndx[0]);
        return getInvoiceMainDTO(findAllSOs(), soIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping(path = "delete/so", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO deleteSO(@RequestBody final InvoiceMainDTO dto) {
    LOG.info("Index: {}", soIndx[0]);
    if (null == dto || null == dto.getInvNum() || !invoiceMainService.exists(dto.getInvNum())) {
      throw new IllegalArgumentException("Invoice with id: " + dto.getInvNum() + " does not exist");
    } else {
      try {
        invoiceMainService.delete(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
        soIndx[0]--;
        LOG.info("Index in deleteInvoiceMain(): {}", soIndx[0]);
        return getInvoiceMainDTO(findAllSOs(), soIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping("/delete/si/{id}")
  public InvoiceMainDTO deleteSIById(@PathVariable("id") final Long id) {
    if (!invoiceMainService.exists(id)) {
      throw new IllegalArgumentException("Invoice with id: " + id + " does not exist");
    } else {
      try {
        invoiceMainService.deleteById(id);
        siIndx[0]--;
        LOG.info("Index in deleteInvoiceMainById(): {}", siIndx[0]);
        return getInvoiceMainDTO(findAllSaleInvoices(), siIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping(path = "delete/si", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO deleteSI(@RequestBody final InvoiceMainDTO dto) {
    LOG.info("Index: {}", siIndx[0]);
    if (null == dto || null == dto.getInvNum() || !invoiceMainService.exists(dto.getInvNum())) {
      throw new IllegalArgumentException("Invoice with id: " + dto.getInvNum() + " does not exist");
    } else {
      try {
        invoiceMainService.delete(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
        siIndx[0]--;
        LOG.info("Index in deleteInvoiceMain(): {}", siIndx[0]);
        return getInvoiceMainDTO(findAllSaleInvoices(), siIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping("/delete/sri/{id}")
  public InvoiceMainDTO deleteSRIById(@PathVariable("id") final Long id) {
    if (!invoiceMainService.exists(id)) {
      throw new IllegalArgumentException("Invoice with id: " + id + " does not exist");
    } else {
      try {
        invoiceMainService.deleteById(id);
        sriIndx[0]--;
        LOG.info("Index in deleteInvoiceMainById(): {}", sriIndx[0]);
        return getInvoiceMainDTO(findAllSaleReturnInvoices(), sriIndx[0]);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @DeleteMapping(path = "delete/sri", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public InvoiceMainDTO deleteSRI(@RequestBody final InvoiceMainDTO dto) {
    LOG.info("Index: {}", sriIndx[0]);
    if (null == dto || null == dto.getInvNum() || !invoiceMainService.exists(dto.getInvNum())) {
      throw new IllegalArgumentException("Invoice with id: " + dto.getInvNum() + " does not exist");
    } else {
      try {
        invoiceMainService.delete(mapper.toInvoiceMain(dto, partyService, invoiceMainService));
        sriIndx[0]--;
        LOG.info("Index in deleteInvoiceMain(): {}", sriIndx[0]);
        return getInvoiceMainDTO(findAllSaleReturnInvoices(), sriIndx[0]);
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
