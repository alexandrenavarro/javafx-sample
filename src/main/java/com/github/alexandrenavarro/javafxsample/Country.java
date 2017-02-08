package com.github.alexandrenavarro.javafxsample;

import lombok.*;

/**
 * Created by anavarro on 06/02/17.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Country {
    private String name;
    private String alpha2Code;
    private String alpha3Code;
}
