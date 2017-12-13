/*     */ package org.apache.oozie.example;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.TimeZone;
/*     */ 
/*     */ public class Repeatable
/*     */ {
/*     */   private String name;
/*     */   private Date baseline;
/*     */   private TimeZone timeZone;
/*     */   private int frequency;
/*     */   private TimeUnit timeUnit;
/*  31 */   public static final TimeZone UTC = TimeZone.getTimeZone("UTC");
/*     */ 
/*     */   int getOccurrence(Date nominalTime, Date timeLimit)
/*     */   {
/*  44 */     int occurrence = -1;
/*     */ 
/*  46 */     long positiveDiff = nominalTime.getTime() - getBaseline().getTime();
/*  47 */     if (positiveDiff >= 0L) {
/*  48 */       Calendar calendar = Calendar.getInstance(getTimeZone());
/*  49 */       calendar.setLenient(true);
/*  50 */       calendar.setTime(getBaseline());
/*  51 */       occurrence = 0;
/*     */ 
/*  54 */       while (calendar.getTime().compareTo(nominalTime) < 0) {
/*  55 */         if ((timeLimit != null) && (calendar.getTime().compareTo(timeLimit) > 0))
/*     */         {
/*  57 */           return -1;
/*     */         }
/*  59 */         calendar.add(getTimeUnit().getCalendarUnit(), getFrequency());
/*  60 */         occurrence++;
/*     */       }
/*     */ 
/*  64 */       long nominalCurrentDelta = nominalTime.getTime() - calendar.getTime().getTime();
/*     */ 
/*  70 */       positiveDiff = calendar.getTime().getTime() - getBaseline().getTime() + nominalCurrentDelta;
/*     */ 
/*  72 */       if (positiveDiff < 0L) {
/*  73 */         occurrence = -1;
/*     */       }
/*     */     }
/*  76 */     return occurrence;
/*     */   }
/*     */ 
/*     */   public int getOccurrence(Date nominalTime)
/*     */   {
/*  88 */     return getOccurrence(nominalTime, null);
/*     */   }
/*     */ 
/*     */   Date getOccurrenceTime(Date nominalTime, int occurrenceOffset, Date timeLimit)
/*     */   {
/* 106 */     Date date = null;
/* 107 */     int occurrence = getOccurrence(nominalTime, timeLimit);
/* 108 */     if (occurrence > -1) {
/* 109 */       occurrence += occurrenceOffset;
/* 110 */       occurrence = occurrence >= 0 ? occurrence : -1;
/*     */     }
/* 112 */     if (occurrence > -1) {
/* 113 */       Calendar calendar = Calendar.getInstance(getTimeZone());
/* 114 */       calendar.setLenient(true);
/* 115 */       calendar.setTime(getBaseline());
/* 116 */       calendar.add(getTimeUnit().getCalendarUnit(), getFrequency() * occurrence);
/*     */ 
/* 118 */       date = calendar.getTime();
/*     */     }
/*     */ 
/* 121 */     return date;
/*     */   }
/*     */ 
/*     */   public Date getOccurrenceTime(Date nominalTime, int occurrenceOffset)
/*     */   {
/* 136 */     return getOccurrenceTime(nominalTime, occurrenceOffset, null);
/*     */   }
/*     */ 
/*     */   public Date getTime(int occurrence)
/*     */   {
/* 147 */     if (occurrence < 0) {
/* 148 */       throw new IllegalArgumentException("occurrence cannot be <0");
/*     */     }
/* 150 */     Calendar calendar = Calendar.getInstance(getTimeZone());
/* 151 */     calendar.setLenient(true);
/* 152 */     calendar.setTime(getBaseline());
/* 153 */     calendar.add(getTimeUnit().getCalendarUnit(), getFrequency() * occurrence);
/*     */ 
/* 155 */     return calendar.getTime();
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 160 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 164 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Date getBaseline() {
/* 168 */     return this.baseline;
/*     */   }
/*     */ 
/*     */   public void setBaseline(Date baseline) {
/* 172 */     this.baseline = baseline;
/*     */   }
/*     */ 
/*     */   public TimeZone getTimeZone() {
/* 176 */     return this.timeZone;
/*     */   }
/*     */ 
/*     */   public void setTimeZone(TimeZone timeZone) {
/* 180 */     this.timeZone = timeZone;
/*     */   }
/*     */ 
/*     */   public int getFrequency() {
/* 184 */     return this.frequency;
/*     */   }
/*     */ 
/*     */   public void setFrequency(int frequency) {
/* 188 */     this.frequency = frequency;
/*     */   }
/*     */ 
/*     */   public TimeUnit getTimeUnit() {
/* 192 */     return this.timeUnit;
/*     */   }
/*     */ 
/*     */   public void setTimeUnit(TimeUnit timeUnit) {
/* 196 */     this.timeUnit = timeUnit;
/*     */   }
/*     */ }

/* Location:           C:\Users\Miquel Angel Andreu\Downloads\demo\demo\examples\apps\spark\lib\oozie-examples.jar
 * Qualified Name:     org.apache.oozie.example.Repeatable
 * JD-Core Version:    0.6.2
 */