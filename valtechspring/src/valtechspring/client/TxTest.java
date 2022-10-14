package valtechspring.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import valtechspring.tx.CarService;
public class TxTest {



   public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext appctx=new ClassPathXmlApplicationContext("Hibtx.xml");
        CarService carService=(CarService) appctx.getBean("carService");
        carService.updatePrice(1,220000);
    }



}