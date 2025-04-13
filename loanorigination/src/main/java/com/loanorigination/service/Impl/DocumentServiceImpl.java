package com.loanorigination.service.Impl;

import com.loanorigination.entity.Document;
import com.loanorigination.repository.DocumentRepository;
import com.loanorigination.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document uploadDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document verifyDocument(Long documentId, String status) {
        Document document = documentRepository.findById(documentId).orElseThrow(() -> new RuntimeException("Document not found"));
        document.setStatus(status);
        return documentRepository.save(document);
    }
}
