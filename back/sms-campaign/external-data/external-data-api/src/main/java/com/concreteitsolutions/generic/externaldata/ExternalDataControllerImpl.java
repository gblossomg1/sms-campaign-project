package com.concreteitsolutions.generic.externaldata;

import com.concreteitsolutions.commonframework.core.exceptions.tmp.LOG;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSourceFormat;
import com.concreteitsolutions.framework.api.model.APIResponse;
import com.concreteitsolutions.generic.externaldata.exceptions.ExternalDataTechnicalException;
import com.concreteitsolutions.generic.externaldata.model.ExternalDataSourceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Component
public class ExternalDataControllerImpl implements ExternalDataController {

    private final ExternalDataProcess externalDataProcess;

    private final ExternalDataService externalDataService;

    @Autowired
    public ExternalDataControllerImpl(ExternalDataProcess externalDataProcess, ExternalDataService externalDataService) {
        this.externalDataProcess = externalDataProcess;
        this.externalDataService = externalDataService;
    }

    public ResponseEntity<String> importExternalData(@RequestParam("file") MultipartFile file, @PathVariable("dataModel") String dataModel, @RequestParam("format") String format) {

        LOG.debug("Entered in import data controller ..");

        ExternalDataSource externalDataSource = ExternalDataSource.builder()
                .dataModel(dataModel)
                .fileName(file.getOriginalFilename())
                .format(ExternalDataSourceFormat.from(format))
                .importDate(new Date())
                .build();

        externalDataProcess.importExternalData(findInputStream(file), externalDataSource);

        //TODO: Return informations about import operation.
        return ResponseEntity.status(HttpStatus.OK).body("OK");
    }

    public ResponseEntity<APIResponse> findExternalData(@RequestBody ExternalDataSourceView externalDataSourceView) {
        ExternalDataSource externalDataSource = ExternalDataSourceView.toExternalData(externalDataSourceView);
        APIResponse externalDataSearchResponse = APIResponse.builder()
                .entity(ExternalDataSourceView.from(externalDataService.searchExternalData(externalDataSource)))
                .build();

        return ResponseEntity.ok(externalDataSearchResponse);
    }


    /**
     * Private functions
     */

    private InputStream findInputStream(final MultipartFile file) {

        try {
            return file.getInputStream();
        } catch (IOException e) {

            e.printStackTrace();
            throw new ExternalDataTechnicalException(ExternalDataTechnicalException.ExternalDataError.FILE_INPUT_ERROR, "Error while reading uploaded file");
        }
    }
}
