package org.example.entities;

import java.security.PublicKey;

public class Company extends TaxPayer {

    private Integer employees;

    public Company(){
        super();
    }

    public Company(String name, Double income, Integer employees) {
        super(name, income);
        this.employees = employees;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    @Override
    public double tax() {
        double companyTax = 0.0;
        if (employees > 10){

            companyTax = getIncome() * 14/100;
        }
        else {
            companyTax = getIncome() * 16/100;
        }
        return companyTax;
    }

}
