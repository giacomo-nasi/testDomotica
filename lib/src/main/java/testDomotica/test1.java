package testDomotica;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import okhttp3.ResponseBody;


public class test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		OkHttpClient client = new OkHttpClient().newBuilder()
//				  .build();
//				Request request = new Request.Builder()
//				  .url("http://127.0.0.1:7579/Mobius/temp/DATA/la")
//				  .method("GET", null)
//				  .addHeader("Accept", "application/json")
//				  .addHeader("X-M2M-RI", "12345")
//				  .addHeader("X-M2M-Origin", "S")
//				  .addHeader("Content-Type", "application/json")
//				  .build();
//				Response response = client.newCall(request).execute();
//				String rBody = response.body().string();
//				String[] parameters = rBody.split(",");
//				String v = null;
//				for(String s:parameters) {
//					if(s.contains("con"))	{
//						String[] content = s.split(":");
//						v = content[1].split("\"")[1];
//					}
//				}
//				System.out.println(rBody);
//				System.out.println(v);
//				System.out.println("La temperatura nella stanza è: " + v);
				
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("application/json;ty=9");
				RequestBody body = RequestBody.create("\n{\n\t\"m2m:grp\" : {\n\t\t\"rn\": \"lights_group\",\n\t    \"mid\": [\n\t    \t\t\"Mobius/lamp1/COMMAND\",\n\t\t        \"Mobius/lamp2/COMMAND\",\n                \"Mobius/lamp3/COMMAND\"\n\t    ],\n\t    \"mnm\":10\n    }\n}\n", mediaType);
				Request request = new Request.Builder()
				  .url("http://127.0.0.1:7579/Mobius")
				  .method("POST", body)
				  .addHeader("X-M2M-RI", "123gsyuuiuihi45")
				  .addHeader("X-M2M-Origin", "S20170717074825768bp2l")
				  .addHeader("Content-Type", "application/json;ty=9")
				  .addHeader("Accept", "application/json")
				  .build();
				Response response = client.newCall(request).execute();
		
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
