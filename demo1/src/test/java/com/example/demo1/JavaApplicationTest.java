package com.example.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Calendar;

/**
 * Author: zouqinjia
 * Description:
 * Date:2018/5/24 15:10
 **/
@RunWith(JUnit4.class)
public class JavaApplicationTest {

    @Test
    public  void testEmoji(){
//        String str = "An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!";
//        str = "1111\uD83D\uDE09";
////        str = convert(str);
//        String result = EmojiParser.removeAllEmojis(str);
//        System.out.println(result);
        Calendar updateTime = Calendar.getInstance();
        System.out.println(updateTime.getTime());
        updateTime.add(Calendar.SECOND,2);
        System.out.println(updateTime.getTime());
    }

    public String convert(String str) {
        if(true){
            StringBuffer sb = aaa(str);
            return (new String(sb));
        }
        return  null;
    }

    private StringBuffer aaa(String str) {
        str = (str == null ? "" : str);
        String tmp;
        StringBuffer sb = new StringBuffer(1000);
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            sb.append("\\u");
            j = (c >>> 8); //取出高8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);
            j = (c & 0xFF); //取出低8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);

        }
        return sb;
    }

    public String convert2(String str) {
        if(true){
            str = (str == null ? "" : str);
            String tmp;
            StringBuffer sb = new StringBuffer(1000);
            char c;
            int i, j;
            sb.setLength(0);
            for (i = 0; i < str.length(); i++) {
                c = str.charAt(i);
                sb.append("\\u");
                j = (c >>> 8); //取出高8位
                tmp = Integer.toHexString(j);
                if (tmp.length() == 1)
                    sb.append("0");
                sb.append(tmp);
                j = (c & 0xFF); //取出低8位
                tmp = Integer.toHexString(j);
                if (tmp.length() == 1)
                    sb.append("0");
                sb.append(tmp);

            }
            return (new String(sb));
        }
        return null;
    }
}
