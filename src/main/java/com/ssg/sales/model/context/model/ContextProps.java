package com.ssg.sales.model.context.model;

import lombok.Data;

@Data
public class ContextProps {
    private String schemaName;
    private String orgCode;
    private Integer orgId;
    private Integer branchId;
    private Integer invId;
}
