package org.example.service;

import org.example.model.Record;
import org.example.repository.RecordRepository;
import org.example.service.function.Function;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecordServiceImpl implements RecordService {
    private RecordRepository recordRepository;
    private Map<String, Function> functionMap;

    @Override
    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public Record findLast() {
        return recordRepository.findTopByOrderByIdDesc();
    }

    @Override
    public int addNumber(int value) {
        Record record = new Record(value);
        return recordRepository.save(record).getId();
    }

    @Override
    public int calculateFunction(String functionName, String ids) {
        Function function = functionMap.get(functionName);
        List<Integer> idsList = new ArrayList<>();
        if (ids != null) {
            idsList = Stream.of(ids.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        return function.calculate(idsList);
    }

    @Override
    public Map<String, String> validateCalculation(String function, String ids) {
        Map<String, String> errorMap = new HashMap<>();
        if (function.isEmpty() || ids.isEmpty()) {
            errorMap.put("emptiness", "Fields are required!");
        }
        if (!ids.matches("(\\d+)(,\\s*\\d+)*")) {
            errorMap.put("wrongString", "Ids' values must be filled in with a comma!");
        }
        if (recordRepository.findAll().isEmpty()) {
            errorMap.put("emptyTable", "First fill the table!");
        }
        return errorMap;
    }

    @Required
    public void setRecordRepository(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Required
    public void setFunctionMap(Map<String, Function> functionMap) {
        this.functionMap = functionMap;
    }
}
