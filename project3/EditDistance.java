import java.util.Scanner;
import java.io.FileReader;
public class EditDistance {
    public static void main(String[] args) throws Exception {
        String[] line = new String[2];
		FileReader txtfile = null;
		Scanner txt = null;
       if (args.length != 0) {
          txtfile = new FileReader(args[0]);
	      txt =	new Scanner(txtfile);
       }
       int i = 0;
       while (txt.hasNextLine())
		{
           line[i] = txt.nextLine();
           i++;
		}
		txt.close();
		Match s = new Match();
        int min = 0;
        int line1 = line[0].length();
        int line2 = line[1].length();
        Path path = s.match(line[0].substring(0, line1), line[1].substring(0, line2));
		System.out.println("Edit Distance " + path.c());
		while (path.next() != null) {
		   System.out.print(line[0].charAt(path.row()) + " ");
		   if (path.col() == path.next().col()) {
		            System.out.print("-" + " ");
		   }
		   else {
		        System.out.print(line[1].charAt(path.col()) + " ");
		    }
		    min = path.c() - path.next().c();
			System.out.println(min);
			path = path.next();
		}
    }
}

