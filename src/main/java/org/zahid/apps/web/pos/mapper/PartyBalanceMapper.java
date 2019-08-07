package org.zahid.apps.web.pos.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zahid.apps.web.pos.dto.PartyBalanceDTO;
import org.zahid.apps.web.pos.entity.PartyBalance;
import org.zahid.apps.web.pos.service.PartyService;

@Component
public class PartyBalanceMapper {

    @Autowired
    private PartyService partyService;

    public PartyBalance fromPartyBalanceDTO(final PartyBalanceDTO dto) {
        final PartyBalance partyBalance = new PartyBalance();

        partyBalance.setPartyBalanceId(dto.getPartyBalanceId());
        partyBalance.setAmount(dto.getAmount());
        partyBalance.setPartyBalanceDate(dto.getPartyBalanceDate());
        partyBalance.setRemarks(dto.getRemarks());
        partyBalance.setCreatedBy(dto.getCreatedBy());
        partyBalance.setCreationDate(dto.getCreationDate());
        partyBalance.setLastUpdatedBy(dto.getLastUpdatedBy());
        partyBalance.setLastUpdateDate(dto.getLastUpdateDate());
        partyBalance.setParty(partyService.findById(dto.getParty()));

        return partyBalance;
    }

    public PartyBalanceDTO toPartyBalanceDTO(final PartyBalance partyBalance) {
        final PartyBalanceDTO dto = new PartyBalanceDTO();

        dto.setPartyBalanceId(partyBalance.getPartyBalanceId());
        dto.setAmount(partyBalance.getAmount());
        dto.setPartyBalanceDate(partyBalance.getPartyBalanceDate());
        dto.setRemarks(partyBalance.getRemarks());
        dto.setCreatedBy(partyBalance.getCreatedBy());
        dto.setCreationDate(partyBalance.getCreationDate());
        dto.setLastUpdatedBy(partyBalance.getLastUpdatedBy());
        dto.setLastUpdateDate(partyBalance.getLastUpdateDate());
        dto.setParty(partyBalance.getParty().getPartyCode());

        return dto;
    }
}
