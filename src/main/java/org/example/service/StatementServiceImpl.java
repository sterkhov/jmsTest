package org.example.service;

import org.example.model.Statement;
import org.example.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementServiceImpl implements StatementService {

    @Autowired
    StatementRepository statementRepository;

    @Override
    public List<Statement> find(Statement statement, String sortBy, boolean DESC) {
        return null;//listByFindIterable(statementRepository.findByStatement(statement).sort(new BasicDBObject(sortBy, DESC ? -1 : 1)));
    }
}
