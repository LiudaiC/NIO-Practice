package main.java;


public class TimeServer {

  public static void main(String[] args) {
    int port = 8080;
    if (args != null && args.length > 0) {
      try {
        port = Integer.valueOf(port);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }
    
    MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
    new Thread(timeServer, "NIO-MultipleTimeServer-001").start();
  }
  
}
