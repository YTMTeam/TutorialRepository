package com.lexington.mc.model.blockchain.pojos.streams;


import java.util.ArrayList;

public class StreamKeyItemsPojo {
ArrayList<String> publishers;
String key;
String data;
int confirmations;
int blocktime;
String txid;
public ArrayList<String> getPublishers() {
	return publishers;
}
public void setPublishers(ArrayList<String> publishers) {
	this.publishers = publishers;
}
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public int getConfirmations() {
	return confirmations;
}
public void setConfirmations(int confirmations) {
	this.confirmations = confirmations;
}
public int getBlocktime() {
	return blocktime;
}
public void setBlocktime(int blocktime) {
	this.blocktime = blocktime;
}
public String getTxid() {
	return txid;
}
public void setTxid(String txid) {
	this.txid = txid;
}


}
