package mod.syconn.hero.util;

public class CommonEvent<P1, P2, P3, R> {

    private P1 p1;
    private P2 p2;
    private P3 p3;
    private R result;

    public CommonEvent(P1 p1, P2 p2, P3 p3, R result) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.result = result;
    }

    public P1 getP1() {
        return p1;
    }

    public void setP1(P1 p1) {
        this.p1 = p1;
    }

    public P2 getP2() {
        return p2;
    }

    public void setP2(P2 p2) {
        this.p2 = p2;
    }

    public P3 getP3() {
        return p3;
    }

    public void setP3(P3 p3) {
        this.p3 = p3;
    }

    public R getResult() {
        return result;
    }

    public void setResult(R result) {
        this.result = result;
    }
}
