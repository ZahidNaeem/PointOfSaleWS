package org.zahid.apps.web.pos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.zahid.apps.web.pos.dto.PartyBalanceDTO;
import org.zahid.apps.web.pos.entity.PartyBalance;
import org.zahid.apps.web.pos.service.PartyService;

@Mapper(componentModel = "spring")
public interface PartyBalanceMapper {

  @Mapping(target = "party", expression = "java(partyService.findById(dto.getParty()))")
  PartyBalance partyBalanceDTOToPartyBalance(final PartyBalanceDTO dto, final PartyService partyService);

  @Mapping(target = "party", expression = "java(partyBalance.getParty().getPartyCode())")
  PartyBalanceDTO partyBalanceToPartyBalanceDTO(final PartyBalance partyBalance);
}
