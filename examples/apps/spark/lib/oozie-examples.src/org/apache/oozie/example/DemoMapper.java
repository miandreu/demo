/*    */ package org.apache.oozie.example;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.StringTokenizer;
/*    */ import org.apache.hadoop.io.IntWritable;
/*    */ import org.apache.hadoop.io.LongWritable;
/*    */ import org.apache.hadoop.io.Text;
/*    */ import org.apache.hadoop.mapred.MapReduceBase;
/*    */ import org.apache.hadoop.mapred.Mapper;
/*    */ import org.apache.hadoop.mapred.OutputCollector;
/*    */ import org.apache.hadoop.mapred.Reporter;
/*    */ 
/*    */ public class DemoMapper extends MapReduceBase
/*    */   implements Mapper<LongWritable, Text, Text, IntWritable>
/*    */ {
/* 33 */   private static final IntWritable one = new IntWritable(1);
/* 34 */   private Text word = new Text();
/*    */ 
/*    */   public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
/*    */     throws IOException
/*    */   {
/* 42 */     String line = value.toString();
/* 43 */     StringTokenizer tokenizer = new StringTokenizer(line);
/* 44 */     while (tokenizer.hasMoreTokens()) {
/* 45 */       this.word.set(tokenizer.nextToken());
/* 46 */       output.collect(this.word, one);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Miquel Angel Andreu\Downloads\demo\demo\examples\apps\spark\lib\oozie-examples.jar
 * Qualified Name:     org.apache.oozie.example.DemoMapper
 * JD-Core Version:    0.6.2
 */