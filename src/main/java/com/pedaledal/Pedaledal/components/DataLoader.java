package com.pedaledal.Pedaledal.components;

import com.pedaledal.Pedaledal.models.manufacturers.Manufacturer;
import com.pedaledal.Pedaledal.models.pedals.EffectType;
import com.pedaledal.Pedaledal.models.pedals.Pedal;
import com.pedaledal.Pedaledal.models.users.AgeRange;
import com.pedaledal.Pedaledal.models.users.User;
import com.pedaledal.Pedaledal.repositories.PedalRepository;
import com.pedaledal.Pedaledal.repositories.UserRepository;
import com.pedaledal.Pedaledal.repositories.ManufacturerRepository;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.Arrays;


@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PedalRepository pedalRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){

        User kenny = new User("Kenny", "kenny.mckeown@gmail.com", AgeRange.R_THREE, "Scotland", "Guitar", "Reverb");
        userRepository.save(kenny);

        User andy = new User("Andy", "ratboyjim@gmail.com", AgeRange.R_THREE, "Scotland", "Bass", "Overdrive");
        userRepository.save(andy);

        Manufacturer ChaseBlissAudio = new Manufacturer("Chase Bliss Audio", "Awesome pedal producer", "www.cba.com");
        manufacturerRepository.save(ChaseBlissAudio);

        Manufacturer boss = new Manufacturer("Boss", "The best pedal cunts", "www.boss-pedals.com");
        manufacturerRepository.save(boss);

        ArrayList<Manufacturer> blooperMans = new ArrayList<>();
        blooperMans.add(ChaseBlissAudio);

//        new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}}

        Pedal blooper = new Pedal("Blooper", "Fancy", "One of my favourites", true, EffectType.LOOPER, 5, "", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(blooper);

//        blooper.setManufacturers(new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}});
//        pedalRepository.save(blooper);

        blooper.addManufacturer(boss);
        pedalRepository.save(blooper);

        andy.addPedal(blooper);
        userRepository.save(andy);

        andy.setName("Dick face");
        userRepository.save(andy);

    }

}
