package com.lexington.mc.model.blockchain.common;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nodes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Node" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="rpcHost" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="rpcPort" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="rpcUsername" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="rpcPassword" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nodes"
})
@XmlRootElement(name = "RpcParameters")
public class RpcParameters {

    @XmlElement(name = "Nodes", required = true)
    protected RpcParameters.Nodes nodes;
    
    /**
     * Gets the value of the nodes property.
     * 
     * @return
     *     possible object is
     *     {@link RpcParameters.Nodes }
     *     
     */
    public RpcParameters.Nodes getNodes() {
        return nodes;
    }

    /**
     * Sets the value of the nodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link RpcParameters.Nodes }
     *     
     */
    public void setNodes(RpcParameters.Nodes value) {
        this.nodes = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Node" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="rpcHost" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="rpcPort" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="rpcUsername" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="rpcPassword" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "node"
    })
    public static class Nodes {

        @XmlElement(name = "Node", required = true)
        protected List<RpcParameters.Nodes.Node> node;

        /**
         * Gets the value of the node property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the node property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNode().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RpcParameters.Nodes.Node }
         * 
         * 
         */
        public List<RpcParameters.Nodes.Node> getNode() {
            if (node == null) {
                node = new ArrayList<RpcParameters.Nodes.Node>();
            }
            return this.node;
        }

        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="rpcHost" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="rpcPort" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="rpcUsername" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="rpcPassword" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "rpcHost",
            "rpcPort",
            "rpcUsername",
            "rpcPassword"
        })
        public static class Node {

            @XmlElement(required = true)
            protected String rpcHost;
            @XmlElement(required = true)
            protected int rpcPort;
            @XmlElement(required = true)
            protected String rpcUsername;
            @XmlElement(required = true)
            protected String rpcPassword;
            @XmlAttribute(name = "name")
            protected String name;

            /**
             * Gets the value of the rpcHost property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRpcHost() {
                return rpcHost;
            }

            /**
             * Sets the value of the rpcHost property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRpcHost(String value) {
                this.rpcHost = value;
            }

            /**
             * Gets the value of the rpcPort property.
             * 
             */
            public int getRpcPort() {
                return rpcPort;
            }

            /**
             * Sets the value of the rpcPort property.
             * 
             */
            public void setRpcPort(int value) {
                this.rpcPort = value;
            }

            /**
             * Gets the value of the rpcUsername property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRpcUsername() {
                return rpcUsername;
            }

            /**
             * Sets the value of the rpcUsername property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRpcUsername(String value) {
                this.rpcUsername = value;
            }

            /**
             * Gets the value of the rpcPassword property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRpcPassword() {
                return rpcPassword;
            }

            /**
             * Sets the value of the rpcPassword property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRpcPassword(String value) {
                this.rpcPassword = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }
        }
    } 
}
