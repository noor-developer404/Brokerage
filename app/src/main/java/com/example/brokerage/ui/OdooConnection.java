//package com.example.brokerage.ui;
//
//import org.apache.xmlrpc.XmlRpcException;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//public class OdooConnection {
//
//    // Replace with your Odoo details and secure token retrieval
//    private static final String URL = "https://ajath4.odoo.com/web";
//    private static final String DATABASE = "admin";
//    private static final String USERNAME = "admin";
//    private static final String TOKEN = retrieveSecureToken(); // Replace with secure token retrieval function
//
//    public static List<String> getEmployeeNames() throws XmlRpcException {
//        OdooClient client = new OdooClient(URL, DATABASE, USERNAME);
////        client.authenticate(TOKEN);
//
//        List<Object> result = client.call("hr.employee", "search_read", Arrays.asList(Arrays.asList()));
//
//        List<String> employeeNames = new ArrayList<>();
//        for (Object data : result) {
//            Map<String, Object> map = (Map<String, Object>) data;
//            if (map.containsKey("name")) {
//                employeeNames.add((String) map.get("name"));
//            }
//        }
//
//        return employeeNames;
//    }
//
//    // Replace with your secure token retrieval function
//    private static String retrieveSecureToken() {
//        // Implement your logic to retrieve the token securely from e.g., KeyStore
//        return "a293c02022f86db75f4a12b00c2697e13081c3a6";
//    }
//}