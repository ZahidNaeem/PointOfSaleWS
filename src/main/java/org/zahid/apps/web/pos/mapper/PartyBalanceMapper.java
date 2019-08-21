package org.zahid.apps.web.pos.mapper;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zahid.apps.web.pos.dto.PartyBalanceDTO;
import org.zahid.apps.web.pos.entity.Party;
import org.zahid.apps.web.pos.entity.PartyBalance;
import org.zahid.apps.web.pos.service.PartyService;

@Mapper(componentModel = "spring")
public abstract class PartyBalanceMapper {

  @Autowired
  private PartyService partyService;

  public abstract PartyBalance partyBalanceDTOToPartyBalance(final PartyBalanceDTO dto);

  public abstract PartyBalanceDTO partyBalanceToPartyBalanceDTO(final PartyBalance partyBalance);

  public Party map(final Long partyCode) {
    return partyService.findById(partyCode);
  }

  public Long map(final Party party) {
    return party.getPartyCode();
  }
}
