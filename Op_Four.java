import java.math.BigInteger;

public class Op_Four {
    public static BigInteger I(BigInteger b, BigInteger c, BigInteger d) {
        BigInteger notD = d.not().and(Op_One.mask32);
        BigInteger bOrNotD = b.or(notD);
        return c.xor(bOrNotD).and(Op_One.mask32);
    }

    public static void opFour(int x) {
        BigInteger a = Op_One.A;
        BigInteger b = Op_One.B;
        BigInteger c = Op_One.C;
        BigInteger d = Op_One.D;
        BigInteger I1 = I(b, c, d);
        int gindex = (7 * x) % 16;

        BigInteger MofG = Padding.hexStrings[gindex];
        BigInteger KofI = new BigInteger(Utils.KConstants[x], 16);
        int SofI = Utils.SValues[x];

        // adding all tgt
        BigInteger temp = Op_One.modularAddition(a, I1, MofG, KofI);

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
