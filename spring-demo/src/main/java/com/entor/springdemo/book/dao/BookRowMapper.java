package com.entor.springdemo.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.entor.springdemo.BookInfo;

/**
 * 书籍行记录映射器
 * 
 * @author Administrator
 *
 */
public class BookRowMapper implements RowMapper<BookInfo> {

	@Override
	public BookInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookInfo info = new BookInfo();
		info.setBid(rs.getInt("b_id"));
		info.setBookName(rs.getString("book_name"));
		info.setAmount(rs.getInt("amount"));
		info.setThumbnail(rs.getString("thumbnail"));
		info.setStatus(rs.getInt("status"));
		return info;
	}

}
