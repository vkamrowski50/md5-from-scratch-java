// EXAMPLE CODE TAKEN FROM GEEKSFORGEEKS.

// importing the required libraries
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5_actual {
    public static void main(String[] args) {
        // making a message
        String inputstring = "They are deterministic";
        try {
            // encoding the message using the library function
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(inputstring.getBytes());
            byte[] digest = md.digest();

            // printing the hash function
            System.out.println("Hash of the input string:");
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            System.out.println(hexString.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
