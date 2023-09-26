package OODZoo;

import OODZoo.ZooAnimals.AllEater;
import OODZoo.ZooAnimals.MeatEater;
import OODZoo.ZooCages.Enclosure;
import OODZoo.ZooCages.Fishtank;
import OODZoo.ZooPersons.Member;
import OODZoo.ZooPersons.Worker;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Enclosure rhinoEnclosure = new Enclosure(20,"20m2",2,30,5,true);
        AllEater rhino = new AllEater(rhinoEnclosure);
        Worker rhinoCareTaker = new Worker("90131309013",2000,rhinoEnclosure);
        Fishtank sharkFishTank = new Fishtank(30,"1000l",1,true);
        MeatEater shark = new MeatEater(sharkFishTank);
        Worker sharkCareTaker = new Worker("234567890",3000,sharkFishTank);
        Member john = new Member("4945670976",LocalDate.of(2020,5,20),930174707);
    }
}
