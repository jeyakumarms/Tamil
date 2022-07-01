# Tamil
Tamil Java Class
Class to split Tamil word to alphabets, Due to the complex structure of tamil alphabets
as requires up to 2 Unicode bytes, each alphabets are stored/returned in string.
 
  Example 1:
  TamilString ts=new TamilString("வாற்கோதுமை");
  List<String> result = ts.getArrayUTF8();
  //result = ["வா","ற்","கோ","து","மை"]
 
  Example 2:
  int len=(new TamilString("வாற்கோதுமை")).length();
  // len = 5
 
 Tamil Unicode charecter list:
  Decimal  Hex        Symbol
  2946	    0x0B82	    ஂ
  2947	    0x0B83	    ஃ
  2949	    0x0B85	    அ
  2950	    0x0B86	    ஆ
  2951	    0x0B87	    இ
  2952	    0x0B88	    ஈ
  2953	    0x0B89	    உ
  2954	    0x0B8A	    ஊ
  2958	    0x0B8E	    எ
  2959	    0x0B8F	    ஏ
  2960	    0x0B90	    ஐ
  2962	    0x0B92	    ஒ
  2963	    0x0B93	    ஓ
  2964	    0x0B94	    ஔ
  2965	    0x0B95	    க
  2969	    0x0B99	    ங
  2970	    0x0B9A	    ச
  2972	    0x0B9C	    ஜ
  2974	    0x0B9E	    ஞ
  2975	    0x0B9F	    ட
  2979	    0x0BA3	    ண
  2980	    0x0BA4	    த
  2984	    0x0BA8	    ந
  2985	    0x0BA9	    ன
  2986	    0x0BAA	    ப
  2990	    0x0BAE	    ம
  2991	    0x0BAF	    ய
  2992	    0x0BB0	    ர
  2993	    0x0BB1	    ற
  2994	    0x0BB2	    ல
  2995	    0x0BB3	    ள
  2996	    0x0BB4	    ழ
  2997	    0x0BB5	    வ
  2998	    0x0BB6	    ஶ
  2999	    0x0BB7	    ஷ
  3000	    0x0BB8	    ஸ
  3001	    0x0BB9	    ஹ
  3006	    0x0BBE	    ா
  3007	    0x0BBF	    ி
  3008	    0x0BC0	    ீ
  3009	    0x0BC1	    ு
  3010	    0x0BC2	    ூ
  3014	    0x0BC6	    ெ
  3015	    0x0BC7	    ே
  3016	    0x0BC8	    ை
  3018	    0x0BCA	    ொ
  3019	    0x0BCB	    ோ
  3020	    0x0BCC	    ௌ
  3021	    0x0BCD	    ்
  3024	    0x0BD0	    ௐ
  3031	    0x0BD7	    ௗ
  3044	    0x0BE4	    ௤
  3045	    0x0BE5	    ௥
  3046	    0x0BE6	    ௦
  3047	    0x0BE7	    ௧
  3048	    0x0BE8	    ௨
  3049	    0x0BE9	    ௩
  3050	    0x0BEA	    ௪
  3051	    0x0BEB	    ௫
  3052	    0x0BEC	    ௬
  3053	    0x0BED	    ௭
  3054	    0x0BEE	    ௮
  3055	    0x0BEF	    ௯
  3056	    0x0BF0	    ௰
  3057	    0x0BF1	    ௱
  3058	    0x0BF2	    ௲
  3059	    0x0BF3	    ௳
  3060	    0x0BF4	    ௴
  3061	    0x0BF5	    ௵
  3062	    0x0BF6	    ௶
  3063	    0x0BF7	    ௷
  3064	    0x0BF8	    ௸
  3065	    0x0BF9	    ௹
  3066	    0x0BFA	    ௺
  73689	    0x11FD9	    𑿙
  73702	    0x11FE6	    𑿦
  73705	    0x11FE9	    𑿩
  73704	    0x11FE8	    𑿨
  73664	    0x11FC0	    𑿀
  73672	    0x11FC8	    𑿈
