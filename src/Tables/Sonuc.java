package Tables;

import java.util.List;
public class Sonuc {
    public List<Uretim> list;
    public boolean check;

    public Sonuc(List<Uretim> list, boolean check) {
        this.list = list;
        this.check = check;
    }

    public List<Uretim> getList() {
        return list;
    }

    public void setList(List<Uretim> list) {
        this.list = list;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
