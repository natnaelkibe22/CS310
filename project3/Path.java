class Path {
         private int row, col;          // the row and column this node represents
         private int cost;              // the matching cost from this point on
         private Path next;        // the next node in the optimal path
         Path(int r, int c) {
             row = r;
             col = c;
             next = null;
         }
         int row() {
             return row;
         }
         int col() {
             return col;
         }
         void srow(int r) {
             this.row = r;
         }
         void scol(int c) {
             this.col = c;
         }
         int c() {
             return cost;
         }
         void cost(int c) {
             this.cost = c;
         }
         void snext(Path change) {
             this.next = null;
             this.next = change;
         }
         Path next() {
             return next;
         }
    }
