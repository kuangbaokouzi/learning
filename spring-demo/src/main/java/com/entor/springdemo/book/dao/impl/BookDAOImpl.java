package com.entor.springdemo.book.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.entor.springdemo.BookInfo;
import com.entor.springdemo.book.dao.BookDAO;
import com.entor.springdemo.book.dao.BookRowMapper;

public class BookDAOImpl implements BookDAO {
	private static final Logger LOGGER = LogManager.getLogger();

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<BookInfo> getAll() {
		return this.jdbcTemplate.query("select * from book_info", new BookRowMapper());
	}

	@Override
	public Integer count() {
		return this.jdbcTemplate.queryForObject("select count(*) from book_info", Integer.class);
	}

	@Override
	public BookInfo selectByBookId(Integer bookId) {
		return this.jdbcTemplate.queryForObject("select * from book_info where b_id = ?", new Object[] { bookId },
				new BookRowMapper());
	}

	@Override
	public BookInfo selectByIdAndStatus(int bid, int status) {
		String sql = "select * from book_info where b_id = ? and status=?";
		return null;
	}

	@Override
	public List<BookInfo> selectByBookName(String bookName) {
		String sql = "select * from book_info where book_name like ?";
		return null;
	}

	@Override
	public Integer getMaxId() {
		return 0;
	}

	@Override
	public void insertBook(BookInfo bookInfo) {
		this.jdbcTemplate.update("insert into book_info(book_name,amount,thumbnail,status) values(?,?,?,?)",
				bookInfo.getBookName(), bookInfo.getAmount(), bookInfo.getThumbnail(), bookInfo.getStatus());
	}

	@Override
	public void deleteBook(Integer bid) {
		this.jdbcTemplate.update("delete from book_info where b_id=?", bid);
	}

	@Override
	public void updateStatusById(int bid, int status) {
		this.jdbcTemplate.update("update book_info set status=? where b_id=?", status, bid);
	}

	@Override
	public void updateBookInfo(BookInfo newBook) {
		String sql = "update book_info set book_name=?, amount=? status=? where b_id=?";
	}

	@Override
	public void updateThumbnailById(Integer bid, String thumbnail) {
		String sql = "update book_info set thumbnail=? where b_id=?";
	}

	@Override
	public void batchDeleteByIds(String[] ids) {
		List<Object[]> paramList = new ArrayList<>();
		for (String param : ids) {
			paramList.add(new Object[] { Integer.parseInt(param) });
		}
		this.jdbcTemplate.batchUpdate("delete from book_info where b_id=?", paramList);
	}

	@Override
	public void reduceBookAmount(int bid) {
		String sql = "update book_info set amount = amount - 1 where b_id=?";
	}

	@Override
	public void increaseBookAmount(int bid) {
		String sql = "update book_info set amount = amount + 1 where b_id=?";
	}

}
