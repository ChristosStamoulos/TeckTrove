package com.example.tecktrove.domain;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


import java.time.LocalDate;
import com.example.tecktrove.contacts.Email;
import com.example.tecktrove.contacts.Telephone;
import com.example.tecktrove.util.Money;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import org.junit.*;


import com.example.tecktrove.util.SimpleCalendar;
import com.example.tecktrove.util.SystemDate;


public class OrderTest {
    private Order order1,order2;
    private Currency euroCurrency = Currency.getInstance("EUR");
    @Before
    public void setUp(){
        ArrayList<OrderLine> R1 = new ArrayList<OrderLine>();
        R1.add(new OrderLine(2,new ProductType(123,new Money(new BigDecimal(2100.0), euroCurrency),"chris")));
        ArrayList<OrderLine> R2 = new ArrayList<OrderLine>();
        order1 = new Order(SystemDate.now(),new Money(new BigDecimal(2100.0), euroCurrency),25100,new Telephone("210984367"),new Email("ok@gmail.com"),R1);
        order2 = new Order(new SimpleCalendar(2023,6,25),new Money(new BigDecimal(2100.1), euroCurrency),25101,new Telephone("110984367"),new Email("oka1@gmail.com"),R2);

    }
    @Test
    public void checkDefaultConstructor(){
        Order o = new Order();
        o.setTotal(Money.euros(20));
        assertEquals(Money.euros(20), o.getTotal());
    }
    @Test
    public void checkGetSet() {
        assertNotEquals(this.order1.getDate(), this.order2.getDate());
        assertNotEquals(this.order1.getTotal(), this.order2.getTotal());
        assertNotEquals(this.order1.getCardNumber(), this.order2.getCardNumber());
        assertNotEquals(this.order1.getTelephone(), this.order2.getTelephone());
        assertNotEquals(this.order1.getEmail(), this.order2.getEmail());
        assertNotEquals(this.order1.getOrderLines(), this.order2.getOrderLines());

        order2.setDate(SystemDate.now());
        assertEquals(order1.getDate(), order2.getDate());
        order2.setTotal(new Money(new BigDecimal(2100.0), euroCurrency));
        assertEquals(this.order1.getTotal(), this.order2.getTotal());
        order1.setCardNumber(25101);
        assertEquals(this.order1.getCardNumber(), this.order2.getCardNumber());
        order2.setTelephone(new Telephone("210984367"));
        assertEquals(this.order1.getTelephone(), this.order2.getTelephone());
        order2.setEmail(new Email("ok@gmail.com"));
        assertEquals(this.order1.getEmail(), this.order2.getEmail());
        ArrayList<OrderLine> l1 = new ArrayList<OrderLine>();
        order1.setOrderLines(l1);
        order2.setOrderLines(l1);
        assertEquals(this.order1.getOrderLines(), this.order2.getOrderLines());
        order1.setCustomer(new Customer(18,  "lola", "1234", "lo", "la", new Email("ok@gmail.com"), new Telephone("12345"), new ArrayList<Synthesis>(), new ArrayList<ProductType>()));
        order2.setCustomer(new Customer(18,  "lola", "1234", "lo", "la", new Email("ok@gmail.com"), new Telephone("12345"), new ArrayList<Synthesis>(), new ArrayList<ProductType>()));
        assertEquals(this.order1.getCustomer(),this.order1.getCustomer());

    }
    @Test
    public void testAddRemove(){
        OrderLine R3 = new OrderLine(2,new ProductType(125,new Money(new BigDecimal(2100.1), euroCurrency),"chris"));
        order1.addOrderLine(R3);
        assertTrue(order1.getOrderLines().remove(R3));
        order2.addOrderLine(R3);
        order2.removeOrderline(R3);
        Boolean notfound = Boolean.TRUE;
        for(OrderLine r: order2.getOrderLines()){
            if(r==R3){
                notfound=Boolean.FALSE;
            }
        }
        assertTrue(notfound);




    }


}
