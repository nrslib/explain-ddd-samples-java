package sample._02_pattern._03_domainService._03;

public class PhysicalDistributionBase
{
    public Baggage ship(Baggage baggage)
    {
        return baggage;
    }

    public void receive(Baggage baggage)
    {
        // ...
    }

    public void Transport(PhysicalDistributionBase to, Baggage baggage)
    {
        var shippedBaggage = ship(baggage);
        to.receive(shippedBaggage);

        // たとえば配送の記録は必要だろうか
    }
}
