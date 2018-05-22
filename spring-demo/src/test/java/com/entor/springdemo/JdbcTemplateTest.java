package com.entor.springdemo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entor.springdemo.book.dao.BookDAO;

@ContextConfiguration(locations = { "classpath:spring-jdbc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcTemplateTest {

	@Resource
	private BookDAO bookDAO;

	@Test
	public void testCount() {
		System.out.println(bookDAO.count());
	}

	@Test
	public void testSelctById() {
		System.out.println(bookDAO.selectByBookId(1));
	}

	@Test
	public void testGetAll() {
		System.out.println(bookDAO.getAll());
	}

	@Test
	public void testSaveBook() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setBookName("三体");
		bookInfo.setAmount(123);
		bookInfo.setThumbnail("santi.png");
		bookInfo.setStatus(0);

		bookDAO.insertBook(bookInfo);
	}

	@Test
	public void testUpdateStatusById() {
		bookDAO.updateStatusById(1, 1);
	}

	@Test
	public void testDeleteById() {
		bookDAO.deleteBook(5);
	}

	@Test
	public void testBatchDelete() {
		bookDAO.batchDeleteByIds(new String[] { "2", "3" });
	}
}
