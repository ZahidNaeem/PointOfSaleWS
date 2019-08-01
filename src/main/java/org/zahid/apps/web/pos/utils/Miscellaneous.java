package org.zahid.apps.web.pos.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashSet;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

public class Miscellaneous {
    private static final Logger LOG = LogManager.getLogger(Miscellaneous.class);
    private static final String SERVLET_START = "/reportservlet?repName=";

    public static Exception getNestedException(Exception rootException) {
        Exception exception = rootException;
        if (exception.getCause() == null) {
            LOG.log(Level.INFO, "Last Exception: {0}", exception);
            return exception;
        } else {
            Exception cause = (Exception) exception.getCause();
            LOG.log(Level.INFO, exception.getClass().getName() + "Exception Cause: {0}", cause);
            return getNestedException(cause);
        }
    }

    public static String getResourceMessage(String rsrcBundle, String key) throws NullPointerException, MissingResourceException, ClassCastException {
        ResourceBundle bundle = ResourceBundle.getBundle(rsrcBundle);
        return bundle.getString(key);
    }

    public static ResourceBundle getResourceBundle(String bundle) throws NullPointerException, MissingResourceException {
        return ResourceBundle.getBundle(bundle);
    }

    public static String convertDBError(Exception e) {
        final String[] resourceMessage = {null};
        String errorMessage = Miscellaneous.getNestedException(e).getMessage();
        Set<ResourceBundle> rbList = new HashSet<>();
        rbList.add(Miscellaneous.getResourceBundle("dbconstraints"));
        rbList.add(Miscellaneous.getResourceBundle("dberrors"));

//        rbList.stream().filter(f -> false == found[0]).forEach(rb -> {
        rbList.forEach(rb -> {
            rb.keySet().stream().filter(s -> errorMessage.toUpperCase().contains(s.toUpperCase())).map(s -> Miscellaneous.getResourceMessage(rb.getBaseBundleName(), s)).forEach(message -> {
                LOG.log(Level.INFO, "Message: {0}", message);
//                found[0] = true;
                resourceMessage[0] = message;
            });
        });

//        outer:
//        for (ResourceBundle rb : rbList) {
// for (String key : rb.keySet()) {
//                if (errorMessage.toUpperCase().contains(key.toUpperCase())) {
//                    String msg = Miscellaneous.getResourceMessage(rb.getBaseBundleName(), key);
//                    resourceMessage[0] = msg;
//                    break outer;
//                }
//            }
//        }

        return resourceMessage[0];
    }

//    public static boolean exists(String operationClass, Long id) throws ClassNotFoundException, NoSuchMethodException {
//        Class aClass = Class.forName(operationClass);
//        Object obj = aClass.cast(new Object());
//        Method method = aClass.getDeclaredMethod("exists");
//        return false;
//    }

    public static int exists(String table, String column, Long id) {
        int result = 0;
        try {
            String sql = "{CALL XXIM_RECORD_EXISTS (?,?,?,?)}";
//            System.out.println("SF Result: " + sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter("PTABLE", table).setParameter("PCOLUMN", column).setParameter("PID", id).getSingleResult());
            Connection conn = DB.getInstance("localhost", "3306", "xxim", "root", "1234").getConnection();
            CallableStatement stmt = conn.prepareCall(sql);
            stmt.registerOutParameter(4, Types.INTEGER);
            stmt.setString(1, table);
            stmt.setString(2, column);
            stmt.setLong(3, id);
            stmt.execute();
            result = stmt.getInt(4);
            LOG.info("Result: ", result);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }/*
//        String sql = "SELECT XXIM_RECORD_EXISTS (" + table + ", " + column + ", " + id + ") FROM DUAL";
//                System.out.println("Query: " + sql);
//        int result = jdbcTemplate.queryForInt(
//                sql, Integer.class);
//        System.out.println("Result: " + result);
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("P_TABLE", table);
        in.addValue("P_COLUMN", column);
        in.addValue("P_ID", id);
        Integer res = countRecordsJdbcCall.executeFunction(Integer.class, in);
        System.out.println("Result: " + res);

//        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withFunctionName("XXIM_RECORD_EXISTS");
//        MapSqlParameterSource in = new MapSqlParameterSource();
//        in.addValue("P_TABLE", table);
//        in.addValue("P_COLUMN", column);
//        in.addValue("P_ID", id);
//        Map<String, Object> out = jdbcCall.execute(in);
//        for (Map.Entry<String, Object> entry : out.entrySet()) {
//            System.out.println(entry.getValue());
//        }
//        ;
//        String sql = "SELECT COUNT(1) FROM " + table + " WHERE " + column + " = " + id;
//        SessionFactory factory =
//                HibernateUtil.getSessionFactory();
//        System.out.println("Result: " + factory.openSession().createSQLQuery(sql).getSingleResult());
//        EntityManager em = factory.createEntityManager();
//        System.out.println("Result: " + em.createNativeQuery(sql)
//                .setParameter(1, table)
//                .setParameter(2, column)
//                .setParameter(3, id)
//                .getSingleResult());*/
        return result;
    }

    public static final String callReport(String repName, JSONObject params) {
        String reportURL = SERVLET_START + repName + (params != null ? "&params=" + params.toString() : "");
        LOG.info("Report URL: " + reportURL);
        return reportURL;
    }
}
