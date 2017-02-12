package com.concreteitsolutions.generic.externaldata;


import com.concreteitsolutions.commonframework.core.exceptions.tmp.LOG;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.generic.externaldata.model.ExternalData;
import com.concreteitsolutions.generic.prospect.ProspectProcess;
import com.concreteitsolutions.generic.prospect.model.Prospect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.concreteitsolutions.generic.externaldata.ExternalDataService;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Component
public class ExternalDataProcessImpl implements ExternalDataProcess {

    private final ExternalDataService externalDataService;

    private final ProspectProcess prospectProcess;

    @Autowired
    public ExternalDataProcessImpl(ProspectProcess prospectProcess, ExternalDataService externalDataService) {
        this.prospectProcess = prospectProcess;
        this.externalDataService = externalDataService;
    }

    public void importExternalData(final InputStream file, ExternalDataSource externalDataSource) {

        List<ExternalData> externalDataList = externalDataService.retrieveDataFromExternalFile(file, externalDataSource);

        LOG.debug("External data list retrieved : ", externalDataList);

        switch (externalDataSource.getDataModel()) {

            case Prospect.DATA_MODEL_NAME:

                List<Prospect> prospectList = findProspectsFromRetrievedDatas(externalDataList);

                linkProspectToExternalDataSource(prospectList, externalDataSource);

                LOG.debug("List of prospects to save :", prospectList);

                externalDataService.saveExternalData(externalDataSource);

                prospectProcess.saveProspectList(prospectList);

            default:
                //TODO: Throw ExternalDataFunctionalException instead
                throw new IllegalArgumentException();
        }
    }

    /**
     * PRIVATE FUNCTIONS
     */
    private List<Prospect> findProspectsFromRetrievedDatas(List<ExternalData> externalDataList) {

        List<Prospect> prospects = new ArrayList<Prospect>();

        for (ExternalData externalData : externalDataList) {

            Prospect currentProspect = Prospect.builder()
                    .firstName(externalData.getCol1())
                    .phoneNumber(externalData.getCol2())
                    .build();

            prospects.add(currentProspect);
        }
        return prospects;
    }

    private void linkProspectToExternalDataSource(List<Prospect> prospectList, ExternalDataSource externalDataSource) {
        for(Prospect p: prospectList) {
            p.setExternalDataSource(externalDataSource);
        }

    }
}
