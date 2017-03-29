package com.lexington.mc.model.blockchain.pojos;


import java.math.BigDecimal;
import java.util.ArrayList;

public class BlockPojo extends PojoApi{
BigDecimal blockId;
String previousblockhash;
String nextblockhash;
String bits;
BigDecimal confirmations;
BigDecimal version;
BigDecimal nonce;
String miner;
BigDecimal difficulty;
String chainwork;
BigDecimal size;
String merkleroot;
BigDecimal time;
String hash;
BigDecimal height;
ArrayList<String> tx;

public String getRowKey() {
	return blockId.toString();
}
public String getPreviousblockhash() {
	return previousblockhash;
}
public void setPreviousblockhash(String previousblockhash) {
	this.previousblockhash = previousblockhash;
}
public String getNextblockhash() {
	return nextblockhash;
}
public void setNextblockhash(String nextblockhash) {
	this.nextblockhash = nextblockhash;
}
public String getBits() {
	return bits;
}
public void setBits(String bits) {
	this.bits = bits;
}
public BigDecimal getConfirmations() {
	return confirmations;
}
public void setConfirmations(BigDecimal confirmations) {
	this.confirmations = confirmations;
}
public BigDecimal getVersion() {
	return version;
}
public void setVersion(BigDecimal version) {
	this.version = version;
}
public BigDecimal getNonce() {
	return nonce;
}
public void setNonce(BigDecimal nonce) {
	this.nonce = nonce;
}
public String getMiner() {
	return miner;
}
public void setMiner(String miner) {
	this.miner = miner;
}
public BigDecimal getDifficulty() {
	return difficulty;
}
public void setDifficulty(BigDecimal difficulty) {
	this.difficulty = difficulty;
}
public String getChainwork() {
	return chainwork;
}
public void setChainwork(String chainwork) {
	this.chainwork = chainwork;
}
public BigDecimal getSize() {
	return size;
}
public void setSize(BigDecimal size) {
	this.size = size;
}
public String getMerkleroot() {
	return merkleroot;
}
public void setMerkleroot(String merkleroot) {
	this.merkleroot = merkleroot;
}
public BigDecimal getTime() {
	return time;
}
public void setTime(BigDecimal time) {
	this.time = time;
}
public String getHash() {
	return hash;
}
public void setHash(String hash) {
	this.hash = hash;
}
public BigDecimal getHeight() {
	return height;
}
public void setHeight(BigDecimal height) {
	this.height = height;
}
public ArrayList<String> getTx() {
	return tx;
}
public void setTx(ArrayList<String> tx) {
	this.tx = tx;
}
public BigDecimal getBlockId() {
	return blockId;
}
public void setBlockId(BigDecimal blockId) {
	this.blockId = blockId;
}



}
