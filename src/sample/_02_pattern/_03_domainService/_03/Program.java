package sample._02_pattern._03_domainService._03;

public class Program {
    public static void main(String[] args){
        var baggage = new Baggage(new BaggageId("target"));
        var from = new PhysicalDistributionBase();
        var to = new PhysicalDistributionBase();

        var shiped = from.ship(baggage);
        to.receive(shiped);
    }
}
