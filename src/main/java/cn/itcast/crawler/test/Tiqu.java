package cn.itcast.crawler.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tiqu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入网址：");
        String url = scanner.nextLine();

        System.out.print("请输入保存文件的路径：");
        String filePath = scanner.nextLine();

        try {
            // 发起HTTP请求并获取网页内容
            Document doc = Jsoup.connect(url).get();

            // 提取网页中的文本内容
            Elements elements = doc.select("p"); // 假设文本内容都包含在<p>标签中
            StringBuilder content = new StringBuilder();
            for (Element element : elements) {
                content.append(element.text()).append("\n");
            }

            // 保存提取的内容到文本文件
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content.toString());
            writer.close();

            System.out.println("文本内容提取成功并保存至文件：" + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            // 处理异常情况
        }
    }
}
