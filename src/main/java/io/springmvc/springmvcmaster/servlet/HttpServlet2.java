package io.springmvc.springmvcmaster.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "HelloServlet2", urlPatterns = "/servlet2")
public class HttpServlet2 extends jakarta.servlet.http.HttpServlet {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            super.doGet(req, resp);

            String method = req.getMethod();
            String requestURI = req.getRequestURI();
            StringBuffer requestURL = req.getRequestURL();
            String requestedSessionId = req.getRequestedSessionId();

            req.setAttribute("attribute1", "value1");
            req.setAttribute("attribute2", "value2");

            StringBuilder attributeBuilder = new StringBuilder();

            req.removeAttribute("attribute1");
            req.getAttributeNames().asIterator().forEachRemaining(
                        attributeName -> attributeBuilder.append("- " + attributeName + ", "));

            String remoteAddr = req.getRemoteAddr();
            String remoteHost = req.getRemoteHost();
            int remotePort = req.getRemotePort();
            String localAddr = req.getLocalAddr();
            String localName = req.getLocalName();
            int localPort = req.getLocalPort();

            String contentType = req.getContentType();
            int contentLength = req.getContentLength();
            String characterEncoding = req.getCharacterEncoding();
            String protocol = req.getProtocol();
            String scheme = req.getScheme();
            String serverName = req.getServerName();
            int serverPort = req.getServerPort();

            Map<String, Object> httpReqArgument = new HashMap();

            httpReqArgument.put("Method", method);
            httpReqArgument.put("RequestURI", requestURI);
            httpReqArgument.put("RequestURL", requestURL);
            httpReqArgument.put("RequestedSessionId", requestedSessionId);
            httpReqArgument.put("Attribute-Names", attributeBuilder.toString());

            httpReqArgument.put("Remote-Addr", remoteAddr == null ? "null" : remoteAddr);
            httpReqArgument.put("Remote-Host", remoteHost == null ? "null" : remoteHost);
            httpReqArgument.put("Remote-Port", remotePort == -1 ? "null" : remotePort);
            httpReqArgument.put("Local-Addr", localAddr == null ? "null" : localAddr);
            httpReqArgument.put("Local-Name", localName == null ? "null" : localName);
            httpReqArgument.put("Local-Port", localPort == -1 ? "null" : localPort);
            httpReqArgument.put("Content-Type", contentType == null ? "null" : contentType);
            httpReqArgument.put("Content-Length", contentLength == -1 ? "null" : contentLength);
            httpReqArgument.put("Character-Encoding", characterEncoding == null ? "null" : characterEncoding);
            httpReqArgument.put("Protocol", protocol == null ? "null" : protocol);
            httpReqArgument.put("Scheme", scheme == null ? "null" : scheme);
            httpReqArgument.put("Server-Name", serverName == null ? "null" : serverName);
            httpReqArgument.put("Server-Port", serverPort == -1 ? "null" : serverPort);

            String response = new ObjectMapper().writeValueAsString(httpReqArgument);
            resp.setContentType("application/json");
            resp.getWriter().write(response);

      }
}
