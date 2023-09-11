package com.example.jiekou1.entiy;

import lombok.Data;

import java.math.BigDecimal;

/**
 * name 场站名
 * day_gas_amount 日输气量     日输气量和  sumDay
 * sumMonth 月输气量和
 * sumYear 年输气量和
 */

@Data
public class GasConsumption {
        private String name;
        private BigDecimal sumDay;
        private BigDecimal sumMonth;
        private BigDecimal sumYear;
}
