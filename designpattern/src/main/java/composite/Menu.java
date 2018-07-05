package composite;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {
    List<MenuComponent> menuComponents;
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
        menuComponents = new ArrayList<>();
    }

    @Override
    public void add(MenuComponent menuComponent) {
        this.menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        this.menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return this.menuComponents.get(i);
    }

    @Override
    public void print() {
        System.out.println(name + ", " + description);
        menuComponents.forEach(MenuComponent::print);
    }
}
