package us.cijian.autumn.pojo;

/**
 * Created by MurphyL on 5/24/2015.
 */
public class KV<KT, VT> {

    private Integer i;
    private KT k;
    private VT v;

    public Integer getI() {
        return i;
    }

    public void setId(Integer i) {
        this.i = i;
    }

    public KT getK() {
        return k;
    }

    public void setK(KT k) {
        this.k = k;
    }

    public VT getV() {
        return v;
    }

    public void setV(VT v) {
        this.v = v;
    }
}
