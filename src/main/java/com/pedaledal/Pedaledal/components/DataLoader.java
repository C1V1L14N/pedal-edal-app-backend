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

        Manufacturer cooperFX = new Manufacturer("Cooper FX", "Canadian", "www.canadian-pedals.com");
        manufacturerRepository.save(cooperFX);

        Manufacturer jhs = new Manufacturer("JHS", "USA", "www.jhspedals.info");
        manufacturerRepository.save(jhs);


//        PEDALS
        Pedal blooper = new Pedal("Blooper", "Fancy", "One of my favourites", true, PedalCategory.OTHER, EffectType.LOOPER, 5, "/PedalImages/chasebliss-blooper.png", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(blooper);
        blooper.setManufacturers(new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}});
        pedalRepository.save(blooper);

        Pedal colourBox = new Pedal("Colour Box", "Very fancy", "One of my favourites", true, PedalCategory.SATURATION, EffectType.PREAMP, 5, "/PedalImages/jhs-colourbox.png", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(colourBox);
        blooper.setManufacturers(new ArrayList<Manufacturer>(){{add(jhs);}});
        pedalRepository.save(colourBox);

        Pedal doubleBarrel = new Pedal("Double Barrel", "Very fancy", "One of my favourites", true, PedalCategory.SATURATION, EffectType.OVERDRIVE, 5, "/PedalImages/jhs-doublebarrelv4.png", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(doubleBarrel);
        doubleBarrel.setManufacturers(new ArrayList<Manufacturer>(){{add(jhs);}});
        pedalRepository.save(doubleBarrel);

        Pedal mt2w = new Pedal("MT-2w", "Metal Zone", "OOOFT!", false, PedalCategory.SATURATION, EffectType.DISTORTION, 4, "/PedalImages/boss-mt2w.png", 11900, 5000, 122, 67, 40, false, false, "Side", false);
        pedalRepository.save(mt2w);
        mt2w.setManufacturers(new ArrayList<Manufacturer>(){{add(boss);}});
        pedalRepository.save(mt2w);


        Pedal ds1 = new Pedal("DS-1", "something", "industry standard", false, PedalCategory.SATURATION, EffectType.DISTORTION, 5, "/PedalImages/boss-ds1.png", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(ds1);
        ds1.setManufacturers(new ArrayList<Manufacturer>(){{add(boss);}});
        pedalRepository.save(ds1);


        Pedal deco = new Pedal("Deco", "Cool cool cool", "Love it", false, PedalCategory.SATURATION, EffectType.OVERDRIVE, 4, "/PedalImages/strymon-deco.png", 27900, 18500, 115, 102, 45, false, true, "top", true);
        pedalRepository.save(deco);
        deco.setManufacturers(new ArrayList<Manufacturer>(){{add(strymon);}});
        pedalRepository.save(deco);

        Pedal elCapistan = new Pedal("el Capistan", "Go from the sound of a pristine, studio-quality tape machine to the heavily fluctuating sound of a machine in need of service. Get the full bodied sound of fresh tape all the way to the gnarled qualities of worn out tape.", "Love it", false, PedalCategory.DELAY, EffectType.DIGITAL, 5, "/PedalImages/strymon-elcap.png", 29900, 22000, 115, 102, 45, false, true, "top", true);
        pedalRepository.save(elCapistan);
        elCapistan.setManufacturers(new ArrayList<Manufacturer>(){{add(strymon);}});
        pedalRepository.save(elCapistan);

        Pedal generationLoss = new Pedal("Generation Loss", "really fancy", "reet gud", false, PedalCategory.MODULATION, EffectType.VIBRATO, 3, "/PedalImages/cooper-genloss.png", 50000, null, 122, 67, 40, true, true, "side", true);
        pedalRepository.save(generationLoss);
        generationLoss.setManufacturers(new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}{add(cooperFX);}});
        pedalRepository.save(generationLoss);

        Pedal blooper2 = new Pedal("Blooper", "Fancy", "One of my favourites", true, PedalCategory.OTHER, EffectType.LOOPER, 5, "/PedalImages/chasebliss-blooper.png", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(blooper2);
        blooper2.setManufacturers(new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}});
        pedalRepository.save(blooper2);

        Pedal colourBox2 = new Pedal("Colour Box", "Very fancy", "One of my favourites", true, PedalCategory.SATURATION, EffectType.PREAMP, 5, "/PedalImages/jhs-colourbox.png", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(colourBox2);
        colourBox2.setManufacturers(new ArrayList<Manufacturer>(){{add(jhs);}});
        pedalRepository.save(colourBox2);

        Pedal doubleBarrel2 = new Pedal("Double Barrel", "Very fancy", "One of my favourites", true, PedalCategory.SATURATION, EffectType.OVERDRIVE, 5, "/PedalImages/jhs-doublebarrelv4.png", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(doubleBarrel2);
        doubleBarrel2.setManufacturers(new ArrayList<Manufacturer>(){{add(jhs);}});
        pedalRepository.save(doubleBarrel2);

        Pedal mt2w2 = new Pedal("MT-2w", "Metal Zone", "OOOFT!", false, PedalCategory.SATURATION, EffectType.DISTORTION, 4, "/PedalImages/boss-mt2w.png", 11900, 5000, 122, 67, 40, false, false, "Side", false);
        pedalRepository.save(mt2w2);
        mt2w2.setManufacturers(new ArrayList<Manufacturer>(){{add(boss);}});
        pedalRepository.save(mt2w2);


        Pedal ds12 = new Pedal("DS-1", "something", "industry standard", false, PedalCategory.SATURATION, EffectType.DISTORTION, 5, "/PedalImages/boss-ds1.png", 49900, 33000, 122, 67, 40, true, false, "Top", true);
        pedalRepository.save(ds12);
        ds12.setManufacturers(new ArrayList<Manufacturer>(){{add(boss);}});
        pedalRepository.save(ds12);


        Pedal deco2 = new Pedal("Deco", "Cool cool cool", "Love it", false, PedalCategory.SATURATION, EffectType.OVERDRIVE, 4, "/PedalImages/strymon-deco.png", 27900, 18500, 115, 102, 45, false, true, "top", true);
        pedalRepository.save(deco2);
        deco2.setManufacturers(new ArrayList<Manufacturer>(){{add(strymon);}});
        pedalRepository.save(deco2);

        Pedal elCapistan2 = new Pedal("el Capistan", "Go from the sound of a pristine, studio-quality tape machine to the heavily fluctuating sound of a machine in need of service. Get the full bodied sound of fresh tape all the way to the gnarled qualities of worn out tape.", "Love it", false, PedalCategory.DELAY, EffectType.DIGITAL, 5, "/PedalImages/strymon-elcap.png", 29900, 22000, 115, 102, 45, false, true, "top", true);
        pedalRepository.save(elCapistan2);
        elCapistan2.setManufacturers(new ArrayList<Manufacturer>(){{add(strymon);}});
        pedalRepository.save(elCapistan2);

        Pedal generationLoss2 = new Pedal("Generation Loss", "really fancy", "reet gud", false, PedalCategory.MODULATION, EffectType.VIBRATO, 3, "/PedalImages/cooper-genloss.png", 50000, null, 122, 67, 40, true, true, "side", true);
        pedalRepository.save(generationLoss2);
        generationLoss2.setManufacturers(new ArrayList<Manufacturer>(){{add(ChaseBlissAudio);}{add(cooperFX);}});
        pedalRepository.save(generationLoss2);


//        BOARDS
        Board board1 = new Board("Andys board", 800, 500, andy);
        boardRepository.save(board1);
        board1.addBoardPedal(deco);
        boardRepository.save(board1);

        Board board2 = new Board("Kennys board", 600, 350, kenny);
        boardRepository.save(board2);

//        USER PEDALS ADD
        andy.addPedal(ds12);
        ds12.setUser(andy);
        userRepository.save(andy);
        pedalRepository.save(ds12);

        andy.addPedal(deco2);
        deco2.setUser(andy);
        userRepository.save(andy);
        pedalRepository.save(deco2);

        andy.addPedal(mt2w2);
        mt2w2.setUser(andy);
        userRepository.save(andy);
        pedalRepository.save(mt2w2);

        andy.addPedal(blooper2);
        blooper2.setUser(andy);
        userRepository.save(andy);
        pedalRepository.save(blooper2);

        andy.addPedal(elCapistan2);
        elCapistan2.setUser(andy);
        userRepository.save(andy);
        pedalRepository.save(elCapistan2);

        andy.addPedal(generationLoss2);
        generationLoss2.setUser(andy);
        userRepository.save(andy);
        pedalRepository.save(generationLoss2);

        andy.addPedal(colourBox2);
        colourBox2.setUser(andy);
        userRepository.save(andy);
        pedalRepository.save(colourBox2);

        andy.addPedal(doubleBarrel2);
        doubleBarrel2.setUser(andy);
        userRepository.save(andy);
        pedalRepository.save(doubleBarrel2);

        kenny.addPedal(mt2w);
        mt2w.setUser(kenny);
        userRepository.save(kenny);
        pedalRepository.save(mt2w);

        kenny.addPedal(blooper);
        blooper.setUser(kenny);
        userRepository.save(kenny);
        pedalRepository.save(blooper);

        kenny.addPedal(elCapistan);
        elCapistan.setUser(kenny);
        userRepository.save(kenny);
        pedalRepository.save(elCapistan);

        kenny.addPedal(generationLoss);
        generationLoss.setUser(kenny);
        userRepository.save(kenny);
        pedalRepository.save(generationLoss);

        kenny.addPedal(ds1);
        ds1.setUser(kenny);
        userRepository.save(kenny);
        pedalRepository.save(ds1);

        kenny.addPedal(colourBox);
        colourBox.setUser(kenny);
        userRepository.save(kenny);
        pedalRepository.save(colourBox);

        kenny.addPedal(doubleBarrel);
        doubleBarrel.setUser(kenny);
        userRepository.save(kenny);
        pedalRepository.save(doubleBarrel);

        kenny.addPedal(deco);
        deco.setUser(kenny);
        userRepository.save(kenny);
        pedalRepository.save(deco);

        ds1.setBoard(board1);
        pedalRepository.save(ds1);
        deco.setBoard(board1);
        pedalRepository.save(deco);

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



