package com.dem.web;

import com.dem.domain.Person;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Controller
public class FreemarkTestController {

    @RequestMapping(value = "/freemark", method = RequestMethod.GET)
    public String page(ModelMap model) {
        List<String> nameList = Arrays.asList("应灵月_15536235658", "胡小中_13022221203", "余翼_13333656236", "爸_13320202012", "蔡挺_13356562520", "余翼_13586897041", "史金方_13586891137", "柳林永_13456112605", "胡小中_13858251801", "应灵月_13566509098", "马丹_13736195112", "王辉_15168513701", "蔡先菊_15257876026", "应金岳_15906568845", "马冬民_13736082177");
        model.put("title", "天秀娟");
        model.put("string", "1");
        model.put("rangData", 20);
        model.put("curTime", new Date());
        model.put("price", 10000.00D);
        model.put("nameList",nameList);
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person p = new Person();
            p.setId(i + "");
            p.setName("天秀娟" + i);
            list.add(p);
        }


        model.put("personList", list);
        return "/freemark";
    }

    public static void main(String[] args) throws IOException, TimeoutException {


    }

    private Connection getConn() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        return factory.newConnection();
    }
}
