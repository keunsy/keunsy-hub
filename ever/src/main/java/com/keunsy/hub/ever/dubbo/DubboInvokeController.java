package com.keunsy.hub.ever.dubbo;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.telnet.TelnetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * 用于页面或其他方式不引包直接调用dubbo接口
 * 注：dubbo.jsp页面需要改动后方能正常使用
 */
@RestController
@RequestMapping(value = "/api/dubbo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
public class DubboInvokeController {

  private static final Logger LOGGER = LoggerFactory.getLogger(DubboInvokeController.class);

  private static final String INVOKE = "invoke";
  private static final String END_STR = "dubbo>";
  private static final String VT220 = "VT220";
  private static final String LS = "ls";
  private static final String LS_L = "ls -l";


  /**
   * 调用服务
   */
  @RequestMapping(value = "/invoke")
  public String invoke(String ip, Integer port, String serviceName, String methodName, String parameter) {

    TelnetClient telnet = null;
    InputStream is = null;
    PrintStream out = null;
    String invokeResult = null;
    try {

      checkIpAndPort(ip, port);
      if (StringUtils.isBlank(serviceName)) {
        throw new Exception("serviceName");
      }
      if (StringUtils.isBlank(methodName)) {
        throw new Exception("methodName");
      }

      telnet = new TelnetClient(VT220);
      telnet.connect(ip, port);
      is = telnet.getInputStream();
      out = new PrintStream(telnet.getOutputStream());
      StringBuilder sb = new StringBuilder();
      sb.append(INVOKE).append(" ").append(serviceName).append(".").append(methodName).append("(").append(parameter).append(")");
      out.println(sb.toString());
      out.flush();

      StringBuilder resultSb = new StringBuilder();

      char ch = (char) is.read();

      //存在丢失一个字符的几率(导致json格式错误），其他方式可能存在阻塞，暂时没有好的解决方式
      while (true) {
        if (ch == '\r' || ch == '\n') {
          // 处理乱码问题
          byte[] temp = resultSb.toString().getBytes("iso8859-1");
          invokeResult = new String(temp, "GBK");
          break;
        }
        resultSb.append(ch);
        ch = (char) is.read();

      }


    } catch (Exception ex) {
      LOGGER.error(ex.getMessage(), ex);
    } finally {
      close(telnet, is, out);
    }
    return invokeResult;
  }

  /**
   * 查看所有服务
   */
  @RequestMapping(value = "/listService")
  public String ls(String ip, Integer port) throws Exception {

    checkIpAndPort(ip, port);
    return excuteCommand(ip, port, LS);
  }

  /**
   * 查看服务所有方法
   */
  @RequestMapping(value = "/listMethod")
  public String ls(String ip, Integer port, String serviceName) throws Exception {

    checkIpAndPort(ip, port);
    return excuteCommand(ip, port, LS_L + " " + serviceName);

  }

  private static String excuteCommand(String ip, Integer port, String command) throws IOException {

    TelnetClient telnet = null;
    InputStream is = null;
    PrintStream out = null;
    try {
      telnet = new TelnetClient(VT220);
      telnet.connect(ip, port);
      is = telnet.getInputStream();
      out = new PrintStream(telnet.getOutputStream());
      out.println(command);
      out.flush();
      return getResult(is);
    } finally {
      close(telnet, is, out);
    }
  }


  private static String getResult(InputStream is) throws IOException {

    StringBuilder resultSb = new StringBuilder();
    char ch = (char) is.read();
    String result;
    while (true) {
      resultSb.append(ch);
      if (resultSb.toString().endsWith(END_STR)) {
        // 处理编码，界面显示乱码问题
        byte[] temp = resultSb.toString().replace(END_STR, "").getBytes("iso8859-1");
        result = new String(temp, "GBK");
        break;
      }
      ch = (char) is.read();
    }

    return result;
  }

  private static void close(TelnetClient telnet, InputStream is, PrintStream out) {
    try {
      if (is != null) {
        is.close();
      }
      if (out != null) {
        out.close();
      }
      if (telnet != null) {
        telnet.disconnect();
      }
    } catch (Exception e) {
      LOGGER.error(e.getMessage(), e);
    }
  }

  private static void checkIpAndPort(String ip, Integer port) throws Exception {
    if (StringUtils.isBlank(ip)) {
      throw new Exception("ip");
    }
    if (null == port) {
      throw new Exception("port");
    }
  }

}
