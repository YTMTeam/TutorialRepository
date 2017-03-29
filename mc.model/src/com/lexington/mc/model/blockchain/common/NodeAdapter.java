package com.lexington.mc.model.blockchain.common;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.lexington.mc.model.blockchain.common.RpcParameters.Nodes;
import com.lexington.mc.model.blockchain.common.RpcParameters.Nodes.Node;


public class NodeAdapter {

	public static Map<String, Node> unmarshal(Nodes value) {
		Map<String, Node> map = new HashMap<String, Node>();
		for (Node node : value.getNode())
			map.put(node.getName(), node);
		return map;
	}

	public static Nodes marshal(Map<String, Node> map) {
		Nodes nodes = new Nodes();
		Collection<Node> values = map.values();
		nodes.node = (new ArrayList<Node>(values));
		return nodes;
	}
}
