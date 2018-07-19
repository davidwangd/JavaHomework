package Logic;

public class Random {

    public Random(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int random(){
        int ret = x * 8728342 ^ y * 32117 ^ z * 299832;
        z = y; y = x; x = ret;
        return Math.abs(ret);
    }

    private int x;
    private int y;
    private int z;
}

