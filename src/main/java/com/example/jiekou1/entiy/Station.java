package com.example.jiekou1.entiy;

import lombok.Data;

import java.math.BigDecimal;

/**
 * name 场站名
 * day_gas_amount 日输气量     日输气量和  sumGas
 */
@Data
public class Station {
    private String name;
    private BigDecimal sumGas;
}
