package com.gk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @Author: GK
 * @Date: 2020/3/1
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountryMedal {

    private String countryName;

    private Integer goldNum;

    private Integer silverNum;

    private Integer bronzeNum;


}
