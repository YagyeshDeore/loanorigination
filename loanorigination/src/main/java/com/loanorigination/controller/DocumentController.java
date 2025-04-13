package com.loanorigination.controller;

import com.loanorigination.entity.Document;
import com.loanorigination.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public Document uploadDocument(@RequestBody Document document) {
        return documentService.uploadDocument(document);
    }

    @PostMapping("/verify/{documentId}/{status}")
    public Document verifyDocument(@PathVariable Long documentId, @PathVariable String status) {
        return documentService.verifyDocument(documentId, status);
    }
}
