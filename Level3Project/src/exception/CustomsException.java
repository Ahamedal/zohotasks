package exception;

public class CustomsException extends Exception{
		public CustomsException(String message) {
			super(message);
		}
		public CustomsException(Exception e) {
			super(e);
		}
		}

