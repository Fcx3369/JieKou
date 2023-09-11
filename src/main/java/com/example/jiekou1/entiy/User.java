package com.example.jiekou1.entiy;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 实体类
 * handover_begin_time 记录开始时间 time
 * abbreviation 管段 abb
 *max_gas_supply_pressure 管段最大压力 MaxGas
 *
 */
@Data
public class User {
    private Timestamp time;
    private BigDecimal MaxGas;
    private String abb;

}
