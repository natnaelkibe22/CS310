public class Match {
    private static int min(int a, int b, int c) {
        int m = a;
        if (b <= m) {
            m = b;
        }
        if (c <= m) {
            m = c;
        }
        return m;
    }
    private static int penality(char a, char b) {
        if (a == b) {
            return 0;
        }
        if (a == ' ' || b == ' ') {
            return 2;
        }
        return 1;
    }
    static Path match(String a, String b) {
        int N = a.length();
        int M = b.length();
        int s1, s2, s3;
        Path[][] opt = new Path[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                opt[i][j] = new Path(i, j);
            }
        }
        opt[N][M].cost(0);
		opt[N][M].snext(null);
		int min = 0;
        for (int i = N - 1; i >= 0; i--) {
            opt[i][M].cost(opt[i + 1][M].c() + 2);
            for (int j = M - 1; j >= 0; j--) {
                opt[N][j].cost(opt[N][j + 1].c() + 2);
                s1 = opt[i + 1][j + 1].c() + penality(a.charAt(i), b.charAt(j));
                s2 = opt[i + 1][j].c() + 2;
                s3 = opt[i][j + 1].c() + 2;
                opt[i][j].cost(min(s1, s2, s3));
                min = opt[i][j].c();
                if (min == s1) {
					opt[i][j].snext(opt[i + 1][j + 1]);
					continue;
				}
				if (min == s2) {
					opt[i][j].snext(opt[i + 1][j]);
					continue;
				}
				if (min == s3) {
					opt[i][j].snext(opt[i][j + 1]);
					continue;
				}
            }
        }
        return opt[0][0];
    }
    public static void main(String[] args) {
        Path path = Match.match("AACAGTTACC", "TAAGGTCA");
        for (Path p = path; p != null; p = p.next()) {
            System.out.println(p.row() + " " + p.col() + " " + p.c());
        }
    }
}