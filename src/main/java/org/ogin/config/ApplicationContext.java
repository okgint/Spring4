package org.ogin.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author ogin
 */
@Configuration
@Import({WebAppContext.class, PersistenceContext.class})
@ComponentScan(basePackages = {
        "org.ogin.dao"
})
@PropertySource("classpath:application.properties")
public class ApplicationContext {
    @Bean
    public PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
