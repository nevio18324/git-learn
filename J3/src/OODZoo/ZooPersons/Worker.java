package OODZoo.ZooPersons;

import OODZoo.ZooAnimals.Animals;
import OODZoo.ZooCages.Cages;

public class Worker extends Persons {
    int wage;
    Cages job;
    public Worker(String phoneNumber, int wage, Cages job) {
        super(phoneNumber);
        this.wage = wage;
        this.job = job;
    }
}
