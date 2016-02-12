package com.example.user.mapapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by user on 20/12/2015.
 */
public class DatabaseDirectory {
    public static String filePath ;
    private String userDbPath;
    private String apartmentDbPath;
    private String residentialDistrictDbPath;

    public void DatabaseDirectory(){
        File sdcard= Environment.getExternalStorageDirectory();
        File file = new File(sdcard, "DatabaseDirectory.xml");
        filePath = file.getAbsolutePath();
        Log.d("filePath", filePath);

    }

    public static String getUserDbPath() {
        String userDbPath="";
        try{
            filePath = getFilePath();
            Log.d("filepathget", filePath);
            File file = new File (filePath);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

            Node userDbNode = doc.getElementsByTagName("userDbPath").item(0);
            Log.d("userDbElement", userDbNode.toString());
            userDbPath= userDbNode.getAttributes().getNamedItem("path").getTextContent();

        }
        catch(Exception e){
            Log.d("getApartmentDbException",e.toString());
        }
        return userDbPath;
    }
    public static Cursor getUserDbCursor(){
        String userDbPath = new DatabaseDirectory().getUserDbPath();
        SQLiteDatabase db = SQLiteDatabase.openDatabase(userDbPath, null, 0);
        Cursor cs = DatabaseOperationUser.getCursor(db);

        return cs;
    }
    public static void setUserDbPath(String userDbPath) {
            Element apartmentDbElement =null;
            try{
                Log.d("userDbPath",userDbPath);
                filePath = getFilePath();
                Log.d("setUserDbPath", filePath);
                File file = new File (filePath);
                Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
                Node userDbNode = doc.getElementsByTagName("userDbPath").item(0);
                Log.d("userDbElement", userDbNode.toString());
                apartmentDbElement = (Element) userDbNode;
                apartmentDbElement.setAttribute("path", userDbPath);
//            apartmentDbElement.getAttributes().getNamedItem("path").setTextContent(apartmentDbPath);

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                File DatabaseDirectoryFile = new File(filePath);
                transformer.transform(new DOMSource(doc), new StreamResult(DatabaseDirectoryFile));


            }
            catch(Exception e){
                Log.d("Exceptionapartment",e.toString());
            }
        }


    public static String getApartmentDbPath() {
        String apartmentDbPath="";
        try{
            filePath = getFilePath();
            Log.d("filepathget", filePath);
            File file = new File (filePath);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

            Node apartmentDbNode = doc.getElementsByTagName("apartmentDbPath").item(0);
            Log.d("apartmentDbElement", apartmentDbNode.toString());
            apartmentDbPath= apartmentDbNode.getAttributes().getNamedItem("path").getTextContent();
            Element apartmentElement = (Element) apartmentDbNode;
            String attribute = apartmentElement.getTextContent();

        }
        catch(Exception e){
            Log.d("getApartmentDbException",e.toString());
        }
        Log.d("apartmentDbPath", apartmentDbPath);
        return apartmentDbPath;
    }

    public static Cursor getApartmentDbCursor(){
        String apartmentDbPath = new DatabaseDirectory().getApartmentDbPath();
        SQLiteDatabase db = SQLiteDatabase.openDatabase(apartmentDbPath, null, 0);
        Cursor cs = DatabaseOperationApartment.getCursor(db);

        return cs;
    }


    public static void setApartmentDbPath(String apartmentDbPath) {
        Element apartmentDbElement =null;
        try{
            Log.d("apartmentDbPath",apartmentDbPath);
            filePath = getFilePath();
            Log.d("setApartmentDbPath", filePath);
            File file = new File (filePath);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            Node apartmentDbNode = doc.getElementsByTagName("apartmentDbPath").item(0);
            Log.d("apartmentDbElement", apartmentDbNode.toString());
            apartmentDbElement = (Element) apartmentDbNode;
            apartmentDbElement.setAttribute("path", apartmentDbPath);
//            apartmentDbElement.getAttributes().getNamedItem("path").setTextContent(apartmentDbPath);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            File DatabaseDirectoryFile = new File(filePath);
            transformer.transform(new DOMSource(doc), new StreamResult(DatabaseDirectoryFile));


        }
        catch(Exception e){
            Log.d("Exceptionapartment",e.toString());
        }

    }

