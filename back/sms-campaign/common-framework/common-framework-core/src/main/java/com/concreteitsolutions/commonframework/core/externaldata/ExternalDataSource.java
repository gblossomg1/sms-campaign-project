package com.concreteitsolutions.commonframework.core.externaldata;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class ExternalDataSource {

    public static final String ID = "id";
    public static final String FORMAT = "format";
    public static final String DATA_MODEL = "dataModel";
    public static final String IMPORT_DATE = "importDate";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExternalDataSourceFormat format;

    private String fileName;

    private String dataModel;

    private String localStoragePath;

    private Date importDate;

    private String businessEntity;

    /** TODO:
     @ManyToOne
     @JoinColumn() private final String user; **/

    public ExternalDataSource(final Date date) {
        this.importDate = date;
    }

}
