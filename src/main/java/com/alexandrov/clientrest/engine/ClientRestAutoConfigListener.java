package com.alexandrov.clientrest.engine;

import com.alexandrov.clientrest.annotations.ClientRestEntity;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

@Component
public class ClientRestAutoConfigListener {

    @Value("${clientrest.entity.package}")
    private String basePackage;

    @Autowired
    private ClientRestConfiguration clientRestConfiguration;

    @EventListener
    @SneakyThrows
    public void handleContextRefresh(ContextRefreshedEvent event) {
        ClassPathScanningCandidateComponentProvider classScanner = new ClassPathScanningCandidateComponentProvider(false);
        classScanner.addIncludeFilter(new AnnotationTypeFilter(ClientRestEntity.class));
        for (BeanDefinition beanDefinition : classScanner.findCandidateComponents(basePackage)) {
            clientRestConfiguration.addEntity(beanDefinition.getBeanClassName());
        }
    }
}
