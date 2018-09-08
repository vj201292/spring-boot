package com.vj.springboot.springbootmongohotelservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public void run(String... strings) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                130, new Address("Peris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Marry", 7, true),
                        new Review("sam", 9, false)
                )
        );

        Hotel ibis = new Hotel(
                "ibis",
                90, new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 9, true),
                        new Review("Max", 7, false)
                )
        );

        Hotel sofitel = new Hotel(
                "sofitel",
                130, new Address("Rome", "Italy"),
                Arrays.asList(
                        new Review("Alen", 8, false),
                        new Review("john", 7, true)
                )
        );

        //drop hotels
        this.hotelRepository.deleteAll();
        List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
        this.hotelRepository.save(hotels);
    }
}
