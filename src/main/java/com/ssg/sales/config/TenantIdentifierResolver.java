package com.ssg.sales.config;

import com.ssg.sales.model.context.model.ContextProps;
import com.ssg.sales.model.context.model.DBContext;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    private String defaultTenant ="public";

    @Override
    public String resolveCurrentTenantIdentifier() {
        if(DBContext.getCurrentDBContext() != null){
            log.info("tenant identified");
//            TenantContext
            ContextProps contextProp =  DBContext.getCurrentDBContext();

            log.info("tenant: "+contextProp.getSchemaName());
            return contextProp.getSchemaName();
        }
        log.info("no tenant identified, going with default");
        return defaultTenant;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
