package sample._02_pattern._03_domainService._05;

import java.util.ArrayList;

public class PhysicalDistributionBase
{
    private ArrayList<Baggage> baggages;

    public PhysicalDistributionBase(ArrayList<Baggage> baggages) {
        this.baggages = baggages;
    }

    public ArrayList<Baggage> getBaggages() {
        return baggages;
    }

    public void setBaggages(ArrayList<Baggage> baggages) {
        this.baggages = baggages;
    }
}
