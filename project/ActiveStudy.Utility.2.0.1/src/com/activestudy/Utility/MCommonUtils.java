package com.activestudy.Utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MCommonUtils {

//	private static Lo logger = Logger.getLogger(MCommonUtils.class);
//	private static GeneratorSeq mt_seq = null;
    public static String getObjectInfo(Object obj) {
        return getObjectInfo(obj, false);
    }

    public static String getObjectInfo(Object obj, boolean print) {
        if (obj == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n " + obj.getClass().getName() + " ");
        tagObjectInfo0(obj, "", sb, 0);
        sb.append("\n");

        String str = sb.toString();

        return str;
    }

    public static boolean isPrimitive(Class c) {
        if (c.isPrimitive()) {
            return true;
        } else if (c == Byte.class
                || c == Short.class
                || c == Integer.class
                || c == Long.class
                || c == Float.class
                || c == Double.class
                || c == Boolean.class
                || c == Character.class
                || c == String.class) {
            return true;
        } else {
            return false;
        }
    }

    private static void tagObjectInfo0(Object obj, String tab, StringBuilder sb, int level) {
        //sb.append("\n" + tab + "Object info: " + String.valueOf(obj.getClass()));
        // sb.append("\n" + tab + "ToString: " + String.valueOf(obj));

        if (isPrimitive(obj.getClass()) || level >= 10) {;
            return;
        }
        Field[] fields = obj.getClass().getFields();
        for (int i = 0; fields != null && i < fields.length; i++) {
            try {
                Field f = fields[i];
                String value = String.valueOf(f.get(obj));
                sb.append("\n" + (tab + tab) + "Field: " + f.getName() + "=" + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (Exception e) {
            }
        }
        Method[] methods = obj.getClass().getMethods();
        for (int i = 0; methods != null && i < methods.length; i++) {
            try {
                Method m = methods[i];
                if (!m.getName().startsWith("get")) {
                    continue;
                }
                if (m.getParameterTypes() != null && m.getParameterTypes().length > 0) {
                    continue;
                }
                Object valueObj = m.invoke(obj);
                if (valueObj == null) {
                    sb.append("\n" + (tab + tab) + "Method: " + m.getName() + "=" + null);
                } else if (valueObj.getClass().isArray()) {
                    //SUA O DAY
                    String value = String.valueOf(valueObj);
                    sb.append("\n" + (tab + tab) + "Method: " + m.getName() + "= (array) " + value);
                } else if (isPrimitive(valueObj.getClass())) {
                    String value = String.valueOf(valueObj);
                    sb.append("\n" + (tab + tab) + "Method: " + m.getName() + "=" + value);
                } else if (!valueObj.getClass().equals(Class.class)) {
                    // System.out.println(valueObj.getClass().getName());
                    tagObjectInfo0(valueObj, "  ", sb, level + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Date addTime(Date date, int type, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(type, value);
        return cal.getTime();
    }

    public static String formatMsisdn(String msisdn, String format) {
        String countryCode = "84";
        if (msisdn == null) {
            return msisdn;
        }
        msisdn = msisdn.replace(" ", "");
        if (msisdn.startsWith("+" + countryCode)) {
            msisdn = msisdn.replaceFirst("+" + countryCode, "");
        } else if (msisdn.startsWith(countryCode)) {
            msisdn = msisdn.replaceFirst(countryCode, "");
        } else if (msisdn.startsWith("0")) {
            msisdn = msisdn.replaceFirst("0", "");
        }
        msisdn = format + msisdn;
        return msisdn;
    }
    private static final String PREFIX_MOBILE_10s[] = {"849"};
    private static final String PREFIX_MOBILE_11s[] = {"8412", "8416", "8419"};

    public static boolean isMobilePhoneNumber(String msisdn) {
        String msisdnStandar = msisdn.replace("+", "");

        if ((msisdnStandar.length() < 11) || (msisdnStandar.length() > 12)) {
            return false;
        }

        for (int i = 0; i < PREFIX_MOBILE_10s.length; i++) {
            if (msisdnStandar.startsWith(PREFIX_MOBILE_10s[i])) {
                if (msisdnStandar.length() == 11) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        for (int i = 0; i < PREFIX_MOBILE_11s.length; i++) {
            if (msisdnStandar.startsWith(PREFIX_MOBILE_11s[i])) {
                if (msisdnStandar.length() == 12) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public static String getCurrentTime() {
        SimpleDateFormat dateFormatFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormatFull.format(System.currentTimeMillis());
    }

    public static String parseTime(String format, Object obj) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(obj);
    }

    public static String comvertTime(String format1, String dateStr, String format2) {
        try {
            SimpleDateFormat df1 = new SimpleDateFormat(format1);
            SimpleDateFormat df2 = new SimpleDateFormat(format2);
            Date date = df1.parse(dateStr);
            return df2.format(date);
        } catch (ParseException e) {
            return dateStr;
        }
    }

    public static long getCRC32Value(String xmlContent) {
        return getChecksumValue(new java.util.zip.CRC32(), xmlContent);
    }

    private static long getChecksumValue(java.util.zip.Checksum checksum, String contentReceiver) {
        byte[] bytes = contentReceiver.getBytes(Charset.forName("UTF8"));
        int len = bytes.length;
        checksum.update(bytes, 0, len);
        return checksum.getValue();
    }

    public static String getOneLineString(String str) {
        if (str == null) {
            return null;
        }
        str = str.replace("|", "::");
        str = str.replace("\r\n", "\\r\\n");
        str = str.replace("\n\r", "\\n\\r");
        str = str.replace("\r", "\\r");
        str = str.replace("\n", "\\n");
        return str;
    }

    public static String nomalizeString(String s) {
        if (s == null) {
            return s;
        }
        s = s.trim();
        s = s.replaceAll("\t", " ");
        s = s.replaceAll(" +", " ");
        return s;
    }

    public static String getChecksumValue(String contentReceiver) {
        try {
            byte[] bytes = contentReceiver.getBytes(Charset.forName("UTF8"));
            int len = bytes.length;
            java.util.zip.Checksum checksum = new java.util.zip.CRC32();
            checksum.update(bytes, 0, len);
            return checksum.getValue() + "";
        } catch (Throwable e) {
            return contentReceiver;
        }
    }

//	public int nextMTSequence() {
//		try {
//			if(mt_seq == null){
//				mt_seq = new GeneratorSeq("config/seq/mt_seq");
//			}
//			int minor_seq = mt_seq.getNextSeq();
//			int i = Bitwise.makeDeliverSequenceNumber(minor_seq, 0);
//			return i;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
    public static String trimCp(String str) {
        if (str.startsWith(";")) {
            str = str.replaceFirst(";", "");
        }
        if (str.endsWith(";")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static String trimP(String str) {
        if (str.startsWith(",")) {
            str = str.replaceFirst(",", "");
        }
        if (str.endsWith(",")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static Timestamp convert2Timestamp(Date date) {
        try {
            if (date == null) {
                return null;
            }
            return new Timestamp(date.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    public static int parseMonthToInt() {
        try {
            SimpleDateFormat dateFormatShort = new SimpleDateFormat("yyyyMM");
            return Integer.parseInt(dateFormatShort.format(System.currentTimeMillis()));
        } catch (Exception e) {
            return 0;
        }
    }

    public static void writeFile(String fileName, String content, boolean append) {
        FileOutputStream fout = null;
        try {
            fout = new java.io.FileOutputStream(fileName, append);
            fout.write(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getStackTraceException(Exception e) {
        String all = "Stack trace of exception: ";
        try {
            all = e.getMessage() + "\n";
            StackTraceElement stackTrace[] = e.getStackTrace();
            int count = stackTrace.length;
            for (int i = count - 1; i >= 0; i--) {
                all += stackTrace[i].toString() + "\n";
            }
        } catch (Exception e2) {
            all += e2.getMessage();
        }
        return all;
    }

    public static String getStackTraceException(Throwable e) {
        String all = "Stack trace of exception: ";
        try {
            all = e.getMessage() + "\n";
            StackTraceElement stackTrace[] = e.getStackTrace();
            int count = stackTrace.length;
            for (int i = count - 1; i >= 0; i--) {
                all += stackTrace[i].toString() + "\n";
            }
        } catch (Exception e2) {
            all += e2.getMessage();
        }
        return all;
    }

    public static Date getLaterDate(Date d1, Date d2) {
        if (d1 == null && d2 == null) {
            return null;
        }
        if (d1 == null) {
            return d2;
        }
        if (d2 == null) {
            return d1;
        }
        boolean temp = d1.compareTo(d2) > 0;
        if (temp) {
            return d1;
        }
        return d2;
    }

    public static int getEarlierTimePosition(Date timeAddSong1, Date timeAddSong2) {
        if (timeAddSong1 == null) {
            return 1;
        } else if (timeAddSong2 == null) {
            return 2;
        }
        boolean temp = timeAddSong1.compareTo(timeAddSong2) > 0;
        if (temp) {
            return 2;
        }
        return 1;
    }

    public static Integer parseInt(String value, Integer defauzt) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return defauzt;
        }
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    public static void main(String[] args) {
        System.out.println(parseMonthToInt());
    }

    public static Object deserializeObject(byte[] data) {
        ByteArrayInputStream in = null;
        ObjectInputStream is = null;
        try {
            in = new ByteArrayInputStream(data);
            is = new ObjectInputStream(in);
            return is.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        return null;
    }

    public static byte[] serializeObject(Object obj) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(obj);
            byte[] yourBytes = bos.toByteArray();
            return yourBytes;
        } catch (Exception e) {
            if (obj == null) {
                e.printStackTrace();
            } else {
                e.printStackTrace();
            }
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
            }
            try {
                bos.close();
            } catch (IOException ex) {
            }
        }
        return null;
    }

    public static void writeObjectToFile2(String fileName, Object obj) {
        byte[] b = serializeObject(obj);
        if (b != null && b.length > 0) {
            writeBytesToFile(b, fileName);
        } else {
            try {
                FileOutputStream fout = new java.io.FileOutputStream(fileName, false);
                // append nothing to clear
                fout.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Hashtable<String, String> parseQueryString(String s) {
        if (s == null) {
            return null;
        }
        Hashtable<String, String> list = new Hashtable<String, String>();
        String[] tmp = s.split("&");
        for (int i = 0; tmp != null && i < tmp.length; i++) {
            if (!tmp[i].contains("=")) {
                list.put(tmp[i], "");
            } else {
                String tmp2[] = tmp[i].split("=");
                list.put(tmp2[0], tmp2[1]);
            }
        }
        return list;
    }

    public static Object readObjectFromFile2(String fileName, boolean clearAfterRead) {
        byte[] b = readBytesFromFile(new File(fileName));
        Object obj = deserializeObject(b);
        if (obj != null && clearAfterRead) {
            try {
                FileOutputStream fout = new java.io.FileOutputStream(fileName, false); // append nothing to clear
                fout.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return obj;
    }

    public static void writeObjectToFile(String fileName, Object obj) {
        FileOutputStream fout = null;
        ObjectOutputStream objOut = null;
        try {
            fout = new java.io.FileOutputStream(fileName, false);
            objOut = new ObjectOutputStream(fout);
            objOut.writeObject(obj);
            objOut.flush();
        } catch (Exception e) {
            // Log.i("MCommonUltils","Exception save Obj: " + e.getMessage());
        } finally {
            try {
                if (objOut != null) {
                    objOut.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Object readObjectFromFile(String fileName, boolean clearAfterRead) {
        FileInputStream fin = null;
        ObjectInputStream objIn = null;
        try {
            fin = new java.io.FileInputStream(fileName);
            objIn = new ObjectInputStream(fin);
            Object obj = objIn.readObject();
            return obj;
        } catch (Exception e) {
            // Log.i("MCommonUltils","Exception load queue: " + e.getMessage());
        } finally {
            try {
                if (objIn != null) {
                    objIn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (clearAfterRead) {
                try {
                    FileOutputStream fout = new java.io.FileOutputStream(fileName, false); // append nothing to clear
                    fout.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String readText(InputStream is) {
        InputStreamReader rd = null;
        BufferedReader in = null;
        try {
            rd = new InputStreamReader(is, "UTF-8");
            in = new BufferedReader(rd);
            String line;
            String all = "";
            while ((line = in.readLine()) != null) {
                all += "\n" + line;
            }
            all = all.replaceFirst("\n", "");
            return all;
        } catch (Exception e) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e2) {
                }
            }
            if (rd != null) {
                try {
                    rd.close();
                } catch (Exception e2) {
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e2) {
                }
            }
        }
        return null;
    }

    public static String readFile(String name) {
        try {
            FileInputStream is = new FileInputStream(name);
            InputStreamReader rd = new InputStreamReader(is, "UTF-8");
            BufferedReader in = new BufferedReader(rd);
            String line;
            String all = "";
            while ((line = in.readLine()) != null) {
                all += "\n" + line;
            }
            all = all.replaceFirst("\n", "");
            in.close();
            rd.close();
            is.close();
            return all;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeFile2(String fileName, String text, boolean append) {
        try {
            FileWriter fw = new FileWriter(fileName, append);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.print(text);
            out.close();
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] getByteArray(InputStream is) {
        ByteArrayOutputStream buffer = null;
        try {
            buffer = new ByteArrayOutputStream();
            int nRead = -1;
            byte[] data = new byte[1024];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            return buffer.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                is.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] getFileBytes(File file) {
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[1024];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ous != null) {
                    ous.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ios != null) {
                    ios.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ous.toByteArray();
    }

    public byte[] getByte(String urlToRead) {
        HttpURLConnection conn = null;
        InputStream is = null;
        ByteArrayOutputStream buffer = null;
        try {
            URL url = new URL(urlToRead);
            conn = (HttpURLConnection) url.openConnection();
            is = conn.getInputStream();
            buffer = new ByteArrayOutputStream();
            int nRead = -1;
            byte[] data = new byte[1024];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            return buffer.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /*public static byte[] serialize(Object obj) throws IOException {
     ByteArrayOutputStream out = new ByteArrayOutputStream();
     ObjectOutputStream os = new ObjectOutputStream(out);
     os.writeObject(obj);
     byte[] b = out.toByteArray();
     os.close();
     out.close();
     return b;
     }
     public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
     ByteArrayInputStream in = new ByteArrayInputStream(data);
     ObjectInputStream is = new ObjectInputStream(in);
     Object obj = is.readObject();
     is.close();
     in.close();
     return obj;
     }*/
    public static void writeBytesToFile(byte[] b, String fileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            fos.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception e2) {
            }
        }
    }

    public static byte[] readBytesFromFile(File file) {
        ByteArrayOutputStream ous = null;
        InputStream ios = null;
        try {
            byte[] buffer = new byte[1024];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ((read = ios.read(buffer)) != -1) {
                ous.write(buffer, 0, read);
            }
        } catch (IOException e) {
            // e.printStackTrace();
        } finally {
            try {
                if (ous != null) {
                    ous.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ios != null) {
                    ios.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ous.toByteArray();
    }

    public static String getCurrentMemInfo() {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();

        int use = Math.round((float) (runtime.totalMemory() - runtime.freeMemory()) / mb);
        int free = Math.round((float) runtime.freeMemory() / mb);
        int max = Math.round((float) runtime.maxMemory() / mb);

        return "jvMem=" + use + "/" + free + "/" + max;
    }

    public static boolean createFolderOfFile(String fileName) {
        if ((fileName == null) || (fileName.isEmpty())) {
            return true;
        }
        File file = new File(fileName);
        if (file.exists()) {
            return true;
        } else {
            if (createFolderOfFile(file.getParent()) == true) {
                return file.mkdir();
            }
            return false;
        }

    }

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean is_Email(String email) {

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
