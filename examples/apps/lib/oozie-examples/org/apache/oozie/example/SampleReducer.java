/*    */ package org.apache.oozie.example;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Iterator;
/*    */ import org.apache.hadoop.io.LongWritable;
/*    */ import org.apache.hadoop.io.Text;
/*    */ import org.apache.hadoop.mapred.JobConf;
/*    */ import org.apache.hadoop.mapred.OutputCollector;
/*    */ import org.apache.hadoop.mapred.Reducer;
/*    */ import org.apache.hadoop.mapred.Reporter;
/*    */ 
/*    */ public class SampleReducer
/*    */   implements Reducer<LongWritable, Text, LongWritable, Text>
/*    */ {
/*    */   public void configure(JobConf jobConf)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void reduce(LongWritable key, Iterator<Text> values, OutputCollector<LongWritable, Text> collector, Reporter reporter)
/*    */     throws IOException
/*    */   {
/* 38 */     while (values.hasNext())
/* 39 */       collector.collect(key, values.next());
/*    */   }
/*    */ 
/*    */   public void close()
/*    */     throws IOException
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Miquel Angel Andreu\Downloads\demo\demo\examples\apps\spark\lib\oozie-examples.jar
 * Qualified Name:     org.apache.oozie.example.SampleReducer
 * JD-Core Version:    0.6.2
 */