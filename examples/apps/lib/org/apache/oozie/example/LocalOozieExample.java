/*     */ package org.apache.oozie.example;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.Properties;
/*     */ import org.apache.hadoop.fs.Path;
/*     */ import org.apache.oozie.client.OozieClient;
/*     */ import org.apache.oozie.client.WorkflowAction;
/*     */ import org.apache.oozie.client.WorkflowJob;
/*     */ import org.apache.oozie.client.WorkflowJob.Status;
/*     */ import org.apache.oozie.local.LocalOozie;
/*     */ 
/*     */ public class LocalOozieExample
/*     */ {
/*     */   public static void main(String[] args)
/*     */   {
/*  35 */     System.exit(execute(args));
/*     */   }
/*     */ 
/*     */   static int execute(String[] args) {
/*  39 */     if (args.length != 2) {
/*  40 */       System.out.println();
/*  41 */       System.out.println("Expected parameters: <WF_APP_HDFS_URI> <WF_PROPERTIES>");
/*  42 */       return -1;
/*     */     }
/*  44 */     String appUri = args[0];
/*  45 */     String propertiesFile = args[1];
/*  46 */     if (propertiesFile != null) {
/*  47 */       File file = new File(propertiesFile);
/*  48 */       if (!file.exists()) {
/*  49 */         System.out.println();
/*  50 */         System.out.println("Specified Properties file does not exist: " + propertiesFile);
/*  51 */         return -1;
/*     */       }
/*  53 */       if (!file.isFile()) {
/*  54 */         System.out.println();
/*  55 */         System.out.println("Specified Properties file is not a file: " + propertiesFile);
/*  56 */         return -1;
/*     */       }
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  62 */       LocalOozie.start();
/*     */ 
/*  65 */       OozieClient wc = LocalOozie.getClient();
/*     */ 
/*  68 */       conf = wc.createConfiguration();
/*  69 */       conf.setProperty("oozie.wf.application.path", new Path(appUri, "workflow.xml").toString());
/*     */ 
/*  71 */       if (propertiesFile != null) {
/*  72 */         conf.load(new FileInputStream(propertiesFile));
/*     */       }
/*     */ 
/*  76 */       String jobId = wc.run(conf);
/*  77 */       Thread.sleep(1000L);
/*  78 */       System.out.println("Workflow job submitted");
/*     */ 
/*  81 */       while (wc.getJobInfo(jobId).getStatus() == WorkflowJob.Status.RUNNING) {
/*  82 */         System.out.println("Workflow job running ...");
/*  83 */         printWorkflowInfo(wc.getJobInfo(jobId));
/*  84 */         Thread.sleep(10000L);
/*     */       }
/*     */ 
/*  88 */       System.out.println("Workflow job completed ...");
/*  89 */       printWorkflowInfo(wc.getJobInfo(jobId));
/*     */ 
/*  91 */       return wc.getJobInfo(jobId).getStatus() == WorkflowJob.Status.SUCCEEDED ? 0 : -1;
/*     */     }
/*     */     catch (Exception ex)
/*     */     {
/*     */       Properties conf;
/*  94 */       System.out.println();
/*  95 */       System.out.println(ex.getMessage());
/*  96 */       return -1;
/*     */     }
/*     */     finally
/*     */     {
/* 100 */       LocalOozie.stop();
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void printWorkflowInfo(WorkflowJob wf) {
/* 105 */     System.out.println("Application Path   : " + wf.getAppPath());
/* 106 */     System.out.println("Application Name   : " + wf.getAppName());
/* 107 */     System.out.println("Application Status : " + wf.getStatus());
/* 108 */     System.out.println("Application Actions:");
/* 109 */     for (WorkflowAction action : wf.getActions()) {
/* 110 */       System.out.println(MessageFormat.format("   Name: {0} Type: {1} Status: {2}", new Object[] { action.getName(), action.getType(), action.getStatus() }));
/*     */     }
/*     */ 
/* 113 */     System.out.println();
/*     */   }
/*     */ }

/* Location:           C:\Users\Miquel Angel Andreu\Downloads\demo\demo\examples\apps\spark\lib\oozie-examples.jar
 * Qualified Name:     org.apache.oozie.example.LocalOozieExample
 * JD-Core Version:    0.6.2
 */