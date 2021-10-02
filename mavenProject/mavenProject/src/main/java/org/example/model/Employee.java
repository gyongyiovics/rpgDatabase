package org.example.model;

import lombok.Getter;
import lombok.Setter;

public class Employee {
    @Getter
    @Setter
    private String employeeName;
    @Getter
    @Setter
    private String position;
    @Getter
    @Setter
    private double salary;

    public Employee() {
    }

    @Override
    public String toString(){
        return String.format("%s - %s - %f", employeeName, position, salary);
    }
}
