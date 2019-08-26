package dev.tinyz.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by TinyZ on 2014/9/23.
 */
public class Main {

    public static void main(String[] args) throws Exception {
//        POIUtil.MathRandomCastTime();
        long beginTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd hh:mm:ss");
        BleData bleData = new BleData("圆形","周长",10.1f,0.5f,9.752f,false,"张三",new Date());
        List<BleData> list = new ArrayList<BleData>();
        for (int i = 0; i <10 ; i++) {
            list.add(bleData);
        }
        String path = "./test.xlsx";
        POIUtil.Excel2007AboveOperate("test2.xls",list);
        long endTime = System.currentTimeMillis();

        System.out.println("Cast time : " + (endTime - beginTime));
    }
}
