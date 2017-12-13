/*    */ package org.apache.oozie.example;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.hadoop.io.LongWritable;
/*    */ import org.apache.hadoop.io.Text;
/*    */ import org.apache.hadoop.mapred.JobConf;
/*    */ import org.apache.hadoop.mapred.Mapper;
/*    */ import org.apache.hadoop.mapred.OutputCollector;
/*    */ import org.apache.hadoop.mapred.Reporter;
/*    */ 
/*    */ public class SampleMapper
/*    */   implements Mapper<LongWritable, Text, LongWritable, Text>
/*    */ {
/*    */   public void configure(JobConf jobConf)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void map(LongWritable key, Text value, OutputCollector<LongWritable, Text> collector, Reporter reporter)
/*    */     throws IOException
/*    */   {
/* 37 */     collector.collect(key, value);
/*    */   }
/*    */ 
/*    */   public void close()
/*    */     throws IOException
/*    */   {
/*    */   }
/*    */ }

/* Location:           C:\Users\Miquel Angel Andreu\Downloads\demo\demo\examples\apps\spark\lib\oozie-examples.jar
 * Qualified Name:     org.apache.oozie.example.SampleMapper
 * JD-Core Version:    0.6.2
 */