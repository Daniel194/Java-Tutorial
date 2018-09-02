package java8.second;

import java.util.Optional;

import static java.util.Optional.ofNullable;

public class Customer {
    private MemberCard memberCard;

    public Customer() {
    }

    public Customer(MemberCard profile) {
        this.memberCard = profile;
    }

    public Optional<MemberCard> getMemberCard() {
        return ofNullable(memberCard);
    }
}
