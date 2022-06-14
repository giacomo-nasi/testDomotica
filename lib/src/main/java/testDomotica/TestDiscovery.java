package testDomotica;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import okhttp3.ResponseBody;


public class TestDiscovery {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				Request request = new Request.Builder()
				  .url("http://127.0.0.1:7579/Mobius?fu=1&ty=2")
				  .method("GET", null)
				  .addHeader("Accept", "application/json")
				  .addHeader("X-M2M-RI", "fds345435")
				  .addHeader("X-M2M-Origin", "S20170717074825768bp2l")
				  .build();
				Response response = client.newCall(request).execute();
				String bodyString = response.body().string();
				System.out.println(bodyString);
				System.out.println();
				
//				System.out.println("body AE lamp1:");
//				request = new Request.Builder()
//				  .url("http://localhost:7579/Mobius/lamp1")
//				  .method("GET", null)
//				  .addHeader("Accept", "application/json")
//				  .addHeader("X-M2M-RI", "12345")
//				  .addHeader("X-M2M-Origin", "S")
//				  .build();
//				response = client.newCall(request).execute();
//				bodyString = response.body().string();
//				System.out.println(bodyString);
//				System.out.println();
//				
//				System.out.println("body AE lamp2:");
//				request = new Request.Builder()
//						  .url("http://localhost:7579/Mobius/lamp2")
//						  .method("GET", null)
//						  .addHeader("Accept", "application/json")
//						  .addHeader("X-M2M-RI", "12345")
//						  .addHeader("X-M2M-Origin", "S")
//						  .build();
//						response = client.newCall(request).execute();
//						bodyString = response.body().string();
//						System.out.println(bodyString);
//						System.out.println();
//				
//				System.out.println("body AE temp:");
//				request = new Request.Builder()
//						  .url("http://localhost:7579/Mobius/temp")
//						  .method("GET", null)
//						  .addHeader("Accept", "application/json")
//						  .addHeader("X-M2M-RI", "12345")
//						  .addHeader("X-M2M-Origin", "S")
//						  .build();
//						response = client.newCall(request).execute();
//						bodyString = response.body().string();
//						System.out.println(bodyString);
//						System.out.println();
//
//				System.out.println("body AE luminosity:");
//				request = new Request.Builder()
//						  .url("http://localhost:7579/Mobius/luminosity")
//						  .method("GET", null)
//						  .addHeader("Accept", "application/json")
//						  .addHeader("X-M2M-RI", "12345")
//						  .addHeader("X-M2M-Origin", "S")
//						  .build();
//						response = client.newCall(request).execute();
//						bodyString = response.body().string();
//						System.out.println(bodyString);
//						System.out.println();
//
//						System.out.println("body AE presence:");
//						request = new Request.Builder()
//								  .url("http://localhost:7579/Mobius/presence")
//								  .method("GET", null)
//								  .addHeader("Accept", "application/json")
//								  .addHeader("X-M2M-RI", "12345")
//								  .addHeader("X-M2M-Origin", "S")
//								  .build();
//								response = client.newCall(request).execute();
//								bodyString = response.body().string();
//								System.out.println(bodyString);
//								System.out.println();
//						
//						System.out.println("body AE notiapplication:");
//						request = new Request.Builder()
//								  .url("http://localhost:7579/Mobius/notiapplication")
//								  .method("GET", null)
//								  .addHeader("Accept", "application/json")
//								  .addHeader("X-M2M-RI", "12345")
//								  .addHeader("X-M2M-Origin", "S")
//								  .build();
//								response = client.newCall(request).execute();
//								bodyString = response.body().string();
//								System.out.println(bodyString);
//								System.out.println();
//						
//						System.out.println("tutte le content instance di un certo dispositivo:");
//						request = new Request.Builder()
//						  .url("http://127.0.0.1:7579/Mobius/lamp1/DATA?fu=1&ty=4")
//						  .method("GET", null)
//						  .addHeader("Accept", "application/json")
//						  .addHeader("X-M2M-RI", "fds345435")
//						  .addHeader("X-M2M-Origin", "S20170717074825768bp2l")
//						  .build();
//						response = client.newCall(request).execute();
//						bodyString = response.body().string();
//						System.out.println(bodyString);
//						System.out.println();
//						
//						System.out.println("Application Entity create dopo un certo tempo:");
//						request = new Request.Builder()
//						  .url("http://127.0.0.1:7579/Mobius?fu=1&cra=20170101T072322&crb=20170101T072322&lim=20&ty=2")
//						  .method("GET", null)
//						  .addHeader("Accept", "application/json")
//						  .addHeader("X-M2M-RI", "234gjhjrgdfgfd")
//						  .addHeader("X-M2M-Origin", "S20170717074825768bp2l")
//						  .build();
//						response = client.newCall(request).execute();
//						bodyString = response.body().string();
//						System.out.println(bodyString);
//						System.out.println();
		
//				MediaType mediaType = MediaType.parse("application/json; ty=4");
//				RequestBody body = null;
//				if(lastTempInt <= 19)	{
//					body = RequestBody.create("{\n    \"m2m:cin\": {\n        \"con\": \"1\"\n    }\n}", mediaType);
//					Request updateTempReq = new Request.Builder()
//							  .url("http://127.0.0.1:7579/Mobius/heating/COMMAND")
//							  .method("POST", body)
//							  .addHeader("Accept", "application/json")
//							  .addHeader("X-M2M-RI", "12345")
//							  .addHeader("X-M2M-Origin", "Sheating")
//							  .addHeader("Content-Type", "application/json; ty=4")
//							  .build();
//							Response updateTempRes = client.newCall(updateTempReq).execute();
//							String bodyString = updateTempRes.body().string();
//							System.out.println(bodyString);
//				}else	{
//					if(lastTempInt > 20)	{
//						body = RequestBody.create("{\n    \"m2m:cin\": {\n        \"con\": \"0\"\n    }\n}", mediaType);
//						Request updateTempReq = new Request.Builder()
//								  .url("http://127.0.0.1:7579/Mobius/heating/COMMAND")
//								  .method("POST", body)
//								  .addHeader("Accept", "application/json")
//								  .addHeader("X-M2M-RI", "12345")
//								  .addHeader("X-M2M-Origin", "Sheating")
//								  .addHeader("Content-Type", "application/json; ty=4")
//								  .build();
//								Response updateTempRes = client.newCall(updateTempReq).execute();
//								String bodyString = updateTempRes.body().string();
//								System.out.println(bodyString);
//					}
//				}
				//Headers responseHeaders = response.headers();				
//			    System.out.println("Last measurement: " + response.header("con"));
//				response.header(con);
//				String r = response.toString();
//				System.out.println(r);
	}

}
