/*    */ package org.apache.oozie.example;
/*    */ 
/*    */ public enum TimeUnit
/*    */ {
/* 24 */   MINUTES(12), HOURS(10), DAYS(5), MONTHS(2);
/*    */ 
/*    */   private int calendarUnit;
/*    */ 
/*    */   private TimeUnit(int calendarUnit)
/*    */   {
/* 30 */     this.calendarUnit = calendarUnit;
/*    */   }
/*    */ 
/*    */   public int getCalendarUnit()
/*    */   {
/* 37 */     return this.calendarUnit;
/*    */   }
/*    */ }

/* Location:           C:\Users\Miquel Angel Andreu\Downloads\demo\demo\examples\apps\spark\lib\oozie-examples.jar
 * Qualified Name:     org.apache.oozie.example.TimeUnit
 * JD-Core Version:    0.6.2
 */