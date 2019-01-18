package _old.iterator.step1;

public interface Waiter {
	
	/**
	 * 打印出菜单的每一项
	 */
	void printMenu();
	
	/**
	 * 只打印早餐
	 */
	void printBreakfastMenu();
	
	/**
	 * 打印午餐
	 */
	void printLunchMenu();
	
	/**
	 * 所有素食
	 */
	void printVegetarianMenu();
	
	/**
	 * 指定餐点 返回是否为素食
	 */
	boolean isItemVegetarianMenu(String name);
}
