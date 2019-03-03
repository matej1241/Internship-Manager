/**
 * UsersImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package studentInternshipManager;

public class UsersImplServiceLocator extends org.apache.axis.client.Service implements studentInternshipManager.UsersImplService {

    public UsersImplServiceLocator() {
    }


    public UsersImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UsersImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UsersImpl
    private java.lang.String UsersImpl_address = "http://localhost:8080/SIM_WebP/services/UsersImpl";

    public java.lang.String getUsersImplAddress() {
        return UsersImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UsersImplWSDDServiceName = "UsersImpl";

    public java.lang.String getUsersImplWSDDServiceName() {
        return UsersImplWSDDServiceName;
    }

    public void setUsersImplWSDDServiceName(java.lang.String name) {
        UsersImplWSDDServiceName = name;
    }

    public studentInternshipManager.UsersImpl getUsersImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UsersImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUsersImpl(endpoint);
    }

    public studentInternshipManager.UsersImpl getUsersImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            studentInternshipManager.UsersImplSoapBindingStub _stub = new studentInternshipManager.UsersImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getUsersImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUsersImplEndpointAddress(java.lang.String address) {
        UsersImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (studentInternshipManager.UsersImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                studentInternshipManager.UsersImplSoapBindingStub _stub = new studentInternshipManager.UsersImplSoapBindingStub(new java.net.URL(UsersImpl_address), this);
                _stub.setPortName(getUsersImplWSDDServiceName());
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
        if ("UsersImpl".equals(inputPortName)) {
            return getUsersImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://studentInternshipManager", "UsersImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://studentInternshipManager", "UsersImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UsersImpl".equals(portName)) {
            setUsersImplEndpointAddress(address);
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
