package com.yizhilu.core.test;

/**
 * @ClassName  com.yizhilu.core.test.FileDisk
 * @description
 * @author : qinggang.liu voo@163.com
 * @Create Date : 2014-2-27 上午11:18:57
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;




public class FileDisk {
    public static void main(String[] args) {
        FileDisk f=new FileDisk();
        System.out.println("start");
        f.PrintDisk("D:/test");
        f.addHeadFoot("D:/test");
        System.out.println("end");

    }
    
    public void PrintDisk(String Diskfile)
    {
        File FirstFile;
        @SuppressWarnings("unused")
        String FirstName=null;//一级目录
        String SecondName=null;//二级目录
        String ThreeName=null;//三级目录
        String FourName=null;//四级目录
        FirstFile=new File(Diskfile);
        if(FirstFile.exists()){//判断文件是否存在
            if(FirstFile.isDirectory()){//如果它是一个目录  
                File FirstFiles[] = FirstFile.listFiles();//声明电教设目录下所有的文件 files[];
                FirstName=FirstFile.getName();//获取一级目录名
                for(int i=0;i<FirstFiles.length;i++){            //遍历电教设目录下所有的文件     
                      if(FirstFiles[i].isDirectory())
                      {
                          File SecondFiles[] = FirstFiles[i].listFiles();//声明二级目录下所有的文件 files[];
                          SecondName=FirstFiles[i].getName();//获取二级目录名
                          for(int j=0;j<SecondFiles.length;j++){            //遍历二级目录下所有的文件     
                                if(SecondFiles[j].isDirectory())
                                {
                                    File ThreeFiles[] = SecondFiles[j].listFiles();//声明三级目录下所有的文件 files[];
                                    ThreeName=SecondFiles[j].getName();//获取三级目录名
                                     for(int k=0;k<ThreeFiles.length;k++){            //遍历三级目录下所有的文件     
                                            if(ThreeFiles[k].isDirectory())
                                            {
                                                File FourFiles[] = ThreeFiles[k].listFiles();//声明四级目录下所有的文件 files[];
                                                FourName=ThreeFiles[k].getName();//获取四级目录名
                                                
                                                try {
                                                    FileWriter fw=new FileWriter(ThreeFiles[k].getAbsolutePath()+"/"+"生成文件.txt");
                                                    BufferedWriter bw=new BufferedWriter(fw);
                                                    bw.write("=======================================");
                                                    bw.newLine();
                                                    bw.write(SecondName+" "+ThreeName+" "+FourName+"：");
                                                    for(int l=0;l<FourFiles.length;l++){
                                                        
                                                        if(FourFiles[l].isDirectory())
                                                        {
                                                            bw.newLine();
                                                            bw.write(FourFiles[l].getName());//输出四级目录下的目录名
                                                        }
                                                        
                                                    }
                                                    bw.newLine();
                                                    bw.write("=======================================");
                                                    bw.flush();
                                                    fw.close();
                                                } catch (IOException e) {
                                                    // TODO Auto-generated catch block
                                                    e.printStackTrace();
                                                }
                                                
                                                
                                                
                                                
                                                
                                            }
                                      }
                                }
                          }
                      }
                }
                 
            }
        }
        
    }
    public void addHeadFoot(String Diskfile)//添加头尾并生成新文件
    {
        
        File FirstFile;
        String FirstName=Diskfile+"/";//一级目录
        String SecondName=null;//二级目录
        String ThreeName=null;//三级目录
        String FourName=null;//四级目录
        String FiveName=null;//四级目录
        String PathName=null;
        FirstFile=new File(Diskfile);
        if(FirstFile.exists()){//判断文件是否存在
            if(FirstFile.isDirectory()){//如果它是一个目录  
                File FirstFiles[] = FirstFile.listFiles();//声明电教设目录下所有的文件 files[];
                
                for(int i=0;i<FirstFiles.length;i++){            //遍历电教设目录下所有的文件     
                      if(FirstFiles[i].isDirectory())
                      {
                          File SecondFiles[] = FirstFiles[i].listFiles();//声明二级目录下所有的文件 files[];
                          SecondName=FirstFiles[i].getName()+"/";
                          for(int j=0;j<SecondFiles.length;j++){            //遍历二级目录下所有的文件     
                                if(SecondFiles[j].isDirectory())
                                {
                                    File ThreeFiles[] = SecondFiles[j].listFiles();//声明三级目录下所有的文件 files[];
                                    ThreeName=SecondFiles[j].getName()+"/";
                                     for(int k=0;k<ThreeFiles.length;k++){            //遍历三级目录下所有的文件     
                                            if(ThreeFiles[k].isDirectory())
                                            {
                                                File FourFiles[] = ThreeFiles[k].listFiles();//声明四级目录下所有的文件 files[];
                                                FourName=ThreeFiles[k].getName()+"/";
                                                for(int l=0;l<FourFiles.length;l++){            //遍历四级目录下所有的文件     
                                                    if(FourFiles[l].isDirectory())
                                                    {
                                                        File FiveFiles[] = FourFiles[l].listFiles();//声明五级目录下所有的文件 files[];
                                                        FiveName=FourFiles[l].getName()+"/";
                                                        for(int m=0;m<FiveFiles.length;m++)
                                                        {
                                                                    PathName=FirstName+SecondName+ThreeName+FourName+FiveName;
                                                                    int beginIndex=FiveFiles[m].getName().indexOf(".");
                                                                    int endIndex=FiveFiles[m].getName().length();
                                                                    if(FiveFiles[m].getName().substring(beginIndex,endIndex ).endsWith(".wmv"))
                                                                    {
                                                                        FiveFiles[m].renameTo(new File(PathName+"/video.wmv"));
                                                                    }else
                                                                    {
                                                                        if((FiveFiles[m].getName().indexOf("反思")>-1 )&&FiveFiles[m].getName().substring(beginIndex, endIndex).equals(".txt"))
                                                                        {
                                                                            
                                                                            File fansi=new File(PathName+"/word_fansi.html");
                                                                            
                                                                            File headFile=new File(Diskfile+"/word_head.txt");
                                                                            File footFile=new File(Diskfile+"/word_footer.txt");
                                                                            
                                                                            addContext(headFile,fansi);//调用添加文件头方法
                                                                            addContext(FiveFiles[m],fansi);//添加文件内容
                                                                            addContext(footFile,fansi);//添加尾部内容
                                                                            
                                                                        }else if((FiveFiles[m].getName().indexOf("设计")>-1) &&FiveFiles[m].getName().substring(beginIndex, endIndex).equals(".txt"))
                                                                        {
                                                                            File sheji=new File(PathName+"/word_sheji.html");
                                                                            
                                                                            File headFile=new File(Diskfile+"/word_head.txt");
                                                                            File footFile=new File(Diskfile+"/word_footer.txt");
                                                                            addContext(headFile,sheji);//调用添加文件头方法
                                                                            addContext(FiveFiles[m],sheji);//添加文件内容
                                                                            addContext(footFile,sheji);//添加尾部内容
                                                                            
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            
                                                        }
                                                        
                                                        
                                                        
                                                    }
                                              }
                                                
                                                
                                                
                                                
                                }
                          }
                      }
                }
                 
            }
        }
    }
    
    public void addContext(File Rfile,File Wfile)//传递读文件和写文件进行内容添加
    {
        BufferedReader br;
        
        try {
            
            br = new BufferedReader(new InputStreamReader(new FileInputStream(Rfile.getAbsoluteFile()),"UTF-8"));
            FileWriter fw=new FileWriter(Wfile.getAbsoluteFile(),true);
            BufferedWriter bw=new BufferedWriter(fw);
            String line=br.readLine();
            while(line!=null)
            {
                System.out.println(line);
                bw.write(line);
                bw.newLine();
                line=br.readLine();
            }
            br.close();
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}    