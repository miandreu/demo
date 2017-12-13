/*    */ package org.apache.oozie.example;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.apache.spark.SparkConf;
/*    */ import org.apache.spark.api.java.JavaRDD;
/*    */ import org.apache.spark.api.java.JavaSparkContext;
/*    */ 
/*    */ public final class SparkFileCopy
/*    */ {
/*    */   public static void main(String[] args)
/*    */     throws Exception
/*    */   {
/* 29 */     if (args.length < 2) {
/* 30 */       System.err.println("Usage: SparkFileCopy <file> <file>");
/* 31 */       System.exit(1);
/*    */     }
/*    */ 
/* 34 */     SparkConf sparkConf = new SparkConf().setAppName("SparkFileCopy");
/* 35 */     JavaSparkContext ctx = new JavaSparkContext(sparkConf);
/* 36 */     JavaRDD lines = ctx.textFile(args[0]);
/* 37 */     lines.saveAsTextFile(args[1]);
/* 38 */     System.out.println("Copied file from " + args[0] + " to " + args[1]);
/* 39 */     ctx.stop();
/*    */   }
/*    */ }

/* Location:           C:\Users\Miquel Angel Andreu\Downloads\demo\demo\examples\apps\spark\lib\oozie-examples.jar
 * Qualified Name:     org.apache.oozie.example.SparkFileCopy
 * JD-Core Version:    0.6.2
 */