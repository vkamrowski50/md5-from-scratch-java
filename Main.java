import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("no args provided. Use make input ARGS='<input>'");
            return;
        }

        for (int x = 0; x < args.length; x++) {
            Padding.input = Padding.input + args[x] + " ";
        }

        if (Padding.input.length() > 55) {
            System.out.println("String input is too long. Must be at most 55 characters.");
            return;
        }

        Padding.input = Padding.input.trim();
        String paddedStr = Padding.pad(Padding.input, false);
        Padding.bitSchedule(paddedStr);

        Op_One.A = new BigInteger("67452301", 16);
        Op_One.B = new BigInteger("efcdab89", 16);
        Op_One.C = new BigInteger("98badcfe", 16);
        Op_One.D = new BigInteger("10325476", 16);

        for (int x = 0; x < 16; x++) {
            Op_One.opOne(x);
        }
        for (int x = 16; x < 32; x++) {
            Op_Two.opTwo(x);
        }
        for (int x = 32; x < 48; x++) {
            Op_Three.opThree(x);
        }
        for (int x = 48; x < 64; x++) {
            Op_Four.opFour(x);
        }
        Op_Final.opFinal(false);
    }
}
