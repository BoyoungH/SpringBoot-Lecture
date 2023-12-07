package jpabook.jpashop.service;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.exception.NotEnoughStockException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {
    @Autowired
    private ItemService itemService;

    @Test
    public void 상품_등록() throws Exception{
        //given
        Item itemBook = new Book();
        itemBook.setName("JPA");
        //when
        itemService.saveItem(itemBook);
        //then
        assertEquals(itemBook, itemService.findOne(itemBook.getId()));
    }

    @Test
    public void 상품_재고_추가() throws Exception{
        //given
        Item itemBook = new Book();
        itemBook.setName("JPA");
        itemBook.addStockQuantity(10);
        //when
        itemService.saveItem(itemBook);
        //then
        assertEquals(itemBook, itemService.findOne(itemBook.getId()));
    }

    @Test
    public void 상품_재고_삭제() throws Exception{
        //given
        Item itemBook = new Book();
        itemBook.setName("JPA");
        itemBook.addStockQuantity(10);
        itemBook.removeStockQuantity(5);
        //when
        itemService.saveItem(itemBook);
        //then
        assertEquals(itemBook, itemService.findOne(itemBook.getId()));
    }

    @Test(expected = NotEnoughStockException.class)
    public void 상품_재고_삭제_예외() throws Exception{
        //given
        Item itemBook = new Book();
        itemBook.setName("JPA");
        itemBook.addStockQuantity(10);
        itemBook.removeStockQuantity(15);
        //when
        itemService.saveItem(itemBook);
        //then
        assertEquals(itemBook, itemService.findOne(itemBook.getId()));
    }



}