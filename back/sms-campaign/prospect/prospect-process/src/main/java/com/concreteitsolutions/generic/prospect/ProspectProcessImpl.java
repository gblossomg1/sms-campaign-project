package com.concreteitsolutions.generic.prospect;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.generic.externaldata.ExternalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.concreteitsolutions.generic.prospect.model.Prospect;
import com.concreteitsolutions.generic.prospect.model.ProspectSearchCriteria;

@Component
public class ProspectProcessImpl implements ProspectProcess {

    private final ProspectService prospectService;

    private final ExternalDataService externalDataService;


    @Autowired
    public ProspectProcessImpl(final ProspectService prospectService, ExternalDataService externalDataService) {
        this.prospectService = prospectService;
        this.externalDataService = externalDataService;
    }

    public List<Prospect> find(final ProspectSearchCriteria criteria, final Long length) {

        return prospectService.find(criteria, length);
    }

    public List<Prospect> find(long length) {
        return prospectService.find(null, length);
    }

    public void saveProspectList(List<Prospect> prospects) {

        prospectService.saveAll(prospects);
    }

    public List<Prospect> findByExternalDataSource(Long externalDataSourceId) {
        ExternalDataSource externalDataSource = externalDataService.findById(externalDataSourceId);
        return prospectService.findByExternalDataSource(externalDataSource);
    }

    private List<Prospect> checkProspectPhoneNumberValidity(List<Prospect> prospects) {
        List<Prospect> prospectList = new ArrayList<Prospect>();


        return prospectList;
    }

    private void formalizePhoneNumber() {

    }
}
