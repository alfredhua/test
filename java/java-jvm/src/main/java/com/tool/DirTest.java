package com.tool;

import com.common.util.GsonUtils;

import java.io.File;
import java.util.*;

/**
 * @author guozhenhua
 * @date 2021/03/21
 */
public class DirTest {


    public static void main(String[] args) {
        String path="/Users/hua/workspace/self/doc/docs/zh-cn/7.分布式";
        File file = new File(path);

        File[] files = file.listFiles();
        for (File dir:files) {
            if (dir.isDirectory()){
                File file1 = new File(path + "/" + dir.getName());
                String[] list = file1.list();
                List<TitleLink> result=new ArrayList<>();
                for (String subDir:list) {
                    if (!subDir.equals("README.md")&&!subDir.equals("file") && !subDir.equals(".DS_Stohtml"))
                    result.add(new TitleLink(subDir.substring(2,subDir.length()-3),"/zh-cn/docs/7.分布式/"+dir.getName()+"/"+subDir.substring(0,subDir.length()-2)+"html"));
                }
                Collections.sort(result, new Comparator<TitleLink>() {
                    @Override
                    public int compare(TitleLink o1, TitleLink o2) {
                        String a = o1.link.substring(o1.link.lastIndexOf("/"));
                        String b = o2.link.substring(o2.link.lastIndexOf("/"));
//                        System.out.println(a);
                        if (a.equals("/.DS_Stohtml")||b.equals("/.DS_Stohtml")){
                            return 0;
                        }
                        Integer aInt = Integer.valueOf(a.substring(1).split("\\.")[0]);
                        return aInt-Integer.valueOf(b.substring(1).split("\\.")[0]);
                    }
                });
                System.out.println(GsonUtils.gson.toJson(result));
            }
        }
    }


    static class TitleLink{
        String title;
        String link;

        public TitleLink() {
        }

        public TitleLink(String title, String link) {
            this.title = title;
            this.link = link;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }


    }
}
