package Others;

public class PasswordValdation {

	public static void main(String[] args) {
		
//		password should contain 1 uppercase
//		                           1 lowercase
//		                           1 number
//		                           no space
//		                           no duplicate characters
//		                           size should 8 - 16 characters

		String pass = "Raju123456";
		boolean uc = false;
		boolean lc = false;
		boolean number = false;
		boolean space = false;
		boolean duplicate = false;

		if (pass.length() >= 8 && pass.length() <= 16) {

			for (int i = 0; i < pass.length() - 1; i++) {
				char ch = pass.charAt(i);
				if (ch >= 'A' && ch <= 'Z') {
					uc = true;
				} else if (ch >= 'a' && ch <= 'z') {
					lc = true;
				} else if (ch >= '0' && ch <= '9') {
					number = true;
				} else if (ch == ' ') {
					space = true;
				}
				if(ch == pass.charAt(i+1)) {
					duplicate = true;
				}
			}
		} 
		else 
		{
			System.out.println("Length of password is lessthan 8 or greater then 16");
		}
		
		if ((uc && lc && number == true) && (space && duplicate == false)) {
			System.out.println("Valid Password");
		} else {
			System.out.println("Not a Valid password");
		}

	}

}
