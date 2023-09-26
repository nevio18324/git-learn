package ChallengeHogWarts;

import java.util.ArrayList;

public class FamilyTree {
    String familyName;
    int familyMembersAtHogWarts;
    Haus house;

    public FamilyTree(String familyName, int familyMembersAtHogWarts, Haus house) {
        this.familyName = familyName;
        this.familyMembersAtHogWarts = familyMembersAtHogWarts;
        this.house = house;
    }
    public static ArrayList<FamilyTree> allFamilies(){
        ArrayList<FamilyTree> familyTreeArrayList = new ArrayList<>();
        familyTreeArrayList.add(new FamilyTree("Wesley",4,Haus.allHomes().get(1)));
        familyTreeArrayList.add(new FamilyTree("Potter",4,Haus.allHomes().get(0)));
        familyTreeArrayList.add(new FamilyTree("Raven",2,Haus.allHomes().get(2)));
        familyTreeArrayList.add(new FamilyTree("Obama",3,Haus.allHomes().get(3)));
        return familyTreeArrayList;
    }
}
