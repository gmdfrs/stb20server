@XmlSchema(
        namespace = "http://univ.fr/stb20",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns={
        @XmlNs(
                prefix="stb20",
                namespaceURI="http://univ.fr/stb20"
        )
})
package fr.univ.rouen.stb20server.model;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;