package com.concreteitsolutions.generic.externaldata.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class ExternalData {

    private String col1;

    private String col2;

    private String col3;

    public void setValue(String value, int position) {
        col1 = position == 1 ? value : col1;
        col2 = position == 2 ? value : col2;
        col3 = position == 3 ? value : col3;

    }
}
