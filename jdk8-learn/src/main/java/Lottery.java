
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Lottery {

    /**
     * 计算自身相对于总体的比例
     *
     * @param self 自身
     * @param all  总体
     * @return 比例
     */
    private static float getPercent(Integer self, Integer all) {
        // 比例计算出来会有很多小数，为了看得清晰，要四舍五入一下
        return new BigDecimal(self / all.floatValue()).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    /**
     * 根据比例，在100之间计算出区间跨度，进一步来计算中奖区间
     *
     * @param percent 比例
     * @return 跨度
     */
    private static int getRandom(float percent) {
        // 如果getPercent中没有四舍五入，那么就需要在这里四舍五入
        return new BigDecimal(percent * 100).intValue();
    }

    private void lottery() {

        Integer allAmount = 233;// 总配额（抽奖总次数）

        List<User> users = new ArrayList<>();
        users.add(new User(1, "张三", 11));
        users.add(new User(2, "李四", 22));
        users.add(new User(3, "王五", 5));
        users.add(new User(4, "赵六", 111));
        users.add(new User(5, "田七", 66));
        users.add(new User(6, "陈八", 18));

        Map<Integer, Offset> userOffsetMap = new HashMap<>();
        float percent;// 比例
        int span;// 跨度
        int start = 0;// 区间开始
        int end;// 区间结束
        for (User user : users) {
            percent = getPercent(user.getAmount(), allAmount);
            span = getRandom(percent);
            // 按照跨度计算offset
            end = start + span;
            userOffsetMap.put(user.getId(), new Offset(percent, span, start, end, user.getAmount()));
            // 因为区间不能超过100，所以每次都需要用新的数值+跨度
            start = end;
        }

        // log
        for (Integer userId : userOffsetMap.keySet()) {
            Offset offset = userOffsetMap.get(userId);
            System.out.println("用户: " + userId + ", 配额: " + offset.getAmount() + ", 占比: " + offset.getPercent() + ", 跨度: " + offset.getSpan() + ", 区间: [" + offset.getStart() + ", " + offset.getEnd() + ")");
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        Integer userId;
        Integer num;
        for (int i = 0; i < allAmount; i++) {
            // 由于这里是递归处理，所以如果最后为null了，说明已经到达了所有人的配额上限（奖品或者抽奖次数用完了）
            userId = randomUser(userOffsetMap);
            if (userId == null) {
                break;
            }
            // 记录每个用户的中标次数，达到上限了就排除掉
            num = countMap.get(userId);
            if (num != null) {
                countMap.put(userId, num + 1);
            } else {
                countMap.put(userId, 1);
            }
            // 次数到了上限，移除用户（可看做：中奖之后移除用户）
            if (countMap.get(userId) >= userOffsetMap.get(userId).getAmount()) {
                userOffsetMap.remove(userId);
            }
        }

        // log
        for (Integer key : countMap.keySet()) {
            System.out.println(key + "中奖了" + countMap.get(key) + "次，概率: " + getPercent(countMap.get(key), allAmount));
        }
    }

    /**
     * 选中之后，会排除掉部分用户，递归调用，将机会让给别的人
     *
     * @param userOffsetMap 用户offset信息
     * @return 选中的用户
     */
    private Integer randomUser(Map<Integer, Offset> userOffsetMap) {
        Integer userId = select(userOffsetMap);
        if (!userOffsetMap.isEmpty() && userId == null) {
            return randomUser(userOffsetMap);
        }
        return userId;
    }

    /**
     * 按照计算好的区间，随机获取用户（即视为中标了）
     *
     * @param userOffsetMap 用户offset信息
     * @return 选中的用户
     */
    private Integer select(Map<Integer, Offset> userOffsetMap) {
        // 计算一个随机数值，看他散列在哪个用户的区间
        int rnum = new Random().nextInt(100);
        Offset offset;
        // 由于要兼顾每一个用户，所以需要循环（效率待定？）
        for (Integer userId : userOffsetMap.keySet()) {
            offset = userOffsetMap.get(userId);
            // 100以内随机，所以需要是左侧需要等于，右侧不需要
            if (offset.getStart() <= rnum && rnum < offset.getEnd()) {
                return userId;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Lottery().lottery();
    }

    class User {

        private int id;
        private String name;
        private int amount;

        public User(int id, String name, int amount) {
            this.id = id;
            this.name = name;
            this.amount = amount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

    class Offset {

        private float percent;
        private int span;
        private int start;
        private int end;
        private int amount;

        public Offset(float percent, int span, int start, int end, int amount) {
            this.percent = percent;
            this.span = span;
            this.start = start;
            this.end = end;
            this.amount = amount;
        }

        public float getPercent() {
            return percent;
        }

        public void setPercent(float percent) {
            this.percent = percent;
        }

        public int getSpan() {
            return span;
        }

        public void setSpan(int span) {
            this.span = span;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

}