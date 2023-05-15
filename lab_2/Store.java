package lab_2;

public class Store {
	private static DigitalVideoDisc itemsInStore[]=new DigitalVideoDisc[2000];
	public static int numberofDVD=0;
	public static void addDVD(DigitalVideoDisc disc) {
		int found=0;
		for(int i=0;i<numberofDVD;i++) {
			if(itemsInStore[i]==disc) {found=1;System.out.println(disc.getTitle() +" is already in the store.");break;}}
		if(found==0) {
			itemsInStore[numberofDVD]=disc;
		    numberofDVD++;
		    System.out.println(disc.getTitle() +" has been added.");}
		found=0;
	}
	public static void removeDVD(DigitalVideoDisc disc) {
	for(int i=0;i<numberofDVD;i++) {
		if(disc==itemsInStore[i]) {
			for(int k=i;k<numberofDVD-1;k++) {
				itemsInStore[k]=itemsInStore[k+1];
				}
			itemsInStore[numberofDVD]=null;
			numberofDVD=1;
			System.out.println(disc.getTitle()+" has been deleted.");
			}
		}
	}
}



