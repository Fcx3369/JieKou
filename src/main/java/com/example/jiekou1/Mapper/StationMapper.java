package com.example.jiekou1.Mapper;

import com.example.jiekou1.entiy.Station;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StationMapper {

    @Select("SELECT name,SUM(day_gas_amount) AS sumGas\n" +
            "FROM station_info,gas_transmission_handover_info\n" +
            "WHERE station_info.data_id = gas_transmission_handover_info.station_id\n" +
            "AND gas_transmission_handover_info.handover_begin_time = '2023-04-13 08:00:00'\n" +
            "GROUP BY station_info.name")
    List<Station> StationAll();
}
