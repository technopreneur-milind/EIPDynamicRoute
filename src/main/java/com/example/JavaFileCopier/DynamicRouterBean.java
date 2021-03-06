package com.example.JavaFileCopier;

import org.apache.camel.Exchange;
import org.apache.camel.Header;

public class DynamicRouterBean {
public String route(String body,
 @Header(Exchange.SLIP_ENDPOINT) String previous) {
 return whereToGo(body, previous);
}
private String whereToGo(String body, String previous) {
 if (previous == null) {
 return "direct://a";
 } 
 else if ("direct://a".equals(previous)) {
 return "language://simple:Bye ${body}";
 } else {
 return null;
 }
}
}
