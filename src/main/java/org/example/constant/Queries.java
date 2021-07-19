package org.example.constant;

public interface Queries {
    String AVG = "select avg (value) from Record where id in (?1)";
    String COUNT = "select count (value) from Record where id in (?1)";
    String MAX = "select max (value) from Record where id in (?1)";
    String MIN = "select min (value) from Record where id in (?1)";
    String SUM = "select sum (value) from Record where id in (?1)";

    String AVG_ALL = "select avg (value) from Record";
    String COUNT_ALL = "select count (value) from Record";
    String MAX_ALL = "select max (value) from Record";
    String MIN_ALL = "select min (value) from Record";
    String SUM_ALL = "select sum (value) from Record";

}
