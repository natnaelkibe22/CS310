import edu.princeton.cs.algs4.SymbolGraph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Stack;
public class DegreesOfSeparationBFS{
    private DegreesOfSeparationBFS() { }
    public static void main(String[] args) {
        String filename  = args[0];
        String delimiter = args[1];
        String source    = args[2];
        String query     = args[3];
        SymbolGraph sg = new SymbolGraph(filename, delimiter);
        Graph G = sg.graph();
        //StdOut.print("Done reading movies.txt\n");
        if (!sg.contains(source)) {
            StdOut.println(source + " not in database.");
            return;
        }
        int s = sg.indexOf(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
            if (sg.contains(query)) {
                int t = sg.indexOf(query);
                if (bfs.hasPathTo(t)) {
                    Stack<String> bacon = new Stack<String>();
                   for (int v : bfs.pathTo(t)) {
                        bacon.push(sg.nameOf(v));
                   }
                   //bacon.push("Done reading movies.txt");
                   int num = (bacon.size() - 1) / 2;
                   //StdOut.println();
                   StdOut.println(query + " has a bacon number of " + num + ".");
                   while (bacon.size() > 1) {
                        StdOut.print(bacon.pop() + " was in the movie " + bacon.pop() + " with ");
                        StdOut.print(bacon.peek() + "\n");
                   }
                }
                else {
                    StdOut.println("Not connected");
                }
            }
            else {
                StdOut.println("   Not in database.");
            }
    }
}