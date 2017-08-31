package org.study.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.study.lucene.util.JdbcUtil;

import java.nio.file.FileSystems;
import java.sql.ResultSet;

/**
 * Created by ArnoldLee on 17/8/25.
 */
public class DbSearchDemo {

    public static final String INDEX_PATH = "/Users/ArnoldLee/logs/lucene-db";
    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/sims?useUnicode=true&amp;characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull";
    public static final String USER = "root";
    public static final String PWD = "1111111a";

    /**
     * 创建索引
     */
    public void creatIndex() {
        IndexWriter indexWriter = null;
        try {
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(INDEX_PATH));
            //Analyzer analyzer = new StandardAnalyzer();
            Analyzer analyzer = new SmartChineseAnalyzer(true);
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
            indexWriter = new IndexWriter(directory, indexWriterConfig);
            indexWriter.deleteAll();// 清除以前的index

            JdbcUtil jdbc = new JdbcUtil(JDBC_URL, USER, PWD);
            ResultSet rs = jdbc.query("select * from sims_customer_import");
            while (rs.next()) {
                Document document = new Document();
                document.add(new Field("pkid", rs.getString("pkid"), TextField.TYPE_STORED));
                document.add(new Field("name", rs.getString("name"), TextField.TYPE_STORED));
                document.add(new Field("card_no", rs.getString("card_no"), TextField.TYPE_STORED));
                document.add(new Field("sex", rs.getString("sex"), TextField.TYPE_STORED));
                document.add(new Field("exam_time", rs.getString("exam_time"), TextField.TYPE_STORED));
                indexWriter.addDocument(document);
            }
            jdbc.closeAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (indexWriter != null) indexWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 搜索
     */
    public void search(String keyWord) {
        DirectoryReader directoryReader = null;
        try {
            // 1、创建Directory
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(INDEX_PATH));
            // 2、创建IndexReader
            directoryReader = DirectoryReader.open(directory);
            // 3、根据IndexReader创建IndexSearch
            IndexSearcher indexSearcher = new IndexSearcher(directoryReader);
            // 4、创建搜索的Query
            // Analyzer analyzer = new StandardAnalyzer();
            Analyzer analyzer = new SmartChineseAnalyzer(true); // 使用IK分词

            // 简单的查询，创建Query表示搜索域为content包含keyWord的文档
            //Query query = new QueryParser("content", analyzer).parse(keyWord);

            String[] fields = {"name", "card_no", "exam_time"};
            // MUST 表示and，MUST_NOT 表示not ，SHOULD表示or
            BooleanClause.Occur[] clauses = {BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD};
            // MultiFieldQueryParser表示多个域解析， 同时可以解析含空格的字符串，如果我们搜索"上海 中国"
            Query multiFieldQuery = MultiFieldQueryParser.parse(keyWord, fields, clauses, analyzer);

            // 5、根据searcher搜索并且返回TopDocs
            TopDocs topDocs = indexSearcher.search(multiFieldQuery, 100); // 搜索前100条结果
            System.out.println("共找到匹配处：" + topDocs.totalHits);
            // 6、根据TopDocs获取ScoreDoc对象
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            System.out.println("共找到匹配文档数：" + scoreDocs.length);

            QueryScorer scorer = new QueryScorer(multiFieldQuery, "name");
            SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter("<span style=\"backgroud:red\">", "</span>");
            Highlighter highlighter = new Highlighter(htmlFormatter, scorer);
            highlighter.setTextFragmenter(new SimpleSpanFragmenter(scorer));
            for (ScoreDoc scoreDoc : scoreDocs) {
                // 7、根据searcher和ScoreDoc对象获取具体的Document对象
                Document document = indexSearcher.doc(scoreDoc.doc);
                String content = document.get("name");
                //TokenStream tokenStream = new SimpleAnalyzer().tokenStream("content", new StringReader(content));
                //TokenSources.getTokenStream("content", tvFields, content, analyzer, 100);
                //TokenStream tokenStream = TokenSources.getAnyTokenStream(indexSearcher.getIndexReader(), scoreDoc.doc, "content", document, analyzer);
                //System.out.println(highlighter.getBestFragment(tokenStream, content));
                System.out.println("-----------------------------------------");
                System.out.println("身份证号：" + document.get("card_no"));
                System.out.println("考试时间：" + document.get("exam_time"));
                System.out.println("姓名：");
                System.out.println(highlighter.getBestFragment(analyzer, "name", content));
                System.out.println("");
                // 8、根据Document对象获取需要的值
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (directoryReader != null) directoryReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        DbSearchDemo demo = new DbSearchDemo();
        //demo.creatIndex();
        demo.search("齐心");
    }
}
