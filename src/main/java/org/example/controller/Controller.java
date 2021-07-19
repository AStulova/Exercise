package org.example.controller;

import org.example.model.Operation;
import org.example.model.Record;
import org.example.service.RecordService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ImportResource("classpath:context.xml") // без этой аннотации почему-то не работает
public class Controller {

    private RecordService service;

    @GetMapping("/")
    public ModelAndView getMainPage() {
        return getModelAndView();
    }

    @PostMapping("/add-value")
    public ModelAndView addNumber(int value) {
        int id = service.addNumber(value);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/calculate")
    public ModelAndView getResultFromAggregateOperation(String function, String ids) {
        ModelAndView modelAndView = getModelAndView();
        Map<String, String> errorMap = service.validateCalculation(function, ids);
        if (errorMap.isEmpty()) {
            Operation operation = new Operation(function, ids, service.calculateFunction(function, ids));
            modelAndView.addObject("lastOperation", operation);
        }
        else {
            modelAndView.addObject("errorMap", errorMap);
        }
        return modelAndView;
    }

    public ModelAndView getModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        int id;
        String name = "";
        List<Record> recordsList = service.findAll();
        if (!recordsList.isEmpty()){
            id = service.findLast().getId();
            modelAndView.addObject("newRecordId", id);
        }
        modelAndView.addObject("errorMap", new HashMap<>());
        modelAndView.addObject("nameOperation", name);
        modelAndView.addObject("recordsList", recordsList);
        modelAndView.addObject("operationAttributes", new Operation());
        modelAndView.addObject("record", new Record());
        modelAndView.setViewName("Page");
        return modelAndView;
    }

    @Required
    public void setService(RecordService service) {
        this.service = service;
    }
}
