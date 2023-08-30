package org.fullstack.springbootecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.nimbus.State;

import org.fullstack.springbootecommerce.etinty.Country;
import org.fullstack.springbootecommerce.etinty.Product;
import org.fullstack.springbootecommerce.etinty.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {
    private EntityManager entityManager;

    @Autowired
    public DataRestConfig (EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        HttpMethod[] theUnsupportedActions = { HttpMethod.POST, HttpMethod.DELETE };

        // disable method for get, put, delete on product
        config.getExposureConfiguration().forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        // disable method get, put, delete for product category
        config.getExposureConfiguration().forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        // disable method post, put, del for country HTTP
        config.getExposureConfiguration().forDomainType(Country.class).
        withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)).withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        //disable method post, put, delete for states
        config.getExposureConfiguration().forDomainType(State.class).
        withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)).withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        exposesId(config);
    }

     private void exposesId(RepositoryRestConfiguration config){
        //fetch all datas
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        //make an array from entity type
        List<Class> entityClasses = new ArrayList<>();

        //get entity type from entities
        for (EntityType tempEntitype: entities){
            entityClasses.add(tempEntitype.getJavaType());
        }

        //expose entity id for specific domain
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }

}
