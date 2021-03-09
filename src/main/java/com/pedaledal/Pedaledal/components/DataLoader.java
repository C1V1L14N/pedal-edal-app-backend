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

        Pedal blooper = new Pedal("Blooper", "Fancy", "One of my favourites", true, PedalCategory.OTHER, EffectType.LOOPER, 5, "", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(blooper);

        Pedal pedal1 = new Pedal("DS-1", "something", "industry standard", false, PedalCategory.SATURATION, EffectType.DISTORTION, 5, "", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(pedal1);
        pedal1.addManufacturer(boss);
        pedalRepository.save(pedal1);

        Pedal pedal2 = new Pedal("MT-2w", "Metal Zone", "OOOFT!", false, PedalCategory.SATURATION, EffectType.DISTORTION, 4, "", 11900, 5000, 122, 67, 40, false, false, "Side", false);
        pedalRepository.save(pedal2);
        pedal2.addManufacturer(boss);
        pedalRepository.save(pedal2);

//        blooper.setManufacturers(new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}});
//        pedalRepository.save(blooper);


        blooper.addManufacturer(boss);
        pedalRepository.save(blooper);

        andy.setPedals(new ArrayList<Pedal>(){{add(blooper);}});
        userRepository.save(andy);

        andy.addPedal(pedal1);
        userRepository.save(andy);

        kenny.addPedal(blooper);
        kenny.addPedal(pedal2);
        userRepository.save(kenny);

        Board board1 = new Board("boardy", 600, 350, andy);
        boardRepository.save(board1);

        board1.addBoardPedal(pedal1);
        boardRepository.save(board1);
        board1.addBoardPedal(pedal2);
        boardRepository.save(board1);

    }

}
