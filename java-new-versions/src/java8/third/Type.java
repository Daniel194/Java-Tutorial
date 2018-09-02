package java8.third;

import java.util.function.BiFunction;

public enum Type {
    REGULAR(PriceService::computeRegularPrice),
    NEW_RELEASE(PriceService::computeNewReleasePrice),
    CHILDREN(PriceService::computeChildrenPrice);

    public final BiFunction<PriceService, Integer, Integer> priceAlgo;

    private Type(BiFunction<PriceService, Integer, Integer> priceAlgo) {
        this.priceAlgo = priceAlgo;
    }
}