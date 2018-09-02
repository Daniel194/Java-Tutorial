package java8.third;

public class PriceService {

    private final NewReleasePriceRepo repo;

    public PriceService(NewReleasePriceRepo repo) {
        this.repo = repo;
    }

    int computeNewReleasePrice(int days) {
        return (int) (days * repo.getFactor());
    }

    int computeRegularPrice(int days) {
        return days + 1;
    }

    int computeChildrenPrice(int days) {
        return 5;
    }

    public int computePrice(Type type, int days) {
        return type.priceAlgo.apply(this, days);
    }
}
