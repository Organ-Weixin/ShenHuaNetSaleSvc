/**
 * PayapiLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cmts.pay.webservice;

public class PayapiLocator extends org.apache.axis.client.Service implements cn.cmts.pay.webservice.Payapi {

    public PayapiLocator() {
    }


    public PayapiLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PayapiLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for payapiHttpSoap11Endpoint
    private java.lang.String payapiHttpSoap11Endpoint_address = "http://membernew.mvtapi.com:8310/cmtspay/services/payapi.payapiHttpSoap11Endpoint/";

    public java.lang.String getpayapiHttpSoap11EndpointAddress() {
        return payapiHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String payapiHttpSoap11EndpointWSDDServiceName = "payapiHttpSoap11Endpoint";

    public java.lang.String getpayapiHttpSoap11EndpointWSDDServiceName() {
        return payapiHttpSoap11EndpointWSDDServiceName;
    }

    public void setpayapiHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        payapiHttpSoap11EndpointWSDDServiceName = name;
    }

    public cn.cmts.pay.webservice.PayapiPortType getpayapiHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(payapiHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getpayapiHttpSoap11Endpoint(endpoint);
    }

    public cn.cmts.pay.webservice.PayapiPortType getpayapiHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.cmts.pay.webservice.PayapiSoap11BindingStub _stub = new cn.cmts.pay.webservice.PayapiSoap11BindingStub(portAddress, this);
            _stub.setPortName(getpayapiHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setpayapiHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        payapiHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.cmts.pay.webservice.PayapiPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.cmts.pay.webservice.PayapiSoap11BindingStub _stub = new cn.cmts.pay.webservice.PayapiSoap11BindingStub(new java.net.URL(payapiHttpSoap11Endpoint_address), this);
                _stub.setPortName(getpayapiHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("payapiHttpSoap11Endpoint".equals(inputPortName)) {
            return getpayapiHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.pay.cmts.cn", "payapi");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.pay.cmts.cn", "payapiHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("payapiHttpSoap11Endpoint".equals(portName)) {
            setpayapiHttpSoap11EndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
