package com.wintergames.game1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.RouterFunction;
import org.springframework.web.reactive.function.RouterFunctions;
import reactor.ipc.netty.http.HttpServer;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class Game1App {

	private static final Logger logger = LoggerFactory.getLogger(Game1App.class);

	@Autowired
	public Environment environment;

	public static void main(String[] args) throws InterruptedException {
		//SpringApplication.run(Game1App.class, args);
		Game1App app = new Game1App();
		Game1App.start();
	}

	@PostConstruct
	public void afterInit(){
		String port = environment.getProperty("local.server.port");
		logger.info("Port: " + port);
	}

	public static void start() throws InterruptedException {
		RouterFunction<?> routes = Game1Routes.method1();

		final int PORT = System.getenv("PORT") != null ? Integer.parseInt(System.getenv("PORT")) : 8080;
		HttpHandler handler = RouterFunctions.toHttpHandler(routes);
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
		HttpServer server = HttpServer.create(PORT);
		server.startAndAwait(adapter);
	}

}
