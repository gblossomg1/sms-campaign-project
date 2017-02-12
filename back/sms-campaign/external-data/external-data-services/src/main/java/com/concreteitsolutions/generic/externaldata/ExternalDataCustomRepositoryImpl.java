package com.concreteitsolutions.generic.externaldata;

import com.concreteitsolutions.commonframework.core.exceptions.tmp.LOG;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.generic.externaldata.model.ExternalData;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExternalDataCustomRepositoryImpl implements ExternalDataCustomRepository {

    private PlatformTransactionManager transactionManager;

    @Autowired
    public ExternalDataCustomRepositoryImpl(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public List<ExternalDataSource> searchExternalData(ExternalDataSource externalDataSource) {
        LOG.debug("Enter in external data search method");

        JpaTransactionManager jpaTransactionManager = (JpaTransactionManager) transactionManager;
        EntityManagerFactory emf = jpaTransactionManager.getEntityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();
        Session session = entityManager.unwrap(Session.class);

        Criteria criteria = session.createCriteria(ExternalDataSource.class);
        Map<String, Object> filters = new HashMap<String, Object>();

        if(externalDataSource.getId() != null) {
            filters.put(ExternalDataSource.ID, externalDataSource.getId());
        }
        if(externalDataSource.getDataModel() != null && !externalDataSource.getDataModel().equals("")){
            filters.put(ExternalDataSource.DATA_MODEL, externalDataSource.getDataModel());
        }
        if(externalDataSource.getFormat() != null) {
            filters.put(ExternalDataSource.FORMAT, externalDataSource.getFormat().name());
        }
        criteria.add(Restrictions.allEq(filters));
        List list = criteria.list();

        return list;
    }
}
