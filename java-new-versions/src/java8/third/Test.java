package java8.third;

public class Test {

    public static void main(String... args) {
        NewReleasePriceRepo repo = mock(NewReleasePriceRepo.class);
        when(repo.getFactor()).thenReturn(2d);
        PriceService priceService = new PriceService(repo);
        System.out.println(priceService.computePrice(Type.REGULAR, 2));
        System.out.println(priceService.computePrice(Type.NEW_RELEASE, 2));
        System.out.println(priceService.computePrice(Type.CHILDREN, 2));
    }

}
