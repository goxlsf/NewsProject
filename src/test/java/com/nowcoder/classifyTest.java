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
public class classifyTest {
    public int max(int[] v){
        int a=0,b=0;
        for (int i = 1; i < 15; i++) {
            if (v[i]>b){
                b=v[i];
                a=i;
            }
        }
        return a;
    }
    @Test
    public void demo() throws IOException {
        System.out.println("获取训练数据：");
        String stopWordTable="G:\\gongcheng\\stop\\13.txt";
        FileInputStream in = new FileInputStream(stopWordTable);
        BufferedReader StopWordFileBr =  new BufferedReader(new InputStreamReader(in,"UTF-8"));
        Set stopWordSet = new HashSet<String>();
        String stopWord = null;
        while ((stopWord=StopWordFileBr.readLine())!= null){
            stopWordSet.add(stopWord);
        }
        Set keyWordSet1 = new HashSet<String>();
        Set keyWordSet2 = new HashSet<String>();
        Set keyWordSet3 = new HashSet<String>();
        Set keyWordSet4 = new HashSet<String>();
        Set keyWordSet5 = new HashSet<String>();
        Set keyWordSet6 = new HashSet<String>();
        Set keyWordSet7 = new HashSet<String>();
        Set keyWordSet8 = new HashSet<String>();
        Set keyWordSet9 = new HashSet<String>();
        Set keyWordSet10 = new HashSet<String>();
        Set keyWordSet11 = new HashSet<String>();
        Set keyWordSet12 = new HashSet<String>();
        BufferedReader bufferedWriter1 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\1.txt"));
        BufferedReader bufferedWriter2 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\2.txt"));
        BufferedReader bufferedWriter3 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\3.txt"));
        BufferedReader bufferedWriter4 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\4.txt"));
        BufferedReader bufferedWriter5 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\5.txt"));
        BufferedReader bufferedWriter6 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\6.txt"));
        BufferedReader bufferedWriter7 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\7.txt"));
        BufferedReader bufferedWriter8 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\8.txt"));
        BufferedReader bufferedWriter9 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\9.txt"));
        BufferedReader bufferedWriter10 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\10.txt"));
        BufferedReader bufferedWriter11 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\11.txt"));
        BufferedReader bufferedWriter12 = new BufferedReader(new FileReader("G:\\gongcheng\\classify\\12.txt"));
        String line = new String();
        while ((line=bufferedWriter1.readLine())!=null){
            keyWordSet1.add(line);
        }
        while ((line=bufferedWriter2.readLine())!=null){
            keyWordSet2.add(line);
        }
        while ((line=bufferedWriter3.readLine())!=null){
            keyWordSet3.add(line);
        }
        while ((line=bufferedWriter4.readLine())!=null){
            keyWordSet4.add(line);
        }
        while ((line=bufferedWriter5.readLine())!=null){
            keyWordSet5.add(line);
        }
        while ((line=bufferedWriter6.readLine())!=null){
            keyWordSet6.add(line);
        }
        while ((line=bufferedWriter7.readLine())!=null){
            keyWordSet7.add(line);
        }
        while ((line=bufferedWriter8.readLine())!=null){
            keyWordSet8.add(line);
        }
        while ((line=bufferedWriter9.readLine())!=null){
            keyWordSet9.add(line);
        }
        while ((line=bufferedWriter10.readLine())!=null){
            keyWordSet10.add(line);
        }
        while ((line=bufferedWriter11.readLine())!=null){
            keyWordSet11.add(line);
        }
        while ((line=bufferedWriter12.readLine())!=null){
            keyWordSet12.add(line);
        }

        int[][] val = new int[200][200];
        String title="孕妈妈在怀孕多久后才会显怀，显怀晚的原因你都知道吗？";
        String content= "对于显怀了孕妈妈可能会有着什么独特的见解，孕中期左右孕妈妈最显怀的特征，也就是胖肚子随着胎儿在妈妈肚子里一天天的发育，那么妈妈的肚子也就会慢慢的变得，在这个时候，孕妈妈隆起的肚子也就会非常的明显了，我们称之为显怀，那么每个妈妈都会经历喜欢这样的事情，大约在几个月孕妈妈的肚子才会喜欢那么喜欢的原因到底是什么？\n" +
                "\n" +
                "显怀还是需要一定的时间，那么在正常的情况下，孕妈妈怀孕到达四个月之后，肚子也就会慢慢的大起来了，大约在这个时候也就是简化的一个时候了，但是喜欢也是因人而异的，之所以怀孕四个月以后再显怀原因是比较简单的，因为在怀孕的前三个月胎儿在妈妈的肚子里不安全，另一个重要的原因就是因为怀孕前期的三个月妈妈不适应怀孕，因此有着巨大的一个妊娠的反应，从而导致妈妈的胃口不好，身体非常的虚，肚子也就会增大，看起来并不是很明显。\n" +
                "\n" +
                "在一般情况下影响到孕妈妈先还的原因也是有一些的，第一个就是遗传因素的影响，宝宝的大小身高一般和父母其实是差不多的，胎儿的大小也就会受到妈妈自身的一个条件的影响，那么这也就是比较正常的范围，身材娇小的妈妈，可能印度普遍会偏小一点，身材肥胖的孕肚也就会比较大。\n" +
                "\n" +
                "在正常情况下，那么在别的因素都是有着一定的情况下，因为妈妈的羊水较多，那么妈妈的肚子也就会比较大，如果是羊水比较少的时候，孕妈妈的肚子也就会小一些，羊水最大的一个垂直深度在三厘米到8厘米左右的一个正常值，孕妈妈在产检的时候也就能够知道自己的羊水的情况。\n" +
                "\n" +
                "妈妈的营养摄入和生活的习惯也就会影响到妈妈的肚子在响，胎儿的营养都是源于母体，如果是在怀孕的时候营养摄入的少，那么就会造成营养不良，因此也就会影响到宝宝的发育，有的妈妈在饮食上控制的非常的好，摄入的营养会被宝宝吸收，这样的妈妈肚子也就会比较小，如果是妈妈怀孕前有吸烟喝酒的行为，并且怀孕以后还在坚持的话，对于宝宝的发育就会带来很大的影响，慢慢的肚子要比正常人小一些。";
        KeyWordComputer kwc = new KeyWordComputer(10);
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
            if(keyWordSet1.contains(key2.getName()))
            {
                int x = 0;
                while (val[1][x]!=0){
                   x++;
                }
                val[1][x]=key2.getFreq();
                System.out.println("国内" + key2.getFreq());
            }
            else if(keyWordSet2.contains(key2.getName()))
            {
                int x = 0;
                while (val[2][x]!=0){
                    x++;
                }
                val[2][x]=key2.getFreq();
                System.out.println("国际" + key2.getFreq());
            }
            else if(keyWordSet3.contains(key2.getName()))
            {
                int x = 0;
                while (val[3][x]!=0){
                    x++;
                }
                val[3][x]=key2.getFreq();
                System.out.println("军事" + key2.getFreq());
            }
            else if(keyWordSet4.contains(key2.getName()))
            {
                int x = 0;
                while (val[4][x]!=0){
                    x++;
                }
                val[4][x]=key2.getFreq();
                System.out.println("财经" + key2.getFreq());
            }
            else if(keyWordSet5.contains(key2.getName()))
            {
                int x = 0;
                while (val[5][x]!=0){
                    x++;
                }
                val[5][x]=key2.getFreq();
                System.out.println("娱乐" + key2.getFreq());
            }
            else if(keyWordSet6.contains(key2.getName()))
            {
                int x = 0;
                while (val[6][x]!=0){
                    x++;
                }
                val[6][x]=key2.getFreq();
                System.out.println("体育" + key2.getFreq());
            }
            else if(keyWordSet7.contains(key2.getName()))
            {
                int x = 0;
                while (val[7][x]!=0){
                    x++;
                }
                val[7][x]=key2.getFreq();
                System.out.println("互联网" + key2.getFreq());
            }
            else if(keyWordSet8.contains(key2.getName()))
            {
                int x = 0;
                while (val[8][x]!=0){
                    x++;
                }
                val[8][x]=key2.getFreq();
                System.out.println("科技" + key2.getFreq());
            }
            else if(keyWordSet9.contains(key2.getName()))
            {
                int x = 0;
                while (val[9][x]!=0){
                    x++;
                }
                val[9][x]=key2.getFreq();
                System.out.println("游戏" + key2.getFreq());
            }
            else if(keyWordSet10.contains(key2.getName()))
            {
                int x = 0;
                while (val[10][x]!=0){
                    x++;
                }
                val[10][x]=key2.getFreq();
                System.out.println("女人" + key2.getFreq());
            }
            else if(keyWordSet11.contains(key2.getName()))
            {
                int x = 0;
                while (val[11][x]!=0){
                    x++;
                }
                val[11][x]=key2.getFreq();
                System.out.println("汽车" + key2.getFreq());
            }
            else if(keyWordSet12.contains(key2.getName()))
            {
                int x = 0;
                while (val[12][x]!=0){
                    x++;
                }
                val[12][x]=key2.getFreq();
                System.out.println("房产" + key2.getFreq());
            }
            else{
                int x = 0;
                while (val[5][x]!=0){
                    x++;
                }
                val[5][x]=key2.getFreq();
                System.out.println("娱乐" + key2.getFreq());
            }
            value.append(key2.getName()+"="+key2.getFreq()+" ");
        }
        String out = value.toString();
        String OutValue = out.substring(0, out.length()-1);
        System.out.println(OutValue);
        int[] v = new int[20];
        for (int i = 1; i<=12;i++){
            int x = 0;
            while (val[i][x]!=0){
                v[i]+=val[i][x];
                x++;
            }
        }
        switch (max(v)){
            case 1:System.out.println("国内");break;
            case 2:System.out.println("国际");break;
            case 3:System.out.println("军事");break;
            case 4:System.out.println("财经");break;
            case 5:System.out.println("娱乐");break;
            case 6:System.out.println("体育");break;
            case 7:System.out.println("互联网");break;
            case 8:System.out.println("科技");break;
            case 9:System.out.println("游戏");break;
            case 10:System.out.println("女人");break;
            case 11:System.out.println("汽车");break;
            case 12:System.out.println("房产");break;
        }



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


