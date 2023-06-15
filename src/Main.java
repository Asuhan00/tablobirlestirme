import Tables.Uretim;
import Tables.Mola;
import Tables.Sonuc;
import java.time.Duration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Uretim> uretim = new ArrayList<>();
        List<Mola> mola = new ArrayList<>();
        int counter = 0;

        Uretim uretim1 = new Uretim(1,LocalDateTime.of(2023, 5, 23, 7, 30),LocalDateTime.of(2023, 5, 23, 8, 30), LocalTime.of(1,0),"Uretim","");
        Uretim uretim2 = new Uretim(2,LocalDateTime.of(2023, 5, 23, 8, 30),LocalDateTime.of(2023, 5, 23, 12, 0), LocalTime.of(3,30),"Uretim","");
        Uretim uretim3 = new Uretim(3,LocalDateTime.of(2023, 5, 23, 12, 0),LocalDateTime.of(2023, 5, 23, 13, 0), LocalTime.of(1,0),"Uretim","");
        Uretim uretim4 = new Uretim(4,LocalDateTime.of(2023, 5, 23, 13, 0),LocalDateTime.of(2023, 5, 23, 13, 45), LocalTime.of(0,45),"Duruş","Arıza");
        Uretim uretim5 = new Uretim(5,LocalDateTime.of(2023, 5, 23, 13, 45),LocalDateTime.of(2023, 5, 23, 17, 30), LocalTime.of(3,45),"Uretim","");

        uretim.add(uretim1);
        uretim.add(uretim2);
        uretim.add(uretim3);
        uretim.add(uretim4);
        uretim.add(uretim5);

        Mola mola1 = new Mola(LocalTime.of(10,0),LocalTime.of(10,15),"Çay Molası");
        Mola mola2 = new Mola(LocalTime.of(12,0),LocalTime.of(12,30),"Yemek Molası");
        Mola mola3 = new Mola(LocalTime.of(15,0),LocalTime.of(15,15),"Çay Molası");

        mola.add(mola1);
        mola.add(mola2);
        mola.add(mola3);

        List<Uretim> sonuc = new ArrayList<>();

        for (int i=0;i< uretim.size();i++) {
            Sonuc sonuc1= karsilastir(uretim.get(i),mola.get(counter));
            sonuc.addAll(sonuc1.getList());
            if (sonuc1.isCheck()&& counter < mola.size()) {
                counter++;
            }
        }
        for (int i = 0; i< sonuc.size();i++) {
            System.out.println(sonuc.get(i).toString());
        }
    }

    public static Sonuc karsilastir(Uretim uretim,Mola mola) {
        List<Uretim> list = new ArrayList<>();

        //uz = uretim zamanı, mz=mola zamanı S=baslangıc F=bitiş
        LocalDateTime uzS = uretim.getStart();
        LocalDateTime uzF = uretim.getFinish();
        LocalTime mzS = mola.getStart();
        LocalTime mzF = mola.getFinish();

        LocalTime ltS = LocalTime.of(uzS.getHour(), uzS.getMinute());
        LocalTime ltF = LocalTime.of(uzF.getHour(), uzF.getMinute());

        int hours;
        int minutes;
        boolean check = false;
        Duration duration;
        if (ltS.isBefore(mzS) && ltF.isAfter(mzF)) {
            check = true;
            duration = Duration.between(ltS,mzS);
            hours = (int)duration.toHours();
            minutes = (int)duration.toMinutes() % 60;
            list.add(new Uretim(uretim.getNo(),uzS,LocalDateTime.of(LocalDate.of(2023, 5, 23),mzS),LocalTime.of(hours,minutes), uretim.getStatus(), uretim.getHalt()));
            duration = Duration.between(mzS,mzF);
            hours = (int)duration.toHours();
            minutes = (int)duration.toMinutes() % 60;
            list.add(new Uretim(uretim.getNo(),LocalDateTime.of(LocalDate.of(2023, 5, 23),mzS),LocalDateTime.of(LocalDate.of(2023, 5, 23),mzF),LocalTime.of(hours,minutes),"Durus",mola.getHalt()));
            duration = Duration.between(mzF,ltF);
            hours = (int)duration.toHours();
            minutes = (int)duration.toMinutes() % 60;
            list.add(new Uretim(uretim.getNo(),LocalDateTime.of(LocalDate.of(2023, 5, 23),mzF),uzF,LocalTime.of(hours,minutes), uretim.getStatus(), uretim.getHalt()));

        } else if (ltS.equals(mzS)&&ltF.isAfter(mzF)) {
            check = true;
            duration = Duration.between(mzS,mzF);
            hours = (int)duration.toHours();
            minutes = (int)duration.toMinutes() % 60;
            list.add(new Uretim(uretim.getNo(), LocalDateTime.of(LocalDate.of(2023, 5, 23),mzS),LocalDateTime.of(LocalDate.of(2023, 5, 23),mzF),LocalTime.of(hours, minutes),"Durus", mola.getHalt()));
            duration = Duration.between(mzF,ltF);
            hours = (int)duration.toHours();
            minutes = (int)duration.toMinutes() % 60;
            list.add(new Uretim(uretim.getNo(),LocalDateTime.of(LocalDate.of(2023, 5, 23),mzF),uzF,LocalTime.of(hours,minutes), uretim.getStatus(), uretim.getHalt()));

        } else if (ltS.isBefore(mzS)&&ltF.equals(mzF)) {
            check = true;
            duration = Duration.between(ltS,mzS);
            hours = (int)duration.toHours();
            minutes = (int)duration.toMinutes() % 60;
            list.add(new Uretim(uretim.getNo(),uzS,LocalDateTime.of(LocalDate.of(2023, 5, 23),mzS),LocalTime.of(hours,minutes), uretim.getStatus(), uretim.getHalt()));
            check = true;
            duration = Duration.between(mzS,mzF);
            hours = (int)duration.toHours();
            minutes = (int)duration.toMinutes() % 60;
            list.add(new Uretim(uretim.getNo(),LocalDateTime.of(LocalDate.of(2023, 5, 23),mzS),LocalDateTime.of(LocalDate.of(2023, 5, 23),mzF),LocalTime.of(hours,minutes),"Durus",mola.getHalt()));


        } else {
            list.add(uretim);
        }

        return new Sonuc(list,check);

    }
}