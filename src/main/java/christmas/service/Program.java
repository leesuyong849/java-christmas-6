package christmas.service;

import christmas.domain.food.*;

import java.util.Arrays;
import java.util.List;

public class Program {

    public static final MenuManager MENU = new MenuManager(List.of(
            new Appetizer("양송이수프", 6000),
            new Appetizer("타파스", 5500),
            new Appetizer("시저샐러드", 8000),
            new Main("티본스테이크", 55000),
            new Main("바비큐립", 54000),
            new Main("해산물파스타", 35000),
            new Main("크리스마스파스타", 25000),
            new Dessert("초코케이크", 15000),
            new Dessert("아이스크림", 5000),
            new Drink("제로콜라", 3000),
            new Drink("레드와인", 60000),
            new Drink("샴페인", 25000)
    ));

    public void play() {

    }
}
