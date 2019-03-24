package cz.ucl.fa.event;

import cz.ucl.fa.model.Contract;

import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.interceptor.Interceptor;
import java.io.Serializable;

@Dependent
public class CustomerNotifier implements Serializable {

    // Pro synchronní variantu použijte @Observes
    public void notifyCustomer(@ObservesAsync TripPurchaseCompleted tripCompletedEvent) {
        Contract c = tripCompletedEvent.getContract();
        System.out.println("The customer will be notified about the contract for " + c.getHoliday().getName() +
                " and " + c.getTravellers().size() + " travellers.");
    }
}