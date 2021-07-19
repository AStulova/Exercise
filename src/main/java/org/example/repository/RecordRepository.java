package org.example.repository;

import org.example.constant.Queries;
import org.example.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record,Integer> {

    Record findTopByOrderByIdDesc();

    @Query(Queries.AVG)
    int getAvg(List<Integer> ids);

    @Query(Queries.COUNT)
    int getCount(List<Integer> ids);

    @Query(Queries.MAX)
    int getMax(List<Integer> ids);

    @Query(Queries.MIN)
    int getMin(List<Integer> ids);

    @Query(Queries.SUM)
    int getSum(List<Integer> ids);


    @Query(Queries.AVG_ALL)
    int getAvgAll();

    @Query(Queries.COUNT_ALL)
    int getCountAll();

    @Query(Queries.MAX_ALL)
    int getMaxAll();

    @Query(Queries.MIN_ALL)
    int getMinAll();

    @Query(Queries.SUM_ALL)
    int getSumAll();
}
