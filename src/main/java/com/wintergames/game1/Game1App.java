package com.wintergames.game1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.RouterFunction;
import org.springframework.web.reactive.function.RouterFunctions;
import reactor.ipc.netty.http.HttpServer;


@SpringBootApplication
public class Game1App {

	public static void main(String[] args) throws InterruptedException {
		//SpringApplication.run(Game1App.class, args);
		Game1App app = new Game1App();
		Game1App.start();
	}

	public static void start() throws InterruptedException {
		RouterFunction<?> routes = Game1Routes.method1();

		HttpHandler handler = RouterFunctions.toHttpHandler(routes);
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
		HttpServer server = HttpServer.create("localhost",8080);
		server.startAndAwait(adapter);
	}

}
