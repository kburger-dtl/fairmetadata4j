/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.dtl.fairmetadata.utils.vocabulary;

import org.openrdf.model.URI;
import org.openrdf.model.impl.URIImpl;


/**
 * FairDataPoint vocabulary.
 * See {@link <a href="https://github.com/DTL-FAIRData/FDP-O">FDP vacobulary</a>}. 
 * 
 * @author Rajaram Kaliyaperumal
 * @since 2016-09-06
 * @version 0.1
 */
public class FDP {
    public static final String PREFIX = "fdp-o";
    public static final String NAMESPACE =  
            "http://rdf.biosemantics.org/ontologies/fdp-o#";    
    public static final URI DATA_RECORD = 
            new URIImpl(NAMESPACE + "dataRecord");
    public static final URI TYPE_DATA_RECORD = 
            new URIImpl(NAMESPACE + "DataRecord");
    public static final URI REFERS_TO= 
            new URIImpl(NAMESPACE + "refersTo");
    public static final URI METADATA_ISSUED= 
            new URIImpl(NAMESPACE + "metadataIssued");
    public static final URI METADATA_MODIFIED= 
            new URIImpl(NAMESPACE + "metadataModified");    
    public static final URI METADATA_IDENTIFIER= 
            new URIImpl(NAMESPACE + "metadataIdentifier");
    public static final URI RML_MAPPING= 
            new URIImpl(NAMESPACE + "rmlMapping");
}
