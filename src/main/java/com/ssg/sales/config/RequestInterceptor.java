package com.ssg.sales.config;

import com.ssg.sales.model.context.model.ContextProps;
import com.ssg.sales.model.context.model.DBContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    @PersistenceContext(unitName = "tenantUnit")
    @Qualifier("tenantEmf")
    EntityManager em;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
//        System.out.println("USER: "+request.getHeader("userId"));
//        Integer userId = Integer.valueOf(request.getHeader("userId"));
//        log.info("user id :"+userId);
        Integer userId = 1;

        Query query = em.createNativeQuery("select otsm.schema_name, o.org_code, u.org_id, u.branch_id, u.inventory_id " +
                "from org_type_schema_mapping otsm inner join organization o on otsm.org_code =o.org_code \n" +
                "inner join users u on o.id = u.org_id where u.id=?1");

//        query.setParameter(1, userId);
//        List<Object[]> contextList = query.getResultList();
        ContextProps contextProps = new ContextProps();
//        for(Object[] arr: contextList){
//            contextProps.setSchemaName(arr[0].toString());
//            contextProps.setOrgCode(arr[1].toString());
//            contextProps.setOrgId((Integer) arr[2]);
//            contextProps.setBranchId((Integer) arr[3]);
//            contextProps.setInvId((Integer) arr[4]);
//        }
        contextProps.setSchemaName("db_1");
        contextProps.setOrgCode("ORG_01");
        contextProps.setOrgId(1);
        contextProps.setBranchId(1);
        contextProps.setInvId(1);
        DBContext.setCurrentDBContext(contextProps);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        DBContext.clear();
    }

}
