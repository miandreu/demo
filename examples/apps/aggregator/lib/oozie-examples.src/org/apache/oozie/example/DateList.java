/*    */ package org.apache.oozie.example;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.io.PrintStream;
/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import java.util.Properties;
/*    */ import java.util.TimeZone;
/*    */ 
/*    */ public class DateList
/*    */ {
/* 32 */   private static final TimeZone UTC = getTimeZone("UTC");
/* 33 */   private static String DATE_LIST_SEPARATOR = ",";
/*    */ 
/*    */   public static void main(String[] args) throws Exception {
/* 36 */     if (args.length < 5) {
/* 37 */       System.out.println("Usage: java DateList <start_time>  <end_time> <frequency> <timeunit> <timezone>");
/*    */ 
/* 39 */       System.out.println("Example: java DateList 2009-02-01T01:00Z 2009-02-01T02:00Z 15 MINUTES UTC");
/*    */ 
/* 41 */       System.exit(1);
/*    */     }
/* 43 */     Date startTime = parseDateUTC(args[0]);
/* 44 */     Date endTime = parseDateUTC(args[1]);
/* 45 */     Repeatable rep = new Repeatable();
/* 46 */     rep.setBaseline(startTime);
/* 47 */     rep.setFrequency(Integer.parseInt(args[2]));
/* 48 */     rep.setTimeUnit(TimeUnit.valueOf(args[3]));
/* 49 */     rep.setTimeZone(getTimeZone(args[4]));
/* 50 */     Date date = null;
/* 51 */     int occurrence = 0;
/* 52 */     StringBuilder dateList = new StringBuilder();
/*    */     do {
/* 54 */       date = rep.getOccurrenceTime(startTime, occurrence++, null);
/* 55 */       if (!date.before(endTime)) {
/*    */         break;
/*    */       }
/* 58 */       if (occurrence > 1) {
/* 59 */         dateList.append(DATE_LIST_SEPARATOR);
/*    */       }
/* 61 */       dateList.append(formatDateUTC(date));
/* 62 */     }while (date != null);
/*    */ 
/* 64 */     System.out.println(new StringBuilder().append("datelist :").append(dateList).append(":").toString());
/*    */ 
/* 66 */     File file = new File(System.getProperty("oozie.action.output.properties"));
/* 67 */     Properties props = new Properties();
/* 68 */     props.setProperty("datelist", dateList.toString());
/* 69 */     OutputStream os = new FileOutputStream(file);
/* 70 */     props.store(os, "");
/* 71 */     os.close();
/*    */   }
/*    */ 
/*    */   private static DateFormat getISO8601DateFormat()
/*    */   {
/* 76 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
/* 77 */     dateFormat.setTimeZone(UTC);
/* 78 */     return dateFormat;
/*    */   }
/*    */ 
/*    */   private static TimeZone getTimeZone(String tzId) {
/* 82 */     TimeZone tz = TimeZone.getTimeZone(tzId);
/* 83 */     if (!tz.getID().equals(tzId)) {
/* 84 */       throw new IllegalArgumentException(new StringBuilder().append("Invalid TimeZone: ").append(tzId).toString());
/*    */     }
/* 86 */     return tz;
/*    */   }
/*    */ 
/*    */   private static Date parseDateUTC(String s) throws Exception {
/* 90 */     return getISO8601DateFormat().parse(s);
/*    */   }
/*    */   private static String formatDateUTC(Date d) throws Exception {
/* 93 */     return d != null ? getISO8601DateFormat().format(d) : "NULL";
/*    */   }
/*    */ 
/*    */   private static String formatDateUTC(Calendar c) throws Exception {
/* 97 */     return c != null ? formatDateUTC(c.getTime()) : "NULL";
/*    */   }
/*    */ }

/* Location:           C:\Users\Miquel Angel Andreu\Downloads\demo\demo\examples\apps\spark\lib\oozie-examples.jar
 * Qualified Name:     org.apache.oozie.example.DateList
 * JD-Core Version:    0.6.2
 */