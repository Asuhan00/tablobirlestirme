package Tables;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Uretim {
    public int no;
    public LocalDateTime start;
    public LocalDateTime finish;
    public LocalTime sure;
    public String status;
    public String halt;

    public Uretim(int no, LocalDateTime start, LocalDateTime finish, LocalTime sure, String status, String halt) {
        this.no = no;
        this.start = start;
        this.finish = finish;
        this.sure = sure;
        this.status = status;
        this.halt = halt;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }

    public String getHalt() {
        return halt;
    }

    public void setHalt(String halt) {
        this.halt = halt;
    }

    public LocalTime getSure() {
        return sure;
    }

    public void setSure(LocalTime sure) {
        this.sure = sure;
    }
    @Override
    public String toString(){
        return this.no + " | " + start + " | " + finish + " | " + sure + " | " + status + " | " + halt;
    }

}
