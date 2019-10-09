package org.zahid.apps.web.pos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.zahid.apps.web.pos.dto.InvoiceDtlDTO;
import org.zahid.apps.web.pos.entity.InvoiceDtl;
import org.zahid.apps.web.pos.service.InvoiceMainService;
import org.zahid.apps.web.pos.service.ItemService;

@Mapper(componentModel = "spring")
public abstract class InvoiceDtlMapper {

    @Autowired
    protected ItemService itemService;

    @Autowired
    protected InvoiceMainService invoiceMainService;

    @Mapping(target = "item", expression = "java(dtl.getItem().getItemCode())")
    @Mapping(target = "invoiceMain", expression = "java(dtl.getInvoiceMain().getInvNum())")
    public abstract InvoiceDtlDTO fromInvoiceDtl(final InvoiceDtl dtl);

    @Mapping(target = "item", expression = "java(itemService.findById(dto.getItem()))")
    @Mapping(target = "invoiceMain", expression = "java(invoiceMainService.findById(dto.getInvoiceMain()))")
    public abstract InvoiceDtl toInvoiceDtl(final InvoiceDtlDTO dto);
}
