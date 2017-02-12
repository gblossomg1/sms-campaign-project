package com.concreteitsolutions.generic.prospect;

import com.concreteitsolutions.framework.api.model.APIResponse;
import com.concreteitsolutions.generic.prospect.model.ProspectView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/prospects")
public interface ProspectController {

    /**
     * Retrieve all prospects that are available in the prospect table
     * @return List of prospects
     */
    List<ProspectView> findAllProspects();

    /**
     * Retrieve Prospects that have been imported by external data source identifier
     * @param externalDataSourceId External data source identifier
     * @return List of prospects
     */

    @RequestMapping(value = "/search/external-data/{externalDataSourceId}", method = RequestMethod.GET)
    ResponseEntity<APIResponse> findProspectsByDataSource(@PathVariable("externalDataSourceId") final Long externalDataSourceId);

}
