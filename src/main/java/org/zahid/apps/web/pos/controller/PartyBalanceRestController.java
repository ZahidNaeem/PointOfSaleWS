package org.zahid.apps.web.pos.controller;

import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.zahid.apps.web.pos.dto.PartyBalanceDTO;
import org.zahid.apps.web.pos.entity.PartyBalance;
import org.zahid.apps.web.pos.mapper.PartyBalanceMapper;
import org.zahid.apps.web.pos.service.PartyBalanceService;

import java.util.List;
import java.util.Set;
import org.zahid.apps.web.pos.service.PartyService;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("balance")
public class PartyBalanceRestController {

  private static final Logger LOG = LogManager.getLogger(ItemRestController.class);
  @Autowired
  private PartyBalanceService partyBalanceService;

  @Autowired
  private PartyService partyService;

  @Autowired
  private PartyBalanceMapper partyBalanceMapper;

  @GetMapping("all")
  public List<PartyBalance> findAll() {
    return partyBalanceService.getPartyBalanceList();
  }

  @GetMapping("{id}")
  public PartyBalance findById(@PathVariable("id") final Long id) {
    return partyBalanceService.findById(id);
  }

  @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public PartyBalance save(@RequestBody final PartyBalance partyBalance) {
        /*if (null == partyBalance.getPartyBalanceId()) {
            partyBalance.setPartyBalanceId(partyBalanceService.generateID() >= (findAll().size() + 1) ? partyBalanceService.generateID() : (findAll().size() + 1));
        }*/
    return partyBalanceService.save(partyBalance);
  }

  @PostMapping(path = "saveAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PartyBalance> saveAll(@RequestBody final Set<PartyBalanceDTO> partyBalanceDTO) {
    final Set<PartyBalance> partyBalances = new HashSet<>();
    partyBalanceDTO.forEach(dto -> {
      final PartyBalance partyBalance = partyBalanceMapper.toPartyBalance(dto, partyService);
      partyBalances.add(partyBalance);
    });
    return partyBalanceService.save(partyBalances);
  }

  @DeleteMapping("delete/{id}")
  public boolean deleteById(@PathVariable("id") final Long id) {
    if (!partyBalanceService.exists(id)) {
      throw new IllegalArgumentException("Item partyBalance with id: " + id + " does not exist");
    } else {
      try {
        partyBalanceService.deleteById(id);
        return true;
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
  }

  @DeleteMapping(path = "delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public boolean delete(@RequestBody final PartyBalance partyBalance) {
    if (null == partyBalance || null == partyBalance.getPartyBalanceId() || !partyBalanceService.exists(partyBalance.getPartyBalanceId())) {
      throw new IllegalArgumentException("Item partyBalance does not exist");
    } else {
      try {
        partyBalanceService.delete(partyBalance);
        return true;
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }
    }
  }
}
