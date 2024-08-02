package works.application1.kullaniciIslemleri.databases;

import works.application1.kullaniciIslemleri.entities.Kullanici;
import works.application1.kullaniciIslemleri.entities.Mail;
import works.application1.kullaniciIslemleri.utility.DatabaseManager;

import java.util.ArrayList;
import java.util.List;

public class MailDB extends DatabaseManager<Mail> {
    public List<Mail> findReceivedByKullanici(Kullanici kullanici) {
        List<Mail> mailsByKullanici = new ArrayList<>();
        for (Mail mail: veriListesi){
            if(mail.getAlici().equals(kullanici)){
                mailsByKullanici.add(mail);
            }
        }
        return mailsByKullanici;
    }

    public List<Mail> findSentByKullanici(Kullanici kullanici) {
        List<Mail> mailsByKullanici = new ArrayList<>();
        for (Mail mail: veriListesi){
            if(mail.getGonderici().equals(kullanici)){
                mailsByKullanici.add(mail);
            }
        }
        return mailsByKullanici;
    }
}