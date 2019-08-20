package com.mdx.experiance.top.interview;

import com.mdx.experiance.annotation.Info;
import com.mdx.experiance.enums.StatusEnum;
import com.mdx.experiance.problem.ProblemConstructBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现描述：
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/8/20
 */
@Info(status = StatusEnum.ACCEPTTED)
public class Problem56 {
    class Interval {
        Integer start;
        Integer end;

        public Interval(Integer start,
                        Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        List<Interval> intervalList = generate(intervals);
        intervalList.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start.compareTo(o2.start);
            }
        });
        LinkedList<Interval> combineInterval = new LinkedList<>();
        combineInterval.add(intervalList.get(0));
        for (int i = 1; i < intervalList.size(); i++) {
            Interval last = combineInterval.getLast();
            Interval cur = intervalList.get(i);
            if (last.end >= cur.start) {
                last.end = Math.max(last.end, cur.end);
            } else {
                combineInterval.add(cur);
            }
        }
        int[][] res = convert(combineInterval);
        return res;
    }

    private int[][] convert(LinkedList<Interval> combineInterval) {
        int[][] res = new int[combineInterval.size()][2];
        for (int i = 0; i < combineInterval.size(); i++) {
            res[i][0] = combineInterval.get(i).start;
            res[i][1] = combineInterval.get(i).end;
        }
        return res;
    }

    private List<Interval> generate(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Interval interval = new Interval(intervals[i][0], intervals[i][1]);
            intervalList.add(interval);
        }
        return intervalList;
    }


    public static void main(String[] args) {
        Problem56 problem = new ProblemConstructBuilder<Problem56>(Problem56.class.getName()).build();
        problem.merge(new int[][]{
                {1, 4},
                {4, 6},
                {8, 10}});
    }
}
