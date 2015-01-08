
/*
 * Kai
 */
package com.team1.proj.konfig;

import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import com.team1.proj.repository.BrukerTemplateRepositoryImpl;
import com.team1.proj.repository.BrukerRepository;
import com.team1.proj.service.BrukerService;
import com.team1.proj.service.BrukerServiceImpl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableWebMvc  // mvc annotation
@ComponentScan(basePackages = {"com.team1.proj.controller"}) // pakken der controllerne ligger
public class Konfig extends WebMvcConfigurationSupport {

    @Bean
    public TilesConfigurer tilesConfigurer() {
        return new TilesConfigurer();
    }

    @Bean
    public TilesViewResolver tilesViewResolver() {
        TilesViewResolver tilesViewResolver = new TilesViewResolver();
        //tilesViewResolver.setOrder(0);
        return tilesViewResolver;
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("/WEB-INF/messages");
        return source;
    }

    // equivalents for <mvc:resources/> tags
    // Hvor finnes statisk ressurser som bilder/ css/ js osv.
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
    }

    @Override
    @Bean
    public HandlerMapping resourceHandlerMapping() {
        AbstractHandlerMapping handlerMapping = (AbstractHandlerMapping) super.resourceHandlerMapping();
        handlerMapping.setOrder(-1);
        return handlerMapping;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    public DataSource dataSource(){
        String url = "jdbc:derby://localhost:1527/sysdbtest";
        String username = "brukernavn";
        String password = "passord";
        DriverManagerDataSource dmds = new DriverManagerDataSource(url, username, password);
        dmds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        try{
            Connection con = dmds.getConnection();
            System.out.println(" *********  Konfig " + con );
            //getAllePersoner(con); //brukes for testing av oppkobling
        }catch(Exception e){
            System.out.println(" Konfig.Feil ved henting av conncetion() " + e);
        }
        return dmds;
    }
    
    @Bean 
    public BrukerRepository repository(){
        return new BrukerTemplateRepositoryImpl();
        //return new PersonDatabaseRepositoryImpl();
    } 
    
    @Bean
    public BrukerService brukerService(){
        return new BrukerServiceImpl();
    }
}

