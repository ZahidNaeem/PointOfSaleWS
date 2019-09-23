package org.zahid.apps.web.pos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.zahid.apps.web.pos.dto.InvoiceMainDTO;
import org.zahid.apps.web.pos.entity.InvoiceMain;
import org.zahid.apps.web.pos.service.InvoiceMainService;
import org.zahid.apps.web.pos.service.PartyService;

@Mapper(componentModel = "spring")
public interface InvoiceMainMapper {

    @Mapping(target = "party", expression = "java(invoiceMain.getParty().getPartyCode())")
    @Mapping(target = "refInvoice", expression = "java(invoiceMain.getRefInvoice() != null ? invoiceMain.getRefInvoice().getInvNum() : null)")
    InvoiceMainDTO fromInvoiceMain(final InvoiceMain invoiceMain);

    @Mapping(target = "party", expression = "java(partyService.findById(dto.getParty()))")
    @Mapping(target = "refInvoice", expression = "java(invoiceMainService.findById(dto.getRefInvoice()))")
    InvoiceMain toInvoiceMain(final InvoiceMainDTO dto, final PartyService partyService, InvoiceMainService invoiceMainService);
}
