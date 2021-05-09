package com.example.bottomnavigationview;

/*
    用于fragment3中的listview的item类 ，为了区分 名命为commodity
    commodity_name：物体名
    commodity_content：物体内容，用于返回给TextView，来改变TextView中的内容
 */
public class commodity {
    private String commodity_name;
    private String commodity_content;

    public String getCommodity_name() {
        return commodity_name;
    }

    public String getCommodity_content() {
        return commodity_content;
    }



    public commodity(String commodity_name, String commodity_content) {
        this.commodity_name = commodity_name;
        this.commodity_content = commodity_content;
    }

}
