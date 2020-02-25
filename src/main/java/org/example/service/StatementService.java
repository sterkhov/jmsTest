package org.example.service;

import org.example.model.Statement;

import java.util.List;

public interface StatementService {
    List<Statement> find(Statement statement, String sortBy, boolean DESC);
}
