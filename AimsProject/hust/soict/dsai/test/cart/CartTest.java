package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc; // Import lớp hust.soict.dsai.aims.media.DigitalVideoDisc từ package disc
import hust.soict.dsai.aims.cart.Cart;

public class CartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addDisc(dvd3);

		cart.printCartDetails();
	}
}