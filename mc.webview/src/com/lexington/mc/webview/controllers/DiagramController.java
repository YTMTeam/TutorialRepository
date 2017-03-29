package com.lexington.mc.webview.controllers;


import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

import com.lexington.mc.webview.util.TimeUtil;
import com.mallocinc.shared.util.time.TimestampUtility;

@ViewScoped
@ManagedBean(name="diagramControl")
public class DiagramController {

	private DefaultDiagramModel model;
	final static Logger       log              = Logger.getLogger(DiagramController.class.getName());

	private Element activeNode=null;

	@PostConstruct
	public void init() {
		model = new DefaultDiagramModel();
		model.setMaxConnections(-1);

		StraightConnector connector = new StraightConnector();
		connector.setPaintStyle("{strokeStyle:'#C9C9C9',lineWidth:2}");
		model.setDefaultConnector(connector);


//		Element elementA = new Element(new NetworkElement("Bank-1", "Untitled-1", "green", "TD Bank",TimestampUtility.getCurrentTimestamp().getTime(),"1", "192.168.1.235:35075", "192.168.1.235:7433",
//				"1472379265", "1472379265", "9049", "1746", 1472379264, "0.12040400", "70002", "/MultiChain:0.1.0.5/", "1AGcxPSJZ8KjUNb6wn1b4yj9itmCUrJ82N9NdG", "1A6gWw8vJX3yUoWjW5ihCWp7nR8NYpKLHDoCMz"), "213px", "0px");
		Element elementA = new Element(new NetworkElement("Bank-1", //name
				"Untitled-1", //image
				"green", //background color
				"TD Bank", //bankname
				TimestampUtility.getCurrentTimestamp().getTime(), //inittime
				"1", //id
				"192.168.1.235:35075", //hostport
				"192.168.1.235:7433", //ipport
				 "9049", // bytesent
				 "1746", //bytereceived
				 1472379264, //connection time
				 "0.12040400", //ping time
				 30, //block count
				 60, //block cut in (s)
				 54666, //mem pool size (kb)
				 76, //last tx number
				 45, //cpu usage (%)
				 59, // ram usage (%)
				 "12" // disk space 
				 ), "213px", "0px");
		elementA.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS_LEFT));
		elementA.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS_RIGHT));

//		Element elementB = new Element(new NetworkElement("Bank-2", "", "darkBlue","Bank-1", TimestampUtility.getCurrentTimestamp().getTime()-50000,"7", "192.168.1.112:35075", "192.168.1.112:7433", "1349848943", "1349848943",
//				"8049", "1846", 1472376548, "0.12040400", "70002", "/MultiChain:0.1.0.5/", "8SwnmzasZ8KjUNb6wn1b4yj9itmCUrJ82N9NdG", "8SwnmzasZ8KjUNb6wn1b4yj9itmCUrJ82N9NdG"), "100px", "66px");
		Element elementB = new Element(new NetworkElement("Bank-2", //name
				"", //image
				"darkBlue", //background color
				"Bank 1", //bankname
				TimestampUtility.getCurrentTimestamp().getTime()-50000, //inittime
				"7", //id
				"192.168.1.112:35075", //hostport
				"192.168.1.235:7433", //ipport
				 "8049", // bytesent
				 "1846", //bytereceived
				 1472376548, //connection time
				 "0.12040400", //ping time
				 30, //block count
				 60, //block cut in (s)
				 88745, //mem pool size (kb)
				 65, //last tx number
				 63, //cpu usage (%)
				 89, // ram usage (%)
				 "44" // disk space
				 ), "100px", "66px");
		
		elementB.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS_TOP));
		elementB.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS_LEFT));

//		Element elementC = new Element(new NetworkElement("Bank-3", "Untitled-2","lightRed","Scotia Bank",TimestampUtility.getCurrentTimestamp().getTime()-150000,"2", "192.168.1.99:35075", "192.168.1.99:7433", "1843651891", "1843651891", "7039", "7039", 1472376548, "0.12040400", "70002", "/MultiChain:0.1.0.5/", "ksjU912lmsdoIdsa98Masd123Nsja976JsdazA", "ksjU912lmsdoIdsa98Masd123Nsja976JsdazA"), "340px", "66px");
		Element elementC = new Element(new NetworkElement("Bank-3", //name
				"Untitled-2", //image
				"lightRed", //background color
				"Scotia Bank", //bankname
				TimestampUtility.getCurrentTimestamp().getTime()-150000, //inittime
				"2", //id
				"192.168.1.99:35075", //hostport
				"192.168.1.99:7433", //ipport
				 "7039", // bytesent
				 "7039", //bytereceived
				 1472376548, //connection time
				 "0.12040400", //ping time
				 30, //block count
				 60, //block cut in (s)
				 25641, //mem pool size (kb)
				 13, //last tx number
				 63, //cpu usage (%)
				 65, // ram usage (%)
				 "78" // disk space
				 ), "340px", "66px");
		elementC.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS_TOP));
		elementC.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS_RIGHT));

