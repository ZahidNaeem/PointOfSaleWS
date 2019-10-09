package org.zahid.apps.web.pos.dto;

import org.zahid.apps.web.pos.model.InvoiceMainModel;
import org.zahid.apps.web.pos.entity.NavigationDtl;

import java.io.Serializable;

public class InvoiceMainDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private NavigationDtl navigationDtl;
  private InvoiceMainModel invoice;

  public NavigationDtl getNavigationDtl() {
    return navigationDtl;
  }

  public void setNavigationDtl(NavigationDtl navigationDtl) {
    this.navigationDtl = navigationDtl;
  }

  public InvoiceMainModel getInvoice() {
    return invoice;
  }

  public void setInvoice(InvoiceMainModel invoice) {
    this.invoice = invoice;
  }
}
