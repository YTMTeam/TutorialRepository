package com.lexington.mc.model.blockchain.common;

import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.lexington.mc.model.blockchain.common.RpcParameters.Nodes.Node;
import com.lexington.mc.model.blockchain.exception.HttpSessionException;


public class HttpClient {

	private static final Logger logger = Logger.getLogger(HttpClient.class);

	private DefaultHttpClient httpClient = null;
	private String host = null;
	private int port;
	private String username = null;
	private String password = null;

	public HttpClient() {
		super();

		this.setHost(BlockchainConstants.NodeConstants.RPC_HOST);
		this.setPort(BlockchainConstants.NodeConstants.RPC_PORT);
		this.setUsername(BlockchainConstants.NodeConstants.RPC_USERNAME);
		this.setPassword(BlockchainConstants.NodeConstants.RPC_PASSWORD);

		this.setHttpClient(new DefaultHttpClient());
	}

	public HttpClient(Node node) {
		super();
		this.setHost(node.getRpcHost());
		this.setPort(node.getRpcPort());
		this.setUsername(node.getRpcUsername());
		this.setPassword(node.getRpcPassword());
		this.setHttpClient(new DefaultHttpClient());
	}
	
	public void destroy(){
		httpClient.getConnectionManager().shutdown();
	}

	public JSONObject sendAndReceive(JSONObject message) {
		String method = "sendAndReceive";
		JSONObject jsonResponse = null;
		try {
			//logger.info("request: " + message.toJSONString());
			//logger.debug("HTTP Request: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(message));
			StringEntity request = new StringEntity(message.toJSONString());			
			HttpPost httpPost = new HttpPost("http://" + this.host + ":" + this.port);
			httpPost.setEntity(request);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			
			logger.info("HTTP Response Status : " + httpResponse.getStatusLine());


			JSONParser parser = new JSONParser();
			jsonResponse = (JSONObject) parser.parse(EntityUtils.toString(httpEntity));
			
			httpPost.releaseConnection();
			//logger.debug("response: " + jsonResponse.toJSONString());
			//logger.debug("HTTP Response: \n" + new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonResponse));
			
		} catch (ParseException e) {
			logger.error("ParseException: '" + method + "' "	+ e.getMessage());
			throw new HttpSessionException("ParseException: '" + method + "' - "+e.getMessage(), e);
		} catch (org.json.simple.parser.ParseException e) {
			logger.error("org.json.simple.parser.ParseException: '" + method + "' "	+ e.getMessage());
			throw new HttpSessionException("org.json.simple.parser.ParseException: '" + method + "' - "+e.getMessage(), e);
		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException: '" + method + "' "	+ e.getMessage());
			throw new HttpSessionException("ClientProtocolException: '" + method + "' - "+e.getMessage(), e);
		} catch (IOException e) {
//			sendAndReceive(message);
			logger.error("IOException: '" + method + "' "	+ e.getMessage());
			throw new HttpSessionException("IOException: '" + method + "' - "+e.getMessage(), e);
		} 
		return jsonResponse;
	}

	public void setHttpClient(DefaultHttpClient httpClient) {
		this.httpClient = httpClient;
		CredentialsProvider credentialsProvider = this.httpClient
				.getCredentialsProvider();
		AuthScope authScope = new AuthScope(this.host, this.port);
		credentialsProvider.setCredentials(authScope,
				new UsernamePasswordCredentials(this.username, this.password));
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
