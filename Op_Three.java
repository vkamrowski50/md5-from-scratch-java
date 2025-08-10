import java.math.BigInteger;

public class Op_Three {
    public static BigInteger H(BigInteger b, BigInteger c, BigInteger d) {
        return b.xor(c).xor(d).and(Op_One.mask32);
    }

    public static void opThree(int x) {
        BigInteger a = Op_One.A;
        BigInteger b = Op_One.B;
        BigInteger c = Op_One.C;
        BigInteger d = Op_One.D;
        BigInteger H1 = H(b, c, d);
        int gindex = (3 * x + 5) % 16;

        BigInteger MofG = Padding.hexStrings[gindex];
        BigInteger KofI = new BigInteger(Utils.KConstants[x], 16);
        int SofI = Utils.SValues[x];

        // adding all tgt
        BigInteger temp = Op_One.modularAddition(a, H1, MofG, KofI);

        // rotation
        BigInteger rotation = Op_One.leftRotate(temp, SofI);

        // new b
        BigInteger Bnew = b.add(rotation).and(Op_One.mask32);

        Op_One.A = d;
        Op_One.B = Bnew;
        Op_One.C = b;
        Op_One.D = c;
    }

}
