package Logic;

// 1 表示蓝色蛇
// 2 表示红色蛇
// 0 表示没有障碍
// 4 表示墙
// 8 表示洞
// 16 表示食物。。

public class Logic {
    public Logic(int height, int width, Random random, int color){
        this.height = height;
        this.width = width;
        this.randomGenner = random;
        this.color = color;
        genBoard();
    }

    private void genBoard(){
        board = new int[height][width];
        holes = new Pos[4];
        int nWall = randomGenner.random() % 4 + 5;
        for (int i = 0;i < nWall;i++){
            int x = randomGenner.random() % height;
            int y = randomGenner.random() % width;
            int len = randomGenner.random() % (Math.min(height, width) / 2);
            int dir = randomGenner.random() % 4;
            int cnt = 0;
            while (cnt < len && 0 < x && x < height && 0 < y && y < width){
                board[x][y] = 4;
                cnt = cnt + 1;
                x = x + directions[dir].x;
                y = y + directions[dir].y;
            }
        }
        for (int i = 0;i < 4;i++){
            int x = randomGenner.random() % height;
            int y = randomGenner.random() % width;
            if (board[x][y] == 0)
                board[x][y] = 8;
            holes[i] = new Pos(x, y);
        }
        for (int i = 0;i < 2;i++){
            int x = randomGenner.random() % height;
            int y = randomGenner.random() % width;
            if (board[x][y] == 0){
                board[x][y] = 16;
            }
        }
    }

    public void process(int dir1, int dir2){

    }

    private int[][] board;                  // 表示面板
    private int height, width;             // 表示 面板的长宽
    private int lives[] = new int[2];
    private int lens[] = new int[2];
    private int positions[][] = new int[2][];           //表示蛇的位置
    private int head[] = new int[2];                    //表示蛇的头的位置
    private Random randomGenner;
    private Pos holes[];
    private Pos directions[] = {new Pos(1,0), new Pos(-1,0), new Pos(0,1), new Pos(0,-1)};
    private int color;

    public static final int NONE = 0;
    public static final int RED = 1;
    public static final int BLUE = 2;
    public static final int WALL = 4;
    public static final int HOLE = 8;
    public static final int FOOD = 16;
}

class Pos{
    public Pos(){
        x = -1;
        y = -1;
    }

    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int x;
    public int y;
}

