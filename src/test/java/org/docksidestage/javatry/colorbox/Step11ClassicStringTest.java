/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.javatry.colorbox;

import java.util.List;

import org.docksidestage.bizfw.colorbox.ColorBox;
import org.docksidestage.bizfw.colorbox.color.BoxColor;
import org.docksidestage.bizfw.colorbox.space.BoxSpace;
import org.docksidestage.javatry.colorbox.base.YourPrivateRoom;
import org.docksidestage.unit.PlainTestCase;

/**
 * The test of String with color-box, not using Stream API. <br>
 * Show answer by log() for question of javadoc.
 * @author jflute
 * @author your_name_here
 */
public class Step11ClassicStringTest extends PlainTestCase {

    // ===================================================================================
    //                                                                            length()
    //                                                                            ========
    /**
     * How many lengths does color name of first color-boxes have? <br>
     * (最初のカラーボックスの色の名前の文字数は？)
     */
    public void test_length_basic() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        ColorBox colorBox = colorBoxList.get(0);
        BoxColor boxColor = colorBox.getColor();
        String colorName = boxColor.getColorName();
        int answer = colorName.length();
        log(answer, colorName); // also show name for visual check
    }

    /**
     * Which string has max length in color-boxes? <br>
     * (カラーボックスに入ってる文字列の中で、一番長い文字列は？)
     */
    public void test_length_findMax() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int length = 0;
        String strContent = null;
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
                    int tmpLength = tmpString.length();
                    if (tmpLength > length) {
                        length = tmpLength;
                        strContent = tmpString;
                    }
                }
            }
        }
        log(strContent != null ? strContent : "Not found string content");
    }

    /**
     * How many characters are difference between max and min length of string in color-boxes? <br>
     * (カラーボックスに入ってる文字列の中で、一番長いものと短いものの差は何文字？)
     */
    public void test_length_findMaxMinDiff() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int maxLength = 0;
        int minLength = 0;
        String strContent = null;
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
                    int tmpLength = tmpString.length();
                    if (tmpLength > maxLength) {
                        maxLength = tmpLength;
                        strContent = tmpString;
                        if (minLength == 0) {
                            minLength = tmpLength;
                        }
                    } else if (tmpLength < minLength) {
                        minLength = tmpLength;
                    }
                }
            }
        }
        log(maxLength - minLength);
    }

    /**
     * Which value (toString() if non-string) has second-max legnth in color-boxes? (without sort)<br>
     * (カラーボックスに入ってる値 (文字列以外はtoString()) の中で、二番目に長い文字列は？ (ソートなしで))
     */
    public void test_length_findSecondMax() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String strLongest = null;
        String strLonger = null;
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
                    //                    log(tmpString);
                    if (strLongest == null) {
                        strLongest = strLonger = tmpString;
                    } else if (tmpString.length() > strLongest.length()) {
                        strLongest = tmpString;
                    } else if (tmpString.length() < strLonger.length()) {
                        strLonger = tmpString;
                    }
                }
            }
        }
        log(strLonger);
    }

    /**
     * How many total lengths of strings in color-boxes? <br>
     * (カラーボックスに入ってる文字列の長さの合計は？)
     */
    public void test_length_calculateLengthSum() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int sum = 0;
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
                    sum += tmpString.length();
                }
            }
        }
        log(sum);
    }

    /**
     * Which color name has max length in color-boxes? <br>
     * (カラーボックスの中で、色の名前が一番長いものは？)
     */
    public void test_length_findMaxColorSize() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String strColor = null;
        for (ColorBox colorBox : colorBoxList) {
            BoxColor color = colorBox.getColor();
            String tmpStrColor = color.getColorName();
            //            log(tmpStrColor);
            if (strColor == null) {
                strColor = tmpStrColor;
            } else if (tmpStrColor.length() > strColor.length()) {
                strColor = tmpStrColor;
            }
        }
        log(strColor != null ? strColor : "Color not found");
    }

    // ===================================================================================
    //                                                            startsWith(), endsWith()
    //                                                            ========================
    /**
     * What is color in the color-box that has string starting with "Water"? <br>
     * ("Water" で始まる文字列をしまっているカラーボックスの色は？)
     */
    public void test_startsWith_findFirstWord() {
        String startString = "Water";
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String strColor = null;
        for (ColorBox colorBox : colorBoxList) {
            BoxColor color = colorBox.getColor();
            String tmpStrColor = color.getColorName();
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
                    if (tmpString.startsWith(startString)) {
                        strColor = tmpStrColor;
                    }
                }
            }
        }
        log(strColor);
    }

    /**
     * What is color in the color-box that has string ending with "front"? <br>
     * ("front" で終わる文字列をしまっているカラーボックスの色は？)
     */
    public void test_endsWith_findLastWord() {
        String endString = "front";
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String strColor = null;
        for (ColorBox colorBox : colorBoxList) {
            BoxColor color = colorBox.getColor();
            String tmpStrColor = color.getColorName();
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
                    if (tmpString.endsWith(endString)) {
                        strColor = tmpStrColor;
                    }
                }
            }
        }
        log(strColor != null ? strColor : "Color not found");
    }

    // ===================================================================================
    //                                                            indexOf(), lastIndexOf()
    //                                                            ========================
    /**
     * What number character is starting with "front" of string ending with "front" in color-boxes? <br>
     * (あなたのカラーボックスに入ってる "front" で終わる文字列で、"front" は何文字目から始まる？)
     */
    public void test_indexOf_findIndex() {
        String endString = "front";
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int num = 0;
        for (ColorBox colorBox : colorBoxList) {
            BoxColor color = colorBox.getColor();
            String tmpStrColor = color.getColorName();
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
                    if (tmpString.endsWith(endString)) {
                        num = tmpString.indexOf(endString);
                    }
                }
            }
        }
        log(num != 0 ? num : "Color not found");
    }

    /**
     * What number character is starting with the late "ど" of string containing plural "ど"s in color-boxes? <br>
     * (あなたのカラーボックスに入ってる「ど」を二つ以上含む文字列で、最後の「ど」は何文字目から始まる？)
     */
    public void test_lastIndexOf_findIndex() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        int num = 0;
        String key = "ど";
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
                    //                    log(tmpString);
                    int apperCount = 0;
                    int tmpNum = 0;
                    while (true) {
                        tmpNum = tmpString.indexOf(key, tmpNum + 1);
                        log(tmpNum);
                        if (tmpNum < 0) {
                            break;
                        } else {
                            apperCount++;
                        }
                        if (apperCount >= 2) {
                            num = tmpNum;
                            break;
                        }
                    }
                }
            }
        }
        log(num);
    }

    // ===================================================================================
    //                                                                         substring()
    //                                                                         ===========
    /**
     * What character is first of string ending with "front" in color-boxes? <br>
     * (カラーボックスに入ってる "front" で終わる文字列の最初の一文字は？)
     */
    public void test_substring_findFirstChar() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String key = "front";
        String initalWord = null;
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
                    //                    log(tmpString);
                    if (tmpString.lastIndexOf(key) >= 0) {
                        initalWord = tmpString.substring(0, 1);
                    }
                }
            }
        }
        log(initalWord);
    }

    /**
     * What character is last of string starting with "Water" in color-boxes? <br>
     * (カラーボックスに入ってる "Water" で始まる文字列の最後の一文字は？)
     */
    public void test_substring_findLastChar() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String key = "Water";
        String lastWord = null;
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
                    //log(tmpString);
                    if (tmpString.indexOf(key) == 0) {
                        lastWord = tmpString.substring(tmpString.length() - 1, tmpString.length());
                    }
                }
            }
        }
        log(lastWord);
    }

    // ===================================================================================
    //                                                                           replace()
    //                                                                           =========
    /**
     * How many characters does string that contains "o" in color-boxes and removing "o" have? <br>
     * (カラーボックスに入ってる "o" (おー) を含んだ文字列から "o" を全て除去したら何文字？)
     */
    public void test_replace_remove_o() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String key = "o";
        int num = 0;
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
//                    log(tmpString);
                    if (tmpString.indexOf(key) >= 0) {
                        tmpString = tmpString.replaceAll(key, "");
                        num = tmpString.length();
                    }
                }
            }
        }
        log(num);
    }

    /**
     * What string is path string of java.io.File in color-boxes, which is replaced with "/" to Windows file separator? <br>
     * カラーボックスに入ってる java.io.File のパス文字列のファイルセパレーターの "/" を、Windowsのファイルセパレーターに置き換えた文字列は？
     */
    public void test_replace_fileseparator() {
        List<ColorBox> colorBoxList = new YourPrivateRoom().getColorBoxList();
        String key = "o";
        int num = 0;
        for (ColorBox colorBox : colorBoxList) {
            List<BoxSpace> spaceList = colorBox.getSpaceList();
            for (BoxSpace boxSpace : spaceList) {
                Object content = boxSpace.getContent();
                if (content instanceof String) {
                    String tmpString = content.toString();
                    //                    log(tmpString);
                    if (tmpString.indexOf(key) >= 0) {
                        tmpString = tmpString.replaceAll(key, "");
                        num = tmpString.length();
                    }
                }
            }
        }
        log(num);
    }

    // ===================================================================================
    //                                                                    Welcome to Devil
    //                                                                    ================
    /**
     * What is total length of text of DevilBox class in color-boxes? <br>
     * (カラーボックスの中に入っているDevilBoxクラスのtextの長さの合計は？)
     */
    public void test_welcomeToDevil() {
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * What string is converted to style "map:{ key = value ; key = value ; ... }" from java.util.Map in color-boxes? <br>
     * (カラーボックスの中に入っている java.util.Map を "map:{ key = value ; key = value ; ... }" という形式で表示すると？)
     */
    public void test_showMap() {
    }

    /**
     * What string of toString() is converted from text of SecretBox class in upper space on the "white" color-box to java.util.Map? <br>
     * (whiteのカラーボックスのupperスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
     */
    public void test_parseMap_basic() {
    }

    /**
     * What string of toString() is converted from text of SecretBox class in both middle and lower spaces on the "white" color-box to java.util.Map? <br>
     * (whiteのカラーボックスのmiddleおよびlowerスペースに入っているSecretBoxクラスのtextをMapに変換してtoString()すると？)
     */
    public void test_parseMap_deep() {
    }
}
