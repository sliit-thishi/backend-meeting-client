package com.movieMania.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Stack;

@SpringBootApplication
public class BackendApplication {


	private static Stack<String> a_client = new Stack<>();
	private static Stack<String> b_client = new Stack<>();

	private static boolean typeLogic = false;

	private static String type = "";


	public static String setVal2(String val) {
		a_client.push(val);
		return "added";
	}

	public String getVal2() {
		while (!a_client.empty()){
			b_client.push(a_client.pop());
		}
		if (b_client.empty()){
			return "empty";
		}
		return b_client.pop();
	}

	public static String getType(){
		return type;
	}
	public String setType(){
		typeLogic = true;

		return "set";
	}

	public String stop(){
		typeLogic=false;
		return "stopped";
	}



	private static void clientMethod() throws IOException {
		Socket s = new Socket("localhost",4999);
		Scanner scanner = new Scanner(System.in);
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("student");
		pr.flush();
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		String str = "";

		for(;;){
//			System.out.println("Enter Request");
//			String request = scanner.nextLine();
////            PrintWriter pr = new PrintWriter(s.getOutputStream());
//			pr.println(request);
//			pr.flush();

//            InputStreamReader in = new InputStreamReader(s.getInputStream());
//            BufferedReader bf = new BufferedReader(in);

			str= bf.readLine();
			System.out.println("server says that "+str);
//			if (str.equalsIgnoreCase("over")){
//				typeLogic = false;
//				break;
//			}
			if (!str.equalsIgnoreCase("empty")){
				setVal2(str);
			}

		}
	}


	public static void main(String[] args) throws IOException {
		SpringApplication.run(BackendApplication.class, args);

		for (;;){
			while (!typeLogic){
				System.out.println(typeLogic);
			}
			clientMethod();
		}

	}

}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enable", matchIfMissing = true)
class SchedulingConfiguration{

}
