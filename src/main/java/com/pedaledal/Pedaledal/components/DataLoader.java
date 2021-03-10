package com.pedaledal.Pedaledal.components;

import com.pedaledal.Pedaledal.models.boards.Board;
import com.pedaledal.Pedaledal.models.manufacturers.Manufacturer;
import com.pedaledal.Pedaledal.models.pedals.EffectType;
import com.pedaledal.Pedaledal.models.pedals.Pedal;
import com.pedaledal.Pedaledal.models.pedals.PedalCategory;
import com.pedaledal.Pedaledal.models.users.AgeRange;
import com.pedaledal.Pedaledal.models.users.User;
import com.pedaledal.Pedaledal.repositories.BoardRepository;
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

    @Autowired
    BoardRepository boardRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){

//        USERS
        User kenny = new User("Kenny", "kenny.mckeown@gmail.com", AgeRange.R_THREE, "Scotland", "Guitar", "Reverb");
        userRepository.save(kenny);

        User andy = new User("Andy", "ratboyjim@gmail.com", AgeRange.R_THREE, "Scotland", "Bass", "Overdrive");
        userRepository.save(andy);


//        MANUFACTURERS
        Manufacturer ChaseBlissAudio = new Manufacturer("Chase Bliss Audio", "Awesome pedal producer", "www.cba.com");
        manufacturerRepository.save(ChaseBlissAudio);

        Manufacturer boss = new Manufacturer("Boss", "The best pedal cunts", "www.boss-pedals.com");
        manufacturerRepository.save(boss);

//        ArrayList<Manufacturer> blooperMans = new ArrayList<>();
//        blooperMans.add(ChaseBlissAudio);

//        new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}}

//        PEDALS
        Pedal pedal1 = new Pedal("Blooper", "Fancy", "One of my favourites", true, PedalCategory.OTHER, EffectType.LOOPER, 5, "", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(pedal1);
        pedal1.addManufacturer(ChaseBlissAudio);
        pedalRepository.save(pedal1);

        Pedal pedal2 = new Pedal("DS-1", "something", "industry standard", false, PedalCategory.SATURATION, EffectType.DISTORTION, 5, "", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(pedal2);
        pedal2.addManufacturer(boss);
        pedalRepository.save(pedal2);

        Pedal pedal3 = new Pedal("MT-2w", "Metal Zone", "OOOFT!", false, PedalCategory.SATURATION, EffectType.DISTORTION, 4, "", 11900, 5000, 122, 67, 40, false, false, "Side", false);
        pedalRepository.save(pedal3);
        pedal3.addManufacturer(boss);
        pedalRepository.save(pedal3);

        Pedal pedal4 = new Pedal("Deco", "Cool cool cool", "Love it", false, PedalCategory.SATURATION, EffectType.OVERDRIVE, 4, "", 27900, 18500, 115, 102, 45, false, true, "top", true);
        pedalRepository.save(pedal4);
        Manufacturer manufacturer1 = new Manufacturer("Strymon", "Expensive", "Webshite");
        manufacturerRepository.save(manufacturer1);
        manufacturer1.addPedal(pedal4);
        manufacturerRepository.save(manufacturer1);

//        blooper.setManufacturers(new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}});
//        pedalRepository.save(blooper);


//        BOARDS
        Board board1 = new Board("Andys board", 800, 500, andy);
        boardRepository.save(board1);
        board1.addBoardPedal(pedal4);
        boardRepository.save(board1);

        Board board2 = new Board("Kennys board", 600, 350, kenny);
        boardRepository.save(board2);

//        USER PEDALS ADD
        andy.addPedal(pedal2);
        userRepository.save(andy);








    }

}
