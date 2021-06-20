package sample._02_pattern._03_domainService._04;

public class TransportService
{
    public void Transport(
            PhysicalDistributionBase from,
            PhysicalDistributionBase to,
            Baggage baggage)
    {
        var shippedBaggage = from.ship(baggage);
        to.receive(shippedBaggage);

        // 配送の記録を行う
    }
}