    public static String getResidentialDistrictDbPath() {
        String residentialDistrictDbPath="";
        try{
            filePath = getFilePath();
            Log.d("filepathget", filePath);
            File file = new File (filePath);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

            Node residentialDistrictDbNode = doc.getElementsByTagName("residentialDistrictDbPath").item(0);
            Log.d("residentialDistrictDbElement", residentialDistrictDbNode.toString());
            residentialDistrictDbPath= residentialDistrictDbNode.getAttributes().getNamedItem("path").getTextContent();
            Element residentialDistrictElement = (Element) residentialDistrictDbNode;
            String attribute = residentialDistrictElement.getTextContent();

        }
        catch(Exception e){
            Log.d("getresidentialDistrictDbException",e.toString());
        }
        Log.d("residentialDistrictDbPath", residentialDistrictDbPath);
        return residentialDistrictDbPath;
    }

    public static void setResidentialDistrictDbPath(String resDistrictDbPath) {
        Element resDistrictDbElement =null;
        try{
            Log.d("resDistrictDbPath",resDistrictDbPath);
            filePath = getFilePath();
            Log.d("setresDistrictDbPath", filePath);
            File file = new File (filePath);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            Node userDbNode = doc.getElementsByTagName("residentialDistrictDbPath").item(0);
            Log.d("resDistrictDbElement", userDbNode.toString());
            resDistrictDbElement = (Element) userDbNode;
            resDistrictDbElement.setAttribute("path", resDistrictDbPath);
//            apartmentDbElement.getAttributes().getNamedItem("path").setTextContent(apartmentDbPath);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            File DatabaseDirectoryFile = new File(filePath);
            transformer.transform(new DOMSource(doc), new StreamResult(DatabaseDirectoryFile));


        }
        catch(Exception e){
            Log.d("Exceptionapartment",e.toString());
        }
    }

    public Cursor getResidentialDistrictDbCursor(){
        String residentialDbPath = new DatabaseDirectory().getResidentialDistrictDbPath();
        SQLiteDatabase db = SQLiteDatabase.openDatabase(residentialDbPath, null, 0);
        Cursor cs = DatabaseOperationResidentialDistrict.getCursor(db);

        return cs;
    }

    public static void CreateXML(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element DatabaseDirectory = document.createElement("DatabaseDirectory");

            Element userDbPathElement = document.createElement("userDbPath");
            userDbPathElement.setAttribute("path", "");

            Element apartmentDbPathElement = document.createElement("apartmentDbPath");
            apartmentDbPathElement.setAttribute("path", "");

            Element residentialDistrictDbPathElement = document.createElement("residentialDistrictDbPath");
            residentialDistrictDbPathElement.setAttribute("path", "");

            DatabaseDirectory.appendChild(userDbPathElement);
            DatabaseDirectory.appendChild(apartmentDbPathElement);
            DatabaseDirectory.appendChild(residentialDistrictDbPathElement);
            document.appendChild(DatabaseDirectory);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            filePath = getFilePath();
            File DatabaseDirectoryFile = new File(filePath);
            transformer.transform(new DOMSource(document), new StreamResult(DatabaseDirectoryFile));
            Log.d("FileCreated", "Created");
        }
        catch (Exception e){
            Log.d("Exception1", e.toString());
        }
    }
    public static String getFilePath(){
//        File sdcard= Environment.getExternalStorageDirectory();
//        File file = new File(sdcard, "DatabaseDirectory.xml");
//        filePath = file.getAbsolutePath();

        filePath = "/sdcard/DatabaseDirectory.xml";

        return filePath;
    }

}
