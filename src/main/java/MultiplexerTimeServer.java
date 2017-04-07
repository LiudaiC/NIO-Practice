package main.java;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class MultiplexerTimeServer implements Runnable{

  private Selector selector;
  
  private ServerSocketChannel serverChannel;
  
  private volatile boolean stop;
  
  public MultiplexerTimeServer(int port) {
    try {
      selector = Selector.open();
      serverChannel = ServerSocketChannel.open();
      
      serverChannel.configureBlocking(false);
      serverChannel.socket().bind(new InetSocketAddress(port));
      serverChannel.register(selector, SelectionKey.OP_ACCEPT);
      System.out.println("The time server is start in port: "+port);
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }

  @Override
  public void run() {
    
  }

}
