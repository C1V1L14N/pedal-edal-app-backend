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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;



import java.util.ArrayList;



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

        Manufacturer strymon = new Manufacturer("Strymon", "Expensive", "Webshite");
        manufacturerRepository.save(strymon);


//        PEDALS
        Pedal blooper = new Pedal("Blooper", "Fancy", "One of my favourites", true, PedalCategory.OTHER, EffectType.LOOPER, 5, "", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(blooper);
        blooper.setManufacturers(new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}});
        pedalRepository.save(blooper);
//        ChaseBlissAudio.addPedal(blooper);
//        manufacturerRepository.save(ChaseBlissAudio);

        Pedal mt2w = new Pedal("MT-2w", "Metal Zone", "OOOFT!", false, PedalCategory.SATURATION, EffectType.DISTORTION, 4, "", 11900, 5000, 122, 67, 40, false, false, "Side", false);
        pedalRepository.save(mt2w);
        mt2w.setManufacturers(new ArrayList<Manufacturer>(){{add(boss);}});
        pedalRepository.save(mt2w);
//        boss.addPedal(mt2w);
//        manufacturerRepository.save(boss);

        Pedal ds1 = new Pedal("DS-1", "something", "industry standard", false, PedalCategory.SATURATION, EffectType.DISTORTION, 5, "", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(ds1);
        ds1.setManufacturers(new ArrayList<Manufacturer>(){{add(boss);}});
        pedalRepository.save(ds1);
//        boss.addPedal(ds1);
//        manufacturerRepository.save(boss);

        Pedal deco = new Pedal("Deco", "Cool cool cool", "Love it", false, PedalCategory.SATURATION, EffectType.OVERDRIVE, 4, "", 27900, 18500, 115, 102, 45, false, true, "top", true);
        pedalRepository.save(deco);
        deco.setManufacturers(new ArrayList<Manufacturer>(){{add(strymon);}});
        pedalRepository.save(deco);
//        strymon.addPedal(deco);
//        manufacturerRepository.save(strymon);


//        BOARDS
        Board board1 = new Board("Andys board", 800, 500, andy);
        boardRepository.save(board1);
        board1.addBoardPedal(deco);
        boardRepository.save(board1);

        Board board2 = new Board("Kennys board", 600, 350, kenny);
        boardRepository.save(board2);

//        USER PEDALS ADD
        andy.addPedal(ds1);
        ds1.setUser(andy);
        userRepository.save(andy);
        pedalRepository.save(ds1);

        andy.addPedal(deco);
        deco.setUser(andy);
        userRepository.save(andy);
        pedalRepository.save(deco);

        kenny.addPedal(mt2w);
        mt2w.setUser(kenny);
        userRepository.save(kenny);
        pedalRepository.save(mt2w);

        kenny.addPedal(blooper);
        blooper.setUser(kenny);
        userRepository.save(kenny);
        pedalRepository.save(blooper);

        ds1.setBoard(board1);
        pedalRepository.save(ds1);

        blooper.setBoard(board2);
        pedalRepository.save(blooper);
        mt2w.setBoard(board2);
        pedalRepository.save(mt2w);
        ds1.setBoard(board2);
        pedalRepository.save(ds1);



    }

    //        ArrayList<Manufacturer> blooperMans = new ArrayList<>();
//        blooperMans.add(ChaseBlissAudio);
//        new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}}
    //        blooper.setManufacturers(new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}});
//        pedalRepository.save(blooper);

}
