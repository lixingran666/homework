package org.westos.武将;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestHero {

    /**
     *
     * 2	伊籍	江陵	男	162	226	24
     * 3	尹赏	天水	男	194	260	44
     */
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        // \t  split("\t")
        // 0     1      2    3   ...
        // 1	阿会喃	云南	男	190	225	74  str
        Stream<Hero> heroStream = lines.map(str -> str.split("\t")).map(array ->
                new Hero(
                        Integer.parseInt(array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6]))
        );

        // 1. 找到武将中武力前三的hero对象, 提示流也可以排序
        /*List<Hero> list1 = heroStream.sorted((a, b) -> -(a.getPower() - b.getPower())).limit(3).collect(Collectors.toList());
        System.out.println(list1);*/

        // 2. 按出生地分组
       /* Map<String, List<Hero>> list2 = heroStream.collect(Collectors.groupingBy((hero) -> hero.getLoc()));
        System.out.println(list2);*/

        // 3. 找出寿命前三的武将
        /*List<Hero> list3 = heroStream.sorted((a, b) -> ((b.getDeath() - b.getBirth()) - (a.getDeath() - a.getBirth()))).limit(3).collect(Collectors.toList());
        System.out.println(list3);*/
        //[Hero{id=436, name='吕岱', loc='会稽', sex='男', birth=161, death=256, power=71},
        // Hero{id=426, name='廖化', loc='江夏', sex='男', birth=170, death=264, power=76},
        // Hero{id=157, name='司马孚', loc='陈留', sex='男', birth=180, death=272, power=37}]

       /* // 4. 女性寿命最高的
        System.out.println(heroStream.filter(hero -> hero.getSex().equals("女"))
                .max((a, b) -> ((a.getDeath() - a.getBirth()) - (b.getDeath() - b.getBirth()))));
        //Optional[Hero{id=814, name='辛宪英', loc='邺', sex='女', birth=191, death=269, power=28}]*/

        // 5. 找出武力排名前三  100, 99, 97 97 ==> 4个人 吕布", "张飞", "关羽", "马超
        TreeSet<Integer> set = new TreeSet<>();
        List<Hero> heroList = heroStream.collect(Collectors.toList());
        for (Hero hero : heroList) {
            set.add(hero.getPower());
        }
        System.out.println(set);
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(set.pollLast());
        hashSet.add(set.pollLast());
        hashSet.add(set.pollLast());
        for (Hero hero : heroList) {
            if(hashSet.contains(hero.getPower())){
                System.out.println(hero);
            }
        }


        // 6. 按各个年龄段分组： 0~20, 21~40, 41~60, 60以上
        /*Map<String, List<Hero>> list6 = heroStream.collect(Collectors.groupingBy(
                hero -> {
                    if ((hero.getDeath() - hero.getBirth()) >= 0 && (hero.getDeath() - hero.getBirth()) <= 20) {
                        return "0~20:";
                    } else if ((hero.getDeath() - hero.getBirth()) >= 21 && (hero.getDeath() - hero.getBirth()) <= 40) {
                        return "21~40:";
                    } else if ((hero.getDeath() - hero.getBirth()) >= 41 && (hero.getDeath() - hero.getBirth()) <= 60) {
                        return "41~60:";
                    } else {
                        return "60以上:";
                    }
                }
        ));
        System.out.println(list6);*/


        // 7. 按武力段分组： >=90， 80~89, 70~79, <70
        /*Map<String, List<Hero>> list7 = heroStream.collect(Collectors.groupingBy(
                hero -> {
                    if (hero.getPower() >= 90) {
                        return "武力段>=90:";
                    } else if (hero.getPower() >= 80 && hero.getPower() <= 89) {
                        return "武力段80~89:";
                    } else if (hero.getPower() >= 70 && hero.getPower() <= 79) {
                        return "武力段70~79:";
                    } else {
                        return "武力段<70:";
                    }
                }
        ));
        System.out.println(list7);*/


        // 8. 按出生地分组后，统计各组人数
        /*Map<String, Long> list8 = heroStream.collect(Collectors.groupingBy(hero -> hero.getLoc(), Collectors.counting()));
        System.out.println(list8);*/
                //{=5, 武陵=7, 下邳=16, 陈留=26, 庐江=13, 晋阳=15, 梓潼=10, 许昌=19, 平原=5,
                // 汉中=7, 北海=5, 濮阳=20, 寿春=5, 柴桑=11, 新野=4, 江州=12, 汝南=8, 宛=14,
                // 江夏=10, 蓟=4, 天水=17, 成都=21, 上庸=2, 小沛=6, 长沙=6, 会稽=8, 建业=21,
                // 零陵=7, 云南=17, 吴=10, 洛阳=30, 北平=15, 长安=13, 西凉=4, 邺=22, 江陵=17,
                // 桂阳=6, 南皮=13, 襄阳=16, 襄平=7}


    }
}
