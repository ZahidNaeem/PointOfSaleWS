package org.zahid.apps.web.pos.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zahid.apps.web.pos.entity.Party;
import org.zahid.apps.web.pos.service.PartyService;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyRestController {
    private static final Logger LOG = LogManager.getLogger(PartyRestController.class);
    @Autowired
    PartyService partyService;

    @GetMapping("/all")
    public List<Party> getAllPartys() {
        final List<Party> partys = partyService.getParties();
        return partys;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Party> getPartyById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(partyService.findById(id), HttpStatus.OK);
    }
}
