package com.github.fabriciolfj.clientservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {

    private Long id;
    private String describe;
}
