package com.lambdatest.tunnel;

import com.lambdatest.httpserver.HttpServer;

import java.io.IOException;
import java.util.ArrayList;

public class TestDaemonThread1 extends Thread {

    public Integer port = null;

    public void run() {
        if (Thread.currentThread().isDaemon()) {//checking for daemon thread
            HttpServer httpServer = new HttpServer();
            try {
                port = HttpServer.findAvailablePort();
                System.out.println(port);
                int[] myIntArray = {port};
                httpServer.main(myIntArray);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("user thread work");
        }
    }
}
