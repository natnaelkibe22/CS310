
public class Match {
	// return the min of 3 integers
	private static int min(int a, int b, int c) {
		int min1 = ((a <= b) ? a : b);
		return (min1 <= c) ? min1 : c;
	}
	static Path match(String a, String b) {
		int subsol1, subsol2, subsol3;
		int M = a.length();
		int N = b.length();
		Path[][] opt = new Path[M + 1][N + 1];

		for (int i = 0; i <= M; i++) {
			for (int j = 0; j <= N; j++) {
				opt[i][j] = new Path();
				opt[i][j].row = i;
				opt[i][j].col = j;
			/*	if (i < M && j < N) {
                opt[i][j].x = a.charAt(i);
                opt[i][j].y = b.charAt(j);
            } */
			}
		}

		opt[M][N].cost = 0;
		opt[M][N].next = null;
		int min = 0;


		for (int i = M - 1; i >= 0; i--) {

			opt[i][N].cost = opt[i + 1][N].cost + 2;
			for (int j = N - 1; j >= 0; j--) {
				opt[M][j].cost = opt[M][j + 1].cost + 2;

				if (a.charAt(i) == b.charAt(j))
					subsol1 = opt[i + 1][j + 1].cost + 0;
				else
					subsol1 = opt[i + 1][j + 1].cost + 1;

				subsol2 = opt[i + 1][j].cost + 2;
				subsol3 = opt[i][j + 1].cost + 2;
				opt[i][j].cost = min(subsol1, subsol2, subsol3);
				min = opt[i][j].cost;
				if (min == subsol1) {
					opt[i][j].next = opt[i + 1][j + 1];
					continue;
				}
				if (min == subsol2) {
					opt[i][j].next = opt[i + 1][j];
					continue;

				}
				if (min == subsol2) {
					opt[i][j].next = opt[i][j + 1];
				}
			}
		}

		return opt[0][0];
	}
	static void main(String[] args) {
		Path path = Match.match("AACAGTTACC", "TAAGGTCA");
		for (Path p = path; p != null; p = p.next)
			System.out.println(p.row + " " + p.col);
	}
	/******************************************************************************
	 * Path.java
	 *
	 * A linked list of nodes representing the optimal path returned by Match
	 *
	 ******************************************************************************/

	public class Path {
		private int row, col;
		private int cost;
		private Path next;

		public Path setPath(Path n) {
			next = n;
		}
		public void setCost(int cst) {
			cost = cst;
		}
		public void setRow(int r) {
			row = r;
		}
		public void setCol(int c) {
			col = c;
		}
		public int getRow() {
			return row;
		}
		public int getCol() {
			return col;
		}
		public int getCost() {
			return cost;
		}
		public Path NextPath() {
			return next;
		}

	}
}
