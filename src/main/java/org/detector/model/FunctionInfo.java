package org.detector.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class FunctionInfo {
    private String name;
    private List<String> modifierList;
    private String returnType;
    private Integer paramCount;
    private Map<String,String> paramNameTypeMapper;
}
