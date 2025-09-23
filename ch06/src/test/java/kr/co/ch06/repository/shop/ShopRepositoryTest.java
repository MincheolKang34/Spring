package kr.co.ch06.repository.shop;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.ch06.dto.ProductAggDTO;
import kr.co.ch06.entity.shop.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ShopRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test1() {
        Customer customer = customerRepository.selectCustomer("a105");
        System.out.println(customer);
    }

    @Test
    public void test2() {
        List<Customer> customerList = customerRepository.selectAllCustomer();
        System.out.println(customerList);
    }

    @Test
    public void test3() {
        List<Customer> customerList = customerRepository.selectProjectionCustoer();
        System.out.println(customerList);
    }

    @Autowired
    private JPAQueryFactory queryFactory;

    QCustomer qCustomer = QCustomer.customer;
    QOrder qOrder = QOrder.order;
    QOrderItem qOrderItem = QOrderItem.orderItem;
    QProduct qProduct = QProduct.product;

    @Test
    public void test4() {
        // select * from shop_Customer where name='김유신';
        List<Customer> customerList = queryFactory
                                        .selectFrom(qCustomer)
                                        .where(qCustomer.name.eq("김유신"))
                                        .fetch();

        List<Customer> resultList = queryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.name.ne("김유신"))
                .fetch();

        System.out.println(resultList);
    }

    @Test
    public void test5() {
        List<Customer> list1 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.gt(30)).fetch();
        List<Customer> list2 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.goe(30)).fetch();
        List<Customer> list3 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.lt(30)).fetch();
        List<Customer> list4 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.loe(30)).fetch();
        List<Customer> list5 = queryFactory.selectFrom(qCustomer).where(qCustomer.age.in(21, 31, 41)).fetch();

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
        System.out.println(list5);
    }

    @Test
    public void test6() {
        List<Customer> list = queryFactory.selectFrom(qCustomer)
                                .where(qCustomer.name.like("%신"))
                                .fetch();

        System.out.println(list);
    }

    @Test
    public void test7() {
        List<Product> list = queryFactory
                .selectFrom(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.desc())
                .fetch();

        System.out.println(list);
    }

    @Test
    public void test8() {
        List<Product> list = queryFactory
                .selectFrom(qProduct)
                .where(qProduct.stock.gt(0))
                .orderBy(qProduct.price.asc())
                .offset(0)
                .limit(3)
                .fetch();

        System.out.println(list);
    }

    @Test
    public void test9() {
        ProductAggDTO resultDTO = queryFactory.select(
                Projections.fields(
                        ProductAggDTO.class,
                        qProduct.price.sum().as("price_sum"),
                        qProduct.price.avg().as("price_avg"),
                        qProduct.price.max().as("price_max"),
                        qProduct.price.min().as("price_min")
                )
        ).from(qProduct).fetchOne();

        System.out.println(resultDTO);
    }

    @Test
    public void test10() {

    }

    @Test
    public void test11() {

    }

    @Test
    public void test12() {

    }

    @Test
    public void test13() {

    }

    @Test
    public void test14() {

    }

    @Test
    public void test15() {

    }

    @Test
    public void test16() {

    }
}
