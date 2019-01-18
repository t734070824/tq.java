package _old.composite.step1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponet{
	
	List<MenuComponet> menuComponets = new ArrayList<>();
	
	private String name;
	
	private String description;
	
	public Menu(String name, String description) {
		this.description = description;
		this.name = name;
	}
	
	@Override
	public void add(MenuComponet menuComponet) {
		menuComponets.add(menuComponet);
	}
	
	@Override
	public void remove(MenuComponet menuComponet) {
		menuComponets.remove(menuComponet);
	}
	
	@Override
	public MenuComponet getChild(int i) {
		return menuComponets.get(i);
	}
	
	@Override
	public void print() {
		System.out.println("Menu:" + name + "," + description);
		Iterator<MenuComponet> iterator = menuComponets.iterator();
		while(iterator.hasNext()){
			MenuComponet next = iterator.next();
			next.print();
		}
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
