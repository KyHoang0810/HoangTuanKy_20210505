package lab_2;

public class Aims {

	public static void main(String[] args) {
		Cart anOrder=new Cart();
		DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars","Scifi","George Lucas",87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladdin","Animation",18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		System.out.println("The total cost is: ");
		System.out.println(anOrder.totalCost());
		anOrder.removeDigitalVideoDisc(dvd3);

	}

}