//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.16 at 08:20:34 AM ICT 
//


package com.healthcaresolutions.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="sdlocall" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="src">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="desc">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="sdlocid">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="rolecode">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="30"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="sdlocname">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="tel1">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="tel2">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="effstartdate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="effenddate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="statuscode">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="place_id">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="30"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="placename">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="200"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *       &lt;anyAttribute processContents='lax' namespace='http://www.w3.org/XML/1998/namespace'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sdlocall"
})
@XmlRootElement(name = "VFPDataSet")
public class VFPDataSet {

    protected List<VFPDataSet.Sdlocall> sdlocall;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the sdlocall property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sdlocall property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSdlocall().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VFPDataSet.Sdlocall }
     * 
     * 
     */
    public List<VFPDataSet.Sdlocall> getSdlocall() {
        if (sdlocall == null) {
            sdlocall = new ArrayList<VFPDataSet.Sdlocall>();
        }
        return this.sdlocall;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
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
     *         &lt;element name="src">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="desc">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="sdlocid">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="rolecode">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="30"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="sdlocname">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="tel1">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="tel2">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="effstartdate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="effenddate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="statuscode">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="place_id">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="30"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="placename">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="200"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
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
        "src",
        "desc",
        "sdlocid",
        "rolecode",
        "sdlocname",
        "tel1",
        "tel2",
        "effstartdate",
        "effenddate",
        "statuscode",
        "placeId",
        "placename"
    })
    public static class Sdlocall {

        @XmlElement(required = true)
        protected String src;
        @XmlElement(required = true)
        protected String desc;
        @XmlElement(required = true)
        protected String sdlocid;
        @XmlElement(required = true)
        protected String rolecode;
        @XmlElement(required = true)
        protected String sdlocname;
        @XmlElement(required = true)
        protected String tel1;
        @XmlElement(required = true)
        protected String tel2;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar effstartdate;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar effenddate;
        @XmlElement(required = true)
        protected String statuscode;
        @XmlElement(name = "place_id", required = true)
        protected String placeId;
        @XmlElement(required = true)
        protected String placename;

        /**
         * Gets the value of the src property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSrc() {
            return src;
        }

        /**
         * Sets the value of the src property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSrc(String value) {
            this.src = value;
        }

        /**
         * Gets the value of the desc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDesc() {
            return desc;
        }

        /**
         * Sets the value of the desc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDesc(String value) {
            this.desc = value;
        }

        /**
         * Gets the value of the sdlocid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSdlocid() {
            return sdlocid;
        }

        /**
         * Sets the value of the sdlocid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSdlocid(String value) {
            this.sdlocid = value;
        }

        /**
         * Gets the value of the rolecode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRolecode() {
            return rolecode;
        }

        /**
         * Sets the value of the rolecode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRolecode(String value) {
            this.rolecode = value;
        }

        /**
         * Gets the value of the sdlocname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSdlocname() {
            return sdlocname;
        }

        /**
         * Sets the value of the sdlocname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSdlocname(String value) {
            this.sdlocname = value;
        }

        /**
         * Gets the value of the tel1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTel1() {
            return tel1;
        }

        /**
         * Sets the value of the tel1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTel1(String value) {
            this.tel1 = value;
        }

        /**
         * Gets the value of the tel2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTel2() {
            return tel2;
        }

        /**
         * Sets the value of the tel2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTel2(String value) {
            this.tel2 = value;
        }

        /**
         * Gets the value of the effstartdate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEffstartdate() {
            return effstartdate;
        }

        /**
         * Sets the value of the effstartdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEffstartdate(XMLGregorianCalendar value) {
            this.effstartdate = value;
        }

        /**
         * Gets the value of the effenddate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEffenddate() {
            return effenddate;
        }

        /**
         * Sets the value of the effenddate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEffenddate(XMLGregorianCalendar value) {
            this.effenddate = value;
        }

        /**
         * Gets the value of the statuscode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatuscode() {
            return statuscode;
        }

        /**
         * Sets the value of the statuscode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatuscode(String value) {
            this.statuscode = value;
        }

        /**
         * Gets the value of the placeId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlaceId() {
            return placeId;
        }

        /**
         * Sets the value of the placeId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlaceId(String value) {
            this.placeId = value;
        }

        /**
         * Gets the value of the placename property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPlacename() {
            return placename;
        }

        /**
         * Sets the value of the placename property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPlacename(String value) {
            this.placename = value;
        }

    }

}
