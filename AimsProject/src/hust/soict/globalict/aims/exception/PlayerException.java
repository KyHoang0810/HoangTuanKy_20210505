package hust.soict.globalict.aims.exception;


public class PlayerException extends java.lang.Exception {

	public PlayerException() {
		
	}

	public PlayerException(String message) {
		super(message);
		System.err.println(message);
	
	}


}
