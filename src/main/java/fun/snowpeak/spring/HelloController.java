package fun.snowpeak.spring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.system.JavaVersion;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;

@EnableAutoConfiguration
@Controller
public class HelloController {
    @RequestMapping("/")
    @ResponseBody
    public String index(HttpServletRequest request) throws IOException {
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        // 设置时区为东 8 区
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String dateTimeStr = sdf.format(date);

        String clientIp = IpUtil.getIpAddress(request);
        StringBuilder sb = new StringBuilder();
        InetAddress inetadd = InetAddress.getLocalHost();

        sb.append(
                "<html><head><title>Spring Boot Application</title></head><body><h1>Hello Spring Boot</h1><p> Current time is ")
                .append(dateTimeStr).append(".</p><p> Your IP is ")
                .append(clientIp)
                .append(".</p><p>This application is running on <b>").append(inetadd.getHostName())
                .append("</b> with IP <b>").append(inetadd.getHostAddress())
                .append("</b>.</p><p>This is a demo project of Spring Boot package in Jar artifact.</p><p>This application is built with Spring <b>")
                .append(SpringVersion.getVersion()).append("</b> on Java <b>")
                .append(JavaVersion.getJavaVersion().toString())
                .append("</b>.</p><h4><a href=\"/hello\">hello</a></h4></body></html>");
        return sb.toString();
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String dateTimeStr = sdf.format(date);
        StringBuilder sb = new StringBuilder();
        sb.append(
                "<html><head><title>Spring Boot Application</title></head><body><h1>Hello Spring Boot</h1><p> Current time is ")
                .append(dateTimeStr)
                .append("</p><p>Hello World 世界你好！</p><p><a href=\"/\">Back to homepage.</a></p></body></html>");

        return sb.toString();
    }
}