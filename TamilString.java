package com.sridan.tamilgames;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to split Tamil word to alphabets, Due to the complex structure of tamil alphabets
 * alphabets as requires up to 2 Unicode bytes, each alphabets are stored/returned in string.
 *
 * Example 1:
 * TamilString ts=new TamilString("வாற்கோதுமை");
 * List<String> result = ts.getArrayUTF8();
 * //result = ["வா","ற்","கோ","து","மை"]
 *
 * Example 2:
 * int len=(new TamilString("வாற்கோதுமை")).length();
 * // len = 5
 *
 * Decimal  Hex        Symbol
 * 2946	    0x0B82	    ஂ
 * 2947	    0x0B83	    ஃ
 * 2949	    0x0B85	    அ
 * 2950	    0x0B86	    ஆ
 * 2951	    0x0B87	    இ
 * 2952	    0x0B88	    ஈ
 * 2953	    0x0B89	    உ
 * 2954	    0x0B8A	    ஊ
 * 2958	    0x0B8E	    எ
 * 2959	    0x0B8F	    ஏ
 * 2960	    0x0B90	    ஐ
 * 2962	    0x0B92	    ஒ
 * 2963	    0x0B93	    ஓ
 * 2964	    0x0B94	    ஔ
 * 2965	    0x0B95	    க
 * 2969	    0x0B99	    ங
 * 2970	    0x0B9A	    ச
 * 2972	    0x0B9C	    ஜ
 * 2974	    0x0B9E	    ஞ
 * 2975	    0x0B9F	    ட
 * 2979	    0x0BA3	    ண
 * 2980	    0x0BA4	    த
 * 2984	    0x0BA8	    ந
 * 2985	    0x0BA9	    ன
 * 2986	    0x0BAA	    ப
 * 2990	    0x0BAE	    ம
 * 2991	    0x0BAF	    ய
 * 2992	    0x0BB0	    ர
 * 2993	    0x0BB1	    ற
 * 2994	    0x0BB2	    ல
 * 2995	    0x0BB3	    ள
 * 2996	    0x0BB4	    ழ
 * 2997	    0x0BB5	    வ
 * 2998	    0x0BB6	    ஶ
 * 2999	    0x0BB7	    ஷ
 * 3000	    0x0BB8	    ஸ
 * 3001	    0x0BB9	    ஹ
 * 3006	    0x0BBE	    ா
 * 3007	    0x0BBF	    ி
 * 3008	    0x0BC0	    ீ
 * 3009	    0x0BC1	    ு
 * 3010	    0x0BC2	    ூ
 * 3014	    0x0BC6	    ெ
 * 3015	    0x0BC7	    ே
 * 3016	    0x0BC8	    ை
 * 3018	    0x0BCA	    ொ
 * 3019	    0x0BCB	    ோ
 * 3020	    0x0BCC	    ௌ
 * 3021	    0x0BCD	    ்
 * 3024	    0x0BD0	    ௐ
 * 3031	    0x0BD7	    ௗ
 * 3044	    0x0BE4	    ௤
 * 3045	    0x0BE5	    ௥
 * 3046	    0x0BE6	    ௦
 * 3047	    0x0BE7	    ௧
 * 3048	    0x0BE8	    ௨
 * 3049	    0x0BE9	    ௩
 * 3050	    0x0BEA	    ௪
 * 3051	    0x0BEB	    ௫
 * 3052	    0x0BEC	    ௬
 * 3053	    0x0BED	    ௭
 * 3054	    0x0BEE	    ௮
 * 3055	    0x0BEF	    ௯
 * 3056	    0x0BF0	    ௰
 * 3057	    0x0BF1	    ௱
 * 3058	    0x0BF2	    ௲
 * 3059	    0x0BF3	    ௳
 * 3060	    0x0BF4	    ௴
 * 3061	    0x0BF5	    ௵
 * 3062	    0x0BF6	    ௶
 * 3063	    0x0BF7	    ௷
 * 3064	    0x0BF8	    ௸
 * 3065	    0x0BF9	    ௹
 * 3066	    0x0BFA	    ௺
 * 73689	0x11FD9	    𑿙
 * 73702	0x11FE6	    𑿦
 * 73705	0x11FE9	    𑿩
 * 73704	0x11FE8	    𑿨
 * 73664	0x11FC0	    𑿀
 * 73672	0x11FC8	    𑿈
 */
