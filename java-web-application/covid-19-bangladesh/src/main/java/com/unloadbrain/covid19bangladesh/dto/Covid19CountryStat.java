package com.unloadbrain.covid19bangladesh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Covid19CountryStat {

    private String totalAffected;
    private String totalDeath;
    private String totalRecovered;
    private long unixTimestamp;

}