//		Element elementD = new Element(new NetworkElement("Bank-4", "Untitled-3", "lightBlue", "Royal Bank of Canada",TimestampUtility.getCurrentTimestamp().getTime()-250000,"3", "192.168.1.35:35075", "192.168.1.35:7433",
//				"489031492", "489031492", "16058", "16058", 1272376548, "0.12040400", "70002", "/MultiChain:0.1.0.5/", "Op123rstUVZC812312msadasdDsands89adsas", "Op123rstUVZC812312msadasdDsands89adsas"), "424px", "177px");
		Element elementD = new Element(new NetworkElement("Bank-4", //name
				"Untitled-3", //image
				"lightBlue", //background color
				"Royal Bank of Canada", //bankname
				TimestampUtility.getCurrentTimestamp().getTime()-250000, //inittime
				"3", //id
				"192.168.1.35:35075", //hostport
				"192.168.1.35:7433", //ipport
				 "16058", // bytesent
				 "16058", //bytereceived
				 1472376548, //connection time
				 "0.12040400", //ping time
				 30, //block count
				 60, //block cut in (s)
				 52355, //mem pool size (kb)
				 47, //last tx number
				 57, //cpu usage (%)
				 46, // ram usage (%)
				 "52" // disk space
				 ), "424px", "177px");
		elementD.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS_TOP));
		elementD.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS_BOTTOM));

//		Element elementE = new Element(new NetworkElement("Bank-6", "","lightRed", "Bank-3",TimestampUtility.getCurrentTimestamp().getTime()-950000,"5", "192.168.1.59:35075", "192.168.1.59:7433", "123456468", "123456468",
//		"12356", "12356", 1272376548, "0.12040400", "70002", "/MultiChain:0.1.0.5/", "0Nc4SiBVZC812312msa5GdasdDs7jsXsx85PlF", "0Nc4SiBVZC812312msa5GdasdDs7jsXsx85PlF"), "128px", "310px");
Element elementE = new Element(new NetworkElement("Bank-6", //name
		"", //image
		"darkBlue", //background color
		"Bank 3", //bankname
		TimestampUtility.getCurrentTimestamp().getTime()-950000, //inittime
		"5", //id
		"192.168.1.59:35075", //hostport
		"192.168.1.59:7433", //ipport
		 "12356", // bytesent
		 "12356", //bytereceived
		 1272376548, //connection time
		 "0.12040400", //ping time
		 30, //block count
		 60, //block cut in (s)
		 46790, //mem pool size (kb)
		 64, //last tx number
		 45, //cpu usage (%)
		 79, // ram usage (%)
		 "13" // disk space
		 ), "128px", "310px");
elementE.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS));
elementE.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS));

//		Element elementF = new Element(new NetworkElement("Bank-5", "","darkRed", "Bank-4",TimestampUtility.getCurrentTimestamp().getTime()-750000,"4", "192.168.1.56:35075", "192.168.1.56:7433", "324156468",
//				"324156468", "16058", "16058", 1272376548, "0.12040400", "70002", "/MultiChain:0.1.0.5/", "L98MsiBVZC812312msadasdDsands89adsasOl", "L98MsiBVZC812312msadasdDsands89adsasOl"), "320px", "310px");
		Element elementF = new Element(new NetworkElement("Bank-5", //name
				"Untitled-4", //image
				"gray", //background color
				"IIROC", //bankname
				TimestampUtility.getCurrentTimestamp().getTime()-750000, //inittime
				"4", //id
				"192.168.1.56:35075", //hostport
				"192.168.1.56:7433", //ipport
				 "16058", // bytesent
				 "16058", //bytereceived
				 1272376548, //connection time
				 "0.12040400", //ping time
				 30, //block count
				 60, //block cut in (s)
				 66321, //mem pool size (kb)
				 34, //last tx number
				 56, //cpu usage (%)
				 21, // ram usage (%)
				 "150" // disk space
				 ), "320px", "310px");
		elementF.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS));
		elementF.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS));

