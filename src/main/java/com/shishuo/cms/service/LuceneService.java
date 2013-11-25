package com.shishuo.cms.service;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

/**
 * Lucene 搜索
 * 
 * @author Herbert
 * 
 */
public class LuceneService {

	public static void main(String[] args) throws IOException, ParseException {
		// 一、创建索引
		// 内存索引模板
		Directory dir = new RAMDirectory();
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);

		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_45,
				analyzer);
		IndexWriter indexWriter = new IndexWriter(dir, config);

		Document doc = new Document();
		String title = "标题";
		String content = "被索引的内容";
		Field f1 = new Field("title", title, TextField.TYPE_STORED);
		Field f2 = new Field("content", content, TextField.TYPE_STORED);
		doc.add(f1);
		doc.add(f2);

		indexWriter.addDocument(doc);
		indexWriter.close();

		// 二、搜索
		DirectoryReader directoryReader = DirectoryReader.open(dir);
		IndexSearcher indexSearcher = new IndexSearcher(directoryReader);

		QueryParser parser = new QueryParser(Version.LUCENE_45, "content",
				analyzer);
		Query query = parser.parse("内容");

		TopDocs topDocs = indexSearcher.search(query, null, 100);
		ScoreDoc[] hits = topDocs.scoreDocs;

		System.out.println("查询结果数：" + hits.length);

		for (int n = 0; n < hits.length; n++) {
			Document hitDoc = indexSearcher.doc(hits[n].doc);
			System.out.println("搜索的结果title：" + hitDoc.get("title"));
		}
	}

}
