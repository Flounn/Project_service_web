/**
 * LivreService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.dauphine.beans;

public class LivreService  implements java.io.Serializable {
    private java.lang.String auteur;

    private java.lang.String[] commentaires;

    private long compteurPrets;

    private java.util.Calendar dateAjout;

    private boolean disponible;

    private java.lang.String isbn;

    private double moyenneNotes;

    private int[] notes;

    private long numero;

    private double prixEuros;

    private java.lang.String titre;

    public LivreService() {
    }

    public LivreService(
           java.lang.String auteur,
           java.lang.String[] commentaires,
           long compteurPrets,
           java.util.Calendar dateAjout,
           boolean disponible,
           java.lang.String isbn,
           double moyenneNotes,
           int[] notes,
           long numero,
           double prixEuros,
           java.lang.String titre) {
           this.auteur = auteur;
           this.commentaires = commentaires;
           this.compteurPrets = compteurPrets;
           this.dateAjout = dateAjout;
           this.disponible = disponible;
           this.isbn = isbn;
           this.moyenneNotes = moyenneNotes;
           this.notes = notes;
           this.numero = numero;
           this.prixEuros = prixEuros;
           this.titre = titre;
    }


    /**
     * Gets the auteur value for this LivreService.
     * 
     * @return auteur
     */
    public java.lang.String getAuteur() {
        return auteur;
    }


    /**
     * Sets the auteur value for this LivreService.
     * 
     * @param auteur
     */
    public void setAuteur(java.lang.String auteur) {
        this.auteur = auteur;
    }


    /**
     * Gets the commentaires value for this LivreService.
     * 
     * @return commentaires
     */
    public java.lang.String[] getCommentaires() {
        return commentaires;
    }


    /**
     * Sets the commentaires value for this LivreService.
     * 
     * @param commentaires
     */
    public void setCommentaires(java.lang.String[] commentaires) {
        this.commentaires = commentaires;
    }


    /**
     * Gets the compteurPrets value for this LivreService.
     * 
     * @return compteurPrets
     */
    public long getCompteurPrets() {
        return compteurPrets;
    }


    /**
     * Sets the compteurPrets value for this LivreService.
     * 
     * @param compteurPrets
     */
    public void setCompteurPrets(long compteurPrets) {
        this.compteurPrets = compteurPrets;
    }


    /**
     * Gets the dateAjout value for this LivreService.
     * 
     * @return dateAjout
     */
    public java.util.Calendar getDateAjout() {
        return dateAjout;
    }


    /**
     * Sets the dateAjout value for this LivreService.
     * 
     * @param dateAjout
     */
    public void setDateAjout(java.util.Calendar dateAjout) {
        this.dateAjout = dateAjout;
    }


    /**
     * Gets the disponible value for this LivreService.
     * 
     * @return disponible
     */
    public boolean isDisponible() {
        return disponible;
    }


    /**
     * Sets the disponible value for this LivreService.
     * 
     * @param disponible
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


    /**
     * Gets the isbn value for this LivreService.
     * 
     * @return isbn
     */
    public java.lang.String getIsbn() {
        return isbn;
    }


    /**
     * Sets the isbn value for this LivreService.
     * 
     * @param isbn
     */
    public void setIsbn(java.lang.String isbn) {
        this.isbn = isbn;
    }


    /**
     * Gets the moyenneNotes value for this LivreService.
     * 
     * @return moyenneNotes
     */
    public double getMoyenneNotes() {
        return moyenneNotes;
    }


    /**
     * Sets the moyenneNotes value for this LivreService.
     * 
     * @param moyenneNotes
     */
    public void setMoyenneNotes(double moyenneNotes) {
        this.moyenneNotes = moyenneNotes;
    }


    /**
     * Gets the notes value for this LivreService.
     * 
     * @return notes
     */
    public int[] getNotes() {
        return notes;
    }


    /**
     * Sets the notes value for this LivreService.
     * 
     * @param notes
     */
    public void setNotes(int[] notes) {
        this.notes = notes;
    }


    /**
     * Gets the numero value for this LivreService.
     * 
     * @return numero
     */
    public long getNumero() {
        return numero;
    }


    /**
     * Sets the numero value for this LivreService.
     * 
     * @param numero
     */
    public void setNumero(long numero) {
        this.numero = numero;
    }


    /**
     * Gets the prixEuros value for this LivreService.
     * 
     * @return prixEuros
     */
    public double getPrixEuros() {
        return prixEuros;
    }


    /**
     * Sets the prixEuros value for this LivreService.
     * 
     * @param prixEuros
     */
    public void setPrixEuros(double prixEuros) {
        this.prixEuros = prixEuros;
    }


    /**
     * Gets the titre value for this LivreService.
     * 
     * @return titre
     */
    public java.lang.String getTitre() {
        return titre;
    }


    /**
     * Sets the titre value for this LivreService.
     * 
     * @param titre
     */
    public void setTitre(java.lang.String titre) {
        this.titre = titre;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LivreService)) return false;
        LivreService other = (LivreService) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.auteur==null && other.getAuteur()==null) || 
             (this.auteur!=null &&
              this.auteur.equals(other.getAuteur()))) &&
            ((this.commentaires==null && other.getCommentaires()==null) || 
             (this.commentaires!=null &&
              java.util.Arrays.equals(this.commentaires, other.getCommentaires()))) &&
            this.compteurPrets == other.getCompteurPrets() &&
            ((this.dateAjout==null && other.getDateAjout()==null) || 
             (this.dateAjout!=null &&
              this.dateAjout.equals(other.getDateAjout()))) &&
            this.disponible == other.isDisponible() &&
            ((this.isbn==null && other.getIsbn()==null) || 
             (this.isbn!=null &&
              this.isbn.equals(other.getIsbn()))) &&
            this.moyenneNotes == other.getMoyenneNotes() &&
            ((this.notes==null && other.getNotes()==null) || 
             (this.notes!=null &&
              java.util.Arrays.equals(this.notes, other.getNotes()))) &&
            this.numero == other.getNumero() &&
            this.prixEuros == other.getPrixEuros() &&
            ((this.titre==null && other.getTitre()==null) || 
             (this.titre!=null &&
              this.titre.equals(other.getTitre())));
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
        if (getAuteur() != null) {
            _hashCode += getAuteur().hashCode();
        }
        if (getCommentaires() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCommentaires());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCommentaires(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getCompteurPrets()).hashCode();
        if (getDateAjout() != null) {
            _hashCode += getDateAjout().hashCode();
        }
        _hashCode += (isDisponible() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIsbn() != null) {
            _hashCode += getIsbn().hashCode();
        }
        _hashCode += new Double(getMoyenneNotes()).hashCode();
        if (getNotes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNotes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNotes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Long(getNumero()).hashCode();
        _hashCode += new Double(getPrixEuros()).hashCode();
        if (getTitre() != null) {
            _hashCode += getTitre().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LivreService.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://beans.dauphine.fr", "LivreService"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auteur");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "auteur"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentaires");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "commentaires"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compteurPrets");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "compteurPrets"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateAjout");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "dateAjout"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("disponible");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "disponible"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isbn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "isbn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moyenneNotes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "moyenneNotes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "notes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "numero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prixEuros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "prixEuros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans.dauphine.fr", "titre"));
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
