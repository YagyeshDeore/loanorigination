package com.loanorigination.service;

import com.loanorigination.entity.Document;

public interface DocumentService {
    Document uploadDocument(Document document);
    Document verifyDocument(Long documentId, String status);
}