//		Element elementG = new Element(new NetworkElement("Bank-7", "","lightBlue", "Bank-2",TimestampUtility.getCurrentTimestamp().getTime()-1250000,"6", "192.168.1.23:35075", "192.168.1.23:7433", "564736531", "564736531",
//				"23546", "23546", 1372376548, "0.13040400", "70002", "/MultiChain:0.1.0.5/", "UjzM1BVZC8123Y12msa5GdasdDs7jsXsxyG8s3", "UjzM1BVZC8123Y12msa5GdasdDs7jsXsxyG8s3"), "8px", "177px");
		Element elementG = new Element(new NetworkElement("Bank-7", //name
				"", //image
				"darkBlue", //background color
				"Bank 2", //bankname
				TimestampUtility.getCurrentTimestamp().getTime()-1250000, //inittime
				"6", //id
				"192.168.1.23:35075", //hostport
				"192.168.1.23:7433", //ipport
				 "23546", // bytesent
				 "23546", //bytereceived
				 1372376548, //connection time
				 "0.13040400", //ping time
				 30, //block count
				 60, //block cut in (s)
				 32141, //mem pool size (kb)
				 54, //last tx number
				 66, //cpu usage (%)
				 76, // ram usage (%)
				 "8" // disk space
				 ), "8px", "177px");
		elementG.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS));
		elementG.addEndPoint(new BlankEndPoint(EndPointAnchor.CONTINUOUS));

		model.addElement(elementA);
		model.addElement(elementB);
		model.addElement(elementC);
		model.addElement(elementD);
		model.addElement(elementF);
		model.addElement(elementE);
		model.addElement(elementG);

		model.connect(new Connection(elementA.getEndPoints().get(0), elementB.getEndPoints().get(0)));        
		model.connect(new Connection(elementA.getEndPoints().get(1), elementC.getEndPoints().get(0)));
		//        model.connect(new Connection(elementA.getEndPoints().get(2), elementD.getEndPoints().get(0)));        
		//        model.connect(new Connection(elementA.getEndPoints().get(3), elementE.getEndPoints().get(0)));
		//        model.connect(new Connection(elementA.getEndPoints().get(4), elementF.getEndPoints().get(0)));        
		//        model.connect(new Connection(elementA.getEndPoints().get(5), elementG.getEndPoints().get(0)));
		model.connect(new Connection(elementC.getEndPoints().get(1), elementD.getEndPoints().get(0)));
		model.connect(new Connection(elementD.getEndPoints().get(1), elementF.getEndPoints().get(0)));
		model.connect(new Connection(elementF.getEndPoints().get(1), elementE.getEndPoints().get(0)));
		model.connect(new Connection(elementE.getEndPoints().get(1), elementG.getEndPoints().get(0)));
		model.connect(new Connection(elementG.getEndPoints().get(1), elementB.getEndPoints().get(1)));

	}


	public void onElementClicked() {
		String elementId=  FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("elementId");
		for(Element e: model.getElements())
			if(((NetworkElement)e.getData()).getName().equals(elementId))
				activeNode=e;


	} 

	public boolean isSelected(){
		return activeNode!=null;

	}



	public DiagramModel getModel() {
		return model;
	}



	public Element getActiveNode() {
		return activeNode;
	}


	public void setActiveNode(Element activeNode) {
		this.activeNode = activeNode;
	}



	public class NetworkElement implements Serializable {

		private String name;

		private String image;
		private String backgroundColor;
		private String id;
		private String bankName;
		private String hostport;
		private String ipport;
		private String lastSend;
		private String lastReceived;
		private String byteSent; 
		private String byteReceived; 
		private String pingTime; 
		private String version; 
		private String subVersion; 
		private String handshake; 
		private String handshakeLocal; 
		private long connectionTime; 
		private String local;
		private long initTime;
		
		private long blockCount;
		private long blockCutIn;
		private long memPoolSize;
		private long lastTxNumber;
		private long cpuUsage;
		private long ramUsage;
		private String diskSpace;

		public NetworkElement() {
		}

		public NetworkElement(String name, String image, String backgroundColor, String bankName, long initTime,
				String id, String hostport,String ipport,String lastSend,String lastReceived,
				String byteSent,String byteReceived, long connectionTime, String pingTime,
				String version, String subVersion, String handshakeLocal, String handshake) {
			this.name = name;
			this.image = image;
			this.backgroundColor = backgroundColor;
			this.bankName=bankName;
			this.initTime=initTime;
			this.id=id;
			this.hostport=hostport;
			this.ipport=ipport;
			this.lastSend=lastSend;
			this.lastReceived=lastReceived;
			this.byteSent=byteSent;
			this.byteReceived=byteReceived;
			this.connectionTime=connectionTime;
			this.pingTime=pingTime;
			this.version=version;
			this.subVersion=subVersion;
			this.handshakeLocal=handshakeLocal;
			this.handshake=handshake;
		}
		
/**
 * This is new constructor with Bojan's additional info: CPU etc
 */
		public NetworkElement(String name, String image, String backgroundColor, String bankName, long initTime, 
				 String id,	String hostport, String ipport, String byteSent, String byteReceived, long connectionTime,
				 String pingTime,
				 long blockCount, long blockCutIn, long memPoolSize,
				long lastTxNumber, long cpuUsage, long ramUsage, String diskSpace) {
			super();
			this.name = name;
			this.image = image;
			this.backgroundColor = backgroundColor;
			this.id = id;
			this.bankName = bankName;
			this.hostport = hostport;
			this.ipport = ipport;
			this.byteSent = byteSent;
			this.byteReceived = byteReceived;
			this.pingTime = pingTime;
			this.connectionTime = connectionTime;
			this.initTime = initTime;
			this.blockCount = blockCount;
			this.blockCutIn = blockCutIn;
			this.memPoolSize = memPoolSize;
			this.lastTxNumber = lastTxNumber;
			this.cpuUsage = cpuUsage;
			this.ramUsage = ramUsage;
			this.diskSpace = diskSpace;
		}

		public String getUpTime(){

			return new TimeUtil().getTimeHMS(TimestampUtility.getCurrentTimestamp().getTime()-initTime);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}


		public String getBackgroundColor() {
			return backgroundColor;
		}

		public void setBackgroundColor(String backgroundColor) {
			this.backgroundColor = backgroundColor;
		}

		@Override
		public String toString() {
			return name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getHostport() {
			return hostport;
		}

		public void setHostport(String hostport) {
			this.hostport = hostport;
		}

		public String getIpport() {
			return ipport;
		}

		public void setIpport(String ipport) {
			this.ipport = ipport;
		}

		public String getLastSend() {
			return lastSend;
		}

		public void setLastSend(String lastSend) {
			this.lastSend = lastSend;
		}

		public String getLastReceived() {
			return lastReceived;
		}

		public void setLastReceived(String lastReceived) {
			this.lastReceived = lastReceived;
		}

		public String getHandshake() {
			return handshake;
		}

		public void setHandshake(String handshake) {
			this.handshake = handshake;
		}

		public String getLocal() {
			return local;
		}

		public void setLocal(String local) {
			this.local = local;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public String getByteSent() {
			return byteSent;
		}

		public void setByteSent(String byteSent) {
			this.byteSent = byteSent;
		}

		public String getByteReceived() {
			return byteReceived;
		}

		public void setByteReceived(String byteReceived) {
			this.byteReceived = byteReceived;
		}

		public String getPingTime() {
			return pingTime;
		}

		public void setPingTime(String pingTime) {
			this.pingTime = pingTime;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public String getSubVersion() {
			return subVersion;
		}

		public void setSubVersion(String subVersion) {
			this.subVersion = subVersion;
		}

		public String getHandshakeLocal() {
			return handshakeLocal;
		}

		public void setHandshakeLocal(String handshakeLocal) {
			this.handshakeLocal = handshakeLocal;
		}

		public String getConnectionTime() {
			return new TimeUtil().getTimeHMS(connectionTime);
		}

		public void setConnectionTime(long connectionTime) {
			this.connectionTime = connectionTime;
		}

		public long getBlockCount() {
			return blockCount;
		}

		public void setBlockCount(long blockCount) {
			this.blockCount = blockCount;
		}

		public long getBlockCutIn() {
			return blockCutIn;
		}

		public void setBlockCutIn(long blockCutIn) {
			this.blockCutIn = blockCutIn;
		}

		public long getMemPoolSize() {
			return memPoolSize;
		}

		public void setMemPoolSize(long memPoolSize) {
			this.memPoolSize = memPoolSize;
		}

		public long getLastTxNumber() {
			return lastTxNumber;
		}

		public void setLastTxNumber(long lastTxNumber) {
			this.lastTxNumber = lastTxNumber;
		}

		public long getCpuUsage() {
			return cpuUsage;
		}

		public void setCpuUsage(long cpuUsage) {
			this.cpuUsage = cpuUsage;
		}

		public long getRamUsage() {
			return ramUsage;
		}

		public void setRamUsage(long ramUsage) {
			this.ramUsage = ramUsage;
		}

		public String getDiskSpace() {
			return diskSpace;
		}

		public void setDiskSpace(String diskSpace) {
			this.diskSpace = diskSpace;
		}


	}
}
