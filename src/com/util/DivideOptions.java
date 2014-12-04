package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by JS on 2014-12-01.
 */
public class DivideOptions {

    public List<String> parse(String options) {
    	
    	
        List<String> list = new ArrayList<String>();

        String[] optionPairArray = options.split("&");

        for (int i=0; i<optionPairArray.length; i++) {

            String[] temp = optionPairArray[i].split("/");

            list.add(temp[0]);
            list.add(temp[1]);
        }

        return list;
    }

}
