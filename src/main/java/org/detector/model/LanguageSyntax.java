package org.detector.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class LanguageSyntax {
    private String name; // name of the language
    private String importKeyword;
    private List<String> words; // including reserved keywords, data type,etc
    private List<String> operators;
}
