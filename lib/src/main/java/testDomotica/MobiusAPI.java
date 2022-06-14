package testDomotica;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MobiusAPI {
	//variables declaration
	OkHttpClient client = new OkHttpClient().newBuilder()
			  .build();	
	String bodyString;
	
	//fields
	String resourceName;

	public MobiusAPI(String rName)	{
		resourceName = rName;
	}
	
	public String getResourceName() {
	        return resourceName;
	}
	 
	Integer getLatestContentInstance() throws IOException{
//		OkHttpClient client = new OkHttpClient().newBuilder()
//				  .build();
		Request request = new Request.Builder()
				  .url("http://127.0.0.1:7579/Mobius/"+ resourceName +"/DATA/la")
				  .method("GET", null)
				  .addHeader("Accept", "application/json")
				  .addHeader("X-M2M-RI", "12345")
				  .addHeader("X-M2M-Origin", "S")
				  .addHeader("Content-Type", "application/json")
				  .build();
				Response response = client.newCall(request).execute();
				String rBody = response.body().string();
				String[] parameters = rBody.split(",");
				String v = null;
				for(String s:parameters) {
					if(s.contains("con"))	{
						String[] content = s.split(":");
						v = content[1].split("\"")[1].trim();
					}
				}
				return Integer.parseInt(v);
	}
	
	void setInitialStatus(int statusToSet) throws IOException	{
		if(statusToSet == 1)	{
//			OkHttpClient client = new OkHttpClient().newBuilder()
//					  .build();
					MediaType mediaType = MediaType.parse("application/json; ty=4");
					RequestBody body = RequestBody.create("{\n    \"m2m:cin\": {\n        \"con\": \"1\"\n    }\n}", mediaType);
					Request request = new Request.Builder()
					  .url("http://127.0.0.1:7579/Mobius/"+ resourceName +"/COMMAND")
					  .method("POST", body)
					  .addHeader("Accept", "application/json")
					  .addHeader("X-M2M-RI", "12345")
					  .addHeader("X-M2M-Origin", "S"+ resourceName +"")
					  .addHeader("Content-Type", "application/json; ty=4")
					  .build();
					Response response = client.newCall(request).execute();
					bodyString = response.body().string();
					System.out.println(bodyString);
		}	else	{
//			OkHttpClient client = new OkHttpClient().newBuilder()
//					  .build();
					MediaType mediaType = MediaType.parse("application/json; ty=4");
					RequestBody body = RequestBody.create("{\n    \"m2m:cin\": {\n        \"con\": \"0\"\n    }\n}", mediaType);
					Request request = new Request.Builder()
					  .url("http://127.0.0.1:7579/Mobius/"+ resourceName +"/COMMAND")
					  .method("POST", body)
					  .addHeader("Accept", "application/json")
					  .addHeader("X-M2M-RI", "12345")
					  .addHeader("X-M2M-Origin", "S"+ resourceName +"")
					  .addHeader("Content-Type", "application/json; ty=4")
					  .build();
					Response response = client.newCall(request).execute();
					bodyString = response.body().string();
					System.out.println(bodyString);
		}
	}
	
	void groupCreate(String[] resourcesInTheGroup) throws IOException	{
//		OkHttpClient client = new OkHttpClient().newBuilder()
//				  .build();
				MediaType mediaType = MediaType.parse("application/json;ty=9");
				String groupCreationString = "\n{\n\t\"m2m:grp\" : {\n\t\t\"rn\": \""+ resourceName +"\",\n\t"
						+ "    \"mid\": [\n\t";
				for(int t = 0; t < resourcesInTheGroup.length; t++)	{
					if(t == resourcesInTheGroup.length - 1)	{
					groupCreationString += "\"Mobius/"+ resourcesInTheGroup[t] +"/COMMAND\"\n\t\t";
					}	else	{
						groupCreationString += "\"Mobius/"+ resourcesInTheGroup[t] +"/COMMAND\",\n\t\t";
					}
				}
				groupCreationString += "],\n\t    \"mnm\":10\n    }\n}\n";
				RequestBody body = RequestBody.create(groupCreationString, mediaType);
				Request request = new Request.Builder()
				  .url("http://127.0.0.1:7579/Mobius")
				  .method("POST", body)
				  .addHeader("X-M2M-RI", "123gsyuuiuihi45")
				  .addHeader("X-M2M-Origin", "S20170717074825768bp2l")
				  .addHeader("Content-Type", "application/json;ty=9")
				  .addHeader("Accept", "application/json")
				  .build();
				Response response = client.newCall(request).execute();
				String bodyString = response.body().string();
				System.out.println(bodyString);
	}
	
	void groupDelete() throws IOException	{
//		OkHttpClient client = new OkHttpClient().newBuilder()
//				  .build();
				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = RequestBody.create("", mediaType);
				Request request = new Request.Builder()
				  .url("http://127.0.0.1:7579/Mobius/"+ resourceName)
				  .method("DELETE", body)
				  .addHeader("Accept", "application/json")
				  .addHeader("X-M2M-RI", "12345")
				  .addHeader("X-M2M-Origin", "S20170717074825768bp2l")
				  .build();
				Response response = client.newCall(request).execute();
				bodyString = response.body().string();
				System.out.println("Gruppo disassemblato con successo");
				System.out.println(bodyString);
	}
	
	void groupHandling(int state) throws IOException	{
//		OkHttpClient client = new OkHttpClient().newBuilder()
//				  .build();
				MediaType mediaType = MediaType.parse("application/json; ty=4");
				RequestBody body = null;
				if(state == 1)	{
					body = RequestBody.create("{\n    \"m2m:cin\": {\n        \"con\": \"1\"\n    }\n}", mediaType);
					System.out.println("Vi è qualcuno nella stanza, luci accese");
				}	else	{
					body = RequestBody.create("{\n    \"m2m:cin\": {\n        \"con\": \"0\"\n    }\n}", mediaType);
					System.out.println("Nessuno nella stanza, luci spente");
				}
				Request request = new Request.Builder()
				  .url("http://127.0.0.1:7579/Mobius/"+ resourceName +"/fopt")
				  .method("POST", body)
				  .addHeader("Accept", "application/json")
				  .addHeader("X-M2M-RI", "12345")
				  .addHeader("X-M2M-Origin", "S")
				  .addHeader("Content-Type", "application/json; ty=4")
				  .build();
				Response response = client.newCall(request).execute();
				bodyString = response.body().string();
				System.out.println(bodyString);
				
	}
	
	int heatingHandling(int currentTemp, int currentHeatingState) throws IOException	{
//		OkHttpClient client = new OkHttpClient().newBuilder()
//				  .build();
				MediaType mediaType = MediaType.parse("application/json; ty=4");
				RequestBody body = null;
				boolean turnedOn = false;
				int newHeatingStatus;
				if(currentTemp < 19)	{
					body = RequestBody.create("{\n    \"m2m:cin\": {\n        \"con\": \"1\"\n    }\n}", mediaType);
					System.out.println("Temperatura bassa, riscaldamento acceso");
					turnedOn = true;
				}else	{
					if(currentTemp > 22)	{
						body = RequestBody.create("{\n    \"m2m:cin\": {\n        \"con\": \"0\"\n    }\n}", mediaType);
						System.out.println("Temperatura alta, riscaldamento spento");
						turnedOn = false;
					}
				}
				Request request = new Request.Builder()
				  .url("http://127.0.0.1:7579/Mobius/"+ resourceName +"/COMMAND")
				  .method("POST", body)
				  .addHeader("Accept", "application/json")
				  .addHeader("X-M2M-RI", "12345")
				  .addHeader("X-M2M-Origin", "S")
				  .addHeader("Content-Type", "application/json; ty=4")
				  .build();
				Response response = client.newCall(request).execute();
				bodyString = response.body().string();
				System.out.println(bodyString);
				if(turnedOn)	{
					newHeatingStatus = 1;
				}	else	{
					newHeatingStatus = 0;
				}
				return newHeatingStatus;
	}
	
}
