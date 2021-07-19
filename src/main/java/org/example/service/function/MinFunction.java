package org.example.service.function;

import org.example.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class MinFunction implements Function {
    private RecordRepository recordRepository;

    @Override
    public int calculate(List<Integer> ids) {
        if (!ids.isEmpty()) {
            return recordRepository.getMin(ids);
        }
        return recordRepository.getMinAll();
    }

    @Required
    public void setRecordRepository(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }
}
