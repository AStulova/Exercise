package org.example.service;

import org.example.model.Record;

import java.util.List;
import java.util.Map;

public interface RecordService {
    List<Record> findAll();
    Record findLast();
    int addNumber(int value);
    int calculateFunction(String functionName, String ids);
    Map<String, String> validateCalculation(String function, String ids);
}
