/*    */ package org.apache.oozie.example;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Iterator;
/*    */ import org.apache.hadoop.io.IntWritable;
/*    */ import org.apache.hadoop.io.Text;
/*    */ import org.apache.hadoop.mapred.MapReduceBase;
/*    */ import org.apache.hadoop.mapred.OutputCollector;
/*    */ import org.apache.hadoop.mapred.Reducer;
/*    */ import org.apache.hadoop.mapred.Reporter;
/*    */ 
/*    */ public class DemoReducer extends MapReduceBase
/*    */   implements Reducer<Text, IntWritable, Text, IntWritable>
/*    */ {
/*    */   public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter)
/*    */     throws IOException
/*    */   {
/* 37 */     int sum = 0;
/* 38 */     while (values.hasNext()) {
/* 39 */       sum += ((IntWritable)values.next()).get();
/*    */     }
/* 41 */     output.collect(key, new IntWritable(sum));
/*    */   }
/*    */ }

/* Location:           C:\Users\Miquel Angel Andreu\Downloads\demo\demo\examples\apps\spark\lib\oozie-examples.jar
 * Qualified Name:     org.apache.oozie.example.DemoReducer
 * JD-Core Version:    0.6.2
 */