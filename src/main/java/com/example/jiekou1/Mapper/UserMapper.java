package com.example.jiekou1.Mapper;

import com.example.jiekou1.entiy.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT\n" +
            "\tg.handover_begin_time AS time,\n" +
            "\tl.abbreviation AS abb,\n" +
            "\tavg(g.max_gas_supply_pressure) AS MaxGas\n" +
            "FROM\n" +
            "\tgas_transmission_handover_info AS g\n" +
            "\tLEFT OUTER JOIN line_info AS l ON g.pipeline_id = l.data_id \n" +
            "WHERE\n" +
            "\t(\n" +
            "\tl.abbreviation IN ( \"孝潜线\", \"孝大线\", \"荆石线\", \"武赤线\", \"黄麻线\", \"黄大线\" )) \n" +
            "\tAND ( g.handover_begin_time >= DATE_SUB( '2023-04-14', INTERVAL 7 DAY ) AND g.handover_begin_time < '2023-04-14' ) \n" +
            "GROUP BY\n" +
            "\tg.handover_begin_time,\n" +
            "\tl.abbreviation \n" +
            "ORDER BY\n" +
            "\tg.handover_begin_time DESC;" )
    List<User> findAll();

}
