import java.math.BigInteger;

public class Padding {

    public static String input = "";
    public static BigInteger[] hexStrings = new BigInteger[16]; // for 512 bit strings there will be 64 bytes. there
                                                                // will
                                                                // be 16 hex vals.

    public static String pad(String inputStr, boolean debug) {
        StringBuilder binary = new StringBuilder();
        for (int x = 0; x < inputStr.length(); x++) {
            int forbin = (int) inputStr.charAt(x);
            binary.append(intToBinary(forbin));
        } // AT THIS POINT BINARY HAS THE MESSAGE IN BINARY

        long lengthpad = binary.length();

        if (debug) {
            System.out.println("Binary string: \n" + binary.toString());
        }

        binary.append("1");

        if (debug) {
            System.out.println("Binary after appending 1: \n" + binary.toString());
        }

        while (binary.length() % 512 != 448) {
            binary.append("0");
        }
        String lengthBin = String.format("%64s", Long.toBinaryString(lengthpad)).replace(' ', '0'); // end with 64
                                                                                                    // bits of length

        StringBuilder lengthstring = new StringBuilder();
        for (int x = 0; x < 8; x++) {
            String bytestr = lengthBin.substring(56 - 8 * x, 64 - 8 * x);
            lengthstring.append(bytestr);
        }
        binary.append(lengthstring.toString());

        if (debug) {
            System.out.println("Binary after padding: \n" + binary.toString());
        }

        return binary.toString();
    }

    public static String intToBinary(int int1) {
        String binary = Integer.toBinaryString(int1);
        return String.format("%8s", binary).replace(' ', '0');
    }

    public static BigInteger binaryStringtoInt(String str) {
        return new BigInteger(str, 2);
    }

    public static void bitSchedule(String str) {
        for (int x = 0; x < 16; x++) {
            String word = str.substring(x * 32, (x + 1) * 32);

            String b0 = word.substring(24, 32);
            String b1 = word.substring(16, 24);
            String b2 = word.substring(8, 16);
            String b3 = word.substring(0, 8);
            String littleendian = b0 + b1 + b2 + b3;

            hexStrings[x] = binaryStringtoInt(littleendian);
        }
    }

}
