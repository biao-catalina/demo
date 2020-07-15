package com.leetcode;

public class ContainerMostWater {

    public static void main(String[] args) {
        ContainerMostWater c = new ContainerMostWater();
        int[] arr = {1, 1};
        System.out.println(c.maxArea(arr));
    }

    public int maxArea(int[] height) {

//        int leftPoi = 0, rightPos = height.length - 1;
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[right] > height[left]) {

                while (height[right] >= height[left] && left < right) {
                    if (height[left] < height[++left]) {
                        break;
                    }
                }
            } else {

                while (height[left] >= height[right] && left < right) {
                    if (height[right] < height[--right]) {
                        break;
                    }
                }
            }
        }

        return max;
    }
}
