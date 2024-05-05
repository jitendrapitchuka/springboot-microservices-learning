package com.jitendra.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;


public class TestNotificationServiceApplication {


	public static void main(String[] args) {
		SpringApplication
				.from(NotificationServiceApplication::main)
				.with(ContainersConfig.class).run(args);
	}

}
