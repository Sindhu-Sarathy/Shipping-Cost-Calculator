package se.lexicon.calculator;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

public class ExpressInternationalShipping implements ShippingCostCalculator {
    @Value("${international.base}")
    private double internationalBase;
    @Value("${express}")
    private double express;

    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.INTERNATIONAL && r.speed() == Speed.EXPRESS;
    }

    public double calculate(ShippingRequest r) {
        return internationalBase + express * r.weightKg();
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Express International Shipping is created");
    }
}
