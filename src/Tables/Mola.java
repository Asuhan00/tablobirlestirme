package Tables;

import java.time.LocalTime;

public class Mola {
    public LocalTime start;
    public LocalTime finish;
    public String halt;

    public Mola(LocalTime start, LocalTime finish, String halt) {
        this.start = start;
        this.finish = finish;
        this.halt = halt;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    public void setFinish(LocalTime finish) {
        this.finish = finish;
    }

    public String getHalt() {
        return halt;
    }

    public void setHalt(String halt) {
        this.halt = halt;
    }
}
