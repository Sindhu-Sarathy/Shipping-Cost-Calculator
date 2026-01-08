package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import se.lexicon.calculator.ExpressInternationalShipping;
import se.lexicon.calculator.StandardDomesticShipping;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCalculatorFactory;
import se.lexicon.service.ShippingCostCalculator;
import se.lexicon.service.ShippingService;

import java.util.List;

@Configuration
//@ComponentScan("se.lexicon.*")
public class AppConfig {

    @Bean
    public ShippingCalculatorFactory shippingCalculatorFactory(List<ShippingCostCalculator> shippingCostCalculators){
        return new ShippingCalculatorFactory(shippingCostCalculators);
    }

    @Bean
    public ShippingService shippingService(ShippingCalculatorFactory factory){
        return new ShippingService(factory);
    }

    @Bean
    public ShippingCostCalculator standardDomesticShipping(){
        return new StandardDomesticShipping();
    }

    @Bean
    public ShippingCostCalculator expressInternationShipping(){
        return new ExpressInternationalShipping();
    }
}
