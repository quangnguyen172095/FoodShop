/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.OrderDetail;
import model.OrderDetails;

public class Email {
    // Email: tuanhai13112003@gmail.com
    // Password: vurk kivp horx hhgz

    final String FROM = "tuanhai13112003@gmail.com";
    final String PASSWORD = "vurk kivp horx hhgz";

    public boolean sendEmail(String to, String tieuDe, String noiDung) {
        // Properties : khai báo các thuộc tính
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
        props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // create Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new PasswordAuthentication(FROM, PASSWORD);
            }
        };

        // Phiên làm việc
        Session session = Session.getInstance(props, auth);

        // Tạo một tin nhắn
        MimeMessage msg = new MimeMessage(session);

        try {
            // Kiểu nội dung
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

            // Người gửi
            msg.setFrom(FROM);

            // Người nhận
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            // Tiêu đề email
            msg.setSubject(tieuDe);

            // Quy đinh ngày gửi
            msg.setSentDate(new Date());
            // Quy định email nhận phản hồi
            // msg.setReplyTo(InternetAddress.parse(FROM, false))
            // Nội dung
            msg.setContent(noiDung, "text/HTML; charset=UTF-8");

            // Gửi email
            Transport.send(msg);
            System.out.println("Gửi email thành công");
            return true;
        } catch (MessagingException e) {
            System.out.println("Gặp lỗi trong quá trình gửi email");
            System.out.println(e);
            return false;
        }
    }

    public void setEmail(List<OrderDetail> orderList, String TO) {
        Email email = new Email();
        double sum = 0;
        int count = 0;
        StringBuilder contentBuilder = new StringBuilder();
        contentBuilder.append("<html><head><style>");
        contentBuilder.append("table {border-collapse: collapse; width: 100%;}");
        contentBuilder.append("th, td {border: 1px solid black; padding: 8px;}");
        contentBuilder.append("th {background-color: #f2f2f2;}");
        contentBuilder.append(".in4 .lightText {color: orangered;font-size: 18px}  "
                + ".seller { margin-top: 16px;padding-bottom: 16px;margin-bottom: 16px;border-bottom: 1px solid #000;}\n"
                + " .seller th { width: 300px;text-align: left;}");
        contentBuilder.append("</style></head><body>");
        contentBuilder.append("<h2>Order Details</h2>");
        contentBuilder.append("<div class=\"in4\"><div class=\"seller\"><table>\n"
                + "                        <tr><th>Tên đơn vị bán hàng (Seller)</th>\n"
                + "                            <td><span class=\"lightText\">ONLINE GROCERY STORE</span></td></tr>\n"
                + "                        <tr><th>Mã số thuế (Tax code)</th><td>0102100740</td></tr>\n"
                + "                        <tr><th>Địa chỉ (Address)</th>\n"
                + "                            <td>Khu Giáo dục và Đào tạo - Khu công nghệ cao Hoà Lạc - Km29 Đại lộ Thăng Long,\n"
                + "                                Huyện Thạch Thất, Thành phố Hà Nội</td></tr>\n"
                + "                        <tr><th>Điện thoại (Tel.)</th><td></td></tr>\n"
                + "                        <tr><th>Số tài khoản (A/C No.)</th>\n"
                + "                            <td>00006969002 tại Ngân hàng TMCP Tiên Phong - Chi nhánh Thăng Long</td></tr>\n"
                + "                    </table></div>");
        contentBuilder.append("<table><thead>");
        contentBuilder.append("<tr><th>STT</th><th>Tên sản phẩm</th><th>Đơn giá</th>\n"
                + "                            <th>Số lượng</th><th>Discount</th><th>Thành tiền</th></tr></thead><tbody>");
        for (OrderDetail order : orderList) {
            contentBuilder.append("<tr>");
            contentBuilder.append("<td>").append(++count).append("</td>");
            contentBuilder.append("<td>").append(order.getProducts().getProductName()).append("</td>");
            contentBuilder.append("<td>").append(order.getProducts().getPrice()).append("</td>");
            contentBuilder.append("<td>").append(order.getQuantity()).append("</td>");
            contentBuilder.append("<td>").append(order.getProducts().getDiscount()).append("</td>");
            double total = (order.getProducts().getPrice() - order.getProducts().getPrice() * order.getProducts().getDiscount()) * order.getQuantity();
            sum += total;
            contentBuilder.append("<td>").append(String.format("%.2f", total)).append("</td>");
            contentBuilder.append("</tr>");
        }
        contentBuilder.append("</tbody><tfoot><tr><td colspan=\"5\" style=\"text-align: right; font-weight: bold;\">Tổng tiền:</td>")
                .append(String.format("%.2f", sum)).append("</td></tr></tfoot></table>");
        contentBuilder.append("<h2>Cảm ơn quý khách</h2></body></html>");
        email.sendEmail(TO, "Order Details", contentBuilder.toString());
    }

    public static void main(String[] args) {
        Email e = new Email();
        OrderDetailsDAO oddao = new OrderDetailsDAO();
//        List<OrderDetails> orderList = oddao.SearchByID(1);
//        e.setEmail(orderList, "tuanhai13112k3@gmail.com");
    }
}
