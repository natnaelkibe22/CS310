import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import java.util.LinkedList;

class MoveToFront {
   private static int list = 256;
   private static LinkedList<Integer> input;
   private static int out;
   //this method performs encoding part
   public static void encode() {
	input = new LinkedList<Integer>();
	out = 0;
	while (out < list) {
		input.add(out);
		out++;
	}
	out = 0;
	String letters = BinaryStdIn.readString();
	char [] ch = letters.toCharArray();
	int i = 0;
	while (i < ch.length) {
	    int j = (int) ch[i];
		BinaryStdOut.write(input.indexOf(j), 8);
		out = input.remove(input.indexOf(j));
		input.add(0, out);
		i++;
	}
	BinaryStdOut.close();
}
// this method performs decoding part
    public static void decode() {
	input = new LinkedList<Integer>();
	out = 0;
	while (out < list) {
		input.add(out);
		out++;
	}
	String letters = BinaryStdIn.readString();
	char[] ch = letters.toCharArray();
	out = 0;
    while (out < ch.length) {
        int j = (int) ch[out];
        int s = input.remove(j);
        BinaryStdOut.write(s,  8);
        input.add(0, s);
        out++;
    }
    BinaryStdOut.close();
}

    public static void main(String[] args)
   {
	if (args[0].equals("-")) {
	    encode();
	}
	if (args[0].equals("+")) {
	    decode();
	}
    }
}