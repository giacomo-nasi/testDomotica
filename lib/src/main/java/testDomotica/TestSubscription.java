package testDomotica;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import java.util.Scanner;

public class TestSubscription {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
		
		//notification registration
		
//		MediaType mediaTypeNoti = MediaType.parse("application/json;ty=2");
//		RequestBody bodyNoti = RequestBody.create("{\n  \"m2m:ae\" : {\n    \"rn\": \"test\",\n      \"api\": \"0.2.481.2.0001.001.000111\",\n      \"lbl\": [\"key1\", \"key2\"],\n      \"rr\": true\n    }\n}", mediaTypeNoti);
//		Request requestNoti = new Request.Builder()
//		  .url("http://localhost:8080/notifications")
//		  .method("POST", bodyNoti)
//		  .addHeader("Accept", "application/json")
//		  .addHeader("X-M2M-RI", "12345")
//		  .addHeader("X-M2M-Origin", "Snotifications")
//		  .addHeader("Content-Type", "application/json;ty=2")
//		  .build();
//		Response responseNoti = client.newCall(requestNoti).execute();
//		String bodyString = responseNoti.body().string();
//		System.out.println(bodyString);
//		System.out.println();
		
		//discovery
				Request request = new Request.Builder()
				  .url("http://127.0.0.1:7579/Mobius/temp?fu=1&ty=3")
				  .method("GET", null)
				  .addHeader("Accept", "application/json")
				  .addHeader("X-M2M-RI", "fds345435")
				  .addHeader("X-M2M-Origin", "S20170717074825768bp2l")
				  .build();
				Response response = client.newCall(request).execute();
				String bodyString = response.body().string();
				System.out.println("Discovery response");
				System.out.println(bodyString);
				System.out.println();
		
		//notification registration (AE create)
				MediaType mediaType = MediaType.parse("application/json;ty=2");
				RequestBody body = RequestBody.create("\n{\n  \"m2m:ae\": {\n    \"rn\": \"notifications\",\n"
						+ "    \"api\": \"0.2.481.2.0001.001.000111\",\n"
						+ "    \"poa\": [\n      \"http://127.0.0.1:8080\"\n    ],\n"
						+ "    \"rr\": true\n  }\n}", mediaType);
				request = new Request.Builder()
				  .url("http://localhost:7579/Mobius")
				  .method("POST", body)
				  .addHeader("Accept", "application/json")
				  .addHeader("X-M2M-RI", "12345")
				  .addHeader("X-M2M-Origin", "Snotifications")
				  .addHeader("Content-Type", "application/json;ty=2")
				  .build();
				response = client.newCall(request).execute();
				bodyString = response.body().string();
				System.out.println("Notification response");
				System.out.println(bodyString);
				System.out.println();
				
		//subscription create
				Scanner reader = new Scanner(System.in);
			 	System.out.println("Inserire l'identificativo da fornire alla subscription");
			 	String subName = reader.nextLine().trim(); 
			 	MediaType mediaTypeSub = MediaType.parse("application/json;ty=23");
					body = RequestBody.create(
							"\n{\n\t\"m2m:sub\" : {\n\t\t\"rn\": \""+ subName +"\",\n\t\t\"enc\":{\n\t\t"
									+ "   \"net\":[3]\n\t\t},\n\t    \"nu\": [\"http://127.0.0.1:8080/api/notifications?ct=json\"]\n    }\n}\n\n\n", mediaTypeSub);
					request = new Request.Builder()
					  .url("http://localhost:7579/Mobius/temp/DATA")
					  .method("POST", body)
					  .addHeader("Accept", "application/json")
					  .addHeader("X-M2M-RI", "123dfsaf45")
					  .addHeader("X-M2M-Origin", "Stemp")
					  .addHeader("Content-Type", "application/json;ty=23")
					  .build();
					response = client.newCall(request).execute();
					bodyString = response.body().string();
					System.out.println("Subscription response");
					System.out.println(bodyString);
					System.out.println();
					reader.close();
	}
}
