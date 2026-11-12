package com.example;

import java.util.List;

public class Alex extends Lion{


    public Alex(Feline feline) throws Exception {
        super("Самец", feline);
    }

    public List<String> getFriends(){
        return List.of("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
