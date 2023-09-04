package com.springproject.albumproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
class AlbumProjectApplicationTests {

    @Test
    void contextLoads() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        formatter.format(date);
        System.out.println(date.toString());
      assert true;

    }

}
