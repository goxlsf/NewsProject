package com.nowcoder;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
public class test {
    @Test
    public void demo() throws IOException {
        System.out.println("获取训练数据：");
        String FileOut="G:\\gongcheng\\classify\\4.txt";
        BufferedWriter bw=new BufferedWriter(new FileWriter(FileOut));

        //读取目录下的每个文件或者文件夹，并读取文件的内容写到目标文字中去
        File[] list = new File("G:\\gongcheng\\sort\\汽车").listFiles();
        int fileCount = 0;
        int folderConut= 0;
        StringBuffer stringBuffer = new StringBuffer();
        for(File file : list)
        {
            if(file.isFile())
            {
                fileCount++;
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while((line=br.readLine())!=null) {
                    stringBuffer.append(line);
                }
                br.close();
            }else {
                folderConut++;
            }
        }
        String stopWordTable="G:\\gongcheng\\stop\\13.txt";
        FileInputStream in = new FileInputStream(stopWordTable);
        BufferedReader StopWordFileBr =  new BufferedReader(new InputStreamReader(in,"UTF-8"));
        Set stopWordSet = new HashSet<String>();
        String stopWord = null;
        while ((stopWord=StopWordFileBr.readLine())!= null){
            stopWordSet.add(stopWord);
        }
        String title="五人落选后升任高官 周锡玮恭喜民进党再度刷新耻度下限";
        String content=stringBuffer.toString();
        KeyWordComputer kwc = new KeyWordComputer(100);
        Iterator it = kwc.computeArticleTfidf(content).iterator();
        StringBuffer value = new StringBuffer();
        int count = 0;
        while(it.hasNext()) {
            count++;

            Keyword key2=(Keyword)it.next();
            if(stopWordSet.contains(key2.getName())){
                System.out.println("跳过了值："+key2.getName());
                continue;

            }

            value.append(key2.getName()+"\n");

        }

        String out = value.toString();
        String OutValue = out.substring(0, out.length()-1);
        System.out.println(OutValue);

    }
    public static void main(String[] args) {
        classifyTest ct = new classifyTest();
        try {
            ct.demo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


