package lab_2;

public class Cart {
	public static final int MAX_NUMBERS_ORDER=20;
	private DigitalVideoDisc itemsOrdered[]=
			new DigitalVideoDisc[MAX_NUMBERS_ORDER];
	public static int qtyOrdered=0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered<20) {
		itemsOrdered[qtyOrdered]=disc;
		qtyOrdered+=1;
		System.out.println(disc.getTitle() +" has been added to the cart.");
		}
		if(qtyOrdered==20) System.out.println("The cart is full.");

	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i=0;i<qtyOrdered;i++) {
			if(disc==itemsOrdered[i]) {
				for(int k=i;k<qtyOrdered-1;k++) {
					itemsOrdered[k]=itemsOrdered[k+1];
					
				}
				itemsOrdered[qtyOrdered-1]=null;
				qtyOrdered-=1;
				System.out.println(disc.getTitle()+" has been deleted.");
			}
			
		}
		
	}
	public float totalCost() {
		float fee=0;
		for(int i=0;i<qtyOrdered;i++) {
			fee+=itemsOrdered[i].getCost();
		}
		return fee;
	}
	//array
	//public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
		//for(int i=0;i<dvdList.length;i++) {
			//if(qtyOrdered<20) 
				//if(dvdList[i]!=null) {
					//itemsOrdered[qtyOrdered]=dvdList[i];
					//qtyOrdered+=1;
					//System.out.println(dvdList[i].getTitle() +" has been added to the cart.");
					//}
			//if(qtyOrdered==20) {System.out.println("The cart is full.");break;}
		//}
		
	//}
	public void addDigitalVideoDisc(DigitalVideoDisc ... dvdList) {
		int dvdlength = dvdList.length;
		if(qtyOrdered + dvdlength > 20) {
			System.out.println("The cart is full.");
		}
		
		else{
			for(int i=0; i<dvdList.length ;i++)
				{itemsOrdered[qtyOrdered] = dvdList[i];
				System.out.println(itemsOrdered[qtyOrdered].getTitle()+ " has been added"); 
				}
			qtyOrdered++;
	     }
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDER) {
			itemsOrdered[qtyOrdered] = disc1;
			qtyOrdered++;
			itemsOrdered[qtyOrdered] = disc2;
			qtyOrdered++;
			System.out.println(disc1.getTitle() + " has been added");
			System.out.println(disc2.getTitle() + " has been added");
		}
		else {
			System.out.println("The cart is full"); 
			return ;
		}
	}
	public void print() {
		System.out.println("***********************CART*********************");
		System.out.println("Ordered Items:");
		for(int i=0;i<qtyOrdered;i++)
			System.out.println("DVD - "+itemsOrdered[i].getTitle()+"- "+itemsOrdered[i].getCategory()+"- " +itemsOrdered[i].getDirector()+"- "+itemsOrdered[i].getLength()+": "+itemsOrdered[i].getCost()+"$");
		System.out.println("Total cost: "+totalCost());
		System.out.println("************************************************");
	}
	public void searchTitle(String title) {
		int found = 0;
		for (int i=0; i<qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				System.out.println(itemsOrdered[i].toString());
				found = 1;
			}
		}
		if (found==0){
			System.out.println("Item not found");
		}
	}
	public void searchId(int id) {
		for (int i=0; i<qtyOrdered; i++) {
			if (itemsOrdered[i].getId() == id) {
				System.out.println(itemsOrdered[i].toString());
				return;
			}
		}
		System.out.println("Item not found");
	}

}
