/*    */ package org.apache.oozie.example;
/*    */ 
/*    */ import org.apache.hadoop.fs.Path;
/*    */ import org.apache.hadoop.mapred.FileInputFormat;
/*    */ import org.apache.hadoop.mapred.FileOutputFormat;
/*    */ import org.apache.hadoop.mapred.JobConf;
/*    */ import org.apache.oozie.action.hadoop.OozieActionConfigurator;
/*    */ import org.apache.oozie.action.hadoop.OozieActionConfiguratorException;
/*    */ 
/*    */ public class SampleOozieActionConfigurator
/*    */   implements OozieActionConfigurator
/*    */ {
/*    */   public void configure(JobConf actionConf)
/*    */     throws OozieActionConfiguratorException
/*    */   {
/* 31 */     if (actionConf.getUser() == null) {
/* 32 */       throw new OozieActionConfiguratorException("No user set");
/*    */     }
/* 34 */     if (actionConf.get("examples.root") == null) {
/* 35 */       throw new OozieActionConfiguratorException("examples.root not set");
/*    */     }
/* 37 */     if (actionConf.get("output.dir.name") == null) {
/* 38 */       throw new OozieActionConfiguratorException("output.dir.name not set");
/*    */     }
/*    */ 
/* 41 */     actionConf.setMapperClass(SampleMapper.class);
/* 42 */     actionConf.setReducerClass(SampleReducer.class);
/* 43 */     actionConf.setNumMapTasks(1);
/* 44 */     FileInputFormat.setInputPaths(actionConf, new Path[] { new Path("/user/" + actionConf.getUser() + "/" + actionConf.get("examples.root") + "/input-data/text") });
/*    */ 
/* 46 */     FileOutputFormat.setOutputPath(actionConf, new Path("/user/" + actionConf.getUser() + "/" + actionConf.get("examples.root") + "/output-data/" + actionConf.get("output.dir.name")));
/*    */   }
/*    */ }

/* Location:           C:\Users\Miquel Angel Andreu\Downloads\demo\demo\examples\apps\spark\lib\oozie-examples.jar
 * Qualified Name:     org.apache.oozie.example.SampleOozieActionConfigurator
 * JD-Core Version:    0.6.2
 */