package com.example.springtest.canal;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

public class CanalTest {

    public static void main(String[] args) {

        CanalClient canalClient = new CanalClient();
        try {
            canalClient.afterPropertiesSet();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
