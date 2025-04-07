package cn.shiva.controller;

import cn.hutool.core.date.DateUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author shiva   2025-04-06 21:19
 */
@RestController
public class DataController {


    @RequestMapping("sse")
    public void sse(HttpServletResponse response) {
        //设置返回格式，SSE
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");

        AtomicBoolean isRunning = new AtomicBoolean(true);
        int count = 0;

        try (PrintWriter writer = response.getWriter()) {
            // 检测客户端是否断开（通过 IOException）
            // TODO 示例代码：最多发送 30 条
            while (isRunning.get() && count < 30) {
                count++;
                String data = "data: " + DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "\n\n";
                writer.write(data);
                writer.flush();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    isRunning.set(false);
                }
            }

            // 主动发送关闭事件
            writer.write("event: close\ndata: Connection closed by server\n\n");
            writer.flush();
        } catch (IOException e) {
            // 客户端断开连接时触发
            System.out.println("Client disconnected");
        }

    }

    @RequestMapping("springSSE")
    public SseEmitter springSSE(HttpServletResponse response) {
        // 3S超时
        SseEmitter emitter = new SseEmitter(10000L);
        // 注册回调函数，处理服务器向客户端推送的消息
        emitter.onCompletion(() -> {
            System.out.println("Connection completed");
            // 在连接完成时执行一些清理工作
        });
        emitter.onTimeout(() -> {
            System.out.println("Connection timeout");
            // 在连接超时时执行一些处理
            emitter.complete();
        });
        // 在后台线程中模拟实时数据
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    emitter.send(SseEmitter.event().name("message").data("[" + new Date() + "] Data #" + i));
                    Thread.sleep(1000);
                }
                emitter.complete(); // 数据发送完成后，关闭连接
            } catch (IOException | InterruptedException e) {
                emitter.completeWithError(e); // 发生错误时，关闭连接并报错
            }
        }).start();

        return emitter;
    }


}
