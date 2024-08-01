package com.chocoh.ql;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chocoh.ql.common.constant.Constants;
import com.chocoh.ql.domain.entity.User;
import com.chocoh.ql.domain.model.Response;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author chocoh
 * @createTime 2024-01-29 00:13
 */
@SpringBootTest
public class QlApplicationTest {
    public static void main(String[] args) {
        Response success = Response.success(new ArrayList<>());
        QlApplicationTest.printJson(success);

        Response response = Response.dataMap()
                .put("1", "参数一")
                .put("2", "参数二")
                .getMap("3")
                .put("3.1", System.currentTimeMillis())
                .put("3.2", new Random().nextInt(8))
                .getMap("3.3")
                .put("4.1", Constants.ROLE_ADMIN)
                .put("4.2", new User(1L, "chocoh", "123123", null,  "admin"))
                .put("4.3", new Response.DataMap().put("5.1", true).put("5.2", ""))
                .ok()
                .put("其他外层参数", "...");
        QlApplicationTest.printJson(response);
    }

    public static void printJson(Object obj) {
        JSON json = JSON.parseObject(JSON.toJSONString(obj));
        String formattedJsonString = JSONObject.toJSONString(json, true);
        System.out.println(formattedJsonString);
    }
}
