package org.example.entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Individual(){
        super();
    }

    public Individual(String name, Double income, Double healthExpenditures) {
        super(name, income);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {
        double individualTax = 0.0;
        if (getIncome() > 20000){
             individualTax = getIncome() * 25/100 - getHealthExpenditures() * 1/2;
        }

        else if (getIncome() < 20000) {
            individualTax = getIncome() * 15/100 - getHealthExpenditures() * 1/2;
        }
        return individualTax;
    }
}
