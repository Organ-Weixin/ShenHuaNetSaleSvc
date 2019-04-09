/**
 * Payapi.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cmts.pay.webservice;

public interface Payapi extends javax.xml.rpc.Service {
    public java.lang.String getpayapiHttpSoap11EndpointAddress();

    public cn.cmts.pay.webservice.PayapiPortType getpayapiHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public cn.cmts.pay.webservice.PayapiPortType getpayapiHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
