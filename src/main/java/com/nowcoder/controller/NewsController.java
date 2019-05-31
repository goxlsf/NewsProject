package com.nowcoder.controller;

import com.nowcoder.model.*;
import com.nowcoder.service.*;
import com.nowcoder.util.ToutiaoUtil;
import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by nowcoder on 2016/7/2.
 */
@Controller
public class NewsController {
    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);
    @Autowired
    NewsService newsService;

    @Autowired
    QiniuService qiniuService;

    @Autowired
    HostHolder hostHolder;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @Autowired
    LikeService likeService;

    private int max(int[] v) {
        int a = 0, b = 0;
        for (int i = 1; i < 15; i++) {
            if (v[i] > b) {
                b = v[i];
                a = i;
            }
        }
            return a;
    }

    public int demo(String Title,String Content) throws IOException {
        String title = Title;
        String content = Content;
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
        KeyWordComputer kwc = new KeyWordComputer(10);
        Iterator it = kwc.computeArticleTfidf(title,content).iterator();
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
            /*case 1:System.out.println("国内");break;
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
            case 12:System.out.println("房产");break;*/
        return max(v);



    }
    @RequestMapping(path = {"/news/{newsId}"}, method = {RequestMethod.GET})
    public String newsDetail(@PathVariable("newsId") int newsId, Model model) {
        News news = newsService.getById(newsId);
        if (news != null) {
            int localUserId = hostHolder.getUser() != null ? hostHolder.getUser().getId() : 0;
            if (localUserId != 0) {
                model.addAttribute("like", likeService.getLikeStatus(localUserId, EntityType.ENTITY_NEWS, news.getId()));
            } else {
                model.addAttribute("like", 0);
            }
            // 评论
            List<Comment> comments = commentService.getCommentsByEntity(news.getId(), EntityType.ENTITY_NEWS);
            List<ViewObject> commentVOs = new ArrayList<ViewObject>();
            for (Comment comment : comments) {
                ViewObject vo = new ViewObject();
                vo.set("comment", comment);
                vo.set("user", userService.getUser(comment.getUserId()));
                commentVOs.add(vo);
            }
            model.addAttribute("comments", commentVOs);
        }
        model.addAttribute("news", news);
        model.addAttribute("owner", userService.getUser(news.getUserId()));
        return "detail";
    }

    @RequestMapping(path = {"/addComment"}, method = {RequestMethod.POST})
    public String addComment(@RequestParam("newsId") int newsId,
                             @RequestParam("content") String content) {
        try {
            content = HtmlUtils.htmlEscape(content);
            // 过滤content
            Comment comment = new Comment();
            comment.setUserId(hostHolder.getUser().getId());
            comment.setContent(content);
            comment.setEntityId(newsId);
            comment.setEntityType(EntityType.ENTITY_NEWS);
            comment.setCreatedDate(new Date());
            comment.setStatus(0);

            commentService.addComment(comment);
            // 更新news里的评论数量
            int count = commentService.getCommentCount(comment.getEntityId(), comment.getEntityType());
            newsService.updateCommentCount(comment.getEntityId(), count);
            // 怎么异步化
        } catch (Exception e) {
            logger.error("增加评论失败" + e.getMessage());
        }
        return "redirect:/news/" + String.valueOf(newsId);
    }


    @RequestMapping(path = {"/image"}, method = {RequestMethod.GET})
    @ResponseBody
    public void getImage(@RequestParam("name") String imageName,
                         HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");
            StreamUtils.copy(new FileInputStream(new
                    File(ToutiaoUtil.IMAGE_DIR + imageName)), response.getOutputStream());
        } catch (Exception e) {
            logger.error("读取图片错误" + imageName + e.getMessage());
        }
    }

    @RequestMapping(path = {"/uploadImage/"}, method = {RequestMethod.POST})
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = newsService.saveImage(file);
            //String fileUrl = qiniuService.saveImage(file);
            if (fileUrl == null) {
                return ToutiaoUtil.getJSONString(1, "上传图片失败");
            }
            return ToutiaoUtil.getJSONString(0, fileUrl);
        } catch (Exception e) {
            logger.error("上传图片失败" + e.getMessage());
            return ToutiaoUtil.getJSONString(1, "上传失败");
        }
    }

    @RequestMapping(path = {"/user/addNews/"}, method = {RequestMethod.POST})
    @ResponseBody
    public String addNews(@RequestParam("image") String image,
                          @RequestParam("title") String title,
                          @RequestParam("content") String content) {
        try {
            News news = new News();
            news.setModuleId(demo(title,content));
            news.setCreatedDate(new Date());
            news.setTitle(title);
            news.setImage(image);
            news.setContent(content);
            if (hostHolder.getUser() != null) {
                news.setUserId(hostHolder.getUser().getId());
            } else {
                // 设置一个匿名用户
                news.setUserId(3);
            }
            newsService.addNews(news);
            return ToutiaoUtil.getJSONString(0);
        } catch (Exception e) {
            logger.error("添加资讯失败" + e.getMessage());
            return ToutiaoUtil.getJSONString(1, "发布失败");
        }
    }
}
