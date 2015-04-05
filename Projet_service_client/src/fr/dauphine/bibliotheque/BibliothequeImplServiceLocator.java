/**
 * BibliothequeImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.dauphine.bibliotheque;

public class BibliothequeImplServiceLocator extends org.apache.axis.client.Service implements fr.dauphine.bibliotheque.BibliothequeImplService {

    public BibliothequeImplServiceLocator() {
    }


    public BibliothequeImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BibliothequeImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BibliothequeImpl
    private java.lang.String BibliothequeImpl_address = "http://localhost:8080/projet_service_server/services/BibliothequeImpl";

    public java.lang.String getBibliothequeImplAddress() {
        return BibliothequeImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BibliothequeImplWSDDServiceName = "BibliothequeImpl";

    public java.lang.String getBibliothequeImplWSDDServiceName() {
        return BibliothequeImplWSDDServiceName;
    }

    public void setBibliothequeImplWSDDServiceName(java.lang.String name) {
        BibliothequeImplWSDDServiceName = name;
    }

    public fr.dauphine.bibliotheque.BibliothequeImpl getBibliothequeImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BibliothequeImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBibliothequeImpl(endpoint);
    }

    public fr.dauphine.bibliotheque.BibliothequeImpl getBibliothequeImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.dauphine.bibliotheque.BibliothequeImplSoapBindingStub _stub = new fr.dauphine.bibliotheque.BibliothequeImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getBibliothequeImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBibliothequeImplEndpointAddress(java.lang.String address) {
        BibliothequeImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.dauphine.bibliotheque.BibliothequeImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.dauphine.bibliotheque.BibliothequeImplSoapBindingStub _stub = new fr.dauphine.bibliotheque.BibliothequeImplSoapBindingStub(new java.net.URL(BibliothequeImpl_address), this);
                _stub.setPortName(getBibliothequeImplWSDDServiceName());
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
        if ("BibliothequeImpl".equals(inputPortName)) {
            return getBibliothequeImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bibliotheque.dauphine.fr", "BibliothequeImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bibliotheque.dauphine.fr", "BibliothequeImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BibliothequeImpl".equals(portName)) {
            setBibliothequeImplEndpointAddress(address);
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
