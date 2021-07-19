package org.example.model;


public class Operation {
    private String function;
    private String ids;
    private int result;

    public Operation() {
    }

    public Operation(String function, String ids, int result) {
        this.function = function;
        this.ids = ids;
        this.result = result;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String name) {
        this.function = name;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
