package com.concreteitsolutions.generic.externaldata.model;

import com.concreteitsolutions.commonframework.core.date.DateUtils;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSource;
import com.concreteitsolutions.commonframework.core.externaldata.ExternalDataSourceFormat;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
@Data
@Builder
public class ExternalDataSourceView {

    private Long id;

    private ExternalDataSourceFormat format;

    private String fileName;

    private String dataModel;

    private String importDate;

    private String businessEntity;

    public static ExternalDataSource toExternalData(ExternalDataSourceView externalDataSourceView) {

        ExternalDataSource externalDataSource = new ExternalDataSource(new Date());

        if(externalDataSourceView.getId() != null) {
            externalDataSource.setId(externalDataSource.getId());
        }
        if (externalDataSourceView.getFormat() != null) {
            externalDataSource.setFormat(externalDataSourceView.getFormat());
        }
        if (externalDataSourceView.getDataModel() != null && !externalDataSourceView.getDataModel().equals("")) {
            externalDataSource.setDataModel(externalDataSourceView.getDataModel());
        }
        return externalDataSource;
    }

    public static List<ExternalDataSourceView> from(List<ExternalDataSource> externalDataSourceList) {
        List<ExternalDataSourceView> externalDataSourceViews = new ArrayList<ExternalDataSourceView>();

        for (ExternalDataSource externalDataSource : externalDataSourceList) {
            externalDataSourceViews.add(ExternalDataSourceView.from(externalDataSource));
        }
        return externalDataSourceViews;
    }

    public static ExternalDataSourceView from(final ExternalDataSource externalDataSource) {
        ExternalDataSourceView externalDataSourceView = ExternalDataSourceView.builder()
                .id(externalDataSource.getId())
                .format(externalDataSource.getFormat())
                .fileName(externalDataSource.getFileName())
                .dataModel(externalDataSource.getDataModel())
                .importDate(DateUtils.parseDate(externalDataSource.getImportDate(), DateUtils.DEFAULT_FRENCH_PATTERN))
                .businessEntity(externalDataSource.getBusinessEntity())
                .build();

        return externalDataSourceView;

    }
}
