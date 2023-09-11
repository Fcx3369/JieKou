package com.example.jiekou1.Mapper;

import com.example.jiekou1.entiy.GasConsumption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GasConsumptionMapper {

    @Select("SELECT A.name,A.sumDay,B.sumMonth,C.sumYear\n" +
            "FROM \n" +
            "\t(\n" +
            "\t\tSELECT station_info.name AS 'name',gas_transmission_handover_info.day_gas_amount AS `sumDay`\n" +
            "\t\tFROM station_info INNER JOIN gas_transmission_handover_info\n" +
            "\t\tON station_info.data_id = gas_transmission_handover_info.station_id\n" +
            "\t\tAND gas_transmission_handover_info.handover_begin_time = '2023-03-13 08:00:00'\n" +
            "\t)AS A\n" +
            "\tINNER JOIN\n" +
            "\t(\n" +
            "\t\tSELECT station_info.name AS 'name',SUM(gas_transmission_handover_info.day_gas_amount) AS 'sumMonth'\n" +
            "\t\tFROM station_info INNER JOIN gas_transmission_handover_info\n" +
            "\t\tON station_info.data_id = gas_transmission_handover_info.station_id\n" +
            "\t\tWHERE YEAR(gas_transmission_handover_info.handover_begin_time) = YEAR(CURRENT_DATE())\n" +
            "\t\tAND MONTH(gas_transmission_handover_info.handover_begin_time) = '03'\n" +
            "\t\tgroup by station_info.name\n" +
            "\t)AS B\n" +
            "\tON A.name = B.name\n" +
            "\tINNER JOIN\n" +
            "\t(\n" +
            "\t\tSELECT station_info.name,SUM(gas_transmission_handover_info.day_gas_amount) AS 'sumYear'\n" +
            "\t\tFROM station_info INNER JOIN gas_transmission_handover_info\n" +
            "\t\tON station_info.data_id = gas_transmission_handover_info.station_id\n" +
            "\t\tWHERE YEAR(gas_transmission_handover_info.handover_begin_time) = '2023'\n" +
            "\t\tgroup by station_info.name\n" +
            "\t)AS C\n" +
            "\tON B.name = C.name\n" +
            "\tgroup by A.name")
    List<GasConsumption> GasConsumptionAll();

}
