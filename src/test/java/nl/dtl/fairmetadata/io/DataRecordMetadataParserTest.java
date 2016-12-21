/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dtl.fairmetadata.io;

import java.util.List;
import nl.dtl.fairmetadata.model.DataRecordMetadata;
import nl.dtl.fairmetadata.utils.ExampleFilesUtils;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for DataRecordMetadataParser.
 * 
 * @author Rajaram Kaliyaperumal
 * @since 2016-10-25
 * @version 0.1
 */
public class DataRecordMetadataParserTest {
    
    private final DataRecordMetadataParser parser = 
            new DataRecordMetadataParser();
    /**
     * Test null RDF string, this test is expected to throw exception
     * @throws Exception 
     */
    @Test(expected = NullPointerException.class)
    public void testParseNullRDFString() throws Exception {
        System.out.println("Test : Parse invalid datarecord content");
        IRI drURI = ExampleFilesUtils.DATARECORD_URI;
        IRI dURI = ExampleFilesUtils.DATASET_URI;
        parser.parse(null, ExampleFilesUtils.DISTRIBUTION_ID, drURI, dURI, 
                ExampleFilesUtils.FILE_FORMAT);
        fail("This test is execpeted to throw an error");
    }
    
    /**
     * Test empty RDF string, this test is expected to throw exception
     * @throws Exception 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testParseEmptyRDFString() throws Exception {
        System.out.println("Test : Parse invalid datarecord content");
        IRI drURI = ExampleFilesUtils.DATARECORD_URI;
        IRI dURI = ExampleFilesUtils.DATASET_URI;
        parser.parse("", ExampleFilesUtils.DISTRIBUTION_ID, drURI, dURI, 
                ExampleFilesUtils.FILE_FORMAT);
        fail("This test is execpeted to throw an error");
    }
    
    /**
     * Test null datarecord ID, this test is expected to throw exception
     * @throws Exception 
     */
    @Test(expected = NullPointerException.class)
    public void testParseNullDistributionID() throws Exception {        
        System.out.println("Test : Parse invalid datarecord content");
        IRI drURI = ExampleFilesUtils.DATARECORD_URI;
        IRI dURI = ExampleFilesUtils.DATASET_URI;
        parser.parse(ExampleFilesUtils.getFileContentAsString(
                ExampleFilesUtils.DISTRIBUTION_METADATA_FILE), null, drURI, 
                dURI, ExampleFilesUtils.FILE_FORMAT);
        fail("This test is execpeted to throw an error");
    }
    
    /**
     * Test empty datarecord ID, this test is expected to throw exception
     * @throws Exception 
     */
    @Test(expected = IllegalArgumentException.class)
    public void testParseEmptyDistributionID() throws Exception {
        System.out.println("Test : Parse invalid datarecord content");
        IRI drURI = ExampleFilesUtils.DATARECORD_URI;
        IRI dURI = ExampleFilesUtils.DATASET_URI;
        parser.parse(ExampleFilesUtils.getFileContentAsString(
                ExampleFilesUtils.DISTRIBUTION_METADATA_FILE), "", drURI, 
                dURI, ExampleFilesUtils.FILE_FORMAT);
        fail("This test is execpeted to throw an error");
    }    
    /**
     * Test null RDFFormat, this test is expected to throw exception
     * @throws Exception 
     */
    @Test(expected = NullPointerException.class)
    public void testParseNullRDFFormat() throws Exception {
        System.out.println("Test : Parse invalid datarecord content");
        IRI drURI = ExampleFilesUtils.DATARECORD_URI;
        IRI dURI = ExampleFilesUtils.DATASET_URI;
        parser.parse(ExampleFilesUtils.getFileContentAsString(
                ExampleFilesUtils.DISTRIBUTION_METADATA_FILE), 
                ExampleFilesUtils.DISTRIBUTION_ID, drURI, dURI, null);
        fail("This test is execpeted to throw an error");
    }
    /**
     * Test valid datarecord metadata rdf file
     * @throws Exception 
     */
    @Test
    public void testParseFile() throws Exception {
        System.out.println("Test : Parse invalid datarecord content");
        IRI drURI = ExampleFilesUtils.DATARECORD_URI;
        IRI dURI = ExampleFilesUtils.DATASET_URI;
        DataRecordMetadata metadata = parser.parse(
                ExampleFilesUtils.getFileContentAsString(
                ExampleFilesUtils.DISTRIBUTION_METADATA_FILE), 
                ExampleFilesUtils.DISTRIBUTION_ID, drURI, dURI, 
                ExampleFilesUtils.FILE_FORMAT);
        assertNotNull(metadata);
    }
    
    /**
     * Test null datarecord URI, this test is excepted to throw 
     * an exception
     * @throws Exception 
     */
    @Test(expected = NullPointerException.class)
    public void testNullDistributionURI() throws Exception {
        System.out.println("Test : Missing dataset URL");
        List<Statement> stmts = ExampleFilesUtils.getFileContentAsStatements(
                ExampleFilesUtils.DATASET_METADATA_FILE, 
                        ExampleFilesUtils.DATASET_URI.toString());
        parser.parse(stmts , null);
       fail("This test is execpeted to throw an error");
    }
    
    /**
     * Test null statements, this test is excepted to throw 
     * an exception
     * @throws Exception 
     */
    @Test(expected = NullPointerException.class)
    public void testNullStatements() throws Exception {
        System.out.println("Test : Parse valid datarecord content");
        IRI drURI = ExampleFilesUtils.DATARECORD_URI;
        parser.parse(null, drURI);
        fail("This test is execpeted to throw an error");
    }
    
    /**
     * Test valid datarecord rdf statements
     * @throws Exception 
     */
    @Test
    public void testParseStatements() throws Exception {
        System.out.println("Test : Parse valid datarecord content");
        IRI drURI = ExampleFilesUtils.DATARECORD_URI;
        DataRecordMetadata metadata = parser.parse(
                ExampleFilesUtils.getFileContentAsStatements(
                ExampleFilesUtils.DATASET_METADATA_FILE, 
                        ExampleFilesUtils.DATARECORD_URI.toString()), drURI);
        assertNotNull(metadata);
    }
    
    /**
     * Test valid datarecord metadata rdf file, with no base
     * @throws Exception 
     */
    @Test
    public void testParseFileWithNoBase() throws Exception {
        System.out.println("Test : Parse valid datarecord "
                + "content with no base uri");
        DataRecordMetadata metadata = parser.parse(
                ExampleFilesUtils.getFileContentAsString(
                ExampleFilesUtils.DATARECORD_METADATA_FILE), null,
                ExampleFilesUtils.FILE_FORMAT);
        assertNotNull(metadata);
    }
    
}
