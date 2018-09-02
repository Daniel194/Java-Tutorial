package java8.second;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class DiscountService {

    public static void main(String... args) {
        DiscountService discountService = new DiscountService();

        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(60))));
        System.out.println(discountService.getDiscountLine(new Customer(new MemberCard(10))));
        System.out.println(discountService.getDiscountLine(new Customer()));
    }

    public String getDiscountLine(Customer customer) {
        return customer.getMemberCard()
                .flatMap(this::getDiscountPercentage)
                .map(d -> "Discount%: " + d)
                .orElse("");
    }

    private Optional<Integer> getDiscountPercentage(MemberCard card) {
        if (card.getFidelityPoints() >= 100) {
            return of(5);
        }
        if (card.getFidelityPoints() >= 50) {
            return of(3);
        }
        return empty();
    }
}