public class TamilString {
    private String string;
    public enum Types{
        INDEPENDENT_VOWELS,
        CONSONANTS,
        DEPENDENT_VOWEL_SIGNS,
        DIGITS,
        NUMERICS,
        CALENDERICAL_SYMBOL,
        CLERICAL_SYMBOL,
        CURRENCY,
        OTHERS,
        UNKOWN
    }
    private final int[] independentVowels={
                                            0x0B83,
                                            0x0B85,
                                            0x0B86,
                                            0x0B87,
                                            0x0B88,
                                            0x0B89,
                                            0x0B8A,
                                            0x0B8E,
                                            0x0B8F,
                                            0x0B90,
                                            0x0B92,
                                            0x0B93,
                                            0x0B94};

    private final int[] consonants={
                                    0x0B95,
                                    0x0B99,
                                    0x0B9A,
                                    0x0B9C,
                                    0x0B9E,
                                    0x0B9F,
                                    0x0BA3,
                                    0x0BA4,
                                    0x0BA8,
                                    0x0BA9,
                                    0x0BAA,
                                    0x0BAE,
                                    0x0BAF,
                                    0x0BB0,
                                    0x0BB1,
                                    0x0BB2,
                                    0x0BB3,
                                    0x0BB4,
                                    0x0BB5,
                                    0x0BB7,
                                    0x0BB8,
                                    0x0BB9
                                    };

    private final int[] dependentVowelSigns={
                                        0x0BBE,
                                        0x0BBF,
                                        0x0BC0,
                                        0x0BC1,
                                        0x0BC2,
                                        0x0BC6,
                                        0x0BC7,
                                        0x0BC8,
                                        0x0BCA,
                                        0x0BCB,
                                        0x0BCC,
                                        0x0BCD,
                                        0x0BD7
                                        };
    private final int[] digits={0x0BE6,0x0BE7,0x0BE8,0x0BE9,0x0BEA, 0x0BEB, 0x0BEC, 0x0BED, 0x0BEE, 0x0BEF};
    private final int[] numerics={0x0BF0, 0x0BF1, 0x0BF2};
    private final int[] calendericalSymbol={0x0BF3,0x0BF4,0x0BF5};
    private final int[] clericalSymbol={0x0BF6, 0x0BF7, 0x0BF8, 0x0BFA};
    private final int[] currency={0x0BF9};
    private final int[] others={0x0BB6, 0x0BD0, 0x0BE4, 0x0BE5,0x11FC0, 0x11FC8, 0x11FD9,
                        0x11FE6, 0x11FE8, 0x11FE9};

    public TamilString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Types getType(char b){
        Types type=Types.UNKOWN;
        if(Arrays.stream(independentVowels).filter(val -> val == b).count()>0)
            type=Types.INDEPENDENT_VOWELS;
        else if(Arrays.stream(consonants).filter(val -> val == b).count()>0)
            type=Types.CONSONANTS;
        else if(Arrays.stream(dependentVowelSigns).filter(val -> val == b).count()>0)
            type=Types.DEPENDENT_VOWEL_SIGNS;
        else if(Arrays.stream(digits).filter(val -> val == b).count()>0)
            type=Types.DIGITS;
        else if(Arrays.stream(numerics).filter(val -> val == b).count()>0)
            type=Types.NUMERICS;
        else if(Arrays.stream(calendericalSymbol).filter(val -> val == b).count()>0)
            type=Types.CALENDERICAL_SYMBOL;
        else if(Arrays.stream(clericalSymbol).filter(val -> val == b).count()>0)
            type=Types.CLERICAL_SYMBOL;
        else if(Arrays.stream(currency).filter(val -> val == b).count()>0)
            type=Types.CURRENCY;
        else if(Arrays.stream(others).filter(val -> val == b).count()>0)
            type=Types.OTHERS;

        return type;
    }

    public int length(){
        return getArrayUTF8().size();
    }

    public List<String> getArrayUTF8(){
        int arrayLen=0;
        char[] stringBytes=string.toCharArray();
        List<String> arrayString=new LinkedList<>();
        boolean isNext=true;
        for(int i=0;i<stringBytes.length;i++){
            if(isNext)
                arrayString.add(String.valueOf(stringBytes[i]));
            else
                arrayString.set(arrayLen, arrayString.get(arrayLen)+String.valueOf(stringBytes[i]));
            isNext=false;
            if(stringBytes.length>i+1 && getType(stringBytes[i+1])!=Types.DEPENDENT_VOWEL_SIGNS) {
                arrayLen++;
                isNext = true;
            }
        }
        return arrayString;
    }
}
