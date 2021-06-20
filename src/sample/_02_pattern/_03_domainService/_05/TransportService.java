package sample._02_pattern._03_domainService._05;

public class TransportService
{
    public void Transport(
            PhysicalDistributionBase from,
            PhysicalDistributionBase to,
            Baggage baggage)
    {
        var optTargetBaggage= from
                .getBaggages()
                .stream()
                .filter(x -> x.getId().equals(baggage.getId()))
                .findFirst();

        optTargetBaggage.map(x -> to.getBaggages().add(x));

        // 配送の記録を行う
    }
}