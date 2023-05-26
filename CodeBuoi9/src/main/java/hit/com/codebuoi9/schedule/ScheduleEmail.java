package hit.com.codebuoi9.schedule;

import hit.com.codebuoi9.email.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class ScheduleEmail {

    @Autowired
    private MailService mailService;

    //fixedRate : khoảng thời gian nó thực hiện tác vụ
    //fixedDelay : khoảng thời gian thực hiện tác vụ thêm method đấy hoàn thành xong
    //Cron leen lich
    @Scheduled(cron = "0 0 20-22 * * * 2023")
    void sentMailSchedule() throws MessagingException {
        mailService.sentMail(
                "doanducminh11082002@gmail.com" ,
                "Xin chào ae!");
    }
}
