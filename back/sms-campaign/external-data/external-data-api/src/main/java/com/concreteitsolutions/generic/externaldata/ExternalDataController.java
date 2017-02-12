package com.concreteitsolutions.generic.externaldata;

import com.concreteitsolutions.framework.api.model.APIResponse;
import com.concreteitsolutions.generic.externaldata.model.ExternalData;
import com.concreteitsolutions.generic.externaldata.model.ExternalDataSourceView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("/external-data")
@CrossOrigin
public interface ExternalDataController {

    @RequestMapping(value = "/excel/{dataModel}", method = RequestMethod.POST)
    ResponseEntity<String> importExternalData(@RequestParam("fileInput") MultipartFile file, @PathVariable("dataModel") String dataModel, @RequestParam("format") String format);

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    ResponseEntity<APIResponse> findExternalData(@RequestBody ExternalDataSourceView externalDataSourceView);

}
