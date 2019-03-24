package cz.ucl.fa.event;

import cz.ucl.fa.model.Contract;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.ObservesAsync;
import java.io.Serializable;

@Dependent
public class TripPaymentController implements Serializable {

    // Pro synchronní variantu použijte @Observes
    public void payForTrip(@ObservesAsync TripPurchaseCompleted tripCompletedEvent) {
        Contract c = tripCompletedEvent.getContract();
        int travellers = c.getTravellers().size();
        System.out.println("Paying for the holiday: " + c.getHoliday().getName() +
                " for " + travellers + " travellers, price:" + travellers * c.getHoliday().getPrice());
    }
}