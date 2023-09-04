package com.springproject.albumproject.service;

import com.springproject.albumproject.model.Invoice;

import java.util.List;

public interface InvoiceService {
     Invoice saveInvoice(Invoice invoice);
     List<Invoice> getAllInvoice();
}
