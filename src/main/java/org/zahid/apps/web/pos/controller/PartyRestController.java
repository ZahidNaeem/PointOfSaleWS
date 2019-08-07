package org.zahid.apps.web.pos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.zahid.apps.web.pos.dto.PartyDTO;
import org.zahid.apps.web.pos.entity.Party;
import org.zahid.apps.web.pos.entity.NavigationDtl;
import org.zahid.apps.web.pos.service.PartyService;

import java.util.List;
import java.util.Set;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("party")
public class PartyRestController {

    private static final Logger LOG = LogManager.getLogger(PartyRestController.class);
    @Autowired
    private PartyService partyService;

    private final int[] indx = {-1};

    @GetMapping("all")
    public List<Party> findAll() {
        return partyService.getParties();
    }

    @GetMapping("{id}")
    public Party findById(@PathVariable("id") final Long id) {
        return partyService.findById(id);
    }

    @GetMapping("first")
    public PartyDTO first() {
        indx[0] = 0;
        LOG.info("Index in first(): {}", indx[0]);
        return getPartyDTO(findAll(), indx[0]);
    }

    @GetMapping("previous")
    public PartyDTO previous() {
        indx[0]--;
        LOG.info("Index in previous(): {}", indx[0]);
        return getPartyDTO(findAll(), indx[0]);
    }

    @GetMapping("next")
    public PartyDTO next() {
        indx[0]++;
        LOG.info("Index in next(): {}", indx[0]);
        return getPartyDTO(findAll(), indx[0]);
    }

    @GetMapping("last")
    public PartyDTO last() {
        indx[0] = findAll().size() - 1;
        LOG.info("Index in last(): {}", indx[0]);
        return getPartyDTO(findAll(), indx[0]);
    }

    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PartyDTO save(@RequestBody final Party party) {
        /*if (null == party.getPartyCode()) {
            party.setPartyCode(partyService.generateID() >= (findAll().size() + 1) ? partyService.generateID() : (findAll().size() + 1));
        }*/
        final Party partySaved = partyService.save(party);
        indx[0] = this.findAll().indexOf(partySaved);
        LOG.info("Index in saveParty(): {}", indx[0]);
        return getPartyDTO(findAll(), indx[0]);
    }

    @PostMapping(path = "saveAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Party> saveAll(@RequestBody final Set<Party> parties) {
        return partyService.save(parties);
    }

    @DeleteMapping("/delete/{id}")
    public PartyDTO deleteById(@PathVariable("id") final Long id) {
        if (!partyService.exists(id)) {
            throw new IllegalArgumentException("Party with id: " + id + " does not exist");
        } else {
            try {
                partyService.deleteById(id);
                indx[0]--;
                LOG.info("Index in deletePartyById(): {}", indx[0]);
                return getPartyDTO(findAll(), indx[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @DeleteMapping(path = "delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PartyDTO delete(@RequestBody final Party party) {
        LOG.info("Index: {}", indx);
        if (null == party || null == party.getPartyCode() || !partyService.exists(party.getPartyCode())) {
            throw new IllegalArgumentException("Party does not exist");
        } else {
            try {
                partyService.delete(party);
                indx[0]--;
                LOG.info("Index in deleteParty(): {}", indx[0]);
                return getPartyDTO(findAll(), indx[0]);
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

    private static final PartyDTO getPartyDTO(List<Party> parties, int indx) {
        if (indx < 0 || indx > parties.size() - 1) {
            LOG.info("Index in getPartyDTO(): {}", indx);
            throw new IndexOutOfBoundsException();
        } else {
            final NavigationDtl dtl = resetNavigation();
            final Party party = parties.get(indx);
            final PartyDTO partyDTO = new PartyDTO();
            partyDTO.setParty(party);
            if (indx > 0) {
                dtl.setFirst(false);
            }
            if (indx < parties.size() - 1) {
                dtl.setLast(false);
            }
            partyDTO.setNavigationDtl(dtl);
            return partyDTO;
        }
    }
}
