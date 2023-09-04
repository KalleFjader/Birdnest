package org.example;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Drones {
    ArrayList<Drone> dronelist= new ArrayList<>();
    ArrayList<String> SNlist= new ArrayList<>();



    public static ArrayList<String> sendGET() throws IOException, ParserConfigurationException, SAXException, XMLStreamException, XPathExpressionException {
        URL obj = new URL("https://assignments.reaktor.com/birdnest/drones");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String line;
        String regex = "\\d+";

        ArrayList<String> SNlist= new ArrayList<>();

        while ((line = in.readLine()) != null) {
            final Pattern sn = Pattern.compile("<serialNumber>(.+?)</serialNumber>", Pattern.DOTALL);
            final Pattern y = Pattern.compile("<positionY>(.+?)</positionY>", Pattern.DOTALL);
            final Pattern x = Pattern.compile("<positionX>(.+?)</positionX>", Pattern.DOTALL);
            final Matcher matcherSN = sn.matcher(line);
            final Matcher matcherY = sn.matcher(line);
            final Matcher matcherX = sn.matcher(line);
            if (matcherSN.find()) {
                System.out.println(matcherSN.group(1));
                SNlist.add(matcherSN.group(1));
            }
        }
        return SNlist;
    }

    public void scanArea() {
        
    }
        /*
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();

    }



        /*
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(con.getInputStream());
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == XMLStreamConstants.ATTRIBUTE) {
                System.out.println(reader.getLocalName());
            }
        }
        reader.close();




        */


        /*int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response);

               // System.out.println("Serial Number -"+ con.getInputStream().getElementsByTagName("serialNumber").item(0).getTextContent());



            }
            */



    }

