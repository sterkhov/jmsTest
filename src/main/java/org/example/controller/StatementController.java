package org.example.controller;

import org.example.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.example.service.StatementService;
import java.util.List;

/**
 * Контроллер для получения заявок от клиента
 *
 * @author Vladislav Sterkhov
 */

@Controller
@RequestMapping("/employee/")
public class StatementController {

    @Autowired
    StatementService statementService;


    /**
     * Получить заявку
     *
     * @return заявка
     */
    @PostMapping(value = "findStatement")
    @ResponseBody
    public List<Statement> findStatement(
            @RequestParam(required = false) String clientName,
            @RequestParam(required = false) String statementName,
            @RequestParam(required = false) String statementStatus,
            @RequestParam(required = false) Long date,
            @RequestParam(required = false) Long dateFrom,
            @RequestParam(required = false) Long dateTo,
            @RequestParam(required = false, defaultValue = "dateGet") String sortBy,
            @RequestParam(required = false, defaultValue = "false") Boolean desc
    ) {
       return null;
    }

    @PutMapping
    public Statement preformStatement(@RequestBody Statement statement){
        return null; //statementService.performStatement(statement);
    }
}
