package service;

import dao.GoodDao;
import model.Good;

import java.util.List;

public class Goodservice {
    public List<Good> selectAllGoods(){
        return new GoodDao().getAllGoods();
    }
}
