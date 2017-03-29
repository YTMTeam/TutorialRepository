package com.mallocinc.database.generated.samples.etl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;



import com.mallocinc.codegenerator.exceptions.GDAOException;
import com.mallocinc.shared.util.dbconnection.GDAODatabaseConnectionFactory;
import com.mallocinc.codegenerator.superclasses.oracle.OracleSystemTab;
import com.mallocinc.dbanalyzer.vendor.oracle.OracleErrorCodes;
import com.mallocinc.shared.util.time.TimestampUtility;

import com.mallocinc.database.generated.working.BlockTab;
import com.mallocinc.database.generated.to.BlockTo;

 /**********************************************************************
 *  <pre>
 *
 *  Generated Class: BlockSample.java
 * 
 *  This is sample class that demonstrates how GDAO Working class
 *  could be used in ETL Processes.
 *
 *  This class can be used as a starting point for coding by following
 *  this procedure:
 *  1. Move them to your package. If you leave this class in the current
 *     package, it may be overwritten next time when you generate the code.
 *  2. Change the name of the Class to something more appropriate to the
 *     function it performs (for example: "ManageUser.java")
 *  3. Use Eclipse (or other IDE) code formatter to "beautify" the code
 *  4. Edit Class to suit your needs (some helpful hints are included in
 *     the comments).
 *  5. If case of database change, generate new code and include new
 *     pieces of code in your class.
 *
 *  Template version: 3.0
 *  Template date:    NLS missing message: template_date in: templates.gdao
 *  Template file:    /templates/Oracle/SampleETLOracleTemplate.txt
 *  Target database:  Oracle 10g, 11g, 12c
 *
 *  "/templates/Oracle/SampleETLOracleTemplate.txt" must be on the CLASSPATH
 *
 *  This code is generated on: 2017-February-27 06:45:55 PM CET
 *   
 *  Sample code demonstrates:
 *  - selecting, modifying, inserting and deleting data
 *  - modifying table
 *  - batch updates
 *  - batch deletes
 *  - update and delete one records based on PK (or To object)
 *
 *  This is the template class used as a model to dynamically
 *  create similar class for every working class.
 *
 *  Sample GDAO code for TABLE "BLOCK"
 *
 *  Note commented lines of code - you may need to
 *  uncomment them to use different options.
 *
 *  @author  Malloc Inc.
 *  @version 3.0
 *  @since   DBA 6.0
 *
 *  Copyright (C) 2015 Malloc Inc.
 *
 *  <pre>
 **********************************************************************/
//@SuppressWarnings("unused")
public class BlockSample {

   final static Logger log = Logger.getLogger(BlockSample.class.getName());
 
   final static String OUTPUT_FILE_NAME    = "./tmp/DatabaseRecordsFile.ytm";
   final static String INTPUT_FILE_NAME    = "./tmp/DatabaseRecordsFile.ytm";
   final static String DB_USER             = "YTM10";
   final static String DB_CONNECTIONS_FILE = "/dbconnections.txt";
 
   public static void main(String[] args) {
 
      Connection connection = null;
      try {
         GDAODatabaseConnectionFactory gDAODatabaseConnectionFactory = new GDAODatabaseConnectionFactory(DB_CONNECTIONS_FILE);
         connection = gDAODatabaseConnectionFactory.getConnection(DB_USER);
         BlockSample blockSample = new BlockSample();
         blockSample.saveToFile(connection, OUTPUT_FILE_NAME);
         blockSample.loadFromFile(connection, OUTPUT_FILE_NAME);
      } catch (GDAOException e) {
         e.printStackTrace();
      }
    }


   /**********************************************************************
   *
   * Save date from table BLOCK
   * onto a serialized object (file)
   *
   **********************************************************************/
   private void saveToFile(Connection connection, String fileName) throws GDAOException {
 
      FileOutputStream out = null;
      ObjectOutputStream s = null;
 
      try {
         BlockTab blockTab = new BlockTab(connection);
         blockTab.getAllRecordsRs();
         ArrayList<BlockTo> list = blockTab.getToArray(BlockTab.FETCH_ALL);
 
         int listSize = list.size();
 
         log.info("Size of the list: " + listSize);
         log.info("Saving database records in " + fileName);
 
         out = new FileOutputStream(fileName);
         s = new ObjectOutputStream(out);
         s.writeObject(list);
         s.flush();
      } catch (GDAOException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      } catch (FileNotFoundException e) {
         log.error("Could not find path to file: " + fileName);
         throw new GDAOException("Could not find file " + fileName);
      } catch (IOException e) {
         log.error("IO problem while saving file " + fileName, e);
         throw new GDAOException(e);
      } finally {
         try {
            connection.close();
            s.close();
            out.close();
            log.debug("Input stream is now closed: " + fileName);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         } catch (IOException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }


   /**********************************************************************
   *
   * Load data from serialized object (file) into 
   * table BLOCK
   *
   **********************************************************************/
   private void loadFromFile(Connection connection, String fileName) throws GDAOException {
 
      FileInputStream in = null;
      ObjectInputStream s = null;
 
      try {
 
         ArrayList<BlockTo> list = new ArrayList<BlockTo>();
 
         log.info("Loading DB structure from\n " + fileName);
         in = new FileInputStream(fileName);
         s = new ObjectInputStream(in);
         list = (ArrayList<BlockTo>) s.readObject();
 
         int listSize = list.size();
 
         log.info("Size of the list: " + listSize);
 
         BlockTab blockTab = new BlockTab(connection);
 
         /************************************************************************
          *
          * Deleting all records from table BLOCK only during testing
          *
          ************************************************************************/
         //blockTab.deleteAllRecords();

         /************************************************************************
          *
          * Insert data from ArrayList into the database table BLOCK
          *
          ************************************************************************/
         blockTab.insert(list);
 
      } catch (GDAOException e) {
         e.printStackTrace();
         throw new GDAOException(e);
      } catch (FileNotFoundException e) {
         log.error("Could not find file " + fileName);
         throw new GDAOException("Could not find file " + fileName);
      } catch (IOException e) {
         log.error("I/O problem while loading file " + fileName + ". File may be corrupted.");
         throw new GDAOException("Could not read from file:\n" + fileName);
      } catch (ClassNotFoundException e) {
         log.error("Class not found problem while saving file " + fileName, e);
         throw new GDAOException("Could save information to file:\n" + fileName);
      }
 
      finally {
         try {
            connection.close();
            in.close();
            s.close();
            log.debug("Input stream is now closed: " + fileName);
         } catch (SQLException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         } catch (IOException e) {
            e.printStackTrace();
            throw new GDAOException(e);
         }
      }
   }
}
