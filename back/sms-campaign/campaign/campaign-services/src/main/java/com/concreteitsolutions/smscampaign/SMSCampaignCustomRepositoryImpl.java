package com.concreteitsolutions.smscampaign;

import com.concreteitsolutions.commonframework.core.exceptions.tmp.LOG;
import com.concreteitsolutions.smscampaign.model.SMSCampaign;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SMSCampaignCustomRepositoryImpl implements SMSCampaignCustomRepository {

    private PlatformTransactionManager transactionManager;

    @Autowired
    public SMSCampaignCustomRepositoryImpl(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public List<SMSCampaign> search(SMSCampaign smsCampaign) {

        LOG.debug("Enter in sms campaign search method");

        JpaTransactionManager jpaTransactionManager = (JpaTransactionManager) transactionManager;
        EntityManagerFactory emf = jpaTransactionManager.getEntityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();
        Session session = entityManager.unwrap(Session.class);

        Criteria criteria = session.createCriteria(SMSCampaign.class);

        Map<String, Object> filters = new HashMap<String, Object>();

        if(smsCampaign.getCustomerName() != null) {
            filters.put(SMSCampaign.CUSTOMER_NAME, smsCampaign.getCustomerName());
        }
        if(smsCampaign.getProspectQuantity() != null) {
            filters.put(SMSCampaign.PROSPECT_QUANTITY, smsCampaign.getProspectQuantity());
        }
        if(smsCampaign.getReference() != null) {
            filters.put(SMSCampaign.REFERENCE, smsCampaign.getReference());
        }
        if(smsCampaign.getState() != null) {
            filters.put(SMSCampaign.STATE, smsCampaign.getState());
        }
        if(smsCampaign.getName() != null && !smsCampaign.getName().equals("")) {
            criteria.add(Restrictions.like(SMSCampaign.NAME, smsCampaign.getName() + "%"));
        }

        criteria.add(Restrictions.allEq(filters));
        List list = criteria.list();

        LOG.debug("Returning criteria api result : ", list);

        entityManager.close();

        return list;
    }
}
