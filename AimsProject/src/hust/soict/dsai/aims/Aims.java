package hust.soict.dsai.aims;
import java.util.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store; 
public class Aims {
	public static Store store=new Store();
	public static void showMenu() {
		System.out.println("AIMS:");
		System.out.println("-----------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("-----------------------");
		System.out.println("Please choose a number: 0-1-2-3"); 
		
	}
	public static void storeMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media’s details"); 
		System.out.println("2. Add a media to cart"); 
		System.out.println("3. Play a media"); 
		System.out.println("4. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4"); 
	}
	public static void mediaDetailsMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2"); 
	}
	public static void cartMenu() { 
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter medias in cart"); 
		System.out.println("2. Sort medias in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Play a media"); 
		System.out.println("5. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4-5"); 
	}
	

	public static void main(String[] args) {
		Cart anOrder=new Cart();
		Scanner sc=new Scanner(System.in);
		int a=0;
		do {
			Aims.showMenu();
			a=sc.nextInt();
			switch(a) {
			case 1:{
				store.print();
				Aims.storeMenu();
				int b=sc.nextInt();
				if(b==1) {
					System.out.println("Please enter the media's title:");
					sc.nextLine();
					String str=sc.nextLine();
					int t=store.findMediaIndex(str);
					if(t>=0) {
						Media add=store.getMedia(t);
						System.out.println(add.toString());
						mediaDetailsMenu();
						int c=sc.nextInt();
						if(c==1) anOrder.addMedia(add);
						else if(c==2) {
							if(add instanceof DigitalVideoDisc) ((DigitalVideoDisc) add).play();
							else if(add instanceof CompactDisc) ((CompactDisc) add).play();
						}
						else if(c==0) break;
						}
					else {System.out.println("No item found");return;}
					break;
					}
				if(b==2) {
					System.out.println("Please enter the media's title:");
					sc.nextLine();
					String str=sc.nextLine();
					int t=store.findMediaIndex(str);
					if(t>=0) {
						Media add=store.getMedia(t);
						anOrder.addMedia(add);
						}
					else {System.out.println("No item found");return;}
					
					}
				if(b==3) {
					System.out.println("Please enter the media's title:");
					sc.nextLine();
					String str=sc.nextLine();
					int t=store.findMediaIndex(str);
					if(t<0) {System.out.println("No item found");return;}
					Media playmedia=store.getMedia(t);
					if(playmedia instanceof DigitalVideoDisc) ((DigitalVideoDisc) playmedia).play();
					else if(playmedia instanceof CompactDisc) ((CompactDisc) playmedia).play();
					}
				if(b==4) {
					anOrder.print();
					cartMenu();
					sc.nextInt();
					int d=sc.nextInt();
					if(d==1) {
						System.out.println("1.Filter by id");
						System.out.println("2.Filter by title");
						System.out.println("Please choose a number: 1-2"); 
						int e=sc.nextInt();
						if(e==1) {
							System.out.println("Please enter the Id:");
							int id_search=sc.nextInt();
							anOrder.searchID(id_search);
						}
						else if(e==2) {
							System.out.println("Please enter the media's title:");
							sc.nextLine();
							String str=sc.nextLine();
							int t=anOrder.findMediaIndex(str);
							if(t<0) {System.out.println("No item found");}
							Media foundmedia=anOrder.getMedia(t);
							System.out.println(foundmedia.toString());
						}
						
					}
					if(d==2) {
						System.out.println("1.Sort by title");
						System.out.println("2.Sort by cost");
						System.out.println("Please choose a number: 1-2"); 
						sc.nextInt();
						int e=sc.nextInt();
						if (e ==1 ) {
							anOrder.sortByTitleCost();
							}
						else {
							anOrder.sortByCostTitle();
							}
						
					}
					if(d==3) {
						System.out.println("Please enter the media's title:");
						String str=sc.nextLine();
						int t=anOrder.findMediaIndex(str);
						if(t>=0) {
							Media remove=anOrder.getMedia(t);
							anOrder.removeMedia(remove);
						
							}
						else {System.out.println("No item found");}
						
						
					}
					if(d==4) {
						System.out.println("Please enter the media's title:");
						String str=sc.nextLine();
						int t=anOrder.findMediaIndex(str);
						if(t<0){System.out.println("No item found");return;}
						Media playmedia=anOrder.getMedia(t);
						if(playmedia instanceof DigitalVideoDisc) ((DigitalVideoDisc) playmedia).play();
						else if(playmedia instanceof CompactDisc) ((CompactDisc) playmedia).play();
						
						
					}
					if(d==5) {
						System.out.println("An order is created.");
						anOrder=null;
						
					}
					if(d==0) break;
				}
				if(b==0) break;
				break;}
			
			case 2: {
				System.out.println("Options: "); 
				System.out.println("--------------------------------"); 
				System.out.println("1. Add a media"); 
				System.out.println("2. Remove a media"); 
				System.out.println("0. Back"); 
				System.out.println("--------------------------------"); 
				System.out.println("Please choose a number: 0-1-2"); 
				int f=sc.nextInt();
				if(f==1) {
					System.out.println("1. Book"); 
					System.out.println("2. DVD"); 
					System.out.println("3. CD");
					System.out.println("Please choose a number: 1-2-3");
					int g=sc.nextInt();
					if(g==1) {
						System.out.println("Enter book's title");
						sc.nextLine();
						String booktitle=sc.nextLine();
						System.out.println("Enter book's category");
						String bookcategory=sc.nextLine();
						System.out.println("Enter book's cost");
						float bookcost=sc.nextFloat();
						System.out.println("Enter number of authors:");
						int nbofauthors=sc.nextInt();
						List<String> authorlist=new ArrayList<String>();
						for(int i=1;i<=nbofauthors-1;i++) {
							System.out.println("Enter author number "+i+":");
							sc.nextLine();
							String author=sc.nextLine();
							authorlist.add(author);
							}
						System.out.println("Enter author number "+nbofauthors+":");
						String author=sc.nextLine();
						authorlist.add(author);
						Book newbook=new Book(booktitle,bookcategory,bookcost,authorlist);
						store.addMedia(newbook);
					}
					if(g==2) {
						System.out.println("Enter DVD's title");
						sc.nextLine();
						String DVDtitle=sc.nextLine();
						System.out.println("Enter DVD's category");
						String DVDcategory=sc.nextLine();
						System.out.println("Enter DVD's director");
						String DVDdirector=sc.nextLine();
						System.out.println("Enter DVD's length");
						int DVDlength=sc.nextInt();
						System.out.println("Enter DVD's cost");
						float DVDcost=sc.nextFloat();
						DigitalVideoDisc newdvd=new DigitalVideoDisc(DVDtitle,DVDcategory,DVDdirector,DVDlength,DVDcost);
						store.addMedia(newdvd);	
					}
					if(g==3) {
						System.out.println("Enter CD's title");
						sc.nextLine();
						String CDtitle=sc.nextLine();
						System.out.println("Enter CD's category");
						String CDcategory=sc.nextLine();
						System.out.println("Enter CD's artist");
						String CDartist=sc.nextLine();
						System.out.println("Enter CD's director");
						String CDdirector=sc.nextLine();
						System.out.println("Enter number of tracks");
						int nboftrack=sc.nextInt();
						List<Track> tracks=new ArrayList<Track>();
						for(int i=0;i<nboftrack;i++) {
							System.out.println("Enter track's title:");
							sc.nextLine();
							String tracktitle=sc.nextLine();
							System.out.println("Enter track's length");
							int tracklength=sc.nextInt();
							tracks.add(new Track(tracktitle,tracklength));	
						}
						System.out.println("Enter CD's cost");
						float CDcost=sc.nextFloat();
						CompactDisc newcd=new CompactDisc(CDtitle,CDcategory,CDcost,CDartist,CDdirector,tracks);
						store.addMedia(newcd);
					}
					break;
				}
				if(f==2) {
					System.out.println("Please enter the media's title:");
					sc.nextLine();
					String str=sc.nextLine();
					int t=store.findMediaIndex(str);
					if(t<0) System.out.println(str+" is not in the store.");
					store.removeMedia(store.getMedia(t));
					break;
					}
				if(f==0) break;
				
			}
			case 3: {
				anOrder.print();
				cartMenu();
				int d=sc.nextInt();
				if(d==1) {
					System.out.println("1.Filter by id");
					System.out.println("2.Filter by title");
					System.out.println("Please choose a number: 1-2"); 
					int e=sc.nextInt();
					if(e==1) {
						System.out.println("Please enter the Id:");
						int id_search=sc.nextInt();
						anOrder.searchID(id_search);
					}
					else if(e==2) {
						System.out.println("Please enter the media's title:");
						sc.nextLine();
						String str=sc.nextLine();
						int t=anOrder.findMediaIndex(str);
						if(t<0) {System.out.println("No item found");return;}
						Media foundmedia=anOrder.getMedia(t);
						System.out.println(foundmedia.toString());
					}	
				}
				if(d==2) {
					System.out.println("1.Sort by title");
					System.out.println("2.Sort by cost");
					System.out.println("Please choose a number: 1-2"); 
					int e=sc.nextInt();
					if (e ==1 ) {
						anOrder.sortByTitleCost();
						}
					else {
						anOrder.sortByCostTitle();
						}
					
				}
			}
			case 0:break;

			}
			}while(a!=0);

	}

}
