package com.colinbeuttler.dragonchronicles.models;


import static com.colinbeuttler.dragonchronicles.models.Dragon.Type.BEHEMOTH;
import static com.colinbeuttler.dragonchronicles.models.Dragon.Type.FAE;
import static com.colinbeuttler.dragonchronicles.models.Dragon.Type.WYRM;

import java.util.ArrayList;

public class DragonList {
    private static final ArrayList<Dragon> dragons = new ArrayList<Dragon>();



    public void addDragons(){
        dragons.add(new Dragon(null, "Nami", FAE, "Windy Islands", "Anglers", null));
        dragons.add(new Dragon(null, "Xeno", WYRM, "Sky Fortress", "Cyber Children", null));
        dragons.add(new Dragon(null, "Goggy", BEHEMOTH, "Deep Water Mountains", "Deep Dwellers", null));
    }



    public int assignDragon() {
        double ranDragon = Math.random() * dragons.size();
        return (int) ranDragon;
    }


    public String toString(int index) {
        return dragons.get(index).toString();
    }
}
