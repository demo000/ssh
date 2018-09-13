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
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Controller
public class FreemarkTestController {

    @RequestMapping(value = "/freemark", method = RequestMethod.GET)
    public String page(ModelMap model) {
        model.put("title", "天秀娟");
        model.put("string", "1");
        model.put("rangData",20);
        model.put("curTime",new Date());
        model.put("price",10000.00D);
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
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        factory.setPort(5672);
        Connection connection = factory.newConnection();

    }
}
