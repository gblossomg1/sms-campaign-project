package com.concreteitsolutions.generic.prospect;

import com.concreteitsolutions.framework.api.model.APIResponse;
import com.concreteitsolutions.generic.prospect.model.ProspectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProspectControllerImpl implements ProspectController {

    private final ProspectService prospectService;

    private final ProspectProcess prospectProcess;

    @Autowired
    public ProspectControllerImpl(ProspectService prospectService, ProspectProcess prospectProcess) {

        this.prospectService = prospectService;
        this.prospectProcess = prospectProcess;
    }

    public List<ProspectView> findAllProspects() {
        return ProspectView.from(prospectService.findAll());
    }

    public ResponseEntity<APIResponse> findProspectsByDataSource(Long externalDataSourceId) {

        APIResponse prospectSearchResult = APIResponse.builder()
                .entity(prospectProcess.findByExternalDataSource(externalDataSourceId))
                .build();

        return ResponseEntity.ok(prospectSearchResult);
    }
}
