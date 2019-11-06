package com.example.meatbowl.database

enum class Ingredients(val category:String, val iKorean:String) {
    /* 카테고리 설명 :
    cetegory : MM(muscle meat) , EB(edible bone) , OG(organ) , VG(veggie) , FR(fruit) , OT( others (ex:egg,yogurt,fish oil....)
    iCode : specific ingredient,MM(100) , EB(200), OG(500), VG(600), FR(700) , OT(900)
    iKorean : ingredient codes's korean translation
     */

    MM101("100","닭가슴살"),
    MM102("100","닭안심"),
    EB201("200","닭발"),
    EB202("200","닭날개"),
    OR501("500","소간"),
    OR502("500","소허파"),
    VG601("600","브로콜리"),
    VG602("600","당근"),
    FR701("700","사과"),
    FR702("700","블루베리"),
    OT901("900","요거트"),
    OT902("900","계란");
}