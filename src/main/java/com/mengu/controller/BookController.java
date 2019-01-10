package com.mengu.controller;

import com.mengu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Controller
 *
 * @author mengu
 * @date 2018/11/13
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

}
