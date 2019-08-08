/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Zenter
 */
public class SendMail {
    final String EMAIL = "javasoftware.zent@gmail.com";
    final String PASSWORD = "Zent@2019";
    final String TOPIC = "Hệ thống quản lý bán hàng";
    public boolean sendMail(String subject, String recipient, String content){
        try {
            Email email = new SimpleEmail();

            // Cấu hình thông tin Email Server
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(EMAIL, PASSWORD));

            // Với gmail cái này là bắt buộc.
            email.setSSLOnConnect(true);

            // Người gửi
            email.setFrom(EMAIL, TOPIC);

            // Tiêu đề
            email.setSubject(subject); //Tiêu đề khi gửi email

            // Nội dung email
            email.setMsg(content); //Nội dung email bạn muốn gửi.
            // Người nhận
            email.addTo(recipient); //Đia chỉ email người nhận
            email.send(); //Thực hiện gửi.
            System.err.println("Sent Email Successfull ! Check youremail, please !");
            System.out.println("\n");
            return true;
        } catch (Exception e) {
            System.out.println("Gửi không thành công !");
            return false;
        }
    }
}
