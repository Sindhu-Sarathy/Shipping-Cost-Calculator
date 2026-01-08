package se.lexicon.calculator;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

public class StandardInternationalShipping implements ShippingCostCalculator {
    @Value("${international.base}")
    private double internationlBase;
    @Value("${standard}")
    private double standard;

    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.INTERNATIONAL && r.speed() == Speed.STANDARD;
    }

    public double calculate(ShippingRequest r) {
        return internationlBase + standard * r.weightKg();
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Standard International Shipping is created");
    }
}
