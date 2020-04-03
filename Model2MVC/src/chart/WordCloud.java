package chart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WordCloud {
   
   public static void main(String[] args){
      
      
   }
   
   public static String stringLine(String url, String selector, int num){
      
      Document doc = null;
      String output = "";
      
      try{
         doc = Jsoup.connect(url).get();
      } catch (IOException e){
         e.printStackTrace();
      }
      
      String line = doc.data();
      System.out.println(line);
      // line = line.substring(line.indexOf("cardList_wrap"));
      System.out.println(line);
      return line;
   }
   
   public static Map<String, Long> map(String url, String selector, int num){
      
      Document doc = null;
      String output = "";
      List<String> list = new ArrayList();
      Map<String, Long> map = null;
      int count = 0;
      
      try{
         doc = Jsoup.connect(url).get();
      }catch(IOException e1){
         e1.printStackTrace();
      }
      
      Elements titles = doc.select(selector);
      
      for(Element e : titles){
         String line = e.text();
         System.out.println(line);
         line = line.replace(",,", " ");
         line = line.replace("\"", " ");
         line = line.replace("|", " ");
         line = line.replace("씨네21", " ");
         line = line.replace("이주현", " ");
         line = line.replace(",", " ");
         line = line.replace("이", " ");
         line = line.replace("김", " ");
         line = line.replace("과", " ");
         line = line.replace("의", " ");
         line = line.replace("는", " ");
         line = line.replace("허남웅", " ");
         line = line.replace("임수연", " ");
         line = line.replace("혜리", " ");
         line = line.replace("쓴", " ");
         line = line.replace("손재곤", " ");
         line = line.replace("를", "");
         line = line.replace("황진미", " ");
         line = line.replace("박평식", " ");
         line = line.replace("을", "");
         line = line.replaceAll("[0-9]","");
         line = line.replace("&amp;", " ");
         line = line.replace("전도연", "");
         line = line.replace("신고", "");
         line = line.replace("비공감", "");
         line = line.replace("...", "");
         line = line.replace("공감", "");
         line = line.replace("*", "");
         line = line.replace(";", "");
         line = line.replace("!", "");
         line = line.replaceAll("[a-z]", "");
         line = line.replaceAll("[A-Z]", "");
         line = line.replace("(", "");
         line = line.replace(")", "");
         

         
      
         String[] strs = line.split(" ");
         list.addAll(Arrays.asList(strs));
      }
      
      map = list.stream().filter(name -> !name.equals("")).collect(
            Collectors.groupingBy(String::toString, Collectors.mapping(String::toString,  Collectors.counting()))
      );
      
      Map<String, Long> map2 = map.entrySet().stream().sorted(new Comparator<Map.Entry>(){
         @Override
         public int compare(Entry o1, Entry o2){
            long num1 = 0;
            long num2 = 0;
            
            try{
               num1 = (long) (o1.getValue());
               num2 = (long) (o2.getValue());
            } catch(Exception e){
               num1 = 0;
               num2 = 0;
            } finally {
               return (int) (num2-num1);
            }
         }
      })
            
         .collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));
      return map2;
            
   }

}