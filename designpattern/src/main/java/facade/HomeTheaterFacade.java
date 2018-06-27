package facade;

public class HomeTheaterFacade {
    private Amplifier amplifier;
    private Player player;
    private Projector projector;
    private Screen screen;

    public HomeTheaterFacade(Amplifier amplifier, Player player, Projector projector, Screen screen) {
        this.amplifier = amplifier;
        this.player = player;
        this.projector = projector;
        this.screen = screen;
    }

    public void watchMovie() {
        amplifier.on();
        amplifier.setVolume(5);
        player.on();
        screen.down();
        projector.on();
    }

    public void endMovie() {
        amplifier.off();
        player.off();
        screen.up();
        projector.off();
    }

}
