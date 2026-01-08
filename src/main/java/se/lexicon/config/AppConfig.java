package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import se.lexicon.calculator.ExpressDomesticShipping;
import se.lexicon.calculator.ExpressInternationalShipping;
import se.lexicon.calculator.StandardDomesticShipping;
import se.lexicon.calculator.StandardInternationalShipping;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCalculatorFactory;
import se.lexicon.service.ShippingCostCalculator;
import se.lexicon.service.ShippingService;

import java.util.List;

@Configuration
//@ComponentScan("se.lexicon.*")
@PropertySource("classpath:application.properties")
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
    @Bean
    public ShippingCostCalculator standardInternationalShipping() {
        return new StandardInternationalShipping();
    }

    @Bean
    public ShippingCostCalculator expressDomesticShipping() {
        return new ExpressDomesticShipping();
    }

}
