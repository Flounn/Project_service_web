/**
 * Compte.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.dauphine.banque;

public class Compte  implements java.io.Serializable {
    private java.lang.String devise;

    private java.lang.String email;

    private java.lang.String mdp;

    private long noCompte;

    private java.lang.String nom;

    private java.lang.String prenom;

    private double solde;

    public Compte() {
    }

    public Compte(
           java.lang.String devise,
           java.lang.String email,
           java.lang.String mdp,
           long noCompte,
           java.lang.String nom,
           java.lang.String prenom,
           double solde) {
           this.devise = devise;
           this.email = email;
           this.mdp = mdp;
           this.noCompte = noCompte;
           this.nom = nom;
           this.prenom = prenom;
           this.solde = solde;
    }


    /**
     * Gets the devise value for this Compte.
     * 
     * @return devise
     */
    public java.lang.String getDevise() {
        return devise;
    }


    /**
     * Sets the devise value for this Compte.
     * 
     * @param devise
     */
    public void setDevise(java.lang.String devise) {
        this.devise = devise;
    }


    /**
     * Gets the email value for this Compte.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Compte.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the mdp value for this Compte.
     * 
     * @return mdp
     */
    public java.lang.String getMdp() {
        return mdp;
    }


    /**
     * Sets the mdp value for this Compte.
     * 
     * @param mdp
     */
    public void setMdp(java.lang.String mdp) {
        this.mdp = mdp;
    }


    /**
     * Gets the noCompte value for this Compte.
     * 
     * @return noCompte
     */
    public long getNoCompte() {
        return noCompte;
    }


    /**
     * Sets the noCompte value for this Compte.
     * 
     * @param noCompte
     */
    public void setNoCompte(long noCompte) {
        this.noCompte = noCompte;
    }


    /**
     * Gets the nom value for this Compte.
     * 
     * @return nom
     */
    public java.lang.String getNom() {
        return nom;
    }


    /**
     * Sets the nom value for this Compte.
     * 
     * @param nom
     */
    public void setNom(java.lang.String nom) {
        this.nom = nom;
    }


    /**
     * Gets the prenom value for this Compte.
     * 
     * @return prenom
     */
    public java.lang.String getPrenom() {
        return prenom;
    }


    /**
     * Sets the prenom value for this Compte.
     * 
     * @param prenom
     */
    public void setPrenom(java.lang.String prenom) {
        this.prenom = prenom;
    }


    /**
     * Gets the solde value for this Compte.
     * 
     * @return solde
     */
    public double getSolde() {
        return solde;
    }


    /**
     * Sets the solde value for this Compte.
     * 
     * @param solde
     */
    public void setSolde(double solde) {
        this.solde = solde;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Compte)) return false;
        Compte other = (Compte) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.devise==null && other.getDevise()==null) || 
             (this.devise!=null &&
              this.devise.equals(other.getDevise()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.mdp==null && other.getMdp()==null) || 
             (this.mdp!=null &&
              this.mdp.equals(other.getMdp()))) &&
            this.noCompte == other.getNoCompte() &&
            ((this.nom==null && other.getNom()==null) || 
             (this.nom!=null &&
              this.nom.equals(other.getNom()))) &&
            ((this.prenom==null && other.getPrenom()==null) || 
             (this.prenom!=null &&
              this.prenom.equals(other.getPrenom()))) &&
            this.solde == other.getSolde();
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
        if (getDevise() != null) {
            _hashCode += getDevise().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getMdp() != null) {
            _hashCode += getMdp().hashCode();
        }
        _hashCode += new Long(getNoCompte()).hashCode();
        if (getNom() != null) {
            _hashCode += getNom().hashCode();
        }
        if (getPrenom() != null) {
            _hashCode += getPrenom().hashCode();
        }
        _hashCode += new Double(getSolde()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Compte.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://banque.dauphine.fr", "Compte"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("devise");
        elemField.setXmlName(new javax.xml.namespace.QName("http://banque.dauphine.fr", "devise"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://banque.dauphine.fr", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mdp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://banque.dauphine.fr", "mdp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noCompte");
        elemField.setXmlName(new javax.xml.namespace.QName("http://banque.dauphine.fr", "noCompte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://banque.dauphine.fr", "nom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prenom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://banque.dauphine.fr", "prenom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("solde");
        elemField.setXmlName(new javax.xml.namespace.QName("http://banque.dauphine.fr", "solde"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
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
