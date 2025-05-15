package com.codiapp.codi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodiApplication implements CommandLineRunner {

    @Autowired
    private HelloRepository helloRepository;

    public static void main(String[] args) {
        SpringApplication.run(CodiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Hello hello = new Hello();
        hello.setId(1L);
        hello.setMessage("Hello Oracle!");

        helloRepository.save(hello);

        System.out.println(" 저장 완료!");
    }

}
