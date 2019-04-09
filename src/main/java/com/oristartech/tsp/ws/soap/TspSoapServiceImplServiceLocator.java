/**
 * TspSoapServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.oristartech.tsp.ws.soap;

public class TspSoapServiceImplServiceLocator extends org.apache.axis.client.Service implements com.oristartech.tsp.ws.soap.TspSoapServiceImplService {

    public TspSoapServiceImplServiceLocator() {
    }


    public TspSoapServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TspSoapServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TspSoapServiceImplPort
    private java.lang.String TspSoapServiceImplPort_address = "http://tsp.tsporistartech.cn:8080/tsp-ws/services/tsp/cinema";

    public java.lang.String getTspSoapServiceImplPortAddress() {
        return TspSoapServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TspSoapServiceImplPortWSDDServiceName = "TspSoapServiceImplPort";

    public java.lang.String getTspSoapServiceImplPortWSDDServiceName() {
        return TspSoapServiceImplPortWSDDServiceName;
    }

    public void setTspSoapServiceImplPortWSDDServiceName(java.lang.String name) {
        TspSoapServiceImplPortWSDDServiceName = name;
    }

    public com.oristartech.tsp.ws.soap.TspSoapService getTspSoapServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TspSoapServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTspSoapServiceImplPort(endpoint);
    }

    public com.oristartech.tsp.ws.soap.TspSoapService getTspSoapServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.oristartech.tsp.ws.soap.TspSoapServiceImplServiceSoapBindingStub _stub = new com.oristartech.tsp.ws.soap.TspSoapServiceImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getTspSoapServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTspSoapServiceImplPortEndpointAddress(java.lang.String address) {
        TspSoapServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.oristartech.tsp.ws.soap.TspSoapService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.oristartech.tsp.ws.soap.TspSoapServiceImplServiceSoapBindingStub _stub = new com.oristartech.tsp.ws.soap.TspSoapServiceImplServiceSoapBindingStub(new java.net.URL(TspSoapServiceImplPort_address), this);
                _stub.setPortName(getTspSoapServiceImplPortWSDDServiceName());
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
        if ("TspSoapServiceImplPort".equals(inputPortName)) {
            return getTspSoapServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.ws.tsp.oristartech.com/", "TspSoapServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.ws.tsp.oristartech.com/", "TspSoapServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TspSoapServiceImplPort".equals(portName)) {
            setTspSoapServiceImplPortEndpointAddress(address);
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
