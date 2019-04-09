/**
 * TicketapiLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.cmts.main.webservice;

public class TicketapiLocator extends org.apache.axis.client.Service implements cn.cmts.main.webservice.Ticketapi {

    public TicketapiLocator() {
    }


    public TicketapiLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TicketapiLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ticketapiHttpSoap11Endpoint
    private java.lang.String ticketapiHttpSoap11Endpoint_address = "http://ticketwj.mvtapi.com:8760/ticketapi/services/ticketapi.ticketapiHttpSoap11Endpoint/";

    public java.lang.String getticketapiHttpSoap11EndpointAddress() {
        return ticketapiHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ticketapiHttpSoap11EndpointWSDDServiceName = "ticketapiHttpSoap11Endpoint";

    public java.lang.String getticketapiHttpSoap11EndpointWSDDServiceName() {
        return ticketapiHttpSoap11EndpointWSDDServiceName;
    }

    public void setticketapiHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        ticketapiHttpSoap11EndpointWSDDServiceName = name;
    }

    public cn.cmts.main.webservice.TicketapiPortType getticketapiHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ticketapiHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getticketapiHttpSoap11Endpoint(endpoint);
    }

    public cn.cmts.main.webservice.TicketapiPortType getticketapiHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.cmts.main.webservice.TicketapiSoap11BindingStub _stub = new cn.cmts.main.webservice.TicketapiSoap11BindingStub(portAddress, this);
            _stub.setPortName(getticketapiHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setticketapiHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        ticketapiHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.cmts.main.webservice.TicketapiPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.cmts.main.webservice.TicketapiSoap11BindingStub _stub = new cn.cmts.main.webservice.TicketapiSoap11BindingStub(new java.net.URL(ticketapiHttpSoap11Endpoint_address), this);
                _stub.setPortName(getticketapiHttpSoap11EndpointWSDDServiceName());
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
        if ("ticketapiHttpSoap11Endpoint".equals(inputPortName)) {
            return getticketapiHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.main.cmts.cn", "ticketapi");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.main.cmts.cn", "ticketapiHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ticketapiHttpSoap11Endpoint".equals(portName)) {
            setticketapiHttpSoap11EndpointEndpointAddress(address);
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
