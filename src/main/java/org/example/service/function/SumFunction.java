package org.example.service.function;

import org.example.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class SumFunction implements Function {
    private RecordRepository recordRepository;

    @Override
    public int calculate(List<Integer> ids) {
        if (!ids.isEmpty()) {
            return recordRepository.getSum(ids);
        }
        return recordRepository.getSumAll();
    }

    @Required
    public void setRecordRepository(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }
}
