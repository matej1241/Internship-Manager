/**
 * UserInformation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package studentInternshipManager;

public class UserInformation  implements java.io.Serializable {
    private java.lang.String businessMail;

    private java.lang.String businessMobile;

    private java.lang.String name;

    private java.lang.String privateMail;

    private java.lang.String privateMobile;

    private java.lang.String role;

    private java.lang.String surname;

    private java.lang.String userID;

    private java.lang.String password;

    public UserInformation() {
    }

    public UserInformation(
           java.lang.String businessMail,
           java.lang.String businessMobile,
           java.lang.String name,
           java.lang.String privateMail,
           java.lang.String privateMobile,
           java.lang.String role,
           java.lang.String surname,
           java.lang.String userID,
           java.lang.String password) {
           this.businessMail = businessMail;
           this.businessMobile = businessMobile;
           this.name = name;
           this.privateMail = privateMail;
           this.privateMobile = privateMobile;
           this.role = role;
           this.surname = surname;
           this.userID = userID;
           this.password = password;
    }


    /**
     * Gets the businessMail value for this UserInformation.
     * 
     * @return businessMail
     */
    public java.lang.String getBusinessMail() {
        return businessMail;
    }


    /**
     * Sets the businessMail value for this UserInformation.
     * 
     * @param businessMail
     */
    public void setBusinessMail(java.lang.String businessMail) {
        this.businessMail = businessMail;
    }


    /**
     * Gets the businessMobile value for this UserInformation.
     * 
     * @return businessMobile
     */
    public java.lang.String getBusinessMobile() {
        return businessMobile;
    }


    /**
     * Sets the businessMobile value for this UserInformation.
     * 
     * @param businessMobile
     */
    public void setBusinessMobile(java.lang.String businessMobile) {
        this.businessMobile = businessMobile;
    }


    /**
     * Gets the name value for this UserInformation.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this UserInformation.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the privateMail value for this UserInformation.
     * 
     * @return privateMail
     */
    public java.lang.String getPrivateMail() {
        return privateMail;
    }


    /**
     * Sets the privateMail value for this UserInformation.
     * 
     * @param privateMail
     */
    public void setPrivateMail(java.lang.String privateMail) {
        this.privateMail = privateMail;
    }


    /**
     * Gets the privateMobile value for this UserInformation.
     * 
     * @return privateMobile
     */
    public java.lang.String getPrivateMobile() {
        return privateMobile;
    }


    /**
     * Sets the privateMobile value for this UserInformation.
     * 
     * @param privateMobile
     */
    public void setPrivateMobile(java.lang.String privateMobile) {
        this.privateMobile = privateMobile;
    }


    /**
     * Gets the role value for this UserInformation.
     * 
     * @return role
     */
    public java.lang.String getRole() {
        return role;
    }


    /**
     * Sets the role value for this UserInformation.
     * 
     * @param role
     */
    public void setRole(java.lang.String role) {
        this.role = role;
    }


    /**
     * Gets the surname value for this UserInformation.
     * 
     * @return surname
     */
    public java.lang.String getSurname() {
        return surname;
    }


    /**
     * Sets the surname value for this UserInformation.
     * 
     * @param surname
     */
    public void setSurname(java.lang.String surname) {
        this.surname = surname;
    }


    /**
     * Gets the userID value for this UserInformation.
     * 
     * @return userID
     */
    public java.lang.String getUserID() {
        return userID;
    }


    /**
     * Sets the userID value for this UserInformation.
     * 
     * @param userID
     */
    public void setUserID(java.lang.String userID) {
        this.userID = userID;
    }


    /**
     * Gets the password value for this UserInformation.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this UserInformation.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserInformation)) return false;
        UserInformation other = (UserInformation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.businessMail==null && other.getBusinessMail()==null) || 
             (this.businessMail!=null &&
              this.businessMail.equals(other.getBusinessMail()))) &&
            ((this.businessMobile==null && other.getBusinessMobile()==null) || 
             (this.businessMobile!=null &&
              this.businessMobile.equals(other.getBusinessMobile()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.privateMail==null && other.getPrivateMail()==null) || 
             (this.privateMail!=null &&
              this.privateMail.equals(other.getPrivateMail()))) &&
            ((this.privateMobile==null && other.getPrivateMobile()==null) || 
             (this.privateMobile!=null &&
              this.privateMobile.equals(other.getPrivateMobile()))) &&
            ((this.role==null && other.getRole()==null) || 
             (this.role!=null &&
              this.role.equals(other.getRole()))) &&
            ((this.surname==null && other.getSurname()==null) || 
             (this.surname!=null &&
              this.surname.equals(other.getSurname()))) &&
            ((this.userID==null && other.getUserID()==null) || 
             (this.userID!=null &&
              this.userID.equals(other.getUserID()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getBusinessMail() != null) {
            _hashCode += getBusinessMail().hashCode();
        }
        if (getBusinessMobile() != null) {
            _hashCode += getBusinessMobile().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPrivateMail() != null) {
            _hashCode += getPrivateMail().hashCode();
        }
        if (getPrivateMobile() != null) {
            _hashCode += getPrivateMobile().hashCode();
        }
        if (getRole() != null) {
            _hashCode += getRole().hashCode();
        }
        if (getSurname() != null) {
            _hashCode += getSurname().hashCode();
        }
        if (getUserID() != null) {
            _hashCode += getUserID().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserInformation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://studentInternshipManager", "UserInformation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessMail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessMail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("businessMobile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "businessMobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("privateMail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "privateMail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("privateMobile");
        elemField.setXmlName(new javax.xml.namespace.QName("", "privateMobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role");
        elemField.setXmlName(new javax.xml.namespace.QName("", "role"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("surname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "surname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
