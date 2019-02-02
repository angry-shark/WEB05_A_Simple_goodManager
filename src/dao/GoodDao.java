package dao;

import model.Good;
import utils.DBUtil;

import java.util.List;

public class GoodDao {
    public List<Good> getAllGoods(){
        return DBUtil.goodList;
    }


}
