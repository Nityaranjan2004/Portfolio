package com.nitya.Portfolio.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
public class KeepAliveScheduler {

    @Value("${APP_URL:http://localhost:8091}")
    private String appUrl;

    private final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    // Cron expression: runs every 14 minutes (e.g. 0, 14, 28, 42, 56)
    // Can be overridden by setting the KEEP_ALIVE_CRON environment variable
    @Scheduled(cron = "${KEEP_ALIVE_CRON:0 */14 * * * *}")
    public void keepAlive() {
        String pingUrl = appUrl + "/api/ping";
        System.out.println("KeepAliveScheduler: Sending ping request to " + pingUrl);

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(pingUrl))
                    .GET()
                    .timeout(Duration.ofSeconds(10))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("KeepAliveScheduler: Ping successful. Status code: " + response.statusCode());
            } else {
                System.err.println("KeepAliveScheduler: Ping failed. Status code: " + response.statusCode() + ", Response: " + response.body());
            }
        } catch (Exception e) {
            System.err.println("KeepAliveScheduler: Error executing ping: " + e.getMessage());
        }
    }
}
