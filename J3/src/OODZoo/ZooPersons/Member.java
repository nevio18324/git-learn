package OODZoo.ZooPersons;

import java.time.LocalDate;

public class Member extends Persons{
    LocalDate memberSince;
    int memberCardNumber;

    public Member(String phoneNumber, LocalDate memberSince, int memberCardNumber) {
        super(phoneNumber);
        this.memberSince = memberSince;
        this.memberCardNumber = memberCardNumber;
    }
}
