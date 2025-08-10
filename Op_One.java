import java.math.BigInteger;

public class Op_One {

    public static BigInteger AA = new BigInteger("67452301", 16);
    public static BigInteger BB = new BigInteger("efcdab89", 16);
    public static BigInteger CC = new BigInteger("98badcfe", 16);
    public static BigInteger DD = new BigInteger("10325476", 16);

    public static BigInteger A = AA;
    public static BigInteger B = BB;
    public static BigInteger C = CC;
    public static BigInteger D = DD;

    public static final BigInteger mod32 = new BigInteger("100000000", 16);
    public static final BigInteger mask32 = new BigInteger("FFFFFFFF", 16);

    public static BigInteger F(BigInteger b, BigInteger c, BigInteger d) {
        BigInteger bAndC = b.and(c);
        BigInteger notB = b.not().and(mask32);
        BigInteger notBAndD = notB.and(d);
        return bAndC.or(notBAndD).and(mask32);
    }

    public static BigInteger modularAddition(BigInteger... values) {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger value : values) {
            sum = sum.add(value);
        }
        return sum.and(mask32);
    }

    public static BigInteger leftRotate(BigInteger value, int shift) {
        shift %= 32;
        BigInteger left = value.shiftLeft(shift);
        BigInteger right = value.shiftRight(32 - shift);
        return left.or(right).and(mask32);
    }

    public static void opOne(int x) {
        BigInteger a = Op_One.A;
        BigInteger b = Op_One.B;
        BigInteger c = Op_One.C;
        BigInteger d = Op_One.D;
        BigInteger F1 = F(b, c, d);
        BigInteger MofG = Padding.hexStrings[x];
        BigInteger KofI = new BigInteger(Utils.KConstants[x], 16);
        int SofI = Utils.SValues[x];

        // adding all tgt
        BigInteger temp = modularAddition(a, F1, MofG, KofI);

        // rotation
        BigInteger rotation = leftRotate(temp, SofI);

        // new b
        BigInteger Bnew = b.add(rotation).and(mask32);

        A = d;
        B = Bnew;
        C = b;
        D = c;
    }
}
