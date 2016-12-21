package com.yhq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.kit.StrKit;
import com.me.model.Message;
import com.yhq.dao.BookDao;
import com.yhq.model.Book;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao;
	
	/**
	 * 获取所有的书本
	 * @return
	 */
	@SuppressWarnings({ "static-access" })
	public Message getAllBook() {
		Message message = new Message();
		List<Book> books = bookDao.findAllBook();
		if(books != null && books.size() > 0) {
			message.success("查找所有书本成功");
			message.dataPut("books", books);
		}
		else {
			message.error("查找所有书本失败");
		}
		return message;
	}
	
	/**
	 * 查找部分书本
	 * 根据传入的type
	 * @param type
	 * @return
	 */
	@SuppressWarnings("static-access")
	public Message getBookByType(String type) {
		Message message = new Message();
		List<Book> books = bookDao.findBookByType(type);
		if(books != null && books.size() > 0) {
			message.success("查找书本成功");
			message.dataPut("books", books);
		}
		else {
			message.error("查找书本失败");
		}
		return message;
	}
	
	/**
	 * 删除书本
	 * @param id
	 * @return
	 */
	public Message deleteBook(Long id) {
		Message message = null;
		if(bookDao.deleteBook(id)) {
			message = Message.success("删除成功！");
		}
		else {
			message = Message.error("删除失败！");
		}
		return message;
	}
}
