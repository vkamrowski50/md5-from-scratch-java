import java.math.BigInteger;

public class Main_Debug {
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
        String paddedStr = Padding.pad(Padding.input, true);
        Padding.bitSchedule(paddedStr);

        Op_One.A = new BigInteger("67452301", 16);
        Op_One.B = new BigInteger("efcdab89", 16);
        Op_One.C = new BigInteger("98badcfe", 16);
        Op_One.D = new BigInteger("10325476", 16);

        System.out.println("i = " + 0 + "\t|\t" + Op_One.A.toString(16) + "\t" + Op_One.B.toString(16) + "\t" + Op_One.C.toString(16) + "\t" + Op_One.D.toString(16));

        for (int x = 0; x < 64; x++) {
            if (x < 16) {
                Op_One.opOne(x);
            }
            else if (x >= 16 & x < 32) {
                Op_Two.opTwo(x);
            }
            else if (x >= 32 & x < 48) {
                Op_Three.opThree(x);
            }
            else if (x >= 48) {
                Op_Four.opFour(x);
            }

            if (x == 15 || x == 31 || x == 47 || x == 63) {
                String stringA = (Op_One.A.toString(16).length() == 7) ? "0" + Op_One.A.toString(16) : Op_One.A.toString(16);
                String stringB = (Op_One.B.toString(16).length() == 7) ? "0" + Op_One.B.toString(16) : Op_One.B.toString(16);
                String stringC = (Op_One.C.toString(16).length() == 7) ? "0" + Op_One.C.toString(16) : Op_One.C.toString(16);
                String stringD = (Op_One.D.toString(16).length() == 7) ? "0" + Op_One.D.toString(16) : Op_One.D.toString(16);
                System.out.println("i = " + x + "\t|\t" + stringA + "\t" + stringB + "\t" + stringC + "\t" + stringD);
            }
        }
        Op_Final.opFinal(true);
    }
}
