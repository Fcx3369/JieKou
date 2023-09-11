package com.example.jiekou1.service;

import com.example.jiekou1.Mapper.UserMapper;
import com.example.jiekou1.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public List<User> findAll(){
        return userMapper.findAll();
        }


/**
    public User getData(){
        User user = new User();

        // 查询数据库获取time、abb和maxGas数据
        List<User> userList = userMapper.findAll();

        // 设置categories数据
        List<String> categories = userList.stream()
                .map(User::getTime)
                .distinct()
                .map(Timestamp::toString)
                .collect(Collectors.toList());
        user.setCategories(categories);

        // 设置series数据
        List<User.Series> seriesList = new ArrayList<>();
        for (User u : userList) {
            User.Series series = new User.Series();
            series.setName(u.getAbb());
            series.setData(Collections.singletonList(u.getMaxGas().doubleValue()));
            seriesList.add(series);
        }
        user.setSeries(seriesList);

        return user;
    }
**/
/** 对一半
public Map<String, Object> getData() {
    List<User> userList = findAll();

    List<String> categories = userList.stream()
            .map(User::getTime)
            .map(Timestamp::toString)
            .collect(Collectors.toList());

    List<Map<String, Object>> seriesList = userList.stream()
            .map(user -> {
                Map<String, Object> series = new HashMap<>();
                series.put("name", user.getAbb());
                series.put("data", Collections.singletonList(user.getMaxGas()));
                return series;
            })
            .collect(Collectors.toList());

    Map<String, Object> result = new HashMap<>();
    result.put("categories", categories);
    result.put("series", seriesList);

    return result;
}
**/
/** 接近，时间上留有0点未去除
public Map<String, Object> getData() {
    List<User> userList = findAll();

    List<String> categories = userList.stream()
            .map(User::getTime)
            .map(Timestamp::toString)
            .distinct()
            .collect(Collectors.toList());

    Map<String, List<Double>> seriesData = new HashMap<>();
    userList.forEach(user -> {
        String abb = user.getAbb();
        Double maxGas = user.getMaxGas().doubleValue();

        if (!seriesData.containsKey(abb)) {
            seriesData.put(abb, new ArrayList<>());
        }
        seriesData.get(abb).add(maxGas);
    });

    List<Map<String, Object>> seriesList = seriesData.entrySet().stream()
            .map(entry -> {
                Map<String, Object> series = new HashMap<>();
                series.put("name", entry.getKey());
                series.put("data", entry.getValue());
                return series;
            })
            .collect(Collectors.toList());

    Map<String, Object> result = new HashMap<>();
    result.put("categories", categories);
    result.put("series", seriesList);

    return result;
}
**/
public Map<String, Object> getData() {
    List<User> userList = findAll();

    List<String> categories = userList.stream()
            .map(User::getTime)
            .map(this::formatTime)
            .distinct()
            .collect(Collectors.toList());

    Map<String, List<Double>> seriesData = new HashMap<>();
    userList.forEach(user -> {
        String abb = user.getAbb();
        Double maxGas = user.getMaxGas().doubleValue();

        if (!seriesData.containsKey(abb)) {
            seriesData.put(abb, new ArrayList<>());
        }
        seriesData.get(abb).add(maxGas);
    });

    List<Map<String, Object>> seriesList = seriesData.entrySet().stream()
            .map(entry -> {
                Map<String, Object> series = new HashMap<>();
                series.put("name", entry.getKey());
                series.put("data", entry.getValue());
                return series;
            })
            .collect(Collectors.toList());

    Map<String, Object> result = new HashMap<>();
    result.put("categories", categories);
    result.put("series", seriesList);

    return result;
}

    private String formatTime(Timestamp timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(timestamp) + " 08:00:00.0";
    }


}

