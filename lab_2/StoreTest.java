package lab_2;


public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87, 19.95f);
		DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars","Scifi","George Lucas",87, 24.95f);
		DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladdin","Animation",18.99f);
		
		Store.addDVD(dvd1);
		Store.addDVD(dvd2);
		Store.addDVD(dvd3);
		
		Store.removeDVD(dvd3);
		
	}

}